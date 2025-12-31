module com.example.bolum141 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bolum141 to javafx.fxml;
    exports com.example.bolum141;
}