package kr.rvs.entrykkutu.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Junhyeong Lim on 2017-02-06.
 */
public final class RoomSelect extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        int width = 700;
        int height = 450;

        Parent root = FXMLLoader.load(getClass().getResource("/Lobby.fxml"));
        primaryStage.setTitle("EntryKkutu");
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.setMinWidth(width);
        primaryStage.setMinHeight(height);
        primaryStage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });
        primaryStage.show();
    }
}
