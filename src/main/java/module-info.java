module com.example.project2jadv {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.project2jadv to javafx.fxml;
    exports com.example.project2jadv;
}