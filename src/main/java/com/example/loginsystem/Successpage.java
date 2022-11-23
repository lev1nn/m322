package com.example.loginsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Successpage {
    @FXML
    private Button button;

    public void logoutButtonClicked(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("login.fxml");
    }
}
