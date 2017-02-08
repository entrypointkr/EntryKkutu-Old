package kr.rvs.entrykkutu.network.listener;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import kr.rvs.entrykkutu.gui.item.RoomItem;
import kr.rvs.entrykkutu.network.packet.Packet;
import kr.rvs.entrykkutu.network.packet.PacketType;
import kr.rvs.entrykkutu.network.packet.server.RoomPacket;
import kr.rvs.entrykkutu.network.packet.server.WelcomePacket;
import kr.rvs.entrykkutu.object.PacketListener;
import kr.rvs.entrykkutu.object.collection.RoomList;
import kr.rvs.entrykkutu.object.game.Room;

import java.util.ArrayList;
import java.util.Map;


/**
 * Created by Junhyeong Lim on 2017-02-08.
 */
public class RoomListener extends PacketListener {
    private TableView<RoomItem> tableView;

    public RoomListener(TableView<RoomItem> tableView) {
        super(PacketType.WELCOME, PacketType.ROOM);
        wrapping(tableView);
        this.tableView = tableView;
    }

    @Override
    public void onReceive(Packet obj) {
        if (obj instanceof WelcomePacket) {
            WelcomePacket packet = (WelcomePacket) obj;
            ObservableList<RoomItem> roomList = tableView.getItems();

            if (roomList.size() > 0) {
                return;
            }

            for (Map.Entry<String, Room> entry : packet.getRooms().entrySet()) {
                Room room = entry.getValue();
                roomList.add(createRoomItem(room));
            }
            tableView.setItems(roomList);
        } else if (obj instanceof RoomPacket) {
            Room room = ((RoomPacket) obj).getRoom();
            final RoomList list = new RoomList(new ArrayList<>(tableView.getItems()));
            Integer index = list.indexMap.get(room.getId());
            if (index == null) {
                index = list.size();
                list.add(createRoomItem(room));
            }
            RoomItem item = list.get(index);
            list.remove(index.intValue());

            if (room.getPlayers().length > 0) {
                updateRoom(item, room);
                list.add(index, item);
            }

            Platform.runLater(() -> tableView.setItems(list));
        }
    }

    private void wrapping(TableView<RoomItem> tableView) {
        ObservableList<RoomItem> roomItems = tableView.getItems();
        if (!(roomItems instanceof RoomList)) {
            tableView.setItems(new RoomList(roomItems));
        }
    }

    private void updateRoom(RoomItem item, Room room) {
        item.setId(room.getId());
        item.setTitle(room.getTitle());
        item.setMode(room.getMode());
        item.setRound(room.getRound());
        item.setTime(room.getTime());
        item.setPlayers(room.getPlayers());
        item.setLimit(room.getLimit());
        item.setPassword(room.isPassword());
    }

    private RoomItem createRoomItem(Room room) {
        return new RoomItem(
                room.getId(), room.getTitle(), room.getMode(),
                room.getRound(), room.getTime(), room.getPlayers().length,
                room.getLimit(), room.isPassword()
        );
    }
}
