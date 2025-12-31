package com.example.bolum144;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.IOException;

public class Bolum14_4 extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        Pane pane = new Pane();

        String str  = "3 4 5 6 7 8 9 10 11 12 1 2 ";

        double centerx = 200;
        double centerY = 200;
        double radius = 100;

        Font font = Font.font("Times New Roman", FontWeight.BOLD, 30);

        for(int i = 0; i < str.length(); i++){

            double angleDegress = i * (360.0 / str.length());

            double angleRadians = Math.toRadians(angleDegress);

            double x = centerx + radius * Math.cos(angleRadians);
            double y = centerY + radius * Math.sin(angleRadians);

            Text text = new Text(x, y, str.charAt(i) + "");

            text.setRotate(angleDegress  + 90);

            pane.getChildren().add(text);
        }

        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Caharacters around circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch();
    }
}
