package com.example.loginsystem;

import com.example.loginsystem.database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    @FXML
    private Label label;

    public void registerButtonClicked(ActionEvent event) throws IOException {
        db = Database.getInstance();
        if (!db.checkUser(String.valueOf(username.getText()))) {
            db.addUser(String.valueOf(username.getText()), (db.generateHash(String.valueOf(password.getText()))), String.valueOf(emailaddress.getText()));
            db.saveChanges();

            Main main = new Main();
            main.changeScene("login.fxml");
        } else {
            label.setText("User with this username already exists");
        }
    }

    public void loginButtonClicked(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("login.fxml");
    }

    public void toggleButtonClicked(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeWallpaper();
    }
}
