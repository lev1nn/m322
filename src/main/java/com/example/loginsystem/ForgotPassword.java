package com.example.loginsystem;

import com.example.loginsystem.database.Database;
import com.example.loginsystem.database.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ForgotPassword {
    private static Database db;
    private static Main main;

    @FXML
    private Button button;
    @FXML
    private TextField emailaddress;

    public void resetPasswordButtonClicked(ActionEvent event) throws IOException {
        main = new Main();
        db = Database.getInstance();

        User user = db.getUserFromEmail(emailaddress.getText());
        user.setPassword(db.generateHash("n3wp4ssw0rd!"));
        db.saveChanges();
        db.setResetPasswordUser(user.getUsername());
        main.changeScene("login.fxml");
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
