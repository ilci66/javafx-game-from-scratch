package com.ilker.gamefromscratch;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher {

    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root);
        primaryStage.setTitle("GameFromScratch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        // Application.launch(HelloApplication.class, args);
        Application.launch(args);

    }

}
