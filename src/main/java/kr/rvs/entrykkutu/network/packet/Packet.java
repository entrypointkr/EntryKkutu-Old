package kr.rvs.entrykkutu.network.packet;

import kr.rvs.entrykkutu.object.game.GameObject;

/**
 * Created by Junhyeong Lim on 2017-02-07.
 */
public abstract class Packet extends GameObject {
    protected String type;
    protected transient PacketType packetType;

    public Packet() {
        this.type = getPacketType().name();
        this.packetType = getPacketType();
    }

    public abstract PacketType getPacketType();

    public String getType() {
        return type;
    }
}
