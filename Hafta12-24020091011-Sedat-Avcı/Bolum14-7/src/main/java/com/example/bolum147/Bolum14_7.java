package com.example.bolum147;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

public class Bolum14_7 extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        VBox pane = new VBox(10);
        pane.setPadding(new Insets(20,20,20,20));
        pane.setAlignment(Pos.CENTER);

        for(int i = 0; i < 5; i++){

            Text text = new Text("Java");

            text.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 24));

            text.setFill(new Color(Math.random(), Math.random(),Math.random(),Math.random()));

            pane.getChildren().add(text);

        }

        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("Color and Font");
        primaryStage.setScene(scene);
        primaryStage.show();

        }

        public static void main(String[] args){
        launch();
        }
}
