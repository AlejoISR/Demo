package com.example.demo.controllers;

import atlantafx.base.theme.CupertinoDark;
import atlantafx.base.theme.CupertinoLight;
import atlantafx.base.theme.Dracula;
import atlantafx.base.theme.NordDark;
import atlantafx.base.theme.NordLight;
import atlantafx.base.theme.PrimerDark;
import atlantafx.base.theme.PrimerLight;
import atlantafx.base.theme.Theme;
import com.example.demo.i18n.I18n;
import com.example.demo.objects.Option;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML private ChoiceBox<Option<Theme>> choiceboxTheme;
    @FXML private ChoiceBox<Option<Locale>> choiceboxLanguage;
    @FXML private Button buttonSave;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Option<Locale> englishOption = new Option<>("English", Locale.forLanguageTag("en-UK"));
        Option<Locale> spanishOption = new Option<>("Español", Locale.forLanguageTag("es-ES"));

        choiceboxLanguage.getItems().addAll(List.of(
                englishOption,
                spanishOption
        ));
        choiceboxLanguage.setValue(spanishOption);

        choiceboxLanguage.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                Locale newLocale = newValue.getObject();
                I18n.setLocale(newLocale);
            }
        });

        Option<Theme> primerDarkOption = new Option<>("Primer (Dark)", new PrimerDark());
        choiceboxTheme.getItems().addAll(List.of(
                primerDarkOption,
                new Option<>("Primer (Light)", new PrimerLight()),
                new Option<>("Dracula", new Dracula()),
                new Option<>("Nord (Light)", new NordLight()),
                new Option<>("Nord (Dark)", new NordDark()),
                new Option<>("Cupertino (Light)", new CupertinoLight()),
                new Option<>("Cupertino (Dark)", new CupertinoDark())
        ));
        choiceboxTheme.setValue(primerDarkOption);

        choiceboxTheme.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                Theme newTheme = newValue.getObject();
                Application.setUserAgentStylesheet(newTheme.getUserAgentStylesheet());
            }
        });
    }
}
