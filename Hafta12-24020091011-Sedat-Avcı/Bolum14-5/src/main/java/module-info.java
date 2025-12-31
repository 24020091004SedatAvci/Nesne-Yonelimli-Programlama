module com.example.bolum145 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bolum145 to javafx.fxml;
    exports com.example.bolum145;
}