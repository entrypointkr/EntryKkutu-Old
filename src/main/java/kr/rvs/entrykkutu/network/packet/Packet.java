package kr.rvs.entrykkutu.network.packet;

import kr.rvs.entrykkutu.object.game.GameObject;
import kr.rvs.entrykkutu.util.Static;

/**
 * Created by Junhyeong Lim on 2017-02-07.
 */
public abstract class Packet extends GameObject {
    protected String type;
    protected transient PacketType packetType;

    public Packet() {
        this.packetType = getPacketType();
        this.type = getPacketType().name().toLowerCase();
    }

    public abstract PacketType getPacketType();

    public String getType() {
        return type;
    }

    public String toJson() {
        return Static.GSON.toJson(this);
    }
}
