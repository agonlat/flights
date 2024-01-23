package com.example.fluganzeigetafel;

import com.example.fluganzeigetafel.CustomDialogs.Popup;
import com.example.fluganzeigetafel.Flights.Data.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


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
        stage.setTitle("Display panel");


        DataInterface dataInterface = DataInterface.getInstance();
        FlightsTable table = new FlightsTable();




        BorderPane pane = new BorderPane();
        MainGraphicElements mainGraphicElements = new MainGraphicElements(pane);


        VBox tableLayout = new VBox();
        TabPaneView paneView = new TabPaneView(tableLayout);
        DataInterface.getInstance().setTabPaneView(paneView);
        tableLayout.getChildren().addAll(new MenuBarView(stage).getMenuBar(),pane,paneView.getTabPaneView());



        Image img = new Image(getClass().getResourceAsStream("/Icons/AIRPLANE.png"));
        stage.getIcons().add(img);


        Duration duration = Duration.minutes(3);

        Timeline timeline = new Timeline(new KeyFrame(duration,event-> signal()));


        DataInterface.getInstance().getTabPaneView().getSelectionModel().selectedItemProperty().addListener((observable, oldTab, newTab) -> {
            if (newTab != null) {
                if (newTab.getText().equals("Flights")) {
                    MainGraphicElements.setButtonVisible(false);
                    MainGraphicElements.setButtonText("");
                    MainGraphicElements.setSubButtonVisible(false);
                } else {
                    MainGraphicElements.setButtonVisible(true);
                    MainGraphicElements.setButtonText("Show data about orders");
                    MainGraphicElements.setSubButtonVisible(true);





                }
            } else {
                // No tab is selected (tab closed), hide the button
                MainGraphicElements.setButtonVisible(false);
                MainGraphicElements.setButtonText("");
                MainGraphicElements.setSubButtonVisible(false);
            }
        });


        Scene scene = new Scene(tableLayout, width, height);



        stage.setScene(scene);
        stage.show();
    }
    public void signal() {
        long actualTime = System.currentTimeMillis(); // Assuming acutalTime is a long representing the current time in milliseconds

        if (!DataInterface.getInstance().getFlights().isEmpty()) {
            for (Flight f : DataInterface.getInstance().getFlights()) {
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                    Date sttDate = dateFormat.parse(f.getStt());

                    long timeDifference = sttDate.getTime() - actualTime; // Calculate time difference in milliseconds

                    // Assuming 15 minutes is represented as 15 * 60 * 1000 milliseconds
                    if (timeDifference < (15 * 60 * 1000)) {
                        String message = f.getFnr() + " is about to start in less than 15 minutes";
                        Popup popup = new Popup(message);

                    }
                } catch (ParseException e) {
                    e.printStackTrace(); // Handle parsing exception
                }
            }
        }
    }

    public static void main(String[] args) {

        launch();
    }
}