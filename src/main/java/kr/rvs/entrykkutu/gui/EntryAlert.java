package kr.rvs.entrykkutu.gui;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogEvent;
import kr.rvs.entrykkutu.util.Static;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Junhyeong Lim on 2017-02-08.
 */
public class EntryAlert {
    private final CountDownLatch latch = new CountDownLatch(1);
    private final AlertStorage storage = new AlertStorage();

    public EntryAlert() {
        final Runnable init = () -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("EntryKkutu");
            alert.setHeaderText("EntryKkutu");
            storage.setAlert(alert);
        };
        if (Platform.isFxApplicationThread()) {
            init.run();
            return;
        }
        Platform.runLater(() -> {
            try {
                init.run();
            } finally {
                latch.countDown();
            }
        });
    }

    public EntryAlert setType(Alert.AlertType type) {
        doAwait(() -> storage.getAlert().setAlertType(type));
        return this;
    }

    public EntryAlert setHeaderText(String s) {
        doAwait(() -> storage.getAlert().setHeaderText(s));
        return this;
    }

    public EntryAlert setContextText(String... strs) {
        doAwait(() -> storage.getAlert().setContentText(String.join("\n", strs)));
        return this;
    }

    public EntryAlert setTitle(String s) {
        doAwait(() -> storage.getAlert().setTitle(s));
        return this;
    }

    public EntryAlert setOnCloseRequest(EventHandler<DialogEvent> val) {
        doAwait(() -> storage.getAlert().setOnCloseRequest(val));
        return this;
    }

    public void show() {
        Platform.runLater(() -> doAwait(() -> storage.getAlert().show()));
    }

    public Alert build() {
        try {
            latch.await();
            return storage.getAlert();
        } catch (Exception ex) {
            Static.ex(ex);
        }
        return null;
    }

    private void doAwait(ExRunnable runnable) {
        try {
            if (!Platform.isFxApplicationThread()) {
                latch.await();
            }
            runnable.run();
        } catch (Exception e) {
            Static.ex(e);
        }
    }

    class AlertStorage {
        private Alert alert;

        public Alert getAlert() {
            return alert;
        }

        public void setAlert(Alert alert) {
            this.alert = alert;
        }
    }

    interface ExRunnable {
        void run() throws Exception;
    }
}
