package com.example.fluganzeigetafel.Statistics;

import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Flights.Data.Flight;
import com.example.fluganzeigetafel.Orders.Data.OrderTable;
import com.example.fluganzeigetafel.Orders.Order;
import com.example.fluganzeigetafel.Orders.Suborders.Suborder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SuborderStats extends Stage {
    public SuborderStats() {
        Flight f = (Flight) DataInterface.getFlightsTable().getSelectionModel().getSelectedItem();
        Tab tab = DataInterface.getInstance().getTabPaneView().getSelectionModel().getSelectedItem();
        HBox box = null;
        TabPane pane = null;

        if (tab != null) {
            if (!(tab.getContent() instanceof TabPane)) {
                // Content is not an instance of TabPane
                box = (HBox) tab.getContent();
            } else {
                // Content is an instance of TabPane

                pane = (TabPane) tab.getContent();
                box = (HBox) pane.getTabs().get(0).getContent();

                if (pane.getTabs().size() > 0) {
                    tab = pane.getTabs().get(0);
                }
            }
        }

        Order order = new Order();
        ArrayList<Suborder> suborders = new ArrayList<>();


        for (Node node : box.getChildren()) {
       if(node instanceof OrderTable) {

                   OrderTable c = (OrderTable) node;
                    order = c.getOrder();

                    suborders =  order.getSubOrdersList();



                    break;
                }
        }



        Map<String, Integer> uasaaMap = new HashMap<>();
        Map<String, Integer> uaartMap = new HashMap<>();

        PieChart uasaaDistribution = new PieChart();
        uasaaDistribution.setTitle("UASAA (Status) Distribution");

        BarChart<String, Number> uaartChart = new BarChart<>(new CategoryAxis(), new NumberAxis());
        uaartChart.setTitle("UAART (Suborder Type) Counts");

        ObservableList<PieChart.Data> uasaaChartData = FXCollections.observableArrayList();
        XYChart.Series<String, Number> uaartSeries = new XYChart.Series<>();

        for (Suborder suborder : suborders) {
            String uasaa = suborder.getUASAA();
            String uaart = suborder.getUAART();

            // Populate UASAA map
            uasaaMap.put(uasaa, uasaaMap.getOrDefault(uasaa, 0) + 1);

            // Populate UAART map
            uaartMap.put(uaart, uaartMap.getOrDefault(uaart, 0) + 1);
        }

        // Populate data for UASAA PieChart
        for (Map.Entry<String, Integer> entry : uasaaMap.entrySet()) {
            uasaaChartData.add(new PieChart.Data(entry.getKey(), entry.getValue()));
        }
        uasaaDistribution.setData(uasaaChartData);

        // Populate data for UAART BarChart
        uaartSeries.setName("UAART Counts");
        for (Map.Entry<String, Integer> entry : uaartMap.entrySet()) {
            uaartSeries.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue()));
        }
        uaartChart.getData().add(uaartSeries);

        // Create the layout
        HBox boxs = new HBox();
        if (suborders.isEmpty()) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("No suborders");
         alert.setContentText("There are no suborders!");
         alert.showAndWait();
         return;
        }
        else
        boxs.getChildren().addAll(uasaaDistribution, uaartChart);

        // Set up the scene and stage
        this.setScene(new Scene(boxs));
        this.setTitle("Suborder stats order: " + order.getAUKEY());
        this.show();
    }


}
