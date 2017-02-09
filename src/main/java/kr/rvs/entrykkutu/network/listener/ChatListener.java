package kr.rvs.entrykkutu.network.listener;

import javafx.scene.control.TextArea;
import kr.rvs.entrykkutu.network.packet.Packet;
import kr.rvs.entrykkutu.network.packet.PacketType;
import kr.rvs.entrykkutu.network.packet.server.ChatPacket;
import kr.rvs.entrykkutu.object.PacketListener;
import kr.rvs.entrykkutu.object.game.Profile;

/**
 * Created by Junhyeong Lim on 2017-02-09.
 */
public class ChatListener extends PacketListener {
    private TextArea textArea;

    public ChatListener(TextArea textArea) {
        super(PacketType.CHAT);
        this.textArea = textArea;
    }

    @Override
    public void onReceive(Packet obj) {
        ChatPacket packet = (ChatPacket) obj;
        String text = "";
        if (!textArea.getText().equals("")) {
            text += "\n";
        }
        Profile profile = packet.getProfile();
        text += (profile.getTitle() != null ? profile.getTitle() : profile.getName()) + ": "  + packet.getValue();
        textArea.appendText(text);
        textArea.positionCaret(textArea.caretPositionProperty().get());
    }
}
