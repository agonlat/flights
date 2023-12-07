package com.example.fluganzeigetafel;
import com.example.fluganzeigetafel.CustomDialogs.LoadFlightsDialog;
import com.example.fluganzeigetafel.Data.DataInterface;
import com.example.fluganzeigetafel.Data.Flight;
import com.example.fluganzeigetafel.Data.FlightsTable;
import com.example.fluganzeigetafel.Menu.DataMenu;
import com.example.fluganzeigetafel.Menu.FileMenu;
import com.example.fluganzeigetafel.Menu.PrintMenu;
import com.example.fluganzeigetafel.Menu.ViewMenu;
import com.example.fluganzeigetafel.Utility.FilterAndSearchMethods;
import com.example.fluganzeigetafel.Utility.UtilityMethods;
import com.example.fluganzeigetafel.Utility.ValidationUtil;
import com.example.fluganzeigetafel.Views.PrintView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
import javafx.scene.image.Image;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Screen screen = Screen.getPrimary();
        double width = screen.getBounds().getWidth();
        double height = screen.getBounds().getHeight();


        stage.setY(0);
        stage.setX(0);


        final Menu fileMenu = new Menu("File");
        final Menu viewMenu = new Menu("View");
        final Menu dataMenu = new Menu("Data");
        final Menu print = new Menu("Print");

        Label label = new Label();
        label.setText("Flight information");
        label.setFont(new Font(20));
        label.setAlignment(Pos.CENTER);


        Button searchButton = new Button("Search");
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

        loadFlightsItem.setOnAction(e-> FileMenu.fileLoadAction(stage));
        exportItem.setOnAction(e->FileMenu.fileExportAction());
        changeFlightItem.setOnAction(e->FileMenu.flightChangeAction(stage));
        changeViewOptionsItem.setOnAction(e-> ViewMenu.changeViewOptionAction());
        FilterAndSearchMethods.filterFlights(filterTextField);
        statisticalDataItem.setOnAction(e-> DataMenu.statisticalDataAction());
        settingsItem.setOnAction(e->DataMenu.settingsActions());
        searchButton.setOnAction(e->UtilityMethods.setSearchButtonAction(searchButton));
        print.setOnAction((ActionEvent event)-> PrintMenu.printOnAction());






        DataInterface dataInterface = DataInterface.getInstance();


        FlightsTable table = new FlightsTable();



        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().setAll(fileMenu, viewMenu, dataMenu, print);

        HBox hBox = new HBox();





        BorderPane pane = new BorderPane();
        pane.setLeft(label);
        pane.setRight(hBox);
        BorderPane.setMargin(label, new Insets(0,0,0,5));


        hBox.getChildren().addAll(searchButton,filterTextField);

        HBox.setMargin(searchButton, new Insets(5,0,5,700));
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