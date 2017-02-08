package kr.rvs.entrykkutu.network.packet.server;

import kr.rvs.entrykkutu.network.packet.Packet;
import kr.rvs.entrykkutu.network.packet.PacketType;

/**
 * Created by Junhyeong Lim on 2017-02-08.
 */
public class PreRoomPacket extends Packet {
    private int id;
    private String channel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    @Override
    public PacketType getPacketType() {
        return PacketType.PREROOM;
    }
}
