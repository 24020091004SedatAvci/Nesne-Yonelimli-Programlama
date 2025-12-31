module com.example.bolum147 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bolum147 to javafx.fxml;
    exports com.example.bolum147;
}