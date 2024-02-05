package com.example.fluganzeigetafel.Suborders.Statistics;

import com.example.fluganzeigetafel.Suborders.Suborder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
/**
 * Generates statistics for changes made to a Suborder.
 */
public class SuborderChangeStats {
    /**
     * Creates a BorderPane containing statistics for the given Suborder.
     *
     * @param suborder The Suborder for which statistics are generated.
     * @return A BorderPane containing statistics such as Changes, Last Change, and Creation Date.
     */
    public static BorderPane createStats(Suborder suborder) {
        BorderPane root = new BorderPane();

        ObservableList<String> orderHistory = FXCollections.observableArrayList(
                "Changes: " + suborder.getChanges(),
                "Last Change: " + suborder.getLastChangeFormatted(),
                "Creation Date: " + suborder.getCreationDateFormatted()
        );

        ListView<String> listView = new ListView<String>(orderHistory);

        root.setRight(listView);


        return root;
    }
}