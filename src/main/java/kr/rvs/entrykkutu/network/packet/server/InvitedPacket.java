package kr.rvs.entrykkutu.network.packet.server;

import kr.rvs.entrykkutu.network.packet.Packet;
import kr.rvs.entrykkutu.network.packet.PacketType;

/**
 * Created by Junhyeong Lim on 2017-02-08.
 */
public class InvitedPacket extends Packet {
    private String from;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public PacketType getPacketType() {
        return PacketType.INVITED;
    }
}
