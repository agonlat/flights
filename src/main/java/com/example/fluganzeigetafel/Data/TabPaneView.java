package com.example.fluganzeigetafel.Data;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class TabPaneView {
    public TabPaneView() {
        TabPane pane = new TabPane();
        Tab flightsTab = new Tab("Flights");
        pane.getTabs().add(flightsTab);
    }
}
