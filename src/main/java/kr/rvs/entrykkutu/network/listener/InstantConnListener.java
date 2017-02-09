package kr.rvs.entrykkutu.network.listener;

import kr.rvs.entrykkutu.network.packet.Packet;
import kr.rvs.entrykkutu.network.packet.PacketType;
import kr.rvs.entrykkutu.network.packet.server.ConnectPacket;
import kr.rvs.entrykkutu.object.ListenerManager;
import kr.rvs.entrykkutu.object.PacketListener;
import kr.rvs.entrykkutu.util.StaticStorage;

/**
 * Created by Junhyeong Lim on 2017-02-09.
 */
public class InstantConnListener extends PacketListener {
    public InstantConnListener() {
        super(PacketType.CONN);
    }

    @Override
    public void onReceive(Packet obj) {
        ConnectPacket packet = (ConnectPacket) obj;
        StaticStorage.setId(packet.getUser().getId());
        ListenerManager.getInst().unregister(this);
    }
}
