package com.example.fluganzeigetafel.Data;

import com.example.fluganzeigetafel.Controller.DataController;
import com.example.fluganzeigetafel.Controller.FileController;
import com.example.fluganzeigetafel.Controller.ViewController;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MenuBarView {
    private MenuBar menuBar;
    public MenuBarView(Stage stage) {
        final Menu fileMenu = new Menu("File");
        final Menu viewMenu = new Menu("View");
        final Menu dataMenu = new Menu("Data");

        // Create File menu items
        MenuItem changeFlightItem = new MenuItem("Change flight");
        MenuItem loadFlightsItem = new MenuItem("Load flights");
        MenuItem exportItem = new MenuItem("Export");

        // Create View menu items
        MenuItem changeViewOptionsItem = new MenuItem("Change View Options");
        MenuItem settingsItem = new MenuItem("Settings");
        MenuItem statisticalDataItem = new MenuItem("Statistical Data");

        menuBar = new MenuBar();
        menuBar.getMenus().setAll(fileMenu, viewMenu, dataMenu);

        fileMenu.getItems().addAll(changeFlightItem,loadFlightsItem,exportItem);
        viewMenu.getItems().addAll(changeViewOptionsItem, settingsItem);
        dataMenu.getItems().add(statisticalDataItem);

        loadFlightsItem.setOnAction(e-> FileController.fileLoadAction(stage));
        exportItem.setOnAction(e-> FileController.fileExportAction());
        changeFlightItem.setOnAction(e-> FileController.flightChangeAction(stage));
        changeViewOptionsItem.setOnAction(e-> ViewController.changeViewOptionAction());
        statisticalDataItem.setOnAction(e-> DataController.statisticalDataAction());
        settingsItem.setOnAction(e-> DataController.settingsActions());
    }

    public MenuBar getMenuBar(){
        return menuBar;
    }
}
