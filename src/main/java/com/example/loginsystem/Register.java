package com.example.loginsystem;

import com.example.loginsystem.database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Register {
    private static Database db;

    @FXML
    private Button button;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private TextField emailaddress;

    public void registerButtonClicked(ActionEvent event) throws IOException {
        db = Database.getInstance();
        db.addUser(String.valueOf(username), String.valueOf(password), String.valueOf(emailaddress));

        Main main = new Main();
        main.changeScene("login.fxml");
    }

    public void loginButtonClicked(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("login.fxml");
    }
}
