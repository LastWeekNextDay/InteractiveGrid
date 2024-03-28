module dev.lwnd.interactivegrid {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens dev.lwnd.interactivegrid to javafx.fxml;
    exports dev.lwnd.interactivegrid;
}