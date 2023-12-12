package com.example.fluganzeigetafel.Data;

import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TabPaneView  {
    private TabPane pane;
    public TabPaneView(VBox vbox) {
         pane = new TabPane();
        Tab flightsTab = new Tab("Flights", DataInterface.flightsTable);
        flightsTab.setClosable(false);
        pane.getTabs().add(flightsTab);
        VBox.setVgrow(pane, Priority.ALWAYS);

    }

    public TabPane getTabPaneView() {
        return pane;
    }

    public Tab addTab(Tab tab) {
        pane.getTabs().add(tab);
        return tab;
    }
}
