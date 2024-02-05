package com.example.fluganzeigetafel.Flights.Manager;


import com.example.fluganzeigetafel.DataInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.print.*;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Map;

 /**
  * This class is responsible for the statistical data of the flights.
  */

public class StatisticsManager {
private Stage stage;
private Image img;
private GridPane pane;
private Scene scene;

    
 /**
  * This constructor creates the window and includes all neccecary operations for showing the stats of all Flights.
  */
    public StatisticsManager() {
         stage = new Stage();
         img = new Image(getClass().getResourceAsStream("/Icons/info-circle-fill.png"));
         stage.getIcons().add(img);
         pane = new GridPane();
         scene = new Scene(pane);

        Button printButton = new Button("Print");



        stage.setTitle("Statistical Data");

        ObservableList<PieChart.Data> airlinesData =
                FXCollections.observableArrayList();
        int i = 0;

        for (Map.Entry<String,Integer> entry: DataInterface.getInstance().getAirlines().entrySet()) {
            airlinesData.add(new PieChart.Data(entry.getKey(), entry.getValue()));
            i++;
        }



        final PieChart airlineChart = new PieChart(airlinesData);
        airlineChart.setTitle("Airlines");

        XYChart.Series<String, Number> allFlights = new XYChart.Series<>();
        allFlights.setName("Total flights");
        allFlights.getData().add(new XYChart.Data<>("All flights ", DataInterface.getInstance().getFlights().size()));

        StackedBarChart<String, Number> stackedBarChartAll = new StackedBarChart<>(new CategoryAxis(), new NumberAxis());
        stackedBarChartAll.getData().add(allFlights);
        stackedBarChartAll.setTitle("Total flights " + DataInterface.getInstance().getFlights().size());

        XYChart.Series<String, Number> changedFlights = new XYChart.Series<>();
        changedFlights.setName("Changed flights");
        changedFlights.getData().add(new XYChart.Data<>("Changed flights", DataInterface.getInstance().getChangedFlightsCounter()));

        StackedBarChart<String, Number> stackedBarChartChanged = new StackedBarChart<>(new CategoryAxis(), new NumberAxis());
        stackedBarChartChanged.getData().add(changedFlights);
        stackedBarChartChanged.setTitle("Changed flights " + DataInterface.getInstance().getChangedFlightsSet().size());


        BorderPane bdp = new BorderPane();
        bdp.setCenter(printButton);

        pane.addRow(0, airlineChart);
        pane.addRow(1, stackedBarChartAll, stackedBarChartChanged);
        GridPane.setColumnSpan(bdp, 2);
        pane.addRow(2, bdp);
        stage.setWidth(stage.getWidth()-50);

        stage.setHeight(stage.getHeight()+300);


        stage.setScene(scene);

        printButton.setOnAction(e -> {
            PrinterJob job = PrinterJob.createPrinterJob();




            if (job != null && job.showPrintDialog(pane.getScene().getWindow())) {

                PageLayout layout = job.getPrinter().createPageLayout(Paper.A4, PageOrientation.LANDSCAPE, Printer.MarginType.DEFAULT);
                int size = 200;
                double airlineChartWidth = airlineChart.getWidth();
                double airlineChartHeight = airlineChart.getHeight();

                double stackedBarChartAllWidth = stackedBarChartAll.getWidth();
                double stackedBarChartAllHeight = stackedBarChartAll.getHeight();

                double stackedBarChartChangedWidth = stackedBarChartChanged.getWidth();
                double stackedBarChartChangedHeight = stackedBarChartChanged.getHeight();



                airlineChart.setMaxSize(size, size);  // Adjust as needed
                stackedBarChartAll.setMaxSize(size, size);
                stackedBarChartChanged.setMaxSize(size, size);


                job.getJobSettings().setPageLayout(layout);
                pane.setMaxWidth(pane.getWidth()-200);
                job.printPage(pane);
                job.endJob();

                airlineChart.setMaxSize(airlineChartWidth, airlineChartHeight);  // Adjust as needed
                stackedBarChartAll.setMaxSize(stackedBarChartAllWidth, stackedBarChartAllHeight);
                stackedBarChartChanged.setMaxSize(stackedBarChartChangedWidth, stackedBarChartChangedHeight);

            }
        });

        stage.showAndWait();



    }
}
