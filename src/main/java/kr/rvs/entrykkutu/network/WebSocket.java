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
    private static final String SCHEME_WEBSOC = "ws";
    private static final String SCHEME_WEBSOCS = "wss";
    private static final String ADDR = "kkutu.kr";
    private static final int SERVER = 2;
    private static final String URL =
            System.getProperty("url", SCHEME_WEBSOC + "://" + ADDR + ":8080/?server=" + SERVER);

    private final Queue<Packet> packetQueue = new ConcurrentLinkedDeque<>();

    public void start() throws Exception {
        URI uri = new URI(URL);
        String scheme = uri.getScheme() == null ? SCHEME_WEBSOC : uri.getScheme();
        final String host = uri.getHost() == null ? ADDR : uri.getHost();
        final int port;
        if (uri.getPort() == -1) {
            if (scheme.equalsIgnoreCase(SCHEME_WEBSOC)) {
                port = 80;
            } else if (scheme.equalsIgnoreCase(SCHEME_WEBSOCS)) {
                port = 443;
            } else {
                port = -1;
            }
        } else {
            port = uri.getPort();
        }

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

        EventLoopGroup group = new NioEventLoopGroup();
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


            while (true) {
                for (Packet packet : packetQueue) {
                    System.err.println(packet.toJson());
                    WebSocketFrame frame = new TextWebSocketFrame(packet.toJson());
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
