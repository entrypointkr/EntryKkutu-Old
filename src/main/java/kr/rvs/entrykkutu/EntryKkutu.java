package kr.rvs.entrykkutu;

import kr.rvs.entrykkutu.gui.Lobby;
import kr.rvs.entrykkutu.network.WebSocket;
import kr.rvs.entrykkutu.network.listener.ErrorListener;
import kr.rvs.entrykkutu.object.ListenerManager;
import kr.rvs.entrykkutu.util.Static;

import static javafx.application.Application.launch;

/**
 * Created by Junhyeong Lim on 2017-02-06.
 */
public final class EntryKkutu {

    public static void main(String[] args) throws Exception {
        // GUI
        new Thread(() -> launch(Lobby.class),
                "EntryKkutu GUI").start();

        // Listener
        ListenerManager.getInst().register(
                new ErrorListener()
        );

        // Network
        Static.setSocket(new WebSocket());
        Static.getSocket().start(8080);
    }
}
