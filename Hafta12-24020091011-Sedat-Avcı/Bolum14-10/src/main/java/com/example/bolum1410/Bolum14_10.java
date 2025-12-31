package com.example.bolum1410;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Bolum14_10 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();


        Ellipse topEllipse = new Ellipse();
        topEllipse.setFill(Color.WHITE);
        topEllipse.setStroke(Color.BLACK);


        topEllipse.centerXProperty().bind(pane.widthProperty().divide(2));
        topEllipse.radiusXProperty().bind(pane.widthProperty().divide(2).multiply(0.8));


        topEllipse.centerYProperty().bind(pane.heightProperty().divide(4));
        topEllipse.radiusYProperty().bind(pane.heightProperty().divide(8));




        Arc bottomArcBack = new Arc();
        bottomArcBack.setFill(Color.WHITE);
        bottomArcBack.setStroke(Color.BLACK);


        bottomArcBack.getStrokeDashArray().addAll(6.0, 21.0);
        bottomArcBack.setType(ArcType.OPEN);
        bottomArcBack.setStartAngle(0);
        bottomArcBack.setLength(180);

        bottomArcBack.centerXProperty().bind(pane.widthProperty().divide(2));
        bottomArcBack.radiusXProperty().bind(pane.widthProperty().divide(2).multiply(0.8));

        bottomArcBack.centerYProperty().bind(pane.heightProperty().multiply(0.75));
        bottomArcBack.radiusYProperty().bind(pane.heightProperty().divide(8));

        Arc bottomArcFront = new Arc();
        bottomArcFront.setFill(Color.WHITE);
        bottomArcFront.setStroke(Color.BLACK);
        bottomArcFront.setType(ArcType.OPEN);
        bottomArcFront.setStartAngle(180);
        bottomArcFront.setLength(180);


        bottomArcFront.centerXProperty().bind(bottomArcBack.centerXProperty());
        bottomArcFront.centerYProperty().bind(bottomArcBack.centerYProperty());
        bottomArcFront.radiusXProperty().bind(bottomArcBack.radiusXProperty());
        bottomArcFront.radiusYProperty().bind(bottomArcBack.radiusYProperty());


        Line leftLine = new Line();
        Line rightLine = new Line();


        leftLine.startXProperty().bind(topEllipse.centerXProperty().subtract(topEllipse.radiusXProperty()));
        leftLine.startYProperty().bind(topEllipse.centerYProperty());
        leftLine.endXProperty().bind(bottomArcBack.centerXProperty().subtract(bottomArcBack.radiusXProperty()));
        leftLine.endYProperty().bind(bottomArcBack.centerYProperty());


        rightLine.startXProperty().bind(topEllipse.centerXProperty().add(topEllipse.radiusXProperty()));
        rightLine.startYProperty().bind(topEllipse.centerYProperty());
        rightLine.endXProperty().bind(bottomArcBack.centerXProperty().add(bottomArcBack.radiusXProperty()));
        rightLine.endYProperty().bind(bottomArcBack.centerYProperty());


        pane.getChildren().addAll(bottomArcBack, bottomArcFront, topEllipse, leftLine, rightLine);

        Scene scene = new Scene(pane, 300, 400);
        primaryStage.setTitle("Exercise14_10");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}