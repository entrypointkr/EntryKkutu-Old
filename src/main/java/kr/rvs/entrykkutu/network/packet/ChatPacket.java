package kr.rvs.entrykkutu.network.packet;

import kr.rvs.entrykkutu.object.game.Profile;

/**
 * Created by Junhyeong Lim on 2017-02-07.
 */
public class ChatPacket extends Packet {
    private String value;
    private boolean notice;
    private Profile profile;

    @Override
    public PacketType getPacketType() {
        return PacketType.CHAT;
    }

    public String getValue() {
        return value;
    }

    public boolean isNotice() {
        return notice;
    }

    public Profile getProfile() {
        return profile;
    }
}
