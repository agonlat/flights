package com.example.fluganzeigetafel.Flights.Controller;

import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.CustomDialogs.LoadFlightsDialog;
import com.example.fluganzeigetafel.Flights.Manager.StatisticsManager;

public class DataController {

    public static void statisticalDataAction() {
        if (DataInterface.getInstance().getFlights().isEmpty()) {
            LoadFlightsDialog loadFlightsDialog = new LoadFlightsDialog();
            return;
        }

        StatisticsManager dataController = new StatisticsManager();


    }

    public static void settingsActions()  {
        if (DataInterface.getInstance().getFlights().isEmpty()) {
            LoadFlightsDialog loadFlightsDialog = new LoadFlightsDialog();
            return;
        }




    }
}
