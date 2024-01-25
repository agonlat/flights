package com.example.fluganzeigetafel.Orders;

import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Flights.Data.FlightsTable;
import com.example.fluganzeigetafel.Orders.Print.Printer;
import com.example.fluganzeigetafel.Orders.Validation.Validation;
import com.example.fluganzeigetafel.Statistics.OrderStats;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.lang.reflect.Method;
import java.util.HashMap;

public class OrderForm {
    public VBox createOrderForm(Order order) {

        HashMap<String, String> map = new HashMap<>();
        map.put("AUKEY", "Autragsschlüssel");
        map.put("DISPO", "Dispositionssystem");
        map.put("DIB", "Dispositionsbereich");
        map.put("JTP", "Job Type");
        map.put("AUSAA", "Auftragsstatus");
        map.put("AUSAU", "Unterstatus");
        map.put("AUKNL", "Kontrollnummer Landung");
        map.put("AUKNS", "Kontrollnummer Start");
        map.put("FGKEY", "Referenz auf Fremddaten");
        map.put("PLKEY", "Planungsschlüssel");
        map.put("ORTFR", "1. Ort (from)");
        map.put("ORTTO", "2. Ort (to)");
        map.put("MENGE", "Menge");
        map.put("EINHE", "Einheit f. MENGE");
        map.put("MENG2", "Menge 2");
        map.put("EINH2", "Einheit f. Menge 2");
        map.put("MENG3", "Menge 3");
        map.put("EINH3", "Einheit f. Menge 3");
        map.put("MENG4", "Menge 4");
        map.put("EINH4", "Einheit f. Menge 4");
        map.put("UAZPL", "planm. benötigte TA's");
        map.put("UAZAK", "Teilauftragszähler");
        map.put("AUAGE", "Auftraggeber");
        map.put("STTBE", "Schedule Time of begin");
        map.put("STTEN", "Schedule Time of End");
        map.put("ETTBE", "Estm. Time of Begin");
        map.put("ETTEN", "Estim. Time of End");
        map.put("ATTBE", "Actual Time of Begin");
        map.put("ATTEN", "Actuel Time of End");
        map.put("ATT20", "1. Vorlage zur Disposition");
        map.put("AUPIR", "Problemindikator");
        map.put("ZINFO", "Zusatzinformationen");
        map.put("LUPDN", "letzter Update");
        map.put("LUPDT", "Zeitpunkt des letzten Updates");
        map.put("LUPDV", "Veranlasser d. letzten Änderung");
        map.put("KEYLK", "ID-des LK-Informationbroker");
        map.put("KEYLE", "ID-des LE-Informationbroker");
        map.put("KEYLF", "ID-des LF-Informationbroker");
        map.put("XAU", "Änderungszeitstempel");
        map.put("AUDAT", "Tagesdatum des Auftrags");
        map.put("AUABF", "Auftragsabfertiger");
        map.put("MITAR", "Mitarbeiterkürzel");
        map.put("FDAEN", "FD-Änderung");
        map.put("FLAGS", "Flags");
        map.put("CINFO", "Creator-Info");
        map.put("MAD", "Mandant");
        map.put("STLIK", "StücklistenKey");
        map.put("PKART", "Prozessart");
        map.put("PKL", "Prozessklasse");
        map.put("PKLAS", "Lastsituation");
        map.put("PKLEA", "Leistungsart");
        map.put("PKNAM", "Prozessklassename");
        map.put("RELFK", "wird in KFZ noch verwendet");



        VBox mainBox = new VBox();
        HBox buttonBox = new HBox();

        Button generateSuborderButton = new Button("Generate suborder");
        Button printButton = new Button("Print");
        Button deleteOrderButton = new Button("Delete");
        Button saveButton = new Button("Save");
        Button showOrderStatisticsButton = new Button("Show data about all orders");
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e-> {
           Scene scene =  DataInterface.flightsTable.getScene();
           VBox b = (VBox) scene.getRoot();
           b.getChildren().remove(FlightsTable.getOdsuComponent());
        });

        printButton.setOnAction(e->{
            Printer printer = new Printer();
            printer.createPDF(order);
        });


        showOrderStatisticsButton.setOnAction(e->{
            OrderStats orderStats = new OrderStats(DataInterface.getCurrentFlight().getContracts());

        });









        Image image = new Image(getClass().getResourceAsStream("/Icons/save.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(16);
        imageView.setFitWidth(16);
        saveButton.setGraphic(imageView);


        buttonBox.getChildren().addAll(saveButton, deleteOrderButton, showOrderStatisticsButton, generateSuborderButton, printButton, closeButton);

        GridPane informationPane = new GridPane();

        GridPane orderPane = new GridPane();
        mainBox.setPadding(new Insets(10));
        orderPane.setHgap(10);
        informationPane.setHgap(10);  // Set horizontal gap for better spacing
        informationPane.setPadding(new Insets(10));
        orderPane.setPadding(new Insets(10));


        saveButton.setOnAction(e->{
           ObservableList<Node> nodes =  orderPane.getChildren();
            Label label = null;
           for (Node node : nodes) {

               if (node instanceof Label) {
                   label = (Label) node;
               }

               if (node instanceof TextField) {
                   TextField field = (TextField) node;
                   checkField(label,field);
               }
           }




        });


        Label aukeyLabel = new Label("Order ID");
        Label dispoLabel = new Label("Disposition system");

        TextField aukeyField = new TextField(order.getAUKEY());
        TextField dispoField = new TextField(order.getDISPO());

        aukeyField.setEditable(false);
        dispoField.setEditable(false);
        aukeyField.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, null, null)));
        dispoField.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, null, null)));

        informationPane.add(aukeyLabel, 0, 0);
        informationPane.add(aukeyField, 1, 0);

        informationPane.add(dispoLabel, 0, 1);
        informationPane.add(dispoField, 1, 1);

        int row = 2; // Start the row index for custom fields
        int col = 0; // Start the column index for custom fields

        int size = order.getCSVRows().size();

        for (int i = 0; i < size; i++) {
            if (order.getCSVRows().get(i).getValue().isBlank())
                continue;

            if (order.getCSVRows().get(i).getDesignation().trim().equals("AUKEY") || order.getCSVRows().get(i).getDesignation().trim().equals("DISPO"))
                continue;

            Label label = new Label(map.get(order.getCSVRows().get(i).getDesignation()));
            label.setId(order.getCSVRows().get(i).getDesignation());
            TextField field = new TextField(order.getCSVRows().get(i).getValue());

            // Add label and field to the orderPane
            orderPane.add(label, col, row);
            orderPane.add(field, col + 1, row);

            // Move to the next row for the next custom field
            row++;

            // Check if we have reached the end of the current set of 10 fields
            if (row % 12 == 2) {
                col += 2; // Move to the next set of columns
                row = 2;  // Reset the row index for the next set
            }
        }

        Separator separator = new Separator(Orientation.HORIZONTAL);
        mainBox.getChildren().addAll(buttonBox, informationPane,separator,orderPane);


        return mainBox;
    }

    private static void checkField(Label label, TextField field) {
        String labelId = label.getId();
        String methodName = "check"+labelId;

        try {
            Method method = Validation.class.getDeclaredMethod(methodName, String.class);
            Object result = method.invoke(null,field.getText().trim());

            if (result instanceof Boolean) {
                boolean res = (Boolean) result;
                if (res == false) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Wrong value");
                    alert.setContentText("Wrong value at: " + labelId + ": " + field.getText());
                    alert.showAndWait();
                    return;
                }

                System.out.println("CORRECT VAL" + field.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
