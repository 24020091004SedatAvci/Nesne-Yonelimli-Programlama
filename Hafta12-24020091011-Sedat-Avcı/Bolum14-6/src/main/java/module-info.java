module com.example.bolum146 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bolum146 to javafx.fxml;
    exports com.example.bolum146;
}