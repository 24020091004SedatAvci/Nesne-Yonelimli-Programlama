package com.example.bolum143;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i < 12; i++){
            list.add(i);
        }

        Collections.shuffle(list);

        HBox pane = new HBox(10);

        pane.setAlignment(Pos.CENTER);

        for(int i = 0; i < 3; i++){
            int imageNumber = list.get(i);

            String path = "/image/tiengow/" + imageNumber + ".png";

            try {

                Image img = new Image(getClass().getResourceAsStream(path));
                ImageView imageView = new ImageView(img);

                imageView.setFitHeight(150);
                imageView.setPreserveRatio(true);

                pane.getChildren().add(imageView);

            } catch (Exception e) {
                System.out.println("Hata: " + path + " yüklenemedi.");
            }
        }
        Scene scene = new Scene(pane, 600, 250);
        primaryStage.setTitle("Random Tiles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch();
    }
}
