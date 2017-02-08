package kr.rvs.entrykkutu.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import kr.rvs.entrykkutu.gui.item.RoomItem;
import kr.rvs.entrykkutu.gui.listener.RoomDoubleClickListener;
import kr.rvs.entrykkutu.network.listener.ErrorListener;
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
    public TableView<RoomItem> roomTable;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        roomTable.setOnMouseClicked(new RoomDoubleClickListener(roomTable));

        ListenerManager.getInst().register(
                new RoomListener(roomTable),
                new UnknownListener(),
                new ErrorListener(),
                new InvitedListener(),
                new PreRoomListener()
        );
    }
}
