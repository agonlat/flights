package com.example.fluganzeigetafel.CustomDialogs;

import javafx.scene.control.Alert;

/**
 * A simple class for showing custom alerts.
 * @author latifiagon
 */
public class EmptyFieldsDialog  {

    /**
     * This constructor creates the custom alert indicating that the action cannot proceed since at least one field is empty.
     * So every field has to be filled!
     * Note that the return type of the clicked button is not needed for the programm logic.
     */
    public EmptyFieldsDialog() {
       Alert alert = new Alert(Alert.AlertType.ERROR);
       alert.setTitle("Error");
       alert.setContentText("Cannot proceed! At least one field is empty.");
       alert.setHeaderText("Error");
       alert.showAndWait();
   }

}
