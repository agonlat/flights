package com.example.fluganzeigetafel;
import com.example.fluganzeigetafel.Data.DataInterface;
import com.example.fluganzeigetafel.Data.FlightsTable;
import com.example.fluganzeigetafel.Controller.DataController;
import com.example.fluganzeigetafel.Controller.FileController;
import com.example.fluganzeigetafel.Controller.PrintController;
import com.example.fluganzeigetafel.Controller.ViewController;
import com.example.fluganzeigetafel.Data.MainGraphicElements;
import com.example.fluganzeigetafel.Data.MenuBarView;
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
        stage.setTitle("Display panel");





        DataInterface dataInterface = DataInterface.getInstance();


        FlightsTable table = new FlightsTable();










        BorderPane pane = new BorderPane();
        MainGraphicElements mainGraphicElements = new MainGraphicElements(pane);



        VBox tableLayout = new VBox();
        tableLayout.getChildren().addAll(new MenuBarView(stage).getMenuBar(),pane, table);
        VBox.setVgrow(table, Priority.ALWAYS);




        Scene scene = new Scene(tableLayout, width, height);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}