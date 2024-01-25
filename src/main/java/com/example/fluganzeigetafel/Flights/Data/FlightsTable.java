package com.example.fluganzeigetafel.Flights.Data;

import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Orders.Order;
import com.example.fluganzeigetafel.Orders.OrderForm;
import com.example.fluganzeigetafel.Orders.Suborders.Suborder;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class FlightsTable extends TreeTableView   {
    public static Node getOdsuComponent() {
        return odsuComp;
    }

    public static void  setOdsuComponent(Node odsuComponent) {
        odsuComp = odsuComponent;
    }

    private static Node odsuComp;


    private String getPropertyName(String columnName) {
        // Convert "Flight nr" to "flightNr" using JavaFX naming conventions
        String[] words = columnName.split("\\s");
        StringBuilder propertyNameBuilder = new StringBuilder(words[0].toLowerCase());
        for (int i = 1; i < words.length; i++) {
            propertyNameBuilder.append(Character.toUpperCase(words[i].charAt(0))).append(words[i].substring(1).toLowerCase());
        }
        return propertyNameBuilder.toString();
    }

    int selectedIndex = 0;

    public FlightsTable() {

        String[] columnNames = {"Flight no", "Control no", "Registration", "Type", "Harbor", "Landing-takeoff-sign", "Sched. time", "Intern. time", "Position", "Terminal", "Client", "Status"};
        String[] propertyNames = {"fnr", "knr", "reg", "typ", "ha0", "lsk", "stt", "itt", "pos", "ter", "mad", "saa"};
        int i = 0;
        for (String columnName : columnNames) {
            TreeTableColumn<Flight, String> column = new TreeTableColumn<>(columnName);
            this.getColumns().add(column);

            // Assuming your Flight class has appropriate property methods, adjust accordingly
            String propertyName = getPropertyName(columnName);
            column.setCellValueFactory(new TreeItemPropertyValueFactory<>(propertyNames[i]));
            column.setStyle("-fx-alignment: CENTER;");
            column.setCellFactory(col -> {
                return new TreeTableCell<Flight, String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!isEmpty()) {

                            this.setBorder(null);
                            setText(item);
                        }
                    }
                };
            });

            i++;
        }




        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Scene scene = getScene();
                VBox vBox = (VBox) scene.getRoot();

                if (getOdsuComponent() != null) {
                    vBox.getChildren().remove(getOdsuComponent());

                }

                // Get the selected item
                TreeItem<Flight> selectedItem = (TreeItem<Flight>) getSelectionModel().getSelectedItem();



                // Check if the selected item is an order or suborder
                if (selectedItem != null) {
                    String selectedItemValue = selectedItem.getValue().getFnr();


                    TreeItem<Flight> flightTreeItem= selectedItem.getParent();
                    DataInterface.setCurrentFlight(flightTreeItem.getValue());

                    OrderForm orderForm = new OrderForm();
                    Order order  = null;
                    if (selectedItem.getValue().getKnr().equals("Order")) {
                        order = DataInterface.getInstance().getOrderByAUKEY(selectedItemValue);
                        VBox orderLayout = orderForm.createOrderForm(order);
                        setOdsuComponent(orderLayout);
                        boolean t = getOdsuComponent() == null;
                        System.out.println(t);
                        vBox.getChildren().add(orderLayout);
                    }

                    else
                        return;


                }
            }
        });


        this.getStylesheets().add(getClass().getResource("/com/example/fluganzeigetafel/tableStyle.css").toExternalForm());



        this.setColumnResizePolicy(TreeTableView.CONSTRAINED_RESIZE_POLICY);
        this.setPlaceholder(new Label(""));
        this.setEditable(true);
        DataInterface.flightsTable = this;
        this.refresh();
    }

    public FlightsTable populateTable(ArrayList<Flight> flights) {
        TreeItem<Flight> rootItem = new TreeItem<>(new Flight("Flights"));
        rootItem.setExpanded(true);


        for (Flight f : flights) {
            TreeItem<Flight> treeItem = new TreeItem<>(f);
            rootItem.getChildren().add(treeItem); // Add 'treeItem', not 'rootItem'
        }

        this.setRoot(rootItem);
        this.refresh();
        return this;
    }

    public static void addOrderItems(TreeTableView<Flight> tableView) {
        TreeItem<Flight> root =  tableView.getRoot();


        for (TreeItem<Flight> item : root.getChildren()) {
           Flight f = (Flight) item.getValue();
           ArrayList<Order> orderList = f.getContracts();

           for (Order order : orderList) {
               TreeItem<Flight> orderTreeItem = new TreeItem<>(
                       new Flight(order.getAUKEY(), "Order","","","","","","","","","",""));
               item.getChildren().add(orderTreeItem);


           }

        }


        tableView.refresh();

    }


    public static void addSubOrderItems(TreeTableView<Flight> tableView) {
        TreeItem<Flight> root = tableView.getRoot();

        for (TreeItem<Flight> item : root.getChildren()) {
            Flight f = (Flight) item.getValue();
            ArrayList<Order> orderList = f.getContracts();

          for (TreeItem<Flight> orderItem : item.getChildren()) {
             Order order = f.getContractByAukey(orderItem.getValue().getFnr());

             for (Suborder suborder : order.getSubOrdersList()) {
                 TreeItem<Flight> subOrderItem = new TreeItem<>(new Flight(suborder.getUAKEY(),"Suborder","","","","","","","","","",""));
                 orderItem.getChildren().add(subOrderItem);
             }

                       }

        }
    }




}