package com.example.fluganzeigetafel.Orders.Statistics;

import com.example.fluganzeigetafel.Orders.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
/**
 * The OrderChangesStats class provides methods for creating a graphical representation of order statistics.
 */
public class OrderChangesStats {

    /**
     * Creates a BorderPane containing statistics for the given order.
     *
     * @param order The order for which statistics are displayed.
     * @return The BorderPane containing order statistics.
     */
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