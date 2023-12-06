package com.example.fluganzeigetafel;

public class DataMenu {

    public static void statisticalDataAction() {
        if (DataInterface.getInstance().getFlights().isEmpty()) {
            LoadFlightsDialog loadFlightsDialog = new LoadFlightsDialog();
            return;
        }



    }

    public static void settingsActions()  {
        if (DataInterface.getInstance().getFlights().isEmpty()) {
            LoadFlightsDialog loadFlightsDialog = new LoadFlightsDialog();
            return;
        }




    }
}
