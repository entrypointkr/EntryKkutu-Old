package kr.rvs.entrykkutu.network.packet;

import kr.rvs.entrykkutu.object.game.User;

/**
 * Created by Junhyeong Lim on 2017-02-07.
 */
public class ConnectPacket extends Packet {
    private User user;

    @Override
    public PacketType getPacketType() {
        return PacketType.CONN;
    }
}
