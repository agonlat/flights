package com.example.fluganzeigetafel.Data;

import com.example.fluganzeigetafel.Controller.PrintController;
import com.example.fluganzeigetafel.Utility.FilterAndSearchMethods;
import com.example.fluganzeigetafel.Utility.UtilityMethods;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class MainGraphicElements extends Node {
    public MainGraphicElements(BorderPane pane) {
        Button searchButton = new Button("Search flight");
        TextField filterTextField = new TextField();
        filterTextField.setPromptText("Filter flights");
        filterTextField.setMaxWidth(100);

         FilterAndSearchMethods.filterFlights(filterTextField);
        searchButton.setOnAction(e-> UtilityMethods.setSearchButtonAction(searchButton));
        Button printButton = new Button("Print");

        printButton.setOnAction(e-> PrintController.printOnAction());

        HBox hBox = new HBox();
        hBox.getChildren().addAll(printButton, searchButton,filterTextField);
        HBox.setMargin(printButton, new Insets(5,0,5,0));
        HBox.setMargin(searchButton, new Insets(5,0,5,0));
        HBox.setMargin(filterTextField, new Insets(5,5,5,0));
        HBox.setHgrow(searchButton, Priority.ALWAYS);
        HBox.setHgrow(filterTextField, Priority.ALWAYS);
        hBox.setSpacing(5);

        pane.setRight(hBox);

    }
}
