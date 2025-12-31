package com.example.bolum148;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Bolum14_8 extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        GridPane pane = new GridPane();

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){

                TextField tf = new TextField();

                tf.setPrefColumnCount(1);
                tf.setPrefWidth(30);
                tf.setPrefHeight(30);
                tf.setAlignment(Pos.CENTER);

                tf.setEditable(false);


                int randomNum = (int)(Math.random() * 2);

                tf.setText(String.valueOf(randomNum));

                pane.add(tf, j, i);
            }
        }

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Random 0 or 1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main( String[] args){
        launch();
    }
}
