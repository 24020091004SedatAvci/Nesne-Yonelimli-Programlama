package com.example.bolum141;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.InputStream;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {

        GridPane pane = new GridPane();

        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setPadding(new Insets(10, 10, 10, 10));

        Image imgTur = new Image(getClass().getResourceAsStream("/image/Turkiye.png"));
        Image imgJap = new Image(getClass().getResourceAsStream("/image/japonya.png"));
        Image imgGer = new Image(getClass().getResourceAsStream("/image/almanya.png"));
        Image imgUk = new Image(getClass().getResourceAsStream("/image/ingiltere.png"));

        pane.add(new ImageView(imgTur),0,0);
        pane.add(new ImageView(imgJap),1,0);
        pane.add(new ImageView(imgGer),0,1);
        pane.add(new ImageView(imgUk),1,1);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Bolum14-1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

        public static void main(String[] args){
            launch();
        }


}
