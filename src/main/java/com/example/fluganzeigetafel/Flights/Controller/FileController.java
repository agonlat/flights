package com.example.fluganzeigetafel.Flights.Controller;

import com.example.fluganzeigetafel.CustomDialogs.LoadFlightsDialog;
import com.example.fluganzeigetafel.CustomDialogs.PopupSuccess;
import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Flights.Data.Flight;
import com.example.fluganzeigetafel.Flights.Data.FlightsTable;
import com.example.fluganzeigetafel.Flights.Handler.FileHandler;
import com.example.fluganzeigetafel.Flights.Manager.FlightChangeManager;
import com.example.fluganzeigetafel.Orders.Order;
import com.example.fluganzeigetafel.Orders.Suborders.SubOrdersFileHandler;
import com.example.fluganzeigetafel.Orders.Suborders.Suborder;
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
            FlightsTable table = dataInterface.flightsTable.populateTable(flights);



            Task<Void> task = new Task<Void>() {
                @Override
                protected Void call() throws Exception {

                    DataInterface.flightsTable.refresh();
                    DataInterface.getInstance().setThreadRunning(true);
                    com.example.fluganzeigetafel.Orders.Handler.FileHandler cr = new com.example.fluganzeigetafel.Orders.Handler.FileHandler();
                    ArrayList<Order> orderArrayList = cr.readCSV_toList("src/main/resources/au.csv");
                    DataInterface.getInstance().setContracts(orderArrayList);


                    cr.addOrdersToFlights(DataInterface.getInstance().getContracts());
                    FlightsTable.addOrderItems(table);
                    DataInterface.flightsTable.refresh();
                    SubOrdersFileHandler fileHandlerd = new SubOrdersFileHandler();
                    ArrayList<Suborder> suborderArrayList = fileHandlerd.readCSVtoListOfSubOrders("src/main/resources/ua.csv");
                    fileHandlerd.addSubOrdersToOrders(suborderArrayList);
                    DataInterface.getInstance().setSubcontractsList(suborderArrayList);
                    DataInterface.flightsTable.refresh();


                    FlightsTable.addSubOrderItems(table);
                    return null;
                }
            };



task.setOnSucceeded(e->{
    DataInterface.getInstance().setThreadRunning(false);
    PopupSuccess success = new PopupSuccess("Orders and suborders loaded successfully", stage);

});




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
