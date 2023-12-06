package com.example.fluganzeigetafel;

import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class FilterAndSearchMethods {
    public static void filterFlights(TextField filterTextField) {

        filterTextField.textProperty().addListener((observable, oldValue, newValue) -> {


        DataInterface dataInterface = DataInterface.getInstance();
        ArrayList<Flight> flights = (ArrayList<Flight>) dataInterface.getFlights();

        // Create a filtered list
        FilteredList<Flight> filteredFlights = new FilteredList<>(FXCollections.observableArrayList(flights));

        String filter = newValue.trim();

        // Set the filter predicate
        filteredFlights.setPredicate(flight ->
                flight.getFnr().startsWith(filter) || flight.getKnr().startsWith(filter));

        // Update the TableView with the filtered list
        DataInterface.flightsTable.setItems(filteredFlights);

        // Refresh the TableView
        DataInterface.flightsTable.refresh();

        // If the filter is empty, show all flights
        if (newValue.isBlank()) {
            DataInterface.flightsTable.setItems(FXCollections.observableArrayList(flights));
            DataInterface.flightsTable.refresh();
        }
        });

    }

    public static void searchAction() {
        Stage stage = new Stage();


    }

}
