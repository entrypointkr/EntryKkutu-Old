package kr.rvs.entrykkutu.network.listener;

import javafx.scene.control.Alert;
import kr.rvs.entrykkutu.gui.EntryAlert;
import kr.rvs.entrykkutu.network.packet.Packet;
import kr.rvs.entrykkutu.network.packet.PacketType;
import kr.rvs.entrykkutu.network.packet.server.ErrorPacket;
import kr.rvs.entrykkutu.object.PacketListener;

import java.lang.reflect.Method;

/**
 * Created by Junhyeong Lim on 2017-02-08.
 */
public class ErrorListener extends PacketListener {
    public static final String FULL = "full";

    public ErrorListener() {
        super(PacketType.ERROR);
    }

    @Override
    public void onReceive(Packet obj) {
        String type = ((ErrorPacket) obj).getCode();
        try {
            Method method = getClass().getMethod(type, String.class);
            method.invoke(this, type);
        } catch (Exception e) {
            unknown(type);
        }
    }

    private void unknown(String type) {
        showAlert("알 수 없는 에러가 발생했습니다!",
                "에러 코드: " + type);
    }

    private void full(String type) {
        showAlert("서버가 가득 찼습니다");
    }

    private void showAlert(String... msg) {
        new EntryAlert().setType(Alert.AlertType.ERROR)
                .setContextText(msg)
                .show();
    }
}
