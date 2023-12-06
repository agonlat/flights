package com.example.fluganzeigetafel;

import javafx.scene.control.Alert;

public class ErrorDialog {

    public ErrorDialog(String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(text);
        alert.showAndWait();
    }

}
