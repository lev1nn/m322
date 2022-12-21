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
        System.out.printf("[SERVER] email -> %s, msg: \"your new password is 'n3wp4ssw0rd!', try now to log in with your new password\" %n", emailaddress.getText());
        main.changeScene("login.fxml");
        //main.showPopup("your new password is 'n3wp4ssw0rd!'");
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
