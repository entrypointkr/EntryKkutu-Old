package kr.rvs.entrykkutu.network.packet.client;

import kr.rvs.entrykkutu.network.packet.Packet;
import kr.rvs.entrykkutu.network.packet.PacketType;
import kr.rvs.entrykkutu.object.game.Profile;
import kr.rvs.entrykkutu.object.game.User;

/**
 * Created by Junhyeong Lim on 2017-02-08.
 */
public class RoomJoinPacket extends Packet {
    private User user;
    private Profile profile;

    public RoomJoinPacket(User user, Profile profile) {
        this.user = user;
        this.profile = profile;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public PacketType getPacketType() {
        return PacketType.CONNROOM;
    }
}
