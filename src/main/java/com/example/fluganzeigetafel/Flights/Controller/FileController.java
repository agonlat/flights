package com.example.fluganzeigetafel.Flights.Controller;

import com.example.fluganzeigetafel.Contract.Contract;
import com.example.fluganzeigetafel.CustomDialogs.LoadFlightsDialog;
import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Flights.Data.Flight;
import com.example.fluganzeigetafel.Flights.Handler.FileHandler;
import com.example.fluganzeigetafel.Flights.Manager.FlightChangeManager;
import javafx.concurrent.Task;
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
            DataInterface.flightsTable.refresh();



            Task<Void> task = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    com.example.fluganzeigetafel.Contract.Handler.FileHandler cr = new com.example.fluganzeigetafel.Contract.Handler.FileHandler();
                    ArrayList<Contract> contractArrayList = cr.readCSV_toList("src/main/resources/au-20240102 (1).csv");
                    DataInterface.getInstance().setContracts(contractArrayList);


                    cr.addContractsToFlights(DataInterface.getInstance().getContracts());



                    return null;
                }
            };








            new Thread(task).start();




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
