package com.example.fluganzeigetafel.Flights.Data;

import com.example.fluganzeigetafel.Flights.Controller.DataController;
import com.example.fluganzeigetafel.Flights.Controller.FileController;
import com.example.fluganzeigetafel.Flights.Controller.ViewController;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * This class is represents the MenuBar.
 */
public class MenuBarView {
    private MenuBar menuBar;

    /**
     * This construcotr creates the MenuBar with the elements File, View and Data.
     * @param stage
     */
    public MenuBarView(Stage stage) {
        final Menu fileMenu = new Menu("File");
        final Menu viewMenu = new Menu("View");
        final Menu dataMenu = new Menu("Data");

        // Create File menu items
        MenuItem changeFlightItem = new MenuItem("Change flight");
        changeFlightItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/Icons/pencil-square.png"))));
        MenuItem loadFlightsItem = new MenuItem("Load flights");
        loadFlightsItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/Icons/file-arrow-up-fill.png"))));

        MenuItem exportItem = new MenuItem("Export");
        exportItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/Icons/file-earmark-arrow-down-fill.png"))));



        // Create View menu items
        MenuItem changeViewOptionsItem = new MenuItem("Change View Options");
        changeViewOptionsItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/Icons/view-stacked.png"))));


        MenuItem statisticalDataItem = new MenuItem("Statistical Data");
        statisticalDataItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/Icons/info-circle-fill.png"))));
        menuBar = new MenuBar();
        viewMenu.getItems().add(changeViewOptionsItem);
        menuBar.getMenus().setAll(fileMenu, viewMenu, dataMenu);

        fileMenu.getItems().addAll(changeFlightItem,loadFlightsItem,exportItem);

        dataMenu.getItems().add(statisticalDataItem);

        loadFlightsItem.setOnAction(e-> FileController.fileLoadAction(stage));
        exportItem.setOnAction(e-> FileController.fileExportAction());
        changeFlightItem.setOnAction(e-> FileController.flightChangeAction(stage));
        changeViewOptionsItem.setOnAction(e-> ViewController.changeViewOptionAction());
        statisticalDataItem.setOnAction(e-> DataController.statisticalDataAction());

    }
 /**
     * This method returs the menuBar.
     * @return menuBar
     */
    public MenuBar getMenuBar(){
        return menuBar;
    }
}
