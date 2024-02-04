package com.example.fluganzeigetafel.Flights.Controller;

import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.CustomDialogs.LoadFlightsDialog;
import com.example.fluganzeigetafel.Flights.Manager.ViewChangeManager;

/**
 * This class is used for controlling the View Menu. It handles operations for view menu item. Which is showing UTC time and local time.
 * @author latifiagon
 */
public class ViewController {

    /**
     * This method creates the view gui for switching between UTC and LOCAL. It creates an object of the type ViewChangeManager.
     */
    public static void changeViewOptionAction() {
        if (DataInterface.getInstance().getFlights().isEmpty()) {
            LoadFlightsDialog loadFlightsDialog = new LoadFlightsDialog();
          return;
        }

        ViewChangeManager changeViewView = new ViewChangeManager();

    }


}
