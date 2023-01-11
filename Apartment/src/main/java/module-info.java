module chamberlain_kevin.apartment {
    requires javafx.controls;
    requires javafx.fxml;


    opens chamberlain_kevin.apartment to javafx.fxml;
    exports chamberlain_kevin.apartment;
}