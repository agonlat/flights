package com.example.fluganzeigetafel.Contract.Data;

import com.example.fluganzeigetafel.Contract.CSVRow;
import com.example.fluganzeigetafel.Contract.Contract;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ContractTable extends TableView {

    public ContractTable() {
      this.setEditable(false);
      this.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
      this.setPlaceholder(new Label(""));

        String[] cols = {
                "Designation", "Value"
        };

        for (String s: cols) {
            TableColumn<CSVRow, String> column = new TableColumn<CSVRow, String>(s);
            column.setCellValueFactory(new PropertyValueFactory<>(s.toLowerCase()));
            this.getColumns().add(column);
        }

    }



}
