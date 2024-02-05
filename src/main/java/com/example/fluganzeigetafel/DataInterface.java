package com.example.fluganzeigetafel;


import com.example.fluganzeigetafel.Orders.Data.CSVRow;
import com.example.fluganzeigetafel.Orders.Order;
import com.example.fluganzeigetafel.Suborders.Suborder;
import com.example.fluganzeigetafel.Flights.Data.Flight;
import com.example.fluganzeigetafel.Flights.Data.FlightsTable;

import com.example.fluganzeigetafel.Flights.Utility.UtilityMethods;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

import java.util.*;
/**
 * The DataInterface class manages the data for the flight information display system.
 * It provides methods for handling flights, orders, and suborders, as well as various utilities.
 * This class follows the Singleton design pattern to ensure a single instance throughout the application.
 * This class serves as a Database for all classes.
 *
 * @author latifiagon
 * @version 1.0
 */
public class DataInterface {
    private ObservableList<TreeItem<Flight>> flightItems;

    private ArrayList<CSVRow> contractDataRow;
    /**
     * Retrieves the current item in the FlightsTable
     *
     * @return The current TreeItem representing a Flight.
     */
    public TreeItem<Flight> getCurrentItem() {
        return currentItem;
    }

    public void setCurrentItem(TreeItem<Flight> currentItem) {
        this.currentItem = currentItem;
    }

    private TreeItem<Flight> currentItem;
    private ArrayList<Order> orders;
    private static DataInterface instance;
    private List<Flight> flights;

    private String filePath;
    private List<Flight> temporaryFlights;
    private int changedFlightsCounter;

    public static Flight getCurrentFlight() {
        return currentFlight;
    }

    public static void setCurrentFlight(Flight currentFlight) {
        DataInterface.currentFlight = currentFlight;
    }

    private static Flight currentFlight;
    public Order getOrderByAUKEY(String aukey) {
        for (Order order : getContracts()) {
            if (order.getAUKEY().equals(aukey.trim()))
                return order;
        }
        return null;
    }
    public boolean isThreadRunning() {
        return isThreadRunning;
    }

    public void setThreadRunning(boolean threadRunning) {
        isThreadRunning = threadRunning;
    }

    private boolean isThreadRunning = false;
    private ArrayList<String> uakeyDatabase;

    public void addUAKEY(String uakey) {
        this.uakeyDatabase.add(uakey);
    }

    public ArrayList<String> getUakeyDatabase() {
        return this.uakeyDatabase;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    private boolean isOpen = false;


    public boolean isPendingStatus() {
        return pendingStatus;
    }

    public void setPendingStatus(boolean pendingStatus) {
        this.pendingStatus = pendingStatus;
    }

    private boolean pendingStatus = false;


    private boolean check = true;

    public ArrayList<Suborder> getSubordersList() {
        return suborderArrayList;
    }
    public static DataInterface getInstance() {

        synchronized (DataInterface.class) {
            if (instance == null)  {
                instance = new DataInterface();
            }

        }


        return instance;
    }

    public void setSubOrdersList(ArrayList<Suborder> subcontractsList) {
        this.suborderArrayList = subcontractsList;
    }

    private ArrayList<Suborder> suborderArrayList;

    public ArrayList<ArrayList<CSVRow>> getRows() {
        return rows;
    }

    private ArrayList<ArrayList<CSVRow>> rows;

    public void addRows(ArrayList<ArrayList<CSVRow>> rows) {
        this.rows = rows;
    }








    public static FlightsTable flightsTable = new FlightsTable();
    private Set<Flight> changedFlightsSet;


    public int getChangedFlightsCounter() {
        return changedFlightsCounter;
    }



    public void incrementCounter() {
        this.changedFlightsCounter++;
    }

    public static FlightsTable getFlightsTable() {
        return flightsTable;
    }


    public HashMap<String, Integer> getAirlines() {
        HashMap<String, Integer> map = new HashMap<>();

        for (Flight f : flights) {
            String airline = UtilityMethods.getAirlineCode(f.getFnr());

            // Check if the airline is already in the map
            if (map.containsKey(airline)) {
                // If yes, get the current count, increment it, and put it back in the map
                int currentCount = map.get(airline);
                map.put(airline, currentCount + 1);
            } else {
                // If no, add the airline to the map with a count of 1
                map.put(airline, 1);
            }
        }

        return map;
    }


    public Set<Flight> getChangedFlightsSet() {
        return changedFlightsSet;
    }

    public ObservableList<TreeItem<Flight>> getFlightItems() {
        return flightItems;
    }

    public void setFlightItems(ObservableList<TreeItem<Flight>> flightItems) {
        this.flightItems = flightItems;
    }

    private DataInterface() {
        flightItems = FXCollections.observableArrayList();

        flights = new ArrayList<>();
        filePath = "";
        changedFlightsCounter = 0;
        temporaryFlights = new ArrayList<>();
        changedFlightsSet = new HashSet<>();
        contractDataRow = new ArrayList<>();
        orders = new ArrayList<>();
        uakeyDatabase = new ArrayList<>();
        currentItem = new TreeItem<>();

    }



    public List<Flight> getFlights() {
        return flights;
    }
    public List<Flight> getTemporaryFlights() {
        return temporaryFlights;
    }


    public String getFilePath() {
        return filePath;
    }

    public boolean setFilePath(final String filePath) {
        if (filePath != null || !filePath.isEmpty() ) {
            this.filePath = filePath;
            return true;
        }


        return false;
    }

    public boolean addFlights(List<Flight>flights) {

        if (flights != null)
            this.flights = flights;


        return this.flights != null;
    }

    public boolean addTemporaryFlights(List<Flight>flights) {

        if (flights != null)
            this.temporaryFlights = flights;


        if (this.temporaryFlights != null)
            return true;
        return false;
    }



    public ObservableList<TreeItem<Flight>> convertFlightsToItems() {
        ObservableList<TreeItem<Flight>> list = FXCollections.observableArrayList();
        TreeItem<Flight> root = flightsTable.getRoot();

        for (Flight f : flights) {
            TreeItem<Flight> item = new TreeItem<>(f);
            list.add(item);
        }







        return list;
    }


    public ArrayList<Order> getContracts() {
        return this.orders;
    }

    public void setContracts(ArrayList<Order> contr) {
        this.orders = contr;
    }

    public ObservableList<TreeItem<Flight>> getItemsCopy() {
        return itemsCopy;
    }

    public void setItemsCopy(ObservableList<TreeItem<Flight>> itemsCopy) {
        this.itemsCopy = itemsCopy;
    }

    ObservableList<TreeItem<Flight>> itemsCopy = null;


}