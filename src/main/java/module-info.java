module com.example.task {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.task to javafx.fxml;
    exports com.example.task;
}