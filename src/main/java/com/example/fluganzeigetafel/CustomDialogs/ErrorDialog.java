package com.example.fluganzeigetafel.CustomDialogs;

import javafx.scene.control.Alert;
import javafx.scene.layout.Region;

/**
 * A class that represents Error Dialogs.
 * @author latifiagon
 */
public class ErrorDialog {

    /**
     * This constructor can be used along with a parameter as a String, which represents the error type.
     * @param text The error text to be displayed.
     */
    public ErrorDialog(String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error");
        alert.setContentText(text);
        alert.getDialogPane().setMinWidth(Region.USE_PREF_SIZE);
        alert.showAndWait();
    }

}
