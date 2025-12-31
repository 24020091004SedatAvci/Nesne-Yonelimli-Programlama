package com.example.bolum146;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import java.io.IOException;

public class Bolum14_6 extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(5, 5, 5, 5));
        pane.setHgap(5);
        pane.setVgap(5);

        int cardIndex = 0;

        for(int i = 0; i <= 52; i++){

            String path = "/image/" + i + ".png";

            try{
                Image image = new Image(getClass().getResourceAsStream(path));
                ImageView imageView = new ImageView(image);

                imageView.setFitWidth(80);
                imageView.setFitHeight(120);

                imageView.setPreserveRatio(true);

                javafx.scene.layout.StackPane kutu = new javafx.scene.layout.StackPane();

                kutu.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-background-color: white;");

                kutu.setPadding(new Insets(2, 2, 2, 2));

                kutu.getChildren().add(imageView);

                pane.add(kutu, cardIndex % 9, cardIndex / 9);

                cardIndex++;
            }catch(Exception e){
                System.out.println("Resim Bulunamadi" + path);

            }
        }

        Scene scene  =new Scene(pane);
        primaryStage.setTitle("52 Cards Grid");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch();
    }

}
