package kr.rvs.entrykkutu.object;


import kr.rvs.entrykkutu.network.packet.Packet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Junhyeong Lim on 2017-02-07.
 */
public class ListenerManager {
    public static final int SEND = 0;
    public static final int RECEIVE = 1;

    private static ListenerManager inst;

    public static synchronized ListenerManager getInst() {
        if (inst == null) {
            inst = new ListenerManager();
        }
        return inst;
    }

    private ListenerManager() {
    }

    private Set<PacketListener> listeners = new HashSet<>();
    private final Executor executor = Executors.newCachedThreadPool();

    public void register(PacketListener... listeners) {
        this.listeners.addAll(Arrays.asList(listeners));
    }

    public void unregister(PacketListener listener) {
        listeners.remove(listener);
    }

    public void update(int state, Packet packet) {
        for (PacketListener listener : listeners) {
            executor.execute(() -> {
                if (!listener.getTypes().contains(packet.getPacketType())) {
                    return;
                }
                if (state == SEND) {
                    listener.onSending(packet);
                } else if (state == RECEIVE) {
                    listener.onReceive(packet);
                } else {
                    throw new RuntimeException("What the fuck \"" + state + "\" state");
                }
            });
        }
    }
}
