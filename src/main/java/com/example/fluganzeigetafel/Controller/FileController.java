package com.example.fluganzeigetafel.Controller;

import com.example.fluganzeigetafel.CustomDialogs.LoadFlightsDialog;
import com.example.fluganzeigetafel.Data.DataInterface;
import com.example.fluganzeigetafel.Data.Flight;
import com.example.fluganzeigetafel.Handler.FileHandler;
import com.example.fluganzeigetafel.Manager.FlightChangeManager;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class FileController {
    public static void fileLoadAction(Stage stage) {
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

    public static void fileExportAction() {
        DataInterface df = DataInterface.getInstance();
        if (df.getFlights().isEmpty()) {
            LoadFlightsDialog dialog = new LoadFlightsDialog();
            return;
        }


        FileHandler handler = new FileHandler();
        handler.writeToCSV_File((ArrayList<Flight>) df.getFlights());
    }

    public static void flightChangeAction(Stage mainStage) {
        DataInterface df = DataInterface.getInstance();

        if (df.getFlights().isEmpty()) {
            LoadFlightsDialog dialog = new LoadFlightsDialog();
            return;
        }

        FlightChangeManager flightChangeManager = new FlightChangeManager(mainStage);
    }

}
