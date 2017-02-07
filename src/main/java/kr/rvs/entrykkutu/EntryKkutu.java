package kr.rvs.entrykkutu;

import kr.rvs.entrykkutu.gui.RoomSelect;
import kr.rvs.entrykkutu.network.WebSocket;

import static javafx.application.Application.launch;

/**
 * Created by Junhyeong Lim on 2017-02-06.
 */
public final class EntryKkutu {
    private static WebSocket network;

    public static void main(String[] args) throws Exception {
        // GUI
        new Thread(() -> launch(RoomSelect.class),
                "EntryKkutu GUI").start();

        // Network
        network = new WebSocket();
        network.start();
    }
}
