package com.example.fluganzeigetafel.Flights.Utility;

import com.example.fluganzeigetafel.CustomDialogs.LoadFlightsDialog;
import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Flights.Data.Flight;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class FilterAndSearchMethods {
    static int counter = 0;
    public static void filterFlights(TextField filterTextField) {





        filterTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (DataInterface.getInstance().getFlights().isEmpty() && counter == 0) {
                LoadFlightsDialog loadFlightsDialog = new LoadFlightsDialog();
                counter++;
                filterTextField.clear();
                counter = 0;
                return;
            }

        DataInterface dataInterface = DataInterface.getInstance();
        ArrayList<Flight> flights = (ArrayList<Flight>) dataInterface.getFlights();

        // Create a filtered list
        FilteredList<Flight> filteredFlights = new FilteredList<>(FXCollections.observableArrayList(flights));


        String filter = newValue.trim();

        // Set the filter predicate
        filteredFlights.setPredicate(flight ->
                flight.getFnr().startsWith(filter) || flight.getKnr().startsWith(filter));

            List<Flight> arrayList = new ArrayList<>(filteredFlights);
            DataInterface.getInstance().addTemporaryFlights(arrayList);
        // Update the TableView with the filtered list
        DataInterface.flightsTable.populateTable(filteredFlights);

        // Refresh the TableView
        DataInterface.flightsTable.refresh();

        // If the filter is empty, show all flights
        if (newValue.isBlank()) {
            DataInterface.getInstance().addFlights(flights);
            DataInterface.flightsTable.populateTable(flights);
            DataInterface.flightsTable.refresh();
        }
        });

    }



}
