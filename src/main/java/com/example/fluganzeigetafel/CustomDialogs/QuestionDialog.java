package com.example.fluganzeigetafel.CustomDialogs;

import javafx.scene.control.Alert;

/**
 * A class that represents question alerts.
 * @author latifiagon
 */
public class QuestionDialog extends Alert{

    /**
     * This constructor creates the close alert that warns with a specific message.
     */
    public QuestionDialog() {
        super(AlertType.WARNING);
        this.setHeaderText("Warning");
        this.setTitle("Warning");
        this.setContentText("Do you really want to delete the order?");


    }

}
