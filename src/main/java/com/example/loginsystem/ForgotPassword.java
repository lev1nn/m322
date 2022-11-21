package com.example.loginsystem;

import com.example.loginsystem.database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ForgotPassword {
    @FXML
    private Button button;
    @FXML
    private TextField emailaddress;

    public void resetPasswordButtonClicked(ActionEvent event) throws IOException {

    }


    public void loginButtonClicked(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("login.fxml");
    }
}
