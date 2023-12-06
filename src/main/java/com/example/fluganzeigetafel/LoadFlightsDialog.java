package com.example.fluganzeigetafel;

import javafx.scene.control.Alert;

public class LoadFlightsDialog {

    public LoadFlightsDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setContentText("Please load flights to proceed!");
        alert.showAndWait();
    }
}
