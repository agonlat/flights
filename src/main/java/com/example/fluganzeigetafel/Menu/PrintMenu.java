package com.example.fluganzeigetafel.Menu;

import com.example.fluganzeigetafel.CustomDialogs.LoadFlightsDialog;
import com.example.fluganzeigetafel.Data.DataInterface;
import com.example.fluganzeigetafel.Views.PrintView;

public class PrintMenu {

    public static void printOnAction() {

        if (DataInterface.getInstance().getFlights().isEmpty()) {
            LoadFlightsDialog loadFlightsDialog = new LoadFlightsDialog();
            return;
        }


        PrintView printMenu = new PrintView();
        printMenu.createPDF();

    }
}
