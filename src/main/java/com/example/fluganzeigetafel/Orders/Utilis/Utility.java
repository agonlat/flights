package com.example.fluganzeigetafel.Orders.Utilis;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TextField;

public class Utility {
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
