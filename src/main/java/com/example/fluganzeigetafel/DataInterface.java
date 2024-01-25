package com.example.fluganzeigetafel;


import com.example.fluganzeigetafel.Orders.CSVRow;
import com.example.fluganzeigetafel.Orders.Order;
import com.example.fluganzeigetafel.Orders.Suborders.Suborder;
import com.example.fluganzeigetafel.Flights.Data.Flight;
import com.example.fluganzeigetafel.Flights.Data.FlightsTable;
import com.example.fluganzeigetafel.Flights.Data.TabPaneView;
import com.example.fluganzeigetafel.Flights.Utility.UtilityMethods;

import java.util.*;

public class DataInterface {

    private ArrayList<CSVRow> contractDataRow;
    private ArrayList<Order> orders;
    private static DataInterface instance;
    private List<Flight> flights;
    private TabPaneView pane;
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
    public boolean isCheck() {
        return check;
    }



    public void setCheck(boolean check) {
        this.check = check;
    }

    private boolean check = true;

    public ArrayList<Suborder> getSubcontractsList() {
        return subcontractsList;
    }

    public void setSubcontractsList(ArrayList<Suborder> subcontractsList) {
        this.subcontractsList = subcontractsList;
    }

    private ArrayList<Suborder> subcontractsList;

    public ArrayList<ArrayList<CSVRow>> getRows() {
        return rows;
    }

    private ArrayList<ArrayList<CSVRow>> rows;

    public void addRows(ArrayList<ArrayList<CSVRow>> rows) {
        this.rows = rows;
    }

    public boolean isFirstTime() {
        return isFirstTime;
    }

    public void setFirstTime(boolean firstTime) {
        isFirstTime = firstTime;
    }

    private boolean isFirstTime = true;
    private String contractsPath = "";

    public String getContractsPath() {
        return this.contractsPath;
    }

    public void setContractsPath(String path) {
        this.contractsPath = path;
    }



    public static FlightsTable flightsTable;
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

    private DataInterface() {
        flights = new ArrayList<>();
        filePath = "";
        changedFlightsCounter = 0;
        temporaryFlights = new ArrayList<>();
        changedFlightsSet = new HashSet<>();
        contractDataRow = new ArrayList<>();
        orders = new ArrayList<>();
        uakeyDatabase = new ArrayList<>();

    }

    public boolean setTabPaneView(TabPaneView view) {
        this.pane = view;
        if (pane != null)
            return true;
        else return false;
    }
    public TabPaneView getTabPaneView() {
       return this.pane;
    }
    public static DataInterface getInstance() {

            synchronized (DataInterface.class) {
                if (instance == null)  {
                    instance = new DataInterface();
                }

            }


        return instance;
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

    public void setFlightsTable(FlightsTable table) {
        flightsTable = table;

    }


    public ArrayList<Order> getContracts() {
        return this.orders;
    }

    public void setContracts(ArrayList<Order> contr) {
        this.orders = contr;
    }
}
