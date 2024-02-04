package com.example.fluganzeigetafel.Flights.Controller;

import com.example.fluganzeigetafel.CustomDialogs.LoadFlightsDialog;
import com.example.fluganzeigetafel.CustomDialogs.PopupSuccess;
import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Flights.Data.Flight;
import com.example.fluganzeigetafel.Flights.Data.FlightsTable;
import com.example.fluganzeigetafel.Flights.Handler.FileHandler;
import com.example.fluganzeigetafel.Flights.Manager.FlightChangeManager;
import com.example.fluganzeigetafel.Orders.Order;
import com.example.fluganzeigetafel.Suborders.Handler.SubOrdersFileHandler;
import com.example.fluganzeigetafel.Suborders.Suborder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.control.TreeItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

/**
 * This class is the controller for the File Menu. It handles operations for file loading, for exporting and editing Menu Items.
 * @author latifiagon
 */
public class FileController {

    /**
     * This method shows a FileChooser to select the csv with flights and afterwards a thread is called for handling the loading
     * of Orders and Suborders because the file content is big and without Threads the performance would be too low.
     * @param stage The stage where to show the FileChooser
     */
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
                    DataInterface.getInstance().setSubOrdersList(suborderArrayList);
                    DataInterface.flightsTable.refresh();

                    DataInterface.getInstance().setFlightItems(DataInterface.flightsTable.getRoot().getChildren());
                    DataInterface.getInstance().setItemsCopy(copyTreeItems(table.getRoot().getChildren()));
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

    /**
     * This method handles the operations for exporting the flights to CSV.
     */
    public static void fileExportAction() {
        DataInterface df = DataInterface.getInstance();
        if (df.getFlights().isEmpty()) {
            LoadFlightsDialog dialog = new LoadFlightsDialog();
            return;
        }


        FileHandler handler = new FileHandler();
        handler.writeToCSV_File((ArrayList<Flight>) df.getFlights());
    }
    /**
     * This method handles the operations for editing flights.
     */
    public static void flightChangeAction(Stage mainStage) {
        DataInterface df = DataInterface.getInstance();

        if (df.getFlights().isEmpty()) {
            LoadFlightsDialog dialog = new LoadFlightsDialog();
            return;
        }

        FlightChangeManager flightChangeManager = new FlightChangeManager(mainStage);
    }

    static TreeItem<Flight> deepcopy(TreeItem<Flight> item) {

        TreeItem<Flight> copy = new TreeItem<>(item.getValue());

        for (TreeItem<Flight> child : item.getChildren()) {

            copy.getChildren().add(deepcopy(child));
        }
        return copy;
    }

    private static ObservableList<TreeItem<Flight>> copyTreeItems(ObservableList<TreeItem<Flight>> originalItems) {
        ObservableList<TreeItem<Flight>> copiedItems = FXCollections.observableArrayList();

        for (TreeItem<Flight> originalItem : originalItems) {

            TreeItem<Flight> copiedItem = deepcopy(originalItem);
            copiedItems.add(copiedItem);

        }

        return copiedItems;
    }


}
