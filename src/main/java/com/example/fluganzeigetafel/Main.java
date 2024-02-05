package com.example.fluganzeigetafel;

import com.example.fluganzeigetafel.Flights.Data.FlightsTable;
import com.example.fluganzeigetafel.Flights.Data.MainGraphicElements;
import com.example.fluganzeigetafel.Flights.Data.MenuBarView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The main class responsible for starting the flight information display system application.
 * Initializes the graphical user interface, sets up the main components, and launches the application.
 *
 */
public class Main extends Application {

    /**
     * The entry point for the flight information display system application.
     * Initializes the GUI components, sets up the main stage, and displays the application window.
     *
     * @param stage The primary stage for the application.
     * @throws IOException If an error occurs during FXML loading.
     */
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

        VBox.setVgrow(table, Priority.ALWAYS);


        tableLayout.getChildren().addAll(new MenuBarView(stage).getMenuBar(),pane,table);



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
