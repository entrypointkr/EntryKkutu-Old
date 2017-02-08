package kr.rvs.entrykkutu.network.listener;

import javafx.scene.control.Alert;
import kr.rvs.entrykkutu.gui.EntryAlert;
import kr.rvs.entrykkutu.network.packet.Packet;
import kr.rvs.entrykkutu.network.packet.PacketType;
import kr.rvs.entrykkutu.network.packet.server.ErrorPacket;
import kr.rvs.entrykkutu.object.PacketListener;
import kr.rvs.entrykkutu.util.Static;

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
            Method method;
            if (Static.isNumber(type)) {
                method = getClass().getMethod("error" + type, String.class);
            } else {
                method = getClass().getMethod(type, String.class);
            }
            method.invoke(this, type);
        } catch (Exception e) {
            unknown(type);
        }
    }

    private void showAlert(String... msg) {
        new EntryAlert().setType(Alert.AlertType.ERROR)
                .setContextText(msg)
                .show();
    }

    private void unknown(String type) {
        showAlert("알 수 없는 에러가 발생했습니다!",
                "에러 코드: " + type);
    }

    public void full(String type) {
        showAlert("서버가 가득 찼습니다");
    }

    public void error429(String type) {
        showAlert("방이 꽉 찼습니다");
    }

    public void error416(String type) {
        showAlert("이미 게임 중인 방입니다.");
    }

    public void error440(String type) {
        showAlert("셧다운제");
    }
}
