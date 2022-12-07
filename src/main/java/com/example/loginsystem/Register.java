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
    private static Main main;

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

        if (String.valueOf(emailaddress.getText()).equals("")) {
            label.setText("Empty emailaddress, please type a emailaddress");
        } else if (String.valueOf(username.getText()).equals("")) {
            label.setText("Empty username, please type a username");
        } else if (String.valueOf(password.getText()).equals("")) {
            label.setText("Empty password, please type a password");
        } else {
            if (!db.checkEmail(String.valueOf(emailaddress.getText()))) {
                if (!db.checkUser(String.valueOf(username.getText()))) {
                    db.addUser(String.valueOf(username.getText()), (db.generateHash(String.valueOf(password.getText()))), String.valueOf(emailaddress.getText()));
                    db.saveChanges();

                    main = new Main();
                    main.changeScene("login.fxml");

                } else label.setText("Username already exists, please take an other one");
            } else label.setText("Account with this emailaddress already exists");
        }
    }

    public void loginButtonClicked(ActionEvent event) throws IOException {
        main = new Main();
        main.changeScene("login.fxml");
    }

    public void toggleButtonClicked(ActionEvent event) throws IOException {
        main = new Main();
        main.changeWallpaper();
    }
}
