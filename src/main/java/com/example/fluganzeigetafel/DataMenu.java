package com.example.fluganzeigetafel;

public class DataMenu {

    public static void statisticalDataAction() {
        if (DataInterface.getInstance().getFlights().isEmpty()) {
            LoadFlightsDialog loadFlightsDialog = new LoadFlightsDialog();
            return;
        }

        StatisticalDataController dataController = new StatisticalDataController();


    }

    public static void settingsActions()  {
        if (DataInterface.getInstance().getFlights().isEmpty()) {
            LoadFlightsDialog loadFlightsDialog = new LoadFlightsDialog();
            return;
        }




    }
}
