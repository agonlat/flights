package com.example.fluganzeigetafel.Data;

import com.example.fluganzeigetafel.Data.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import com.example.fluganzeigetafel.Data.DataInterface;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class FlightsTable extends TableView{

    public FlightsTable() {


        this.setEditable(false);
        this.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.setPlaceholder(new Label(""));

        String[] cols = new String[]{"FNR", "KNR", "REG", "TYP", "HA0", "LSK", "STT", "ITT", "POS", "TER", "MAD", "SAA"};

        for (String s : cols) {
            TableColumn<Flight, String> column = new TableColumn<>(s);
            column.setCellValueFactory(new PropertyValueFactory<>(s.toLowerCase()));
            this.getColumns().add(column);
            column.setStyle("-fx-alignment: CENTER;");

        }


        DataInterface.flightsTable = this;


    }

    public void populateTable(ArrayList<Flight> flights) {
        ObservableList<Flight> observableFlightList = FXCollections.observableArrayList(flights);

        this.setItems(observableFlightList);

    }

}
