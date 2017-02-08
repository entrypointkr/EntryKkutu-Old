package kr.rvs.entrykkutu.gui.item;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import kr.rvs.entrykkutu.object.game.Room;
import kr.rvs.entrykkutu.object.game.RoomType;

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
        String name = str(mode);
        switch (mode) {
            case RoomType.영어끝말:
                name = "영어 끝말잇기";
                break;
            case RoomType.한글쿵쿵따:
                name = "한국어 쿵쿵따";
                break;
            case RoomType.한글끝말:
                name = "한국어 끝말잇기";
                break;
            case RoomType.자음퀴즈:
                name = "자음퀴즈";
                break;
            case RoomType.한글십자말:
                name = "한국어 십자말";
                break;
            case RoomType.한글앞말:
                name = "한국어 앞말잇기";
                break;
            case RoomType.훈민정음:
                name = "훈민정음";
                break;
            case RoomType.한글단어대결:
                name = "한국어 단어대결";
                break;
            case RoomType.한글솎솎:
                name = "한국어 솎솎";
                break;
        }
        return new SimpleStringProperty(name);
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
