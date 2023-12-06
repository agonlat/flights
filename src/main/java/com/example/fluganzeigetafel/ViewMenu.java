package com.example.fluganzeigetafel;

public class ViewMenu {

    public static void changeViewOptionAction() {
        if (DataInterface.getInstance().getFlights().isEmpty()) {
            LoadFlightsDialog loadFlightsDialog = new LoadFlightsDialog();
          return;
        }

        ViewChange viewChange = new ViewChange();

    }

    public static void settingsAction() {
        if (DataInterface.getInstance().getFlights().isEmpty()) {
            LoadFlightsDialog loadFlightsDialog = new LoadFlightsDialog();
            return;
        }
    }
}
