package com.example.fluganzeigetafel.Flights.Data;

import com.example.fluganzeigetafel.Flights.Controller.PrintController;
import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Flights.Utility.FilterAndSearchMethods;
import com.example.fluganzeigetafel.Flights.Utility.UtilityMethods;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainGraphicElements {
    public MainGraphicElements(BorderPane pane) throws FileNotFoundException {


      //  pane.getStylesheets().add("/stylesheet.css");

   //     Font customFont = Font.loadFont(getClass().getResourceAsStream("src/main/resources/Roboto-Medium.ttf"), 13);
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
      //  pane.setStyle("-fx-background-color: radial-gradient(center 50% 50%, radius 100%, rgba(30,30,30,1), rgba(86,86,86,1) 79%);");

        Button closeTabsButton = new Button("Close all tabs");

        // closeTabsButton.setStyle("-fx-font-family: customFont; -fx-background-color: #1E1E1E; -fx-text-fill: #ffffff; -fx-border-radius: 5; -fx-background-radius: 8; ");

        closeTabsButton.setOnAction(e->
                {
                    int size = DataInterface.getInstance().getTabPaneView().getTabs().size();
                    DataInterface.getInstance().getTabPaneView().getTabs().remove(1,size);
                    DataInterface.getInstance().setFirstTime(true);

                    for (Flight f : DataInterface.getInstance().getFlights())
                        f.setCurrentTabsLoaded(false);
                }
        );
        pane.setLeft(boxTabs);
        boxTabs.getChildren().add(closeTabsButton);
        boxTabs.setMargin(closeTabsButton, new Insets(5,0,5,5));

         FilterAndSearchMethods.filterFlights(filterTextField);
        searchButton.setOnAction(e-> UtilityMethods.setSearchButtonAction(searchButton));
        Button printButton = new Button("Print all flights");

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
