package com.example.demo;

import atlantafx.base.theme.Dracula;
import atlantafx.base.theme.Theme;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML private ChoiceBox<Option<Theme>> choiceboxTheme;


    @Override
    public void initialize(URL location, ResourceBundle resources) {



        choiceboxTheme.getItems().addAll(List.of(

                new Option<>("Dracula", new Dracula()),
        new Option<>("Nord (Light)", new Dracula()),
        new Option<>("Nord (Dark)", new Dracula())

        ));


        choiceboxTheme.valueProperty().addListener((observable, oldValue, newValue)->{
           Theme newTheme = (Theme) newValue.getObject();
            Application.setUserAgentStylesheet(newTheme.getUserAgentStylesheet());
        });

    }
}