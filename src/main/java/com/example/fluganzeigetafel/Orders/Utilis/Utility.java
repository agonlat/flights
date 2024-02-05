package com.example.fluganzeigetafel.Orders.Utilis;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TextField;
/**
 * The Utility class provides utility methods for handling common tasks.
 */
public class Utility {
     /**
     * Checks if the text fields in the given list are empty.
     *
     * @param nodes The list of nodes to check.
     * @return true if any of the text fields are empty, false otherwise.
     */
    public static boolean fieldsAreEmpty(ObservableList<Node> nodes) {
        for (Node node : nodes) {
            if (node instanceof TextField) {
                TextField field = (TextField) node;
                if (field.getText().isBlank()) {
                    return true;
                }
            }
        }
        return false;
    }
}
