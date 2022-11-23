module com.example.loginsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires gson;
    requires java.sql;

    opens com.example.loginsystem to javafx.fxml;
    exports com.example.loginsystem;
    exports com.example.loginsystem.database;
}