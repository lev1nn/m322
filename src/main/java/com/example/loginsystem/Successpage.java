package com.example.loginsystem;

import com.example.loginsystem.database.Database;
import com.example.loginsystem.database.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class Successpage {
    private Database db;

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
        Main main = new Main();
        main.changeScene("login.fxml");

        db.setInactive(db.getActiveUsers().get(0).getUsername());
    }
}
