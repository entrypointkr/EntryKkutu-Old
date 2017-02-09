package kr.rvs.entrykkutu.object;


import kr.rvs.entrykkutu.network.packet.Packet;
import kr.rvs.entrykkutu.network.packet.PacketType;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Junhyeong Lim on 2017-02-07.
 */
public class ListenerManager {
    public static final int SEND = 0;
    public static final int RECEIVE = 1;

    private static ListenerManager inst;
    private static final Object LOCK = new Object();

    private final Map<PacketType, Set<PacketListener>> listenerMap = new ConcurrentHashMap<>();

    private ListenerManager() {
    }

    public static synchronized ListenerManager getInst() {
        if (inst == null) {
            inst = new ListenerManager();
        }
        return inst;
    }

    public void register(PacketListener... listeners) {
        for (PacketListener listener : listeners) {
            for (PacketType type : listener.getTypes()) {
                Set<PacketListener> listenerSet = this.listenerMap.get(type);
                if (listenerSet == null) {
                    listenerSet = Collections.newSetFromMap(new ConcurrentHashMap<>());
                }
                listenerSet.add(listener);
                this.listenerMap.put(type, listenerSet);
            }
        }

    }

    public void unregister(PacketListener listener) {
        for (PacketType type : listener.getTypes()) {
            Set<PacketListener> listenerSet = this.listenerMap.get(type);
            if (listenerSet == null) {
                continue;
            }
            listenerSet.remove(listener);
        }
    }

    public void update(int state, Packet packet) {
        Set<PacketListener> listenerSet = this.listenerMap.get(packet.getPacketType());
        if (listenerSet == null) {
            return;
        }
        for (PacketListener listener : listenerSet) {
            if (state == SEND) {
                listener.onSending(packet);
            } else if (state == RECEIVE) {
                listener.onReceive(packet);
            } else {
                throw new RuntimeException("What the fuck \"" + state + "\" state");
            }
        }
    }
}
