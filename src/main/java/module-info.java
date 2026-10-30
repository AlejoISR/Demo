module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires atlantafx.base;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports com.example.demo.objects;
    opens com.example.demo.objects to javafx.fxml;
    exports com.example.demo.controllers;
    opens com.example.demo.controllers to javafx.fxml;
    exports com.example.demo.i18n;
    opens com.example.demo.i18n to javafx.fxml;
}