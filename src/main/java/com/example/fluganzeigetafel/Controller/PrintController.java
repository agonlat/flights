package com.example.fluganzeigetafel.Controller;

import com.example.fluganzeigetafel.CustomDialogs.LoadFlightsDialog;
import com.example.fluganzeigetafel.Data.DataInterface;
import com.example.fluganzeigetafel.Manager.PrintManager;

public class PrintController {

    public static void printOnAction() {

        if (DataInterface.getInstance().getFlights().isEmpty()) {
            LoadFlightsDialog loadFlightsDialog = new LoadFlightsDialog();
            return;
        }


        PrintManager printMenu = new PrintManager();
        printMenu.createPDF();

    }
}
