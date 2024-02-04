package com.example.fluganzeigetafel.CustomDialogs;

import javafx.scene.control.Alert;

/**
 * A class that represents alerts for loading flights.
 * @author latifiagon
 */
public class LoadFlightsDialog {

    /**
     * This constructor creates an alert indicating that the flights has to be loaded before proceeding with operations.
     */
    public LoadFlightsDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Information");
        alert.setContentText("Please load flights to proceed!");
        alert.showAndWait();
    }
}
