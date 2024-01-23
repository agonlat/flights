package com.example.fluganzeigetafel.CustomDialogs;

import javafx.scene.control.Alert;

public class QuestionDialog extends Alert{
    public QuestionDialog() {
        super(AlertType.WARNING);
        this.setHeaderText("Warning");
        this.setTitle("Warning");
        this.setContentText("Do you really want to delete the contract?");


    }

}
