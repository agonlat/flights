package com.example.fluganzeigetafel;
import com.example.fluganzeigetafel.Data.DataInterface;
import com.example.fluganzeigetafel.Data.FlightsTable;
import com.example.fluganzeigetafel.Controller.DataController;
import com.example.fluganzeigetafel.Controller.FileController;
import com.example.fluganzeigetafel.Controller.PrintController;
import com.example.fluganzeigetafel.Controller.ViewController;
import com.example.fluganzeigetafel.Utility.FilterAndSearchMethods;
import com.example.fluganzeigetafel.Utility.UtilityMethods;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Screen screen = Screen.getPrimary();
        double width = screen.getBounds().getWidth();
        double height = screen.getBounds().getHeight();


        stage.setY(0);
        stage.setX(0);
        stage.setMaximized(true);


        final Menu fileMenu = new Menu("File");
        final Menu viewMenu = new Menu("View");
        final Menu dataMenu = new Menu("Data");


        Label label = new Label();
        label.setText("Flight information");
        label.setFont(new Font(20));
        label.setAlignment(Pos.CENTER);


        Button searchButton = new Button("Search flight");
        TextField filterTextField = new TextField();
        filterTextField.setPromptText("Filter flights");
        filterTextField.setMaxWidth(100);

        // Create File menu items
        MenuItem changeFlightItem = new MenuItem("Change flight");
        MenuItem loadFlightsItem = new MenuItem("Load flights");
        MenuItem exportItem = new MenuItem("Export");

        // Create View menu items
        MenuItem changeViewOptionsItem = new MenuItem("Change View Options");
        MenuItem settingsItem = new MenuItem("Settings");

        // Create Data menu items
        MenuItem statisticalDataItem = new MenuItem("Statistical Data");



        fileMenu.getItems().addAll(changeFlightItem,loadFlightsItem,exportItem);
        viewMenu.getItems().addAll(changeViewOptionsItem, settingsItem);
        dataMenu.getItems().add(statisticalDataItem);

        loadFlightsItem.setOnAction(e-> FileController.fileLoadAction(stage));
        exportItem.setOnAction(e-> FileController.fileExportAction());
        changeFlightItem.setOnAction(e-> FileController.flightChangeAction(stage));
        changeViewOptionsItem.setOnAction(e-> ViewController.changeViewOptionAction());
        FilterAndSearchMethods.filterFlights(filterTextField);
        statisticalDataItem.setOnAction(e-> DataController.statisticalDataAction());
        settingsItem.setOnAction(e-> DataController.settingsActions());
        searchButton.setOnAction(e->UtilityMethods.setSearchButtonAction(searchButton));







        Button printButton = new Button("Print");

       // printButton.setGraphic(view);

        printButton.setOnAction(e-> PrintController.printOnAction());




        DataInterface dataInterface = DataInterface.getInstance();


        FlightsTable table = new FlightsTable();



        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().setAll(fileMenu, viewMenu, dataMenu);

        HBox hBox = new HBox();





        BorderPane pane = new BorderPane();
        pane.setLeft(label);
        pane.setRight(hBox);
        BorderPane.setMargin(label, new Insets(0,0,0,5));


        hBox.getChildren().addAll(printButton, searchButton,filterTextField);
        HBox.setMargin(printButton, new Insets(5,0,5,0));
        HBox.setMargin(searchButton, new Insets(5,0,5,0));
        HBox.setMargin(filterTextField, new Insets(5,5,5,0));
        HBox.setHgrow(searchButton, Priority.ALWAYS);
        HBox.setHgrow(filterTextField, Priority.ALWAYS);
        hBox.setSpacing(5);



        //BorderPane pane = new BorderPane();
       // pane.setTop(menuBar);

        VBox tableLayout = new VBox();
        tableLayout.getChildren().addAll(menuBar,pane, table);
        VBox.setVgrow(table, Priority.ALWAYS);
       // tableLayout.set

       // pane.setCenter(tableLayout);




        Scene scene = new Scene(tableLayout, width, height);




        stage.setTitle("Display panel");
        stage.setScene(scene);



        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}