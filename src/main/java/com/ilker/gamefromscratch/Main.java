package com.ilker.gamefromscratch;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.HashSet;
import java.util.Set;


public class Main extends Application {
    private static final String RANDY_MARSH = "https://www.iconarchive.com/show/south-park-icons-by-sykonist/Randy-Marsh-Guitar-Hero-1-icon.html";

    private static final double SCENE_WIDTH = 800, SCENE_HEIGHT = 600;
    private static final int MOVEMENT_SPEED = 2;

    private Node hero;
    @FXML
    private Rectangle player = new Rectangle();

    @FXML
    private Rectangle ball = new Rectangle();

    @FXML
    private Rectangle hoop = new Rectangle();

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT, Color.BEIGE);

    //        final Canvas canvas = new Canvas(SCENE_WIDTH,SCENE_HEIGHT);
    //        GraphicsContext gc = canvas.getGraphicsContext2D();
    //
    //        gc.setFill(Color.BLUE);
    //        gc.fillRect(0,0, scene.getWidth(), scene.getHeight());
    //
    //        root.getChildren().add(canvas);

        // Player
        player.setX(50);
        player.setY(50);
        player.setWidth(20);
        player.setHeight(100);
        player.setArcWidth(20);
        player.setArcHeight(20);

        root.getChildren().add(player);


        // Movement
        Set<KeyCode> held = new HashSet<KeyCode>();

        scene.setOnKeyPressed (event -> held.add(event.getCode()));
        scene.setOnKeyReleased (event -> held.remove(event.getCode()));

        AnimationTimer timer = new AnimationTimer() {
            public void handle(long now) {
                System.out.println(held);

                int dx = 0, dy = 0;

                if(held.isEmpty()) System.out.println("nothing to do.");
                if(held.contains(KeyCode.UP)) dy -= 1;
                if(held.contains(KeyCode.DOWN)) dy += 1;
                if(held.contains(KeyCode.LEFT)) dx -= 1;
                if(held.contains(KeyCode.RIGHT)) dx += 1;

                System.out.printf("dx: %d \n", dx);
                System.out.printf("dy: %d \n", dy);

                movePlayerBy(dx, dy);
            };
        };

        primaryStage.setTitle("GameFromScratch");
        primaryStage.setScene(scene);
        timer.start();
        primaryStage.show();
    }

    private void movePlayerBy(int dx, int dy) {
        if (dx == 0 && dy == 0) return;

        final double cx = player.getBoundsInLocal().getWidth() / 2;
        final double cy = player.getBoundsInLocal().getHeight() / 2;

        double x = cx + player.getLayoutX() + dx;
        double y = cy + player.getLayoutY() + dy;

        movePlayerTo(x,y);
    }


    private void movePlayerTo(double x, double y) {
        final double cx = player.getBoundsInLocal().getWidth() / 2;
        final double cy = player.getBoundsInLocal().getHeight() / 2;

        System.out.printf("x: %g , y: %g \n", x, y);
        System.out.printf("Within bounds: %b \n", x - cx >= 0 && y - cy >= 0 && x + cx <= SCENE_WIDTH && y + cy <= SCENE_HEIGHT);

        // check if in bounds
        if(x - cx >= 0 && y - cy >= 0 && x + cx <= SCENE_WIDTH && y + cy <= SCENE_HEIGHT) {
            player.relocate(x - cx, y - cy);
        }
    }

    public static void main(String[] args) {launch(args);}
}
