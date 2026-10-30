package com.example.demo;

import atlantafx.base.theme.PrimerDark;
import atlantafx.base.theme.Theme;
import com.example.demo.i18n.I18n;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Theme theme = new PrimerDark();
        Application.setUserAgentStylesheet(theme.getUserAgentStylesheet());

        Scene scene = new Scene(I18n.loadRoot(MainApplication.class.getResource("Main-view.fxml")), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
