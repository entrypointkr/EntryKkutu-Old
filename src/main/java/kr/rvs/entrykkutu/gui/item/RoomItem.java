package kr.rvs.entrykkutu.gui.item;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import kr.rvs.entrykkutu.object.game.Room;

import static kr.rvs.entrykkutu.util.Static.str;

/**
 * Created by Junhyeong Lim on 2017-02-08.
 */
public class RoomItem extends Room {

    public RoomItem(int id, String title, int mode, int round, int time, int personnel, int limit, boolean password) {
        super.id = id;
        super.title = title;
        super.mode = mode;
        super.round = round;
        super.time = time;
        super.players = new Object[personnel];
        super.limit = limit;
        super.password = password;
    }

    public SimpleIntegerProperty idProperty() {
        return new SimpleIntegerProperty(id);
    }

    public SimpleStringProperty titleProperty() {
        return new SimpleStringProperty(title);
    }

    public SimpleStringProperty modeProperty() {
        return new SimpleStringProperty(str(mode));
    }

    public SimpleIntegerProperty roundProperty() {
        return new SimpleIntegerProperty(round);
    }

    public SimpleStringProperty timeProperty() {
        return new SimpleStringProperty(str(time + "초"));
    }

    public SimpleStringProperty personnelProperty() {
        return new SimpleStringProperty(players.length + "/" + limit);
    }

    public SimpleStringProperty passwordProperty() {
        return new SimpleStringProperty(password ? "예" : "아니오");
    }


}
