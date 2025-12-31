module com.example.bolum149 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bolum149 to javafx.fxml;
    exports com.example.bolum149;
}