package com.example.loginsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Stage stg;
    private static Scene scene;
    private static String theme = "dark";
    private String darkTheme = getClass().getResource("css/styles-dark.css").toExternalForm();
    private String lightTheme = getClass().getResource("css/styles-light.css").toExternalForm();

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        scene = new Scene(fxmlLoader.load(), 650, 375);
        scene.getStylesheets().add(darkTheme);
        stage.setTitle("Login System");
        stage.setScene(scene);
        stage.show();
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
        stg.show();
    }

    public void changeWallpaper() throws IOException {
        if (theme.equals("dark")) {
            theme = "light";
            scene.getStylesheets().remove(darkTheme);
            scene.getStylesheets().add(lightTheme);
        } else {
            theme = "dark";
            scene.getStylesheets().remove(lightTheme);
            scene.getStylesheets().add(darkTheme);
        }
    }
}
