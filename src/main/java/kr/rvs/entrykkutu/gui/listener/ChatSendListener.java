package kr.rvs.entrykkutu.gui.listener;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import kr.rvs.entrykkutu.network.PacketFactory;
import kr.rvs.entrykkutu.util.Static;


/**
 * Created by Junhyeong Lim on 2017-02-09.
 */
public class ChatSendListener implements EventHandler<KeyEvent> {
    private TextField area;

    public ChatSendListener(TextField area) {
        this.area = area;
    }

    @Override
    public void handle(KeyEvent event) {
        if (event.getCode() != KeyCode.ENTER) {
            return;
        }
        Static.sendPacket(
                PacketFactory.creeateTalk(area.getText()));
        area.setText("");
    }
}
