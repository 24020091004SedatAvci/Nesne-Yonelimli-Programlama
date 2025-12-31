package com.example.bolum145;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class Bolum14_5 extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        GridPane pane = new GridPane();

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){

                Rectangle rect = new Rectangle(40, 40);

                if((i + j) % 2 == 0){
                    rect.setFill(Color.WHITE);
                }else{
                    rect.setFill(Color.BLACK);
                }

                pane.add(rect, i, j);
            }
        }

        Scene scene = new Scene(pane);
        primaryStage.setTitle("--CheckerBoard--");
        primaryStage.setScene(scene);
        primaryStage.show();

        }
        public static void main(String[] args){
            launch();
        }
}
