package kr.rvs.entrykkutu.gui.listener;

import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import kr.rvs.entrykkutu.gui.item.RoomItem;
import kr.rvs.entrykkutu.network.packet.Packet;
import kr.rvs.entrykkutu.network.packet.client.RoomEnterPacket;
import kr.rvs.entrykkutu.util.Static;


/**
 * Created by Junhyeong Lim on 2017-02-08.
 */
public class RoomDoubleClickListener implements EventHandler<MouseEvent> {
    private TableView<RoomItem> tableView;

    public RoomDoubleClickListener(TableView<RoomItem> tableView) {
        this.tableView = tableView;
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getClickCount() == 2) {
            RoomItem item = tableView.getSelectionModel().getSelectedItem();
            if (item == null) {
                return;
            }
            Packet packet = new RoomEnterPacket(item.getId());
            Static.sendPacket(packet);
        }
    }
}
