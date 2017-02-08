package kr.rvs.entrykkutu.network.packet;

/**
 * Created by Junhyeong Lim on 2017-02-07.
 */
public class UnknownPacket extends Packet {
    public UnknownPacket(String type) {
        super.type = type;
    }

    @Override
    public PacketType getPacketType() {
        return PacketType.UNKNOWN;
    }
}
