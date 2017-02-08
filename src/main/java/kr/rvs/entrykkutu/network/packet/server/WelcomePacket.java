package kr.rvs.entrykkutu.network.packet.server;

import kr.rvs.entrykkutu.network.packet.Packet;
import kr.rvs.entrykkutu.network.packet.PacketType;
import kr.rvs.entrykkutu.object.game.Room;
import kr.rvs.entrykkutu.object.game.User;

import java.util.Map;

/**
 * Created by Junhyeong Lim on 2017-02-07.
 */
public class WelcomePacket extends Packet {
    private String id;
    private boolean guest;
    private int playTime;
    private Map<String, User> users;
    private Map<String, Room> rooms;
    private boolean admin;
    private boolean caj;

    public String getId() {
        return id;
    }

    public boolean isGuest() {
        return guest;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public Map<String, Room> getRooms() {
        return rooms;
    }

    public boolean isAdmin() {
        return admin;
    }

    @Override
    public PacketType getPacketType() {
        return PacketType.WELCOME;
    }
}
