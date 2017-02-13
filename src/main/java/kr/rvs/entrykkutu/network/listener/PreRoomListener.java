package kr.rvs.entrykkutu.network.listener;

import kr.rvs.entrykkutu.network.packet.Packet;
import kr.rvs.entrykkutu.network.packet.PacketType;
import kr.rvs.entrykkutu.network.packet.server.PreRoomPacket;
import kr.rvs.entrykkutu.object.PacketListener;
import kr.rvs.entrykkutu.util.Static;

/**
 * Created by Junhyeong Lim on 2017-02-08.
 */
public class PreRoomListener extends PacketListener {
    public PreRoomListener() {
        super(PacketType.PREROOM);
    }

    @Override
    public void onReceive(Packet obj) {
        try {
            Static.getSocket().start(8495 +
                    Static.anInt(((PreRoomPacket) obj).getChannel()));
        } catch (Exception ex) {
            Static.ex(ex);
        }
    }
}

