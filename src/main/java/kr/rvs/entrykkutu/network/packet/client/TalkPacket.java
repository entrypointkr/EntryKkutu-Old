package kr.rvs.entrykkutu.network.packet.client;

import kr.rvs.entrykkutu.network.packet.Packet;
import kr.rvs.entrykkutu.network.packet.PacketType;

/**
 * Created by Junhyeong Lim on 2017-02-08.
 */
public class TalkPacket extends Packet {
    private String value;

    public TalkPacket(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public PacketType getPacketType() {
        return PacketType.TALK;
    }
}
