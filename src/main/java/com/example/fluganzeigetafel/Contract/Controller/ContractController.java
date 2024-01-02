package com.example.fluganzeigetafel.Contract.Controller;

import com.example.fluganzeigetafel.Contract.CSVRow;
import com.example.fluganzeigetafel.Contract.Contract;
import com.example.fluganzeigetafel.Contract.Data.GraphicPane;
import com.example.fluganzeigetafel.Contract.Data.ContractTable;
import com.example.fluganzeigetafel.Contract.Handler.FileHandler;
import com.example.fluganzeigetafel.CustomDialogs.Popup;
import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Flights.Data.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.util.ArrayList;

public class ContractController {


    public static void addTabs(TableCell<Flight, String> cell) {

        // if (DataInterface.getInstance().getTabPaneView().getTabs().size() != 0)
        //  DataInterface.getInstance().setFirstTime(true);




        if (!cell.isEmpty()) {
            boolean isFirst = DataInterface.getInstance().isFirstTime();
            Flight ff = (Flight) DataInterface.flightsTable.getSelectionModel().getSelectedItem();


           if (!ff.isTablesLoaded()) {



                ArrayList<ArrayList<CSVRow>> rows;


                DataInterface.getInstance().setFirstTime(false);
                Flight f = (Flight) DataInterface.getInstance().getFlightsTable().getItems().get(cell.getIndex());

               if(f.getCsvListOfList().size() == 0) {
                   Popup popup = new Popup("No contracts found!");
               }



                for (ArrayList<CSVRow> row : f.getCsvListOfList()) {
                    // Create a new instance of ContractTable for each tab
                    ContractTable contractTable = new ContractTable();
                    contractTable.addRows(row);
                    f.addTables(contractTable);

                    String auk = "";
                    for (CSVRow csv:row) {
                        if (csv.getDesignation().trim().equals("AUKEY"))
                            for (Contract con:DataInterface.getInstance().getContracts()) {
                                if (con.getAUKEY().equals(csv.getValue())) {
                                    contractTable.setContract(con);
                                }
                            }
                    }

                    // Create a new instance of Tab for each tab
                    Tab tab = new Tab("Contract " + f.getKnr(), contractTable);

                    // Add all CSVRows for the current contract to the ContractTable
                    ObservableList<CSVRow> list = FXCollections.observableArrayList(row);
                    contractTable.setItems(list);

                    contractTable.refresh();

                    // Create a new instance of HBox for each tab
                    HBox contentBox = new HBox();
                    contentBox.getChildren().add(contractTable);
                    HBox.setHgrow(contractTable, Priority.ALWAYS);
                    GraphicPane bp = new GraphicPane(contentBox, contractTable);

                    // Set the content of the tab
                    tab.setContent(contentBox);

                    // Add the ContractTable to a new tab in the TabPane
                    DataInterface.getInstance().getTabPaneView().addTab(tab);
                    DataInterface.getInstance().setFirstTime(false);
                }
                ff.setCurrentTabsLoaded(true);
                ff.setTablesLoaded(true);
            } else {
               if(ff.getCsvListOfList().size() == 0) {
                   Popup popup = new Popup("No contracts found!");
               }
               if (!ff.isCurrentTabsLoaded()) {
                   if(ff.getCsvListOfList().size() == 0) {
                       Popup popup = new Popup("No contracts found!");
                   }


                   ArrayList<Contract> contracts = DataInterface.getInstance().getContracts();
                   Flight flight = (Flight) DataInterface.getInstance().getFlightsTable().getItems().get(cell.getIndex());
                   FileHandler contractHandler = new FileHandler();


                   for (ContractTable view : flight.getTables()) {
                       // Create a new instance of Tab for each tab
                       Tab tab = new Tab("Contract " + flight.getKnr());

                       // Create a new instance of HBox for each tab
                       HBox contentBox = new HBox();
                       contentBox.getChildren().add(view);
                       HBox.setHgrow(view, Priority.ALWAYS);
                       GraphicPane bp = new GraphicPane(contentBox, view);

                       // Set the content of the tab
                       tab.setContent(contentBox);

                       // Add the ContractTable to a new tab in the TabPane
                       DataInterface.getInstance().getTabPaneView().addTab(tab);

                   }
               }
           }
        }
    }
    }







