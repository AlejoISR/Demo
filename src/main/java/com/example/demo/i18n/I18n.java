package com.example.demo.i18n;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextInputControl;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class I18n {

    private static final ObjectProperty<Locale> locale = new SimpleObjectProperty<>(Locale.forLanguageTag("es-ES"));

    public static Locale getLocale() {
        return locale.get();
    }

    public static void setLocale(Locale newLocale) {
        locale.set(newLocale);
    }

    public static ObjectProperty<Locale> localeProperty() {
        return locale;
    }

    public static String get(String clave) {
        ResourceBundle caja = ResourceBundle.getBundle("i18n.messages", locale.get());
        return caja.getString(clave);
    }

    public static Parent loadRoot(URL fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(fxml);
        Parent parent = loader.load();

        processRoot(parent);

        return parent;
    }

    public static StringBinding bind(String userData) {
        return Bindings.createStringBinding(() -> get(userData), locale);
    }

    public static void processNode(Object userData, StringProperty text) {
        if (userData instanceof String u && !u.isBlank()) {
            text.bind(bind(u));
        }
    }

    public static void processRoot(Node node) {
        if (node == null) return;

        // PROCESAR LOS NODOS
        if (node instanceof Labeled n) processNode(n.getUserData(), n.textProperty());
        if (node instanceof TextInputControl n) processNode(n.getUserData(), n.promptTextProperty());

        if (node instanceof Parent n) n.getChildrenUnmodifiable().forEach(I18n::processRoot);
    }
}
