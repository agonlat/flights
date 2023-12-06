package com.example.fluganzeigetafel;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.FileHandler;

import java.io.File;
import java.util.ArrayList;

public class FileMenu {
    static void fileLoadAction(Stage stage) {
        DataInterface dataInterface = DataInterface.getInstance();

        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV-Files", "*.csv"));

        File file = chooser.showOpenDialog(stage);

        FileHandler fileHandler = new FileHandler();

        if (file != null) {
            dataInterface.setFilePath(file.getAbsolutePath());

            ArrayList<Flight> flights = fileHandler.readCSV_File(dataInterface.getFilePath());
            dataInterface.addFlights(flights);

            dataInterface.flightsTable.populateTable(flights);
        }
    }

    static void fileExportAction() {
        DataInterface df = DataInterface.getInstance();
        if (df.getFlights().isEmpty()) {
            LoadFlightsDialog dialog = new LoadFlightsDialog();
            return;
        }


        FileHandler handler = new FileHandler();
        handler.writeToCSV_File((ArrayList<Flight>) df.getFlights());
    }

    static void flightChangeAction() {
        DataInterface df = DataInterface.getInstance();

        if (df.getFlights().isEmpty()) {
            LoadFlightsDialog dialog = new LoadFlightsDialog();
            return;
        }

        FlightChange flightChange = new FlightChange();
    }

}
