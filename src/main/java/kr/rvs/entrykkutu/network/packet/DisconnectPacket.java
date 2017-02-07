package kr.rvs.entrykkutu.network.packet;

/**
 * Created by Junhyeong Lim on 2017-02-07.
 */
public class DisconnectPacket extends Packet {
    private String id;

    @Override
    public PacketType getPacketType() {
        return PacketType.DISCONN;
    }

    public String getId() {
        return id;
    }
}
