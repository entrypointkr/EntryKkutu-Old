package kr.rvs.entrykkutu.network.packet;

/**
 * Created by Junhyeong Lim on 2017-02-07.
 */
public class ErrorPacket extends Packet {
    private String code;

    public String getCode() {
        return code;
    }

    @Override
    public PacketType getPacketType() {
        return PacketType.ERROR;
    }
}
