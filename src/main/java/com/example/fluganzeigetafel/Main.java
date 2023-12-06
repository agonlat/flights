package com.example.fluganzeigetafel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
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

        loadFlightsItem.setOnAction(e->FileMenu.fileLoadAction(stage));
        exportItem.setOnAction(e->FileMenu.fileExportAction());
        changeFlightItem.setOnAction(e->FileMenu.flightChangeAction());
        changeViewOptionsItem.setOnAction(e->ViewMenu.changeViewOptionAction());
        FilterAndSearchMethods.filterFlights(filterTextField);
        statisticalDataItem.setOnAction(e->DataMenu.statisticalDataAction());
        settingsItem.setOnAction(e->DataMenu.settingsActions());



        searchButton.setOnAction(e-> {
            if (DataInterface.getInstance().getFlights().isEmpty()) {
                LoadFlightsDialog dil = new LoadFlightsDialog();
                return;
            }

            Stage stage1 = new Stage() ;
            stage1.setWidth(stage1.getWidth()+100);
            stage1.setResizable(false);
            Label label1 = new Label("Flight no or control no");
            TextField field = new TextField();

            Button submit = new Button("Search");
            Button cancel = new Button("Cancel");

            cancel.setOnAction(b->stage1.close());

           VBox box = new VBox();
           box.setPadding(new Insets(0,5,0,5));
           HBox hbox = new HBox();
           box.setSpacing(5);
           hbox.setSpacing(5);
           HBox.setHgrow(cancel, Priority.ALWAYS);
            HBox.setHgrow(submit, Priority.ALWAYS);
           hbox.getChildren().addAll(cancel,submit);
           box.getChildren().addAll(label1, field, hbox);
            hbox.setPadding(new Insets(0,0,5,0));






            submit.setOnAction(g->{
                if (ValidationUtil.checkFlightNumberFormat(field.getText().trim())) {
                    if (ValidationUtil.checkFlightNumberExistence(field.getText().trim()) != null) {
                        Flight f = ValidationUtil.checkFlightNumberExistence(field.getText().trim());
                        String pattern = "FNR: " + f.getFnr() +
                                " KNR: " + f.getKnr() +
                                " REG: " + f.getReg() +
                                " TYP: " + f.getTyp() +
                                " HA0: " + f.getHa0() +
                                " LSK: " + f.getLsk() +
                                " STT: " + f.getStt() +
                                " ITT: " + f.getItt() +
                                " POS: " + f.getPos() +
                                " TER: " + f.getTer() +
                                " MAD: " + f.getMad() +
                                " SAA: " + f.getSaa();

                        Alert alert = new Alert(Alert.AlertType.INFORMATION, pattern,new ButtonType("Print", ButtonBar.ButtonData.APPLY));
                        alert.setTitle("Information");


                        alert.setContentText(pattern);
                        alert.setWidth(alert.getWidth() + 500);
                        Optional<ButtonType> opt = alert.showAndWait();

                        if (opt.isPresent() && opt.get().getButtonData() == ButtonBar.ButtonData.APPLY) {
                            PDF_controller controller = new PDF_controller();
                            controller.createPDF(f);
                        }

                    }
                    else {
                        Alert alertF = new Alert(Alert.AlertType.INFORMATION);

                        alertF.setTitle("Information");
                        alertF.setContentText("Flight not found!");
                        alertF.showAndWait();
                    }




                }
               else {
                    Alert alertF = new Alert(Alert.AlertType.INFORMATION);
                    alertF.setTitle("Information");
                    alertF.setContentText("Flight does not match the pattern!");
                    alertF.showAndWait();
                }

            });
            stage1.setScene(new Scene(box));
            stage1.showAndWait();
        });




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

        stage.setTitle("Anzeigetafel");
        stage.setScene(scene);



        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}