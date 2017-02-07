package kr.rvs.entrykkutu.network.packet;

import kr.rvs.entrykkutu.object.game.Room;
import kr.rvs.entrykkutu.object.game.RoomOption;
import kr.rvs.entrykkutu.object.game.UserState;

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
