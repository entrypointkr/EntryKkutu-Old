package kr.rvs.entrykkutu.network.listener;

import kr.rvs.entrykkutu.gui.EntryAlert;
import kr.rvs.entrykkutu.network.packet.Packet;
import kr.rvs.entrykkutu.network.packet.PacketType;
import kr.rvs.entrykkutu.network.packet.server.InvitedPacket;
import kr.rvs.entrykkutu.object.PacketListener;

/**
 * Created by Junhyeong Lim on 2017-02-08.
 */
public class InvitedListener extends PacketListener {
    public InvitedListener() {
        super(PacketType.INVITED);
    }

    @Override
    public void onReceive(Packet obj) {
        InvitedPacket packet = (InvitedPacket) obj;
        new EntryAlert()
                .setContextText(packet.getFrom() + " 님에게서 초대 요청이 왔습니다.")
                .show();
    }
}
