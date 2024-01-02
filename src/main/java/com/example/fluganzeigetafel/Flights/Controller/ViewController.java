package com.example.fluganzeigetafel.Flights.Controller;

import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.CustomDialogs.LoadFlightsDialog;
import com.example.fluganzeigetafel.Flights.Manager.ViewChangeManager;

public class ViewController {

    public static void changeViewOptionAction() {
        if (DataInterface.getInstance().getFlights().isEmpty()) {
            LoadFlightsDialog loadFlightsDialog = new LoadFlightsDialog();
          return;
        }

        ViewChangeManager changeViewView = new ViewChangeManager();

    }

    public static void settingsAction() {
        if (DataInterface.getInstance().getFlights().isEmpty()) {
            LoadFlightsDialog loadFlightsDialog = new LoadFlightsDialog();
            return;
        }
    }
}
