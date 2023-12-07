package com.example.fluganzeigetafel.Menu;

import com.example.fluganzeigetafel.Data.DataInterface;
import com.example.fluganzeigetafel.CustomDialogs.LoadFlightsDialog;
import com.example.fluganzeigetafel.Views.StatisticsView;

public class DataMenu {

    public static void statisticalDataAction() {
        if (DataInterface.getInstance().getFlights().isEmpty()) {
            LoadFlightsDialog loadFlightsDialog = new LoadFlightsDialog();
            return;
        }

        StatisticsView dataController = new StatisticsView();


    }

    public static void settingsActions()  {
        if (DataInterface.getInstance().getFlights().isEmpty()) {
            LoadFlightsDialog loadFlightsDialog = new LoadFlightsDialog();
            return;
        }




    }
}
