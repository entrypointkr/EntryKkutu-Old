package kr.rvs.entrykkutu.gui.listener;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;
import kr.rvs.entrykkutu.util.Static;

/**
 * Created by Junhyeong Lim on 2017-02-09.
 */
public class ChatChangeListener implements ChangeListener<String> {
    private TextArea area;
    private int limit;

    public ChatChangeListener(TextArea area, int limit) {
        this.area = area;
        this.limit = limit;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        String text = area.getText();
        int lines = Static.countMatches(text, "\n");
        if (lines >= limit) {
            text = text.substring(text.indexOf("\n") + 1);
        }
        area.setText(text);
    }
}
