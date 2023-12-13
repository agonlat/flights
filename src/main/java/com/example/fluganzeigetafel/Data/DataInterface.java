package com.example.fluganzeigetafel.Data;


import com.example.fluganzeigetafel.Contract.CSVRow;
import com.example.fluganzeigetafel.Contract.Contract;
import com.example.fluganzeigetafel.Utility.UtilityMethods;
import javafx.scene.control.TabPane;

import java.util.*;

public class DataInterface {

    private ArrayList<CSVRow> contractDataRow;
    private ArrayList<Contract> contracts;
    private static DataInterface instance;
    private List<Flight> flights;
    private TabPaneView pane;
    private String filePath;
    private List<Flight> temporaryFlights;
    private int changedFlightsCounter;


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
        contracts = new ArrayList<>();

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


    public ArrayList<Contract> getContracts() {
        return this.contracts;
    }

    public void setContracts(ArrayList<Contract> contr) {
        this.contracts = contr;
    }
}
