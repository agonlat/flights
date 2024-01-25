package com.example.fluganzeigetafel.Flights.Data;

import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Flights.Controller.PrintController;
import com.example.fluganzeigetafel.Flights.Utility.FilterAndSearchMethods;
import com.example.fluganzeigetafel.Flights.Utility.UtilityMethods;
import com.example.fluganzeigetafel.Statistics.OrderStats;
import com.example.fluganzeigetafel.Statistics.SuborderStats;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.io.FileNotFoundException;

public class MainGraphicElements {
    private static Button showDataButton;
    private static Button showSubDataButton;

    public static void setSubButtonVisible(boolean c) {
        showSubDataButton.setVisible(c);
    }



    public static void setButtonVisible(boolean c) {
        showDataButton.setVisible(c);
    }

    public static void setButtonText(String text) {
        showDataButton.setText(text);
    }
    public MainGraphicElements(BorderPane pane) throws FileNotFoundException {


        Button searchButton = new Button("");
        Image img = new Image(getClass().getResourceAsStream("/Icons/MAG.png"));
        ImageView imageView = new ImageView();
        imageView.setFitWidth(15);
        imageView.setFitHeight(15);
        imageView.setImage(img);
      searchButton.setGraphic(imageView);
        TextField filterTextField = new TextField();
        filterTextField.setPromptText("Filter flights");
        filterTextField.setMaxWidth(100);

         showSubDataButton = new Button("Show data about suborders");
         showSubDataButton.setOnAction(b -> {
             SuborderStats stats = new SuborderStats();
         });

       showDataButton = new Button("");
       showDataButton.setVisible(false);
        showSubDataButton.setVisible(false);
        showDataButton.setMinWidth(150);
        showDataButton.setOnAction(e->{
            OrderStats stats = new OrderStats(DataInterface.getCurrentFlight().getContracts());
        });
        HBox boxTabs = new HBox();








         FilterAndSearchMethods.filterFlights(filterTextField);
        searchButton.setOnAction(e-> UtilityMethods.setSearchButtonAction(searchButton));
        Button printButton = new Button("Print all flights");

        printButton.setOnAction(e-> PrintController.printOnAction());

        HBox hBox = new HBox();
        hBox.getChildren().addAll(printButton, searchButton,filterTextField);
        HBox.setMargin(printButton, new Insets(5,0,5,0));
        HBox.setMargin(searchButton, new Insets(5,0,5,0));
        HBox.setMargin(filterTextField, new Insets(5,5,5,0));

        HBox.setMargin(showDataButton, new Insets(5,5,5,0));
        HBox.setMargin(showSubDataButton, new Insets(5,5,5,0));
        HBox.setHgrow(searchButton, Priority.ALWAYS);
        HBox.setHgrow(filterTextField, Priority.ALWAYS);
        hBox.setSpacing(5);

        pane.setRight(hBox);

    }
}
