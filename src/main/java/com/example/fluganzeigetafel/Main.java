package com.example.fluganzeigetafel;
import com.example.fluganzeigetafel.Flights.Data.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
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






        Scene scene = new Scene(tableLayout, width, height);


        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}