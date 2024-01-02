package com.example.fluganzeigetafel.Flights.Controller;

import com.example.fluganzeigetafel.CustomDialogs.LoadFlightsDialog;
import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Flights.Data.Flight;
import com.example.fluganzeigetafel.Flights.Manager.PrintManager;

import java.util.ArrayList;

public class PrintController {

    public static void printOnAction() {

        if (DataInterface.getInstance().getFlights().isEmpty()) {
            LoadFlightsDialog loadFlightsDialog = new LoadFlightsDialog();
            return;
        }


        PrintManager printMenu = new PrintManager();
        if (!DataInterface.getInstance().getTemporaryFlights().isEmpty())
            printMenu.createPDF((ArrayList<Flight>) DataInterface.getInstance().getTemporaryFlights());
        else
            printMenu.createPDF((ArrayList<Flight>) DataInterface.getInstance().getFlights());


    }
}
