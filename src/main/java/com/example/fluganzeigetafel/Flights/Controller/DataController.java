package com.example.fluganzeigetafel.Flights.Controller;

import com.example.fluganzeigetafel.CustomDialogs.LoadFlightsDialog;
import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Flights.Manager.StatisticsManager;

/**
 * A simple class for controlling the data menu of the programm.
 * @author latifiagon
 */

public class DataController {

    /**
     * This method first checks if the flights were loaded or not.
     * If there are no flights a popup appears.
     * If there are flights, an object of the type StatisticsManager is created which shows the statistical data for the flights.
     */
    public static void statisticalDataAction() {
        if (DataInterface.getInstance().getFlights().isEmpty()) {
            LoadFlightsDialog loadFlightsDialog = new LoadFlightsDialog();
            return;
        }

        StatisticsManager dataController = new StatisticsManager();


    }






    }

