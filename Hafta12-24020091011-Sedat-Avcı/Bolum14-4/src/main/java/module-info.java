module com.example.bolum144 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bolum144 to javafx.fxml;
    exports com.example.bolum144;
}