package com.example.loginsystem;

import com.example.loginsystem.database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Login {
    private static Database db;

    @FXML
    private Button button;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label label;

    public void loginButtonClicked(ActionEvent event) throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {
        Main main = new Main();
        db = Database.getInstance();

        if (db.checkUser(String.valueOf(username.getText()))) {
            if (db.checkPassword(String.valueOf(username.getText()), db.generateHash(String.valueOf(password.getText())))) {
                db.setActive(String.valueOf(username.getText()));
                main.changeScene("afterlogin.fxml");
            } else {
               label.setText("invalid password");
            }
        } else {
            label.setText("invalid user");
        }
    }

    public void registerButtonClicked(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("register.fxml");
    }

    public void resetPasswordButtonClicked(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("forgotpassword.fxml");
    }
}
