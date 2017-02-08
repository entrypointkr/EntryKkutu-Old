package kr.rvs.entrykkutu.network.listener;

import kr.rvs.entrykkutu.network.packet.Packet;
import kr.rvs.entrykkutu.network.packet.PacketType;
import kr.rvs.entrykkutu.object.PacketListener;

/**
 * Created by Junhyeong Lim on 2017-02-08.
 */
public class UnknownListener extends PacketListener {
    public UnknownListener() {
        super(PacketType.UNKNOWN);
    }

    @Override
    public void onReceive(Packet obj) {
        System.err.println("Received unknown packet type: " + obj.getType());
    }
}
