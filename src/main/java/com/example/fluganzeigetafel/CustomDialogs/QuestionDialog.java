package com.example.fluganzeigetafel.CustomDialogs;

import javafx.scene.control.Alert;

public class QuestionDialog extends Alert{
    public QuestionDialog() {
        super(AlertType.WARNING);

        this.setContentText("Do you really want to delete the contract?");


    }

}
