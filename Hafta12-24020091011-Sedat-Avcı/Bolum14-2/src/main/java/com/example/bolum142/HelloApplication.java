package com.example.bolum142;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {

        GridPane pane = new GridPane();

        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);


        Image imageX = new Image(getClass().getResourceAsStream("/image/x.png"));
        Image imageO = new Image(getClass().getResourceAsStream("/image/o.png"));

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){

                StackPane cell = new StackPane();

                cell.setStyle("-fx-border-color: black; -fx-border-width: 50; -fx-pref-height: 50;");
                int status = (int)(Math.random() * 3);

                if(status == 0){
                   ImageView imgView = new ImageView(imageX);

                   cell.getChildren().add(imgView);
                }
                else if(status == 1){
                    ImageView imgView = new ImageView(imageO);

                    cell.getChildren().add(imgView);
                }
                pane.add(cell, j, i);
            }
        }
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Tic-Tac-Toe Board");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch();
    }
}
