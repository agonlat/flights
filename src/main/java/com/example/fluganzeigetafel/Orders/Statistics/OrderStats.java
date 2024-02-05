package com.example.fluganzeigetafel.Orders.Statistics;

import com.example.fluganzeigetafel.Orders.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * The OrderStats class represents a graphical display of order statistics, including disposition system, jobtype,
 * and mandant distribution.
 */
public class OrderStats extends Stage {

    /**
     * Creates an OrderStats stage with graphical displays of disposition system, jobtype, and mandant distribution.
     *
     * @param orderList The list of orders for which statistics are generated.
     */

    public OrderStats(ArrayList<Order> orderList) {

        ArrayList<Order> orders = orderList;
        Map<String, Integer> dispoMap = new HashMap<>();
        Map<String, Integer> jtpMap = new HashMap<>();
        Map<String, Integer> madMap = new HashMap<>();

        PieChart dispoDistribution = new PieChart();
        dispoDistribution.setTitle("Disposition system distribution");

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        for (Order order : orders) {
            String dispo = order.getDISPO();
            String jtp = order.getJTP();
            String mad = order.getMAD();

            if (!dispoMap.containsKey(dispo)) {
                dispoMap.put(dispo, 1);

            } else {
                dispoMap.put(dispo, dispoMap.get(dispo)+1);
            }

            if (!jtpMap.containsKey(jtp)) {
                jtpMap.put(jtp, 1);
            } else {
                jtpMap.put(jtp, jtpMap.get(jtp)+1);
            }

            if (!madMap.containsKey(mad)) {
                madMap.put(mad, 1);
            } else {
                madMap.put(mad, madMap.get(mad)+1);
            }
        }

        for (Map.Entry<String, Integer> map : dispoMap.entrySet()) {
            pieChartData.add(new PieChart.Data(map.getKey(), map.getValue()));
        }

        dispoDistribution.setData(pieChartData);

        CategoryAxis jtpXAxis = new CategoryAxis();
        NumberAxis jtpYAxis = new NumberAxis();
        BarChart<String, Number> jtpChart = new BarChart<>(jtpXAxis, jtpYAxis);
        jtpChart.setTitle("Jobtype distribution");

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("JTP");

        // Populate jtpMap
        for (Map.Entry<String, Integer> map : jtpMap.entrySet()) {
            series.getData().add(new XYChart.Data<>(map.getKey(), map.getValue()));
        }

        jtpChart.getData().add(series);

        // Create the BarChart for MAD distribution
        CategoryAxis madXAxis = new CategoryAxis();
        NumberAxis madYAxis = new NumberAxis();
        BarChart<String, Number> madChart = new BarChart<>(madXAxis, madYAxis);
        madChart.setTitle("Mandant distribution");

        XYChart.Series<String, Number> seriesMad = new XYChart.Series<>();
        seriesMad.setName("MAD");

        // Populate madMap
        for (Map.Entry<String, Integer> map : madMap.entrySet()) {
            seriesMad.getData().add(new XYChart.Data<>(map.getKey(), map.getValue()));
        }

        madChart.getData().add(seriesMad);

        // Create the layout
        HBox box = new HBox();
        box.getChildren().addAll(dispoDistribution, jtpChart, madChart);

        // Set up the scene and stage
        this.setScene(new Scene(box));
        this.setTitle("Order stats");
        this.show();



    }

}