package com.example.fluganzeigetafel.Flights.Utility;

import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Flights.Data.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;

public class FilterAndSearchMethods {


    public static void filterFlights(TextField filterTextField) {
        filterTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Changed");
            ObservableList<TreeItem<Flight>> treeItems = DataInterface.getInstance().getFlightItems();
            String filter = newValue.trim().toUpperCase();
            FilteredList<TreeItem<Flight>> filteredFlights = new FilteredList<>(FXCollections.observableArrayList(treeItems));

            if (DataInterface.getInstance().isThreadRunning() && !filterTextField.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Please wait until the orders and suborders are loaded! A popup should appear after finishing");
                alert.setHeaderText("WARNING");
                alert.showAndWait();
                filterTextField.setText("");
                return;
            }

            if (newValue.isBlank()) {
                // If the filter is blank, reset the table to display all flights


                DataInterface.getFlightsTable().populateTable(DataInterface.getInstance().getItemsCopy());
                DataInterface.flightsTable.refresh();

            } else {
                filteredFlights = new FilteredList<>(FXCollections.observableArrayList(DataInterface.getInstance().getItemsCopy()));

                filteredFlights.setPredicate(pred ->
                        (pred.getValue().getFnr().toUpperCase().startsWith(filter) || pred.getValue().getKnr().toUpperCase().startsWith(filter)) &&
                                (!"Order".equals(pred.getValue().getKnr()) && !"Suborder".equals(pred.getValue().getKnr()))
                );

                for (TreeItem<Flight> item : filteredFlights) {
                    DataInterface.getInstance().getTemporaryFlights().add(item.getValue());
                }

                // Clear existing items and add filtered ones
                DataInterface.flightsTable.getRoot().getChildren().setAll(filteredFlights);
                DataInterface.flightsTable.refresh();
            }
        });


    }
}
