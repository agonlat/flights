package com.example.fluganzeigetafel.Orders.Statistics;

import com.example.fluganzeigetafel.Orders.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

public class OrderChangesStats {
    public static BorderPane createStats(Order order) {
        BorderPane root = new BorderPane();

        ObservableList<String> orderHistory = FXCollections.observableArrayList(
                "Changes: " + order.getChanges(),
                "Last Change: " + order.getLastChangeFormatted(),
                "Creation Date: " + order.getCreationDateFormatted()
        );

        ListView<String> listView = new ListView<String>(orderHistory);

        root.setRight(listView);


        return root;
    }

}
