package com.example.loginsystem;

import com.example.loginsystem.database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

    public void loginButtonClicked(ActionEvent event) throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {
        Main main = new Main();

        /*db = Database.getInstance();

        db.addUser("user", "1234", "email");

        if (db.checkUser(String.valueOf(username))) {
            if (db.checkPassword(String.valueOf(username), String.valueOf(password))) {
                main.changeScene("afterlogin.fxml");
            } else System.out.println("password not valid");
        } else System.out.println("username not valid");*/

        if (username.getText().toString().equals("root") && password.getText().toString().equals("1234")) {
            main.changeScene("afterlogin.fxml");
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
