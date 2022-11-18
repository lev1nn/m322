package com.example.loginsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Login {
    @FXML
    private Button button;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void loginButtonClicked(ActionEvent event) throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {
        Main main = new Main();
        if (username.getText().toString().equals("root") && password.getText().toString().equals("1234")) {
            main.changeScene("afterlogin.fxml");
        }
    }
}
