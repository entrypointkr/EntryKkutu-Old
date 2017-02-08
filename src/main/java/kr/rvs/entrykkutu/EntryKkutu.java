package kr.rvs.entrykkutu;

import kr.rvs.entrykkutu.gui.RoomSelect;
import kr.rvs.entrykkutu.network.WebSocket;
import kr.rvs.entrykkutu.util.Static;

import static javafx.application.Application.launch;

/**
 * Created by Junhyeong Lim on 2017-02-06.
 */
public final class EntryKkutu {

    public static void main(String[] args) throws Exception {
        // GUI
        new Thread(() -> launch(RoomSelect.class),
                "EntryKkutu GUI").start();

        // Network
        Static.setSocket(new WebSocket());
        Static.getSocket().start(8080);
    }
}
