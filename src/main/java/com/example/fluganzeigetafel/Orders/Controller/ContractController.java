package com.example.fluganzeigetafel.Orders.Controller;

import com.example.fluganzeigetafel.CustomDialogs.Popup;
import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Flights.Data.Flight;
import com.example.fluganzeigetafel.Orders.CSVRow;
import com.example.fluganzeigetafel.Orders.Data.OrderTable;
import com.example.fluganzeigetafel.Orders.Data.GraphicPane;
import com.example.fluganzeigetafel.Orders.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.util.ArrayList;

public class ContractController {


    public static void addTabs(TableCell<Flight, String> cell) {
        if (DataInterface.getInstance().isThreadRunning()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please wait until the orders and suborders are loaded! A popup should appear after finishing");
            alert.setHeaderText("WARNING");
            alert.showAndWait();
            return;
        }

        if (!cell.isEmpty()) {
            boolean isFirst = DataInterface.getInstance().isFirstTime();
            Flight selectedFlight = (Flight) DataInterface.flightsTable.getSelectionModel().getSelectedItem();

            if (!selectedFlight.isTablesLoaded()) {
                if (selectedFlight.getCsvListOfList().isEmpty()) {
                    Popup popup = new Popup("No contracts found!");
                } else {
                    ArrayList<Order> orders = selectedFlight.getContracts();

                    for (Order order : orders) {
                        OrderTable orderTable = new OrderTable();
                        orderTable.setOrder(order);
                        selectedFlight.addTables(orderTable);

                        // Create a new instance of Tab for each tab
                        Tab tab = new Tab(selectedFlight.getFnr().trim() + "_" + "Order" + orderTable.getOrder().getAUKEY(), orderTable);

                        // Add all CSVRows for the current contract to the ContractTable
                        ObservableList<CSVRow> list = FXCollections.observableArrayList(order.getCSVRows());
                        orderTable.setItems(list);

                        // Create a new instance of HBox for each tab
                        HBox contentBox = new HBox();
                        contentBox.getChildren().add(orderTable);
                        HBox.setHgrow(orderTable, Priority.ALWAYS);
                        GraphicPane bp = new GraphicPane(contentBox, orderTable);

                        // Set the content of the tab
                        tab.setContent(contentBox);

                        // Add the ContractTable to a new tab in the TabPane
                        DataInterface.getInstance().getTabPaneView().addTab(tab);
                    }



                    selectedFlight.setCurrentTabsLoaded(true);
                    selectedFlight.setTablesLoaded(true);
                }
            } else {
                if (!selectedFlight.isCurrentTabsLoaded()) {
                    if (selectedFlight.getCsvListOfList().isEmpty()) {
                        Popup popup = new Popup("No orders found!");
                    } else {
                        for (OrderTable view : selectedFlight.getTables()) {


                            // Create a new instance of Tab for each tab
                            Tab tab = new Tab(selectedFlight.getFnr().trim() + "_" + "Order" + view.getOrder().getAUKEY());

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
    }}
