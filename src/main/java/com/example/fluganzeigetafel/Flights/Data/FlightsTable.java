package com.example.fluganzeigetafel.Flights.Data;

import com.example.fluganzeigetafel.Contract.Controller.ContractController;
import com.example.fluganzeigetafel.CustomDialogs.ErrorDialog;
import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Flights.Utility.ValidationUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.util.ArrayList;
import java.util.Stack;

public class FlightsTable extends TableView   {
    int selectedIndex = 0;

    public FlightsTable() {

      /*  this.setSortPolicy(param -> {
            FXCollections.sort(this.getItems(), (o1, o2) -> {
                Flight ob1 = (Flight)o1;
                Flight ob2= (Flight)o2;

                // Compare each column based on its type
                if (!ob1.getFnr().equals(ob2.getFnr())) {
                    return ob1.getFnr().compareTo(ob2.getFnr());
                }
                if (!ob1.getKnr().equals(ob2.getKnr())) {
                    return ob1.getKnr().compareTo(ob2.getKnr());
                }
                if (!ob1.getReg().equals(ob2.getReg())) {
                    return ob1.getReg().compareTo(ob2.getReg());
                }
                if (!ob1.getTyp().equals(ob2.getTyp())) {
                    return ob1.getTyp().compareTo(ob2.getTyp());
                }
                // Repeat the pattern for the remaining columns
                if (!ob1.getHa0().equals(ob2.getHa0())) {
                    return ob1.getHa0().compareTo(ob2.getHa0());
                }
                if (!ob1.getLsk().equals(ob2.getLsk())) {
                    return ob1.getLsk().compareTo(ob2.getLsk());
                }
                if (!ob1.getStt().equals(ob2.getStt())) {
                    return ob1.getStt().compareTo(ob2.getStt());
                }
                if (!ob1.getItt().equals(ob2.getItt())) {
                    return ob1.getItt().compareTo(ob2.getItt());
                }
                if (!ob1.getTer().equals(ob2.getTer())) {
                    return ob1.getTer().compareTo(ob2.getTer());
                }
                if (!ob1.getPos().equals(ob2.getPos())) {
                    return ob1.getPos().compareTo(ob2.getPos());
                }
                if (!ob1.getMad().equals(ob2.getMad())) {
                    return ob1.getMad().compareTo(ob2.getMad());
                }
                if (!ob1.getSaa().equals(ob2.getSaa())) {
                    return ob1.getSaa().compareTo(ob2.getSaa());
                }

                // If all specified columns are equal, return 0
                return 0;
            });

            return true;
        });

        */

        this.setEditable(true);


        Stack<Flight> delItems = new Stack<>();
        this.setUserData(delItems);
        MenuItem deleteItem = new MenuItem("Delete");
        MenuItem undoDeletion = new MenuItem("Undo deletion");
        ContextMenu contextMenu = new ContextMenu();

        deleteItem.setOnAction(e -> {
            Flight selectedFlight = (Flight) this.getSelectionModel().getSelectedItem();
            if (selectedFlight != null) {
                DataInterface.getInstance().getFlights().remove(selectedFlight);
                selectedIndex=this.getSelectionModel().getSelectedIndex();
                delItems.push(selectedFlight);
                this.populateTable((ArrayList<Flight>) DataInterface.getInstance().getFlights());
                this.refresh();
            }
        });

        // Handle the "Undo deletion" menu item
        undoDeletion.setOnAction(e -> {
            if (!delItems.isEmpty()) {
                Flight lastDeletedFlight = delItems.pop();
                DataInterface.getInstance().getFlights().add(selectedIndex, lastDeletedFlight);
                this.populateTable((ArrayList<Flight>) DataInterface.getInstance().getFlights());
                this.refresh();
            }
        });

        // Add menu items to the context menu
        contextMenu.getItems().addAll(deleteItem, undoDeletion);

        // Set the context menu for the table
        this.setContextMenu(contextMenu);




        this.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.setPlaceholder(new Label(""));
        int ind = 0;

        String[] cols = new String[]{"FNR", "KNR", "REG", "TYP", "HA0", "LSK", "STT", "ITT", "POS", "TER", "MAD", "SAA"};

        for (String s : cols) {

            TableColumn<Flight, String> column = new TableColumn<>(s);


            column.setCellValueFactory(new PropertyValueFactory<>(s.toLowerCase()));
            //     column.setSortType(TableColumn.SortType.ASCENDING);

        if (ind == 0) {

    column.setCellFactory(col -> {
        TableCell<Flight, String> cell = new TableCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (!empty) {
                    setText(item);

                    // Set text color to blue for the first column
              //  Flight f = (Flight) DataInterface.getFlightsTable().getSelectionModel().getSelectedItem();
              //  if (f != null && !f.getContracts().isEmpty())
                    setStyle("-fx-text-fill: blue;-fx-alignment: center");
                } else {
                    setText(null);
                    setStyle("");
                }
            }
        };



        // Change cursor on mouse enter
        cell.setOnMouseEntered(e -> cell.setCursor(Cursor.HAND));




        // Handle click events
        // Handle click events
        cell.setOnMouseClicked(e -> {

            ContractController.addTabs(cell);





        });

        return cell;

    });
    ind = -1;

}
            switch (s) {



                case "POS":

                    column.setEditable(true);
                    column.setCellFactory(TextFieldTableCell.<Flight>forTableColumn());
                    column.setOnEditCommit(e->{
                        Flight f = e.getRowValue();
                        String changed = e.getNewValue();
                        if (ValidationUtil.checkNewPosition(changed)) {
                            f.setPos(changed);
                        } else {
                            ErrorDialog dialog = new ErrorDialog("Wrong value! Check to proceed");
                            this.refresh();
                        }
                    });
                    break;

                case "TER":
                    column.setEditable(true);
                    column.setCellFactory(TextFieldTableCell.<Flight>forTableColumn());
                    column.setOnEditCommit(e->{
                        Flight f = e.getRowValue();
                        String changed = e.getNewValue();
                        if (!ValidationUtil.checkTER(changed)) {
                            ErrorDialog dialog = new ErrorDialog("Wrong value! Check to proceed");
                        }
                        else
                            f.setTer(changed);
                    });
                    break;
                case "SAA":
                    column.setEditable(true);
                    column.setCellFactory(TextFieldTableCell.<Flight>forTableColumn());
                    column.setOnEditCommit(e->{
                        Flight f = e.getRowValue();
                        String changed = e.getNewValue();
                        if (!ValidationUtil.checkSAA(changed)) {
                            ErrorDialog dialog = new ErrorDialog("Wrong value! Check to proceed");
                            this.refresh();
                        }
                        else
                            f.setSaa(changed);
                    });
                    break;
                case "ITT":
                    column.setEditable(true);
                    column.setCellFactory(TextFieldTableCell.<Flight>forTableColumn());
                    column.setOnEditCommit(e->{
                        Flight f = e.getRowValue();
                        String changed = e.getNewValue();
                        f.setItt(changed);
                        if (ValidationUtil.checkNewInternalTimeFormat(changed) && ValidationUtil.checkNewInternalTimeValue(changed, e.getOldValue()))
                            f.setItt(changed);
                        else {
                            ErrorDialog dialog = new ErrorDialog("Wrong value! Check to proceed");
                            this.refresh();
                        }


                        if (!ValidationUtil.checkNewInternalTimeValue(changed, e.getOldValue())) {
                            ErrorDialog dialog = new ErrorDialog("New itt cannot be smaller than the old one!");
                            this.refresh();
                        }

                    });
                    break;
                default:
                    column.setEditable(false);
            }




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