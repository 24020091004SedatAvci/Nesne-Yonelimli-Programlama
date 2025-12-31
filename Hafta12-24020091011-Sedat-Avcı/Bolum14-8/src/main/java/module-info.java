module com.example.bolum148 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bolum148 to javafx.fxml;
    exports com.example.bolum148;
}