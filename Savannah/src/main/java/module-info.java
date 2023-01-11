module chamberlain_kevin.savannah {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens chamberlain_kevin.savannah to javafx.fxml;
    exports chamberlain_kevin.savannah;
}