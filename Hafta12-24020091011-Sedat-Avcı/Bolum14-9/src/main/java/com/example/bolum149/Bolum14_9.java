package com.example.bolum149;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class Bolum14_9 extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setHgap(10);
        pane.setVgap(10);

        pane.add(new TaichiPane(), 0, 0);
        pane.add(new TaichiPane(), 1, 0);
        pane.add(new TaichiPane(), 0, 1);
        pane.add(new TaichiPane(), 1, 1);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("4 Taichis");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    class TaichiPane extends Pane{
        public TaichiPane(){
            setPrefWidth(200);
            setPrefHeight(200);


            double w = 200, h = 200;
            double radius = w / 2 * 0.90;
            double centerX = w / 2;
            double centerY = h / 2;

            Circle largeCirgle = new Circle(centerX, centerY, radius);
            largeCirgle.setFill(Color.WHITE);
            largeCirgle.setStroke(Color.BLACK);

            Arc arc = new Arc(centerX, centerY, radius, radius, 90,180);
            arc.setType(ArcType.OPEN);
            arc.setFill(Color.BLACK);

            Circle topCircle = new Circle(centerX, centerY - radius / 2, radius / 2);
            topCircle.setFill(Color.BLACK);

            Circle bottomCircle = new Circle(centerX, centerY + radius / 2, radius / 2);
            bottomCircle.setFill(Color.WHITE);

            Circle topDot = new Circle(centerX, centerY - radius / 2, radius / 8);
            topDot.setFill(Color.WHITE);

            Circle bottomDot = new Circle(centerX, centerY + radius / 2, radius / 8);
            bottomDot.setFill(Color.BLACK);

           getChildren().addAll(largeCirgle, arc, topCircle, bottomCircle, topDot, bottomDot);


        }
    }
    public static void main(String[] args){
        launch();
    }
}
