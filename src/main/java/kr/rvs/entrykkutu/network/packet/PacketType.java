package kr.rvs.entrykkutu.network.packet;

import kr.rvs.entrykkutu.network.packet.client.RoomJoinPacket;
import kr.rvs.entrykkutu.network.packet.server.ChatPacket;
import kr.rvs.entrykkutu.network.packet.server.ConnectPacket;
import kr.rvs.entrykkutu.network.packet.server.DisconnectPacket;
import kr.rvs.entrykkutu.network.packet.server.ErrorPacket;
import kr.rvs.entrykkutu.network.packet.server.RoomPacket;
import kr.rvs.entrykkutu.network.packet.server.WelcomePacket;

/**
 * Created by Junhyeong Lim on 2017-02-07.
 */
public enum PacketType {
    UNKNOWN(Side.UNKNOWN, UnknownPacket.class),

    WELCOME(Side.SERVER, WelcomePacket.class),
    ROOM(Side.SERVER, RoomPacket.class),
    DISCONN(Side.SERVER, DisconnectPacket.class),
    CHAT(Side.SERVER, ChatPacket.class),
    ERROR(Side.SERVER, ErrorPacket.class),
    CONN(Side.SERVER, ConnectPacket.class),

    CONNROOM(Side.CLIENT, RoomJoinPacket.class),
    ;

    private Side side;
    private Class<? extends Packet> packetCls;

    PacketType(Side side, Class<? extends Packet> packetCls) {
        this.side = side;
        this.packetCls = packetCls;
    }

    public Side getSide() {
        return side;
    }

    public Class<? extends Packet> getPacketCls() {
        return packetCls;
    }

    public enum Side {
        SERVER,
        CLIENT,
        UNKNOWN
    }
}
