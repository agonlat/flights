package com.example.fluganzeigetafel.Flights.Data;

import com.example.fluganzeigetafel.Flights.Controller.PrintController;
import com.example.fluganzeigetafel.Flights.Utility.FilterAndSearchMethods;
import com.example.fluganzeigetafel.Flights.Utility.UtilityMethods;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.io.FileNotFoundException;

/**
 * This class is used for the GUI elements that are on the start page.
 */
public class MainGraphicElements {


    /**
     * This constructor creates the GUI elements that are at the top of the Flights table, like Search Button, Filter TextField ...
     * @param pane The BorderPane that is above the table, where these elements are.
     * @throws FileNotFoundException
     */
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



        HBox boxTabs = new HBox();


        Button printButton = new Button("Print current flights");

        printButton.setOnAction(e-> {PrintController printController = new PrintController();
        printController.printOnAction();});

        boxTabs.getChildren().addAll(printButton, searchButton);




         FilterAndSearchMethods filter = new FilterAndSearchMethods();
         filter.filterFlights(filterTextField);
        searchButton.setOnAction(e-> UtilityMethods.setSearchButtonAction(searchButton));

        HBox hBox = new HBox();
        hBox.getChildren().addAll( filterTextField);
        boxTabs.setSpacing(5);
        HBox.setMargin(printButton, new Insets(5,0,5,5));
        HBox.setMargin(searchButton, new Insets(5,0,5,0));
        HBox.setMargin(filterTextField, new Insets(5,5,5,0));


        HBox.setHgrow(searchButton, Priority.ALWAYS);
        HBox.setHgrow(filterTextField, Priority.ALWAYS);
        hBox.setSpacing(5);

        pane.setLeft(boxTabs);
        pane.setRight(hBox);

    }
}
