package com.example.task;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private static Stage stg;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Scene1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Little Meow!");
        stage.getIcons().add(new Image("C:\\Users\\hp\\IdeaProjects\\Task\\src\\main\\resources\\com\\example\\task\\every.jpeg"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }

    public static void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(HelloApplication.class.getResource(fxml));
        stg.getScene().setRoot(pane);
    }
}