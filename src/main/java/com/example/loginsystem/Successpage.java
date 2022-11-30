package com.example.loginsystem;

import com.example.loginsystem.database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class Successpage {
    private static Database db;
    private static Main main;

    @FXML
    private Button button;
    @FXML
    private Label label;
    @FXML
    private void initialize() throws IOException {
        db = Database.getInstance();

        label.setText("Welcome " + db.getActiveUsers().get(0).getUsername());
    }

    public void logoutButtonClicked(ActionEvent event) throws IOException {
        main = new Main();
        main.changeScene("login.fxml");

        db.setInactive(db.getActiveUsers().get(0).getUsername());
    }

    public void toggleButtonClicked(ActionEvent event) throws IOException {
        main = new Main();
        main.changeWallpaper();
    }
}
