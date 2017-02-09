package kr.rvs.entrykkutu.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import kr.rvs.entrykkutu.gui.item.RoomItem;
import kr.rvs.entrykkutu.gui.listener.ChatChangeListener;
import kr.rvs.entrykkutu.gui.listener.ChatSendListener;
import kr.rvs.entrykkutu.gui.listener.RoomDoubleClickListener;
import kr.rvs.entrykkutu.network.listener.ChatListener;
import kr.rvs.entrykkutu.network.listener.ErrorListener;
import kr.rvs.entrykkutu.network.listener.InstantConnListener;
import kr.rvs.entrykkutu.network.listener.InvitedListener;
import kr.rvs.entrykkutu.network.listener.PreRoomListener;
import kr.rvs.entrykkutu.network.listener.RoomListener;
import kr.rvs.entrykkutu.network.listener.UnknownListener;
import kr.rvs.entrykkutu.object.ListenerManager;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Junhyeong Lim on 2017-02-06.
 */
public class Controller implements Initializable {
    @FXML
    public TableView<RoomItem> roomView;
    @FXML
    public TextArea chatArea;
    @FXML
    public TextField chatField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        roomView.setOnMouseClicked(new RoomDoubleClickListener(roomView));
        chatArea.setWrapText(true);
        chatArea.textProperty().addListener(new ChatChangeListener(chatArea, 50));
        chatField.setOnKeyPressed(new ChatSendListener(chatField));

        ListenerManager.getInst().register(
                new RoomListener(roomView),
                new UnknownListener(),
                new InvitedListener(),
                new PreRoomListener(),
                new ChatListener(chatArea),
                new InstantConnListener()
        );
    }
}
