package com.ilker.gamefromscratch;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;

import java.util.ResourceBundle;

public class MovementController {
    @FXML
    private Rectangle ball;

    @FXML
    private Rectangle player;

    @FXML
    private Rectangle hoop;


    @FXML
    void start(ActionEvent event) {
        ball.setLayoutX(200);
        ball.setLayoutY(200);
    }

    AnimationTimer collisionTimer = new AnimationTimer() {
        @Override
        public void handle(long timestamp) {
            checkCollision(ball, hoop);
        }
    };

//    public void initialize(ResourceBundle resourceBundle) {
//        MovementController movementController = new MovementController(ball, scene);
//
//        collisionTimer.start();
//    }

    public void checkCollision(Rectangle ball, Rectangle hoop) {
        if(ball.getBoundsInParent().intersects(hoop.getBoundsInParent())) {
            System.out.println("Collision");
        }
    }

}
