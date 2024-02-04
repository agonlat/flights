package com.example.fluganzeigetafel.Flights.Controller;

import com.example.fluganzeigetafel.CustomDialogs.LoadFlightsDialog;
import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Flights.Data.Flight;
import com.example.fluganzeigetafel.Flights.Manager.PrintManager;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * This class is for controlling the Print Menu. It handles operations for the Print Menu Item
 */

public class PrintController extends Stage{

    /**
     * This method creates a PDF File based on the current flights. If they are filtered, the filtered ones are generated as a PDF, if not
     * then all flights are generated as a PDF.
     */

    public void printOnAction() {

        ArrayList<Flight> listOfFlights =  null;
        ArrayList<Flight> finalListOfFlights = listOfFlights;
        PrintManager printMenu = new PrintManager();
        if (DataInterface.getInstance().getFlights().isEmpty()) {
            LoadFlightsDialog loadFlightsDialog = new LoadFlightsDialog();
            return;
        }

        if (!DataInterface.getInstance().getTemporaryFlights().isEmpty())
            printMenu.createPDF((ArrayList<Flight>) DataInterface.getInstance().getTemporaryFlights());

        else
        printMenu.createPDF((ArrayList<Flight>) DataInterface.getInstance().getFlights());











}}
