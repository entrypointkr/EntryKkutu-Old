package kr.rvs.entrykkutu.network;

import kr.rvs.entrykkutu.network.packet.client.TalkPacket;

/**
 * Created by Junhyeong Lim on 2017-02-09.
 */
public class PacketFactory {
    public static TalkPacket creeateTalk(String val) {
        return new TalkPacket(val);
    }
}
