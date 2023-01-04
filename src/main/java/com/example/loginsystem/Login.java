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
    private static Main main;

    @FXML
    private Button button;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label label;
    @FXML
    private void initialize() throws IOException {
        db = Database.getInstance();

        if (db.getResetPasswordUsers().isEmpty()) {
            label.setText("Hello, enter your credentials to log in");
        } else {
            label.setText("Your new password is 'n3wp4ssw0rd!'");
        }
    }

    public void loginButtonClicked(ActionEvent event) throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {
        main = new Main();

        if (db.checkUser(String.valueOf(username.getText()))) {
            if (db.checkPassword(String.valueOf(username.getText()), db.generateHash(String.valueOf(password.getText())))) {
                db.setActive(String.valueOf(username.getText()));
                main.changeScene("afterlogin.fxml");
                db.removeResetPasswordUsers();
            } else {
               label.setText("invalid password");
            }
        } else {
            label.setText("invalid user");
        }
    }

    public void registerButtonClicked(ActionEvent event) throws IOException {
        main = new Main();
        main.changeScene("register.fxml");
    }

    public void resetPasswordButtonClicked(ActionEvent event) throws IOException {
        main = new Main();
        main.changeScene("forgotpassword.fxml");
    }

    public void toggleButtonClicked(ActionEvent event) throws IOException {
        main = new Main();
        main.changeWallpaper();
    }
}
