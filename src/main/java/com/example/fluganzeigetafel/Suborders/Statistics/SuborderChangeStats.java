package com.example.fluganzeigetafel.Suborders.Statistics;

import com.example.fluganzeigetafel.Suborders.Suborder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

public class SuborderChangeStats {
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
