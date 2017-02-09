package kr.rvs.entrykkutu.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.scene.control.Alert;
import kr.rvs.entrykkutu.gui.EntryAlert;
import kr.rvs.entrykkutu.network.WebSocket;
import kr.rvs.entrykkutu.network.packet.Packet;

/**
 * Created by Junhyeong Lim on 2017-02-08.
 */
public class Static {
    private static WebSocket socket;
    public static final Gson GSON = new GsonBuilder().create();

    public static void setSocket(WebSocket socket) {
        Static.socket = socket;
    }

    public static WebSocket getSocket() {
        return socket;
    }

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

    public static void sendPacket(Packet packet) {
        socket.addPacket(packet);
    }

    public static boolean isNumber(String value) {
        boolean seenDot = false;
        boolean seenExp = false;
        boolean justSeenExp = false;
        boolean seenDigit = false;
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (c >= '0' && c <= '9') {
                seenDigit = true;
                continue;
            }
            if ((c == '-' || c == '+') && (i == 0 || justSeenExp)) {
                continue;
            }
            if (c == '.' && !seenDot) {
                seenDot = true;
                continue;
            }
            justSeenExp = false;
            if ((c == 'e' || c == 'E') && !seenExp) {
                seenExp = true;
                justSeenExp = true;
                continue;
            }
            return false;
        }
        if (!seenDigit) {
            return false;
        }
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int countMatches(String contents, String element) {
        if (contents.isEmpty() || element.isEmpty()) {
            return 0;
        }
        int ret = 0;
        int lastIndex = 0;
        while ((lastIndex = contents.indexOf(element, lastIndex)) != -1) {
            ret++;
            lastIndex++;
        }
        return ret;
    }
}
