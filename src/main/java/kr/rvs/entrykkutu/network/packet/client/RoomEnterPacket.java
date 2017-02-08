package kr.rvs.entrykkutu.network.packet.client;

import kr.rvs.entrykkutu.network.packet.Packet;
import kr.rvs.entrykkutu.network.packet.PacketType;
import kr.rvs.entrykkutu.util.Static;

/**
 * Created by Junhyeong Lim on 2017-02-08.
 */
public class RoomEnterPacket extends Packet {
    private String id;

    public RoomEnterPacket(int id) {
        this.id = Static.str(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public PacketType getPacketType() {
        return PacketType.ENTER;
    }
}
