module com.example.bolum142 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bolum142 to javafx.fxml;
    exports com.example.bolum142;
}