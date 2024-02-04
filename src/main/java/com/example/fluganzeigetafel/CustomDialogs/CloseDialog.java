package com.example.fluganzeigetafel.CustomDialogs;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * A simple class for showing custom alerts.
 * @author latifiagon
 */
public class CloseDialog {

    /**
     * This method creates an alert indicating users that closing the current page will result in losing the information, if unsaved,
     * and returns the result of the button as boolean
     * @return true if the user clicked on OK
     */
    public static boolean createCloseDialog() {
        boolean returnType = false;

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("WARNING");
        alert.setHeaderText("Warning");
        alert.setContentText("Do you really want to close this page? Unsaved information will be lost!");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            returnType = true;
        }

        return returnType;
    }
}
