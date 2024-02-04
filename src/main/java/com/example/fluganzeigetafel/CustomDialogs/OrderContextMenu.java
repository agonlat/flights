package com.example.fluganzeigetafel.CustomDialogs;

import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Flights.Data.FlightsTable;
import com.example.fluganzeigetafel.Orders.Forms.OrderForm;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;

/**
 * This class represents a custom context menu for an Order.
 * Note that it extends ContextMenu in order to inherit the methods for a convenient work.
 * @author latifiagon
 */
public class OrderContextMenu extends ContextMenu {

    /**
     * This constructor creates the custom context menu and shows the empty Order after clicked on generate Order.
     * It has only one item which is "Generate Order"
     */
    public OrderContextMenu() {
        MenuItem createOrderItem = new MenuItem("Generate order");
        createOrderItem.setOnAction(e->{
            OrderForm orderForm = new OrderForm();
            VBox box = orderForm.createOrderForm();
            VBox vBox = (VBox) DataInterface.flightsTable.getScene().getRoot();
            vBox.getChildren().remove(DataInterface.getInstance().getCurrentItem());
            vBox.getChildren().add(box);
            FlightsTable.setOdsuComponent(box);
        });
        this.getItems().addAll(createOrderItem);
    }

}
