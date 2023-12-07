package com.example.fluganzeigetafel.Menu;

import com.example.fluganzeigetafel.Data.DataInterface;
import com.example.fluganzeigetafel.CustomDialogs.LoadFlightsDialog;
import com.example.fluganzeigetafel.Views.Change_viewView;

public class ViewMenu {

    public static void changeViewOptionAction() {
        if (DataInterface.getInstance().getFlights().isEmpty()) {
            LoadFlightsDialog loadFlightsDialog = new LoadFlightsDialog();
          return;
        }

        Change_viewView changeViewView = new Change_viewView();

    }

    public static void settingsAction() {
        if (DataInterface.getInstance().getFlights().isEmpty()) {
            LoadFlightsDialog loadFlightsDialog = new LoadFlightsDialog();
            return;
        }
    }
}
