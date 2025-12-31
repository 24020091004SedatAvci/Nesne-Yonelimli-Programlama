module com.example.bolum143 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bolum143 to javafx.fxml;
    exports com.example.bolum143;
}