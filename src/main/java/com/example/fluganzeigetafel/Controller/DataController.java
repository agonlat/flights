package com.example.fluganzeigetafel.Controller;

import com.example.fluganzeigetafel.Data.DataInterface;
import com.example.fluganzeigetafel.CustomDialogs.LoadFlightsDialog;
import com.example.fluganzeigetafel.Manager.StatisticsManager;

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
