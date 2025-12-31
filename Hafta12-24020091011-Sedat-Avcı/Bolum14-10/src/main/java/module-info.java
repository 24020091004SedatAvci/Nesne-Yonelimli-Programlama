module com.example.bolum1410 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bolum1410 to javafx.fxml;
    exports com.example.bolum1410;
}