package kr.rvs.entrykkutu.network.packet.server;

import kr.rvs.entrykkutu.network.packet.Packet;
import kr.rvs.entrykkutu.network.packet.PacketType;
import kr.rvs.entrykkutu.object.game.Room;

/**
 * Created by Junhyeong Lim on 2017-02-07.
 */
public class RoomPacket extends Packet {
    private Room room;

    @Override
    public PacketType getPacketType() {
        return PacketType.ROOM;
    }

    public Room getRoom() {
        return room;
    }
}
