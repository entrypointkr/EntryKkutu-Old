package kr.rvs.entrykkutu.object;

import kr.rvs.entrykkutu.network.packet.Packet;
import kr.rvs.entrykkutu.network.packet.PacketType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Junhyeong Lim on 2017-02-07.
 */
public abstract class PacketListener {
    private Set<PacketType> types;

    public PacketListener(PacketType... types) {
        this.types = new HashSet<>(Arrays.asList(types));
    }

    public void onReceive(Packet obj) {}

    public void onSending(Packet obj) {}

    public Set<PacketType> getTypes() {
        return types;
    }
}
