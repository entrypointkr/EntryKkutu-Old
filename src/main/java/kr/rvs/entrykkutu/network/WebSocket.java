package kr.rvs.entrykkutu.network;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshakerFactory;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketVersion;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import kr.rvs.entrykkutu.network.packet.Packet;

import java.net.URI;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by Junhyeong Lim on 2017-02-06.
 */
public final class WebSocket {
    private static final EventLoopGroup group = new NioEventLoopGroup();
    private static final String SCHEME_WEBSOC = "ws";
    private static final String SCHEME_WEBSOCS = "wss";
    private static final String ADDR = "kkutu.kr";

    public static final String FULL_ADDR = SCHEME_WEBSOC + "://" + ADDR;

    private final Queue<Packet> packetQueue = new ConcurrentLinkedDeque<>();

    public void start(int port) throws Exception {
        URI uri = new URI(FULL_ADDR + ":" + port);
        String scheme = uri.getScheme() == null ? SCHEME_WEBSOC : uri.getScheme();
        final String host = uri.getHost() == null ? ADDR : uri.getHost();

        if (!scheme.equalsIgnoreCase(SCHEME_WEBSOC)
                && !scheme.equalsIgnoreCase(SCHEME_WEBSOCS)) {
            throw new RuntimeException("");
        }

        final boolean ssl = scheme.equalsIgnoreCase(SCHEME_WEBSOCS);
        final SslContext sslCtx;
        if (ssl) {
            sslCtx = SslContextBuilder.forClient()
                    .trustManager(InsecureTrustManagerFactory.INSTANCE).build();
        } else {
            sslCtx = null;
        }

        try {
            final WebSocketHandler handler =
                    new WebSocketHandler(
                            WebSocketClientHandshakerFactory.newHandshaker(
                                    uri, WebSocketVersion.V13, null, false, new DefaultHttpHeaders(), 1000000));

            Bootstrap bs = new Bootstrap();
            bs.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipe = ch.pipeline();
                            if (sslCtx != null) {
                                pipe.addLast(sslCtx.newHandler(ch.alloc(), host, port));
                            }
                            pipe.addLast(new HttpClientCodec(), new HttpObjectAggregator(8192), handler);
                        }
                    });

            Channel ch = bs.connect(uri.getHost(), port).sync().channel();
            handler.handshakeFuture().sync();

            for (; ; ) {
                for (Packet packet : packetQueue) {
                    String json = packet.toJson();
                    System.err.println(json);
                    WebSocketFrame frame = new TextWebSocketFrame(json);
                    ch.writeAndFlush(frame);
                    packetQueue.remove(packet);
                }
            }
        } finally {
            group.shutdownGracefully();
        }
    }

    public void addPacket(Packet packet) {
        packetQueue.add(packet);
    }
}
