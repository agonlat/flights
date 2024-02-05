package com.example.fluganzeigetafel.Flights.Data;

import com.example.fluganzeigetafel.CustomDialogs.OrderContextMenu;
import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Orders.Order;
import com.example.fluganzeigetafel.Orders.Statistics.OrderChangesStats;
import com.example.fluganzeigetafel.Orders.Forms.OrderForm;
import com.example.fluganzeigetafel.Suborders.Statistics.SuborderChangeStats;
import com.example.fluganzeigetafel.Suborders.Suborder;
import com.example.fluganzeigetafel.Suborders.Forms.SuborderForm;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

/**
 * This is the class which represents the flights in a TreeTableView. It extends TreeTableView.
 * @author latifiagon
 */

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

    /**
     * This constructor creates the Flight table and handles are operations like listening to events or generating the TreeItems.
     */
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




        this.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<Flight>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<Flight>> observable,
                                TreeItem<Flight> oldValue, TreeItem<Flight> newValue) {
                Scene scene = getScene();
                VBox vBox = (VBox) scene.getRoot();



                // Check if the item is selected (not just expanded/collapsed)
                if (newValue != null && newValue != oldValue) {
                    // Get the selected item
                    TreeItem<Flight> selectedItem = (TreeItem<Flight>) getSelectionModel().getSelectedItem();

                    // Check if the selected item is an order or suborder

                    if (selectedItem != null) {

                        if (DataInterface.getInstance().isThreadRunning()) {
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setContentText("Please wait until the orders and suborders are loaded! A popup should appear after finishing");
                            alert.setHeaderText("WARNING");
                            alert.showAndWait();
                            selectedItem.setExpanded(false);
                            return;
                        }
                        String selectedItemValue = selectedItem.getValue().getFnr();

                        TreeItem<Flight> flightTreeItem = selectedItem.getParent();
                        DataInterface.setCurrentFlight(flightTreeItem.getValue());

                        OrderForm orderForm = new OrderForm();
                        Order order = null;
                        Suborder suborder = null;

                        if ("Order".equals(selectedItem.getValue().getKnr())) {

                            order = DataInterface.getInstance().getOrderByAUKEY(selectedItemValue);

                            VBox orderLayout = orderForm.createOrderForm(order);

                            HBox infoBox = new HBox();
                            BorderPane pane = OrderChangesStats.createStats(order);
                            infoBox.getChildren().addAll(orderLayout, pane);
                            HBox.setHgrow(pane, javafx.scene.layout.Priority.ALWAYS);

                            vBox.getChildren().addAll(infoBox);
                            setOdsuComponent(infoBox);
                            DataInterface.getInstance().setCurrentItem(selectedItem);

                        } else if ("Suborder".equals(selectedItem.getValue().getKnr())) {

                            SuborderForm suborderForm = new SuborderForm();
                            TreeItem<Flight> ff = selectedItem.getParent();
                            Order orderC = DataInterface.getInstance().getOrderByAUKEY(ff.getValue().getFnr());

                            suborder = orderC.getSubOrderByUAKEY(selectedItem.getValue().getFnr().trim());

                            VBox suborderLayout = suborderForm.createSubOrderForm(suborder, orderC);

                            HBox infoBox = new HBox();
                            BorderPane pane = SuborderChangeStats.createStats(suborder);
                            infoBox.getChildren().addAll(suborderLayout, pane);
                            HBox.setHgrow(pane, javafx.scene.layout.Priority.ALWAYS);


                            vBox.getChildren().addAll(infoBox);
                            setOdsuComponent(infoBox);
                            DataInterface.getInstance().setCurrentItem(selectedItem);
                        } else {
                            DataInterface.setCurrentFlight(selectedItem.getValue());
                        }
                        Platform.runLater(() -> getSelectionModel().clearSelection());
                    }
                }
            }
        });


        this.getStylesheets().add(getClass().getResource("/com/example/fluganzeigetafel/tableStyle.css").toExternalForm());



        this.setColumnResizePolicy(TreeTableView.CONSTRAINED_RESIZE_POLICY);
        this.setPlaceholder(new Label(""));
        this.setEditable(true);
        DataInterface.flightsTable = this;
        this.refresh();
        setContextMenu(new OrderContextMenu());
    }

    /**
     * This method populates the FlightsTable with flights.
     * Note that the flights are converted to TreeItems.
     * @param flights The Flights to be added as ArrayList
     */

    public FlightsTable populateTable(ArrayList<Flight> flights) {
        TreeItem<Flight> rootItem = new TreeItem<>(new Flight("Flights","","","","","","","","","","",""));
        rootItem.setExpanded(true);


        for (Flight f : flights) {
            TreeItem<Flight> treeItem = new TreeItem<>(f);
            rootItem.getChildren().add(treeItem); // Add 'treeItem', not 'rootItem'
        }

        this.setRoot(rootItem);



        this.refresh();
        return this;
    }

    /**
     * This method adds the Orders to the specific Flights
     * @param tableView The TableView where to add the Orders
     */

    public static void addOrderItems(TreeTableView<Flight> tableView) {
        TreeItem<Flight> root =  tableView.getRoot();


        for (TreeItem<Flight> item : root.getChildren()) {
            Flight f = (Flight) item.getValue();
            ArrayList<Order> orderList = f.getOrders();

            for (Order order : orderList) {
                TreeItem<Flight> orderTreeItem = new TreeItem<>(
                        new Flight(order.getAUKEY(), "Order","","","","","","","","","",""));
                item.getChildren().add(orderTreeItem);


            }

        }


        tableView.refresh();

    }

    /**
     * This method adds the Suborders to the specific Orders
     * @param tableView The TableView where to add the Suborders
     */


    public static void addSubOrderItems(TreeTableView<Flight> tableView) {
        TreeItem<Flight> root = tableView.getRoot();

        for (TreeItem<Flight> item : root.getChildren()) {
            Flight f = (Flight) item.getValue();
            ArrayList<Order> orderList = f.getOrders();

            for (TreeItem<Flight> orderItem : item.getChildren()) {
                Order order = f.getOrderByAUKEY(orderItem.getValue().getFnr());

                for (Suborder suborder : order.getSubOrdersList()) {
                    TreeItem<Flight> subOrderItem = new TreeItem<>(new Flight(suborder.getUAKEY(),"Suborder","","","","","","","","","",""));
                    orderItem.getChildren().add(subOrderItem);
                }

            }

        }
    }

    /**
     * This method is for populating the flights table.
     * @param flights The flights as an Observable List of TreeItems of Flights
     */


    public void populateTable(ObservableList<TreeItem<Flight>> flights) {
        DataInterface.flightsTable.getRoot().getChildren().clear();
        DataInterface.flightsTable.getRoot().getChildren().addAll(flights);
    }
}