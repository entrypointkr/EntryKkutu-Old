package kr.rvs.entrykkutu.network.packet.server;

import kr.rvs.entrykkutu.network.packet.Packet;
import kr.rvs.entrykkutu.network.packet.PacketType;
import kr.rvs.entrykkutu.object.game.User;

/**
 * Created by Junhyeong Lim on 2017-02-07.
 */
public class ConnectPacket extends Packet {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public PacketType getPacketType() {
        return PacketType.CONN;
    }
}
