package com.example.fluganzeigetafel.Controller;

import com.example.fluganzeigetafel.Data.DataInterface;
import com.example.fluganzeigetafel.CustomDialogs.LoadFlightsDialog;
import com.example.fluganzeigetafel.Manager.ViewChangeManager;

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
