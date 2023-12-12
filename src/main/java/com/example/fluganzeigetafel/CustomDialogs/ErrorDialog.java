package com.example.fluganzeigetafel.CustomDialogs;

import javafx.scene.control.Alert;
import javafx.scene.layout.Region;

public class ErrorDialog {

    public ErrorDialog(String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(text);
        alert.getDialogPane().setMinWidth(Region.USE_PREF_SIZE);
        alert.showAndWait();
    }

}
