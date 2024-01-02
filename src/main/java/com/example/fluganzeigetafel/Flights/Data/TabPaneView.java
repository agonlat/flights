package com.example.fluganzeigetafel.Flights.Data;

import com.example.fluganzeigetafel.DataInterface;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TabPaneView extends TabPane {

    public TabPaneView(VBox vbox) {

        Tab flightsTab = new Tab("Flights", DataInterface.flightsTable);
        flightsTab.setClosable(false);
        this.getTabs().add(flightsTab);
        VBox.setVgrow(this, Priority.ALWAYS);





    }

    public TabPane getTabPaneView() {
        return this;
    }

    public Tab addTab(Tab tab) {
        this.getTabs().add(tab);
        return tab;
    }
}
