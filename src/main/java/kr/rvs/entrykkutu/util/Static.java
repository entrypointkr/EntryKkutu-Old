package kr.rvs.entrykkutu.util;

import javafx.scene.control.Alert;
import kr.rvs.entrykkutu.gui.EntryAlert;

/**
 * Created by Junhyeong Lim on 2017-02-08.
 */
public class Static {
    public static String str(Object obj) {
        return String.valueOf(obj);
    }

    public static int anInt(Object obj) {
        return Integer.parseInt(str(obj));
    }

    public static void ex(Exception ex) {
        new EntryAlert().setType(Alert.AlertType.ERROR)
                .setContextText(
                        "에러가 발생했습니다.",
                        ex.toString()
                )
                .show();
    }
}
