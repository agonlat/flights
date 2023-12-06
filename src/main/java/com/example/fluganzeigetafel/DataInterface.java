package com.example.fluganzeigetafel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.util.ArrayList;
import java.util.List;

public class DataInterface {
    private static DataInterface instance;
    private List<Flight> flights;
    private List<Flight> temporaryFlights;
    private String filePath;
    public static FlightsTable flightsTable;

    private DataInterface() {
        flights = new ArrayList<>();
        temporaryFlights = new ArrayList<>();
        filePath = "";

    }

    public static DataInterface getInstance() {
        if (instance == null) {
            synchronized (DataInterface.class) {
                if (instance == null)  {
                    instance = new DataInterface();
                }

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


        if (this.flights != null)
            return true;
    return false;
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

}
