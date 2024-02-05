package com.example.fluganzeigetafel.Suborders.Forms;

import com.example.fluganzeigetafel.CustomDialogs.CloseDialog;
import com.example.fluganzeigetafel.CustomDialogs.EmptyFieldsDialog;
import com.example.fluganzeigetafel.CustomDialogs.ErrorDialog;
import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Flights.Data.Flight;
import com.example.fluganzeigetafel.Flights.Data.FlightsTable;
import com.example.fluganzeigetafel.Orders.Data.CSVRow;
import com.example.fluganzeigetafel.Orders.Order;
import com.example.fluganzeigetafel.Orders.Print.Printer;
import com.example.fluganzeigetafel.Suborders.Suborder;
import com.example.fluganzeigetafel.Suborders.Utils.Utils;
import com.example.fluganzeigetafel.Orders.Utilis.Utility;
import com.example.fluganzeigetafel.Orders.Validation.Validation;
import com.example.fluganzeigetafel.Orders.Statistics.OrderStats;
import com.example.fluganzeigetafel.Suborders.Statistics.SuborderStats;
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
import java.time.LocalDateTime;
import java.util.*;

/**
 * Manages the form for Suborders, handling field correctness, gui elements ...
 */
public class SuborderForm {
    static boolean allFieldsCorrect = true;
    private Map<Label, TextField> changeDetection;
    private boolean isChanged;
    static Order orderS;
    private VBox mainBox = new VBox();
    private HBox buttonBox = new HBox();
    private GridPane informationPane = new GridPane();

    private GridPane orderPane = new GridPane();

    /**
     * Creates a VBox containing the form for a Suborder, based on the provided Suborder and Order.
     *
     * @param suborder The Suborder for which the form is created.
     * @param order    The associated Order.
     * @return A VBox containing the Suborder form.
     */
    public VBox createSubOrderForm(Suborder suborder, Order order) {


        HashMap<String, String> uaKeyMap = new HashMap<>();

        uaKeyMap.put("UAKEY", "UA-Schlüssel");
        uaKeyMap.put("AUKEY", "Referenz auf Auftrag");
        uaKeyMap.put("SPREK", "Referenz auf SPRE-Satz (Belegung)");
        uaKeyMap.put("REKEY", "Referenz auf RE-Satz (Resource)");
        uaKeyMap.put("URK", "Ursprünglicher REKEY");
        uaKeyMap.put("FGKEY", "Referenz auf Fremddaten");
        uaKeyMap.put("SPKEY", "Referenz auf SP-Satz (Personal)");
        uaKeyMap.put("UAART", "Art des Teilauftrag");
        uaKeyMap.put("UASAA", "Auftragsstatus des Teilauftrages");
        uaKeyMap.put("UASAU", "Unterstatus");
        uaKeyMap.put("ORTFR", "1. Ort (from)");
        uaKeyMap.put("ORTTO", "2. Ort (to)");
        uaKeyMap.put("SAAOF", "Offset in Minuten f. Flugstatus-Trigger");
        uaKeyMap.put("SAA20", "Flugstatus-Trigger");
        uaKeyMap.put("STT20", "geplante Vorlage zur Disposition");
        uaKeyMap.put("STTBE", "Schedule Time of begin");
        uaKeyMap.put("STTEN", "Schedule Time of End");
        uaKeyMap.put("ETTEN", "Estim. Time of End");
        uaKeyMap.put("ETTBE", "Estm. Time of Begin");
        uaKeyMap.put("ATTBE", "Actual Time of Begin");
        uaKeyMap.put("ATTEN", "Actual Time of End");
        uaKeyMap.put("ATT20", "Vorlage zur Disposition");
        uaKeyMap.put("ATT30", "Zeitpunkt der letzten Auftragszuweisung");
        uaKeyMap.put("ATT40", "Zeitpunkt Status 40");
        uaKeyMap.put("ATT50", "Zeitpunkt Status 50");
        uaKeyMap.put("ATT55", "Zeitpunkt Status 55");
        uaKeyMap.put("ATT60", "Zeitpunkt Status 60");
        uaKeyMap.put("ATT70", "Zeitpunkt Status 70");
        uaKeyMap.put("ATT75", "Zeitpunkt Status 75");
        uaKeyMap.put("ATTER", "");
        uaKeyMap.put("ETT30", "erwarteter Auftragsbeginn");
        uaKeyMap.put("MENGE", "Anzahl");
        uaKeyMap.put("EINHE", "Einheit f. MENGE");
        uaKeyMap.put("MENG2", "Menge 2");
        uaKeyMap.put("EINH2","Einheit f. Menge 2");
        uaKeyMap.put("MENG3", "Menge 3");
        uaKeyMap.put("EINH3", "Einheit f. Menge 3");
        uaKeyMap.put("MENG4", "Menge 4");
        uaKeyMap.put("EINH4", "Einheit f. Menge 4");
        uaKeyMap.put("UAPIR", "Problemindikator");
        uaKeyMap.put("QKB", "Qualifikation");
        uaKeyMap.put("ZINFO", "Zusatzinformationen");
        uaKeyMap.put("SKRIT", "Kriterien f. Unterauftrag");
        uaKeyMap.put("LZUAU", "Letzter Teilauftrag");
        uaKeyMap.put("INDNR", "Index");
        uaKeyMap.put("LUPDN", "letzter Update");
        uaKeyMap.put("LUPDT", "Zeitpunkt d letzten Updates");
        uaKeyMap.put("LUPDV", "Veranlasser der letzten Änderung");
        uaKeyMap.put("XUA", "letzte Bearbeitung");
        uaKeyMap.put("UAABF", "Abfertiger");
        uaKeyMap.put("UAREE", "Rechnungsempfänger");
        uaKeyMap.put("UAAGE", "Auftraggeber Unterauftrag");
        uaKeyMap.put("UAINF", "Information UA");
        uaKeyMap.put("UAKSL", "Kennzeichen Sonderleistung");
        uaKeyMap.put("CINFO", "Creator-Info");
        uaKeyMap.put("SKA", "Sortierkriterien");
        uaKeyMap.put("STLIK", "StücklistenKey");
        uaKeyMap.put("OKEYN", "Interpretierter Ort");
        uaKeyMap.put("ABI", "tatsächliche Bindezeit");
        uaKeyMap.put("EBI", "erwartete Bindezeit");
        uaKeyMap.put("SBI", "geplante Bindezeit");
        uaKeyMap.put("TOURK", "Tourenkennzeichen");
        uaKeyMap.put("RELFK", "wird in KFZ verwendet");
        uaKeyMap.put("CBDFK", "nicht mehr benötigt");
        uaKeyMap.put("DFKEY", "nicht mehr benötigt");









        Button printButton = new Button("Print");
        Button deleteSubOrderButton = new Button("Delete");
        Button saveButton = new Button("Save");
        Button showSubOrderStatisticsButton = new Button("Show data about all suborders");
        Button closeButton = new Button("Close");


        closeButton.setOnAction(e-> {
            if (CloseDialog.createCloseDialog()) {
                Scene scene =  DataInterface.flightsTable.getScene();
                VBox b = (VBox) scene.getRoot();
                b.getChildren().remove(FlightsTable.getOdsuComponent());
            } else {

            }

        });

        printButton.setOnAction(e->{
            if (Utility.fieldsAreEmpty(orderPane.getChildren())) {
                EmptyFieldsDialog emptyFieldsDialog = new EmptyFieldsDialog();
            } else {
                Printer printer = new Printer();
                printer.createPDF(suborder);
            }



        });


        showSubOrderStatisticsButton.setOnAction(e->{

            if (Utility.fieldsAreEmpty(orderPane.getChildren())) {
                EmptyFieldsDialog emptyFieldsDialog = new EmptyFieldsDialog();
            } else {
                SuborderStats orderStats = new SuborderStats(order);
            }
        });




        deleteSubOrderButton.setOnAction(e-> {

            if (Utility.fieldsAreEmpty(orderPane.getChildren())) {
                Scene scene =  DataInterface.flightsTable.getScene();
                VBox b = (VBox) scene.getRoot();
                b.getChildren().remove(FlightsTable.getOdsuComponent());
            } else {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("Do you really want to delete the suborder?");
                alert.setHeaderText("Warning");
                Optional<ButtonType> result =  alert.showAndWait();

                result.ifPresent(c->{
                    if (c == ButtonType.OK) {

                        DataInterface.getInstance().getSubordersList().remove(suborder);


                        //  DataInterface.getInstance().getContracts().remove(order);
                        Scene flightsTableScene = DataInterface.flightsTable.getScene();
                        VBox flightsTableBox = (VBox) flightsTableScene.getRoot();
                        flightsTableBox.getChildren().remove(FlightsTable.getOdsuComponent());

                        TreeItem<Flight> treeItem = DataInterface.getInstance().getCurrentItem();

                        TreeItem<Flight> parent = treeItem.getParent();
                        parent.getChildren().remove(treeItem);


                        DataInterface.flightsTable.refresh();


                    } else {
                        return;
                    }
                });

            }





        });




        Image image = new Image(getClass().getResourceAsStream("/Icons/save.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(16);
        imageView.setFitWidth(16);
        saveButton.setGraphic(imageView);


        buttonBox.getChildren().addAll(saveButton, deleteSubOrderButton, showSubOrderStatisticsButton, printButton, closeButton);



        mainBox.setPadding(new Insets(10));
        orderPane.setHgap(10);
        informationPane.setHgap(10);  // Set horizontal gap for better spacing
        informationPane.setPadding(new Insets(10));
        orderPane.setPadding(new Insets(10));






        Label aukeyLabel = new Label("Order ID");
        Label uakeyLabel = new Label("Suborder ID");

        TextField aukeyField = new TextField(suborder.getAUKEY());
        TextField uakeyField = new TextField(suborder.getUAKEY());

        aukeyField.setEditable(false);
        uakeyField.setEditable(false);
        aukeyField.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, null, null)));
        uakeyField.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, null, null)));

        informationPane.add(aukeyLabel, 0, 0);
        informationPane.add(aukeyField, 1, 0);

        informationPane.add(uakeyLabel, 0, 1);
        informationPane.add(uakeyField, 1, 1);

        int row = 2; // Start the row index for custom fields
        int col = 0; // Start the column index for custom fields

        int size = suborder.getCSVRows().size();





        for (int i = 0; i < size; i++) {
            if (suborder.getCSVRows().get(i).getValue().isBlank())
                continue;

            if (suborder.getCSVRows().get(i).getDesignation().trim().equals("AUKEY") || suborder.getCSVRows().get(i).getDesignation().trim().equals("UAKEY"))
                continue;

            Label label = new Label(uaKeyMap.get(suborder.getCSVRows().get(i).getDesignation()));
            label.setId(suborder.getCSVRows().get(i).getDesignation());
            TextField field = new TextField();
            field.setText(suborder.getCSVRows().get(i).getValue());




            field.textProperty().addListener((observable, oldValue, newValue) -> {

                if (!oldValue.trim().equals(newValue.trim())) {

                    isChanged = true;
                }

            });

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


        ObservableList<Node> nodes = (ObservableList<Node>) orderPane.getChildren();


        saveButton.setOnAction(e->{
            if (Utility.fieldsAreEmpty(orderPane.getChildren())) {
                EmptyFieldsDialog emptyFieldsDialog = new EmptyFieldsDialog();
            } else {
                allFieldsCorrect = true;
                ObservableList<Node> nodes_c =  orderPane.getChildren();


                Label label = null;
                for (Node node : nodes_c) {

                    if (node instanceof Label) {
                        label = (Label) node;
                    }

                    if (node instanceof TextField) {
                        TextField field = (TextField) node;
                        checkField(label,field);
                        if (allFieldsCorrect == false)
                            return;
                    }
                }


                if (allFieldsCorrect) {
                    for (Node node : nodes) {

                        if (node instanceof Label) {
                            label = (Label) node;
                        }

                        if (node instanceof TextField) {
                            TextField field = (TextField) node;




                            performUpdate(label, field, suborder);











                        }
                    }


                    suborder.setChanges(order.getChanges()+1);
                    suborder.setLastChange(LocalDateTime.now());






                    DataInterface.flightsTable.refresh();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText("Success");
                    alert.setContentText("Changes successfully changed!");
                    alert.showAndWait();

                }


            }





        });





        return mainBox;





    }
    /**
     * Creates a VBox containing the form for a Suborder based on the provided Order, representing a new Suborder.
     *
     * @param order The Order for which the Suborder form is created.
     * @return A VBox containing the Suborder form.
     */
    public VBox createSubOrderForm(Order order) {
        orderS = order;
        isChanged = false;
        changeDetection = new HashMap<>();

        String dispo = order.getDISPO().trim();
        Suborder suborder = new Suborder();
        suborder.setAUKEY(order.getAUKEY());
        suborder.setUAKEY(Utils.generateUAKEY());



        Map<String, List<String>> dispoSystems = new HashMap<>();
        ArrayList<CSVRow> rows = new ArrayList<>();
        // Werte hinzufügen
        List<String> values = new ArrayList<>();
        values.add("UAKEY");
        values.add("AUKEY");
        values.add("SPREK");
        values.add("REKEY");
        values.add("FGKEY");
        values.add("SPKEY");
        values.add("UAART");
        values.add("UASAA");
        values.add("UASAU");
        values.add("ORTFR");
        values.add("ORTTO");
        values.add("SAAOF");
        values.add("SAA20");
        values.add("STT20");
        values.add("STTBE");
        values.add("STTEN");
        values.add("ETTEN");
        values.add("ETTBE");
        values.add("ATTBE");
        values.add("ATTEN");
        values.add("ATT20");
        values.add("ATT30");
        values.add("ATT40");
        values.add("ATT50");
        values.add("ATT55");
        values.add("ATT60");
        values.add("ATT70");
        values.add("ATT75");
        values.add("ATTER");
        values.add("ETT30");
        values.add("MENGE");
        values.add("EINHE");
        values.add("MENG2");
        values.add("UAPIR");
        values.add("ZINFO");
        values.add("LZUAU");
        values.add("INDNR");
        values.add("LUPDN");
        values.add("LUPDT");
        values.add("LUPDV");
        values.add("XUA");
        values.add("UAABF");
        values.add("UAREE");
        values.add("UAAGE");
        values.add("UAINF");
        values.add("UAKSL");
        values.add("CINFO");
        values.add("SKA");
        values.add("ABI");
        values.add("EBI");
        values.add("SBI");
        values.add("TOURK");


        List<String> values2 = Arrays.asList("UAKEY", "AUKEY", "SPREK", "REKEY", "SPKEY", "UAART",
                "UASAA", "UASAU", "ORTFR", "ORTTO", "STTBE", "STTEN", "ETTEN", "ETTBE", "ATTBE",
                "ATTEN", "ATT20", "ATT30", "ATT40", "ATT50", "ATT60", "ATT70", "ATT75", "MENGE",
                "EINHE", "UAPIR", "ZINFO", "LZUAU", "LUPDN", "LUPDT", "LUPDV", "XUA", "CINFO",
                "ABI", "EBI", "SBI", "TOURK");


        List<String> values3 = Arrays.asList("UAKEY", "AUKEY", "SPKEY", "UAART", "UASAA", "STTBE",
                "STTEN", "STTEN", "ETTEN", "ETTEN", "ETTBE", "ATTBE", "ATTEN", "ATT20", "ATT40",
                "ATT50", "UAPIR", "LUPDN", "LUPDT", "LUPDV", "XUA", "EBI", "SBI", "ZINFO");


        List<String> values4 = Arrays.asList("UAKEY", "AUKEY", "SPREK", "REKEY", "URK", "FGKEY", "SPKEY",
                "UAART", "UASAA", "UASAU", "ORTFR", "SAA20", "STT20", "STTBE", "STTEN", "ETTEN", "ETTBE",
                "ATTBE", "ATTEN", "ATT20", "ATT30", "ATT40", "ATT50", "ATT55", "ATT60", "ATT70", "ATT75",
                "ATTER", "ETT30", "MENGE", "EINHE", "MENG2", "UAPIR", "QKB", "ZINFO", "INDNR", "LUPDN",
                "LUPDT", "LUPDV", "XUA", "UAABF",
                "UAREE", "UAAGE", "UAINF", "UAKSL", "CINFO", "SKA", "STLIK", "ABI", "EBI", "SBI");


        List<String> values5 = Arrays.asList("ATT20", "ATT30", "AUKEY", "FGKEY", "LUPDN", "LUPDT", "LUPDV", "MENG2",
                "MENGE", "ORTFR", "ORTTO", "UAAGE", "UAINF", "UAKEY", "UASAA", "UASAU", "XUA", "ZINFO");


        List<String> values6 = Arrays.asList("UAKEY", "AUKEY", "SPREK", "REKEY", "FGKEY", "SPKEY", "UAART",
                "UASAA", "ORTFR", "ORTTO", "SAAOF", "SAA20", "STT20", "STTBE", "STTEN", "ETTEN", "ETTBE",
                "ATTBE", "ATTEN", "ATT20", "ATT30", "ATT40", "ATT50", "ATT55", "ATT60", "ATT70", "ATT75",
                "ATTER", "ETT30", "MENGE", "EINHE", "MENG2", "UAPIR", "QKB", "ZINFO", "LZUAU", "INDNR",
                "LUPDN", "LUPDT", "LUPDV", "XUA", "UAABF",
                "UAREE", "UAAGE", "UAINF", "UAKSL", "CINFO", "SKA", "STLIK", "OKEYN", "RELFK");

        List<String> values7 = Arrays.asList("UAKEY", "AUKEY", "REKEY", "URK", "FGKEY", "UAART", "UASAA", "UASAU", "ORTFR",
                "ORTTO", "SAA20", "STT20", "STTBE", "STTEN", "ETTEN", "ETTBE", "ATTBE", "ATTEN", "ATT20", "ATT40", "ATTER",
                "MENG3", "MENGE", "EINHE", "MENG2", "UAPIR", "ZINFO", "INDNR", "LUPDN", "LUPDT", "LUPDV", "XUA", "UAABF",
                "UAAGE", "UAINF", "UAKSL", "CINFO", "SKA", "STLIK", "ABI", "EBI", "SBI");


        List<String> values8 = Arrays.asList("ATT20", "ATT30", "ATTBE", "ATTEN", "ATT55", "ATT60", "ATT70", "ATT75",
                "AUKEY", "ETTBE", "ETTEN", "LUPDN", "LUPDT", "LUPDV", "ORTFR", "REKEY", "SPREK", "STTBE", "STTEN",
                "UAKEY", "UASAA", "XUA", "ZINFO", "ABI", "EBI", "SBI");


        List<String> values9 = Arrays.asList("UAKEY", "AUKEY", "FGKEY", "UASAA", "ORTFR", "ORTTO", "STT20", "STTBE", "STTEN",
                "ETTEN", "ETTBE", "ATTBE", "ATTEN", "ATT30", "ATT40", "ATT50",
                "ATTER", "ZINFO", "INDNR", "LUPDN", "LUPDT", "LUPDV", "XUA", "UAABF", "UAREE", "UAAGE", "STLIK");

        List<String> values10 = Arrays.asList("ATT20", "ATT30", "ATT40", "ATT50", "ATT60", "ATTBE", "ATTEN", "ETTBE",
                "ETTEN", "AUKEY", "ETTBE", "ETTEN", "LUPDN", "LUPDT", "LUPDV", "ORTTO", "STT20", "STTBE", "STTEN",
                "UAART", "UAINF", "UAKEY", "UASAA", "XUA");

        List<String> values11 = Arrays.asList("UAKEY", "AUKEY", "SPREK", "REKEY", "URK", "FGKEY", "SPKEY", "UAART", "UASAA", "UASAU",
                "ORTFR", "ORTTO", "SAAOF", "SAA20", "STT20", "STTBE", "STTEN", "ETTEN", "ETTBE", "ATTBE", "ATTEN", "ATT20",
                "ATT30", "ATT40", "ATT50", "ATT55", "ATT60", "ATT70", "ATT75", "ATTER", "ETT30", "MENGE", "EINHE", "MENG2",
                "EINH2", "MENG3", "EINH3", "MENG4", "EINH4", "UAPIR", "QKB", "ZINFO", "SKRIT", "LZUAU", "INDNR", "LUPDN",
                "LUPDT", "LUPDV", "XUA", "UAABF", "UAREE", "UAAGE", "UAINF", "UAKSL", "CINFO", "SKA", "STLIK", "OKEYN",
                "ABI", "EBI", "SBI", "TOURK");
        ArrayList<String> list = null;
        ArrayList<String> array2 = new ArrayList<>(values2);
        ArrayList<String> array3 = new ArrayList<>(values3);
        ArrayList<String> array4 = new ArrayList<>(values4);
        ArrayList<String> array5 = new ArrayList<>(values5);
        ArrayList<String> array6 = new ArrayList<>(values6);
        ArrayList<String> array7 = new ArrayList<>(values7);
        ArrayList<String> array8 = new ArrayList<>(values8);
        ArrayList<String> array9 = new ArrayList<>(values9);
        ArrayList<String> array10 = new ArrayList<>(values10);
        ArrayList<String> array11 = new ArrayList<>(values11);



        dispoSystems.put("BUS", values);
        dispoSystems.put("LUCHS", array2);
        dispoSystems.put("CLEAN", array3);
        dispoSystems.put("COBRA2", array4);
        dispoSystems.put("MAUSGEP", array5);
        dispoSystems.put("KFZ", array6);
        dispoSystems.put("PANDA-ANK", array7);
        dispoSystems.put("FUCHS", array8);
        dispoSystems.put("PUMA2", array9);
        dispoSystems.put("ENTEISUNG", array10);
        dispoSystems.put("BAGTR", array11);


        switch (dispo) {
            case "PUMA2":
            case "BUS":
            case "LUCHS":
            case "CLEAN":
            case "COBRA2":
            case "MAUSGEP":
            case "KFZ":
            case "PANDA":
            case "FUCHS":
            case "ENTEISUNG":
            case "BAGTR":

                list = (ArrayList<String>) dispoSystems.get(dispo);
                break;
            default:
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("An internal error occured. Please try again.");
                alert.setHeaderText("ERROR");
                alert.setTitle("Error");
                alert.showAndWait();

        }

        FlightsTable.setOdsuComponent(orderPane );
        ArrayList<String> labelNames = list;

        HashMap<String, String> uaKeyMap = new HashMap<>();

        uaKeyMap.put("UAKEY", "UA-Schlüssel");
        uaKeyMap.put("AUKEY", "Referenz auf Auftrag");
        uaKeyMap.put("SPREK", "Referenz auf SPRE-Satz (Belegung)");
        uaKeyMap.put("REKEY", "Referenz auf RE-Satz (Resource)");
        uaKeyMap.put("URK", "Ursprünglicher REKEY");
        uaKeyMap.put("FGKEY", "Referenz auf Fremddaten");
        uaKeyMap.put("SPKEY", "Referenz auf SP-Satz (Personal)");
        uaKeyMap.put("UAART", "Art des Teilauftrag");
        uaKeyMap.put("UASAA", "Auftragsstatus des Teilauftrages");
        uaKeyMap.put("UASAU", "Unterstatus");
        uaKeyMap.put("ORTFR", "1. Ort (from)");
        uaKeyMap.put("ORTTO", "2. Ort (to)");
        uaKeyMap.put("SAAOF", "Offset in Minuten f. Flugstatus-Trigger");
        uaKeyMap.put("SAA20", "Flugstatus-Trigger");
        uaKeyMap.put("STT20", "geplante Vorlage zur Disposition");
        uaKeyMap.put("STTBE", "Schedule Time of begin");
        uaKeyMap.put("STTEN", "Schedule Time of End");
        uaKeyMap.put("ETTEN", "Estim. Time of End");
        uaKeyMap.put("ETTBE", "Estm. Time of Begin");
        uaKeyMap.put("ATTBE", "Actual Time of Begin");
        uaKeyMap.put("ATTEN", "Actual Time of End");
        uaKeyMap.put("ATT20", "Vorlage zur Disposition");
        uaKeyMap.put("ATT30", "Zeitpunkt der letzten Auftragszuweisung");
        uaKeyMap.put("ATT40", "Zeitpunkt Status 40");
        uaKeyMap.put("ATT50", "Zeitpunkt Status 50");
        uaKeyMap.put("ATT55", "Zeitpunkt Status 55");
        uaKeyMap.put("ATT60", "Zeitpunkt Status 60");
        uaKeyMap.put("ATT70", "Zeitpunkt Status 70");
        uaKeyMap.put("ATT75", "Zeitpunkt Status 75");
        uaKeyMap.put("ATTER", "");
        uaKeyMap.put("ETT30", "erwarteter Auftragsbeginn");
        uaKeyMap.put("MENGE", "Anzahl");
        uaKeyMap.put("EINHE", "Einheit f. MENGE");
        uaKeyMap.put("MENG2", "Menge 2");
        uaKeyMap.put("EINH2","Einheit f. Menge 2");
        uaKeyMap.put("MENG3", "Menge 3");
        uaKeyMap.put("EINH3", "Einheit f. Menge 3");
        uaKeyMap.put("MENG4", "Menge 4");
        uaKeyMap.put("EINH4", "Einheit f. Menge 4");
        uaKeyMap.put("UAPIR", "Problemindikator");
        uaKeyMap.put("QKB", "Qualifikation");
        uaKeyMap.put("ZINFO", "Zusatzinformationen");
        uaKeyMap.put("SKRIT", "Kriterien f. Unterauftrag");
        uaKeyMap.put("LZUAU", "Letzter Teilauftrag");
        uaKeyMap.put("INDNR", "Index");
        uaKeyMap.put("LUPDN", "letzter Update");
        uaKeyMap.put("LUPDT", "Zeitpunkt d letzten Updates");
        uaKeyMap.put("LUPDV", "Veranlasser der letzten Änderung");
        uaKeyMap.put("XUA", "letzte Bearbeitung");
        uaKeyMap.put("UAABF", "Abfertiger");
        uaKeyMap.put("UAREE", "Rechnungsempfänger");
        uaKeyMap.put("UAAGE", "Auftraggeber Unterauftrag");
        uaKeyMap.put("UAINF", "Information UA");
        uaKeyMap.put("UAKSL", "Kennzeichen Sonderleistung");
        uaKeyMap.put("CINFO", "Creator-Info");
        uaKeyMap.put("SKA", "Sortierkriterien");
        uaKeyMap.put("STLIK", "StücklistenKey");
        uaKeyMap.put("OKEYN", "Interpretierter Ort");
        uaKeyMap.put("ABI", "tatsächliche Bindezeit");
        uaKeyMap.put("EBI", "erwartete Bindezeit");
        uaKeyMap.put("SBI", "geplante Bindezeit");
        uaKeyMap.put("TOURK", "Tourenkennzeichen");
        uaKeyMap.put("RELFK", "wird in KFZ verwendet");
        uaKeyMap.put("CBDFK", "nicht mehr benötigt");
        uaKeyMap.put("DFKEY", "nicht mehr benötigt");







        VBox mainBox = new VBox();
        HBox buttonBox = new HBox();


        Button printButton = new Button("Print");
        Button deleteSubOrderButton = new Button("Delete");
        Button saveButton = new Button("Save");
        Button showSubOrderStatisticsButton = new Button("Show data about all suborders");
        Button closeButton = new Button("Close");

        closeButton.setOnAction(e-> {



            if (CloseDialog.createCloseDialog()) {
                Scene scene =  DataInterface.flightsTable.getScene();
                VBox b = (VBox) scene.getRoot();
                b.getChildren().remove(FlightsTable.getOdsuComponent());}
            else {

            }



        });

        printButton.setOnAction(e->{

            if (Utility.fieldsAreEmpty(orderPane.getChildren())) {
                EmptyFieldsDialog emptyFieldsDialog = new EmptyFieldsDialog();
            } else {
                Printer printer = new Printer();
                printer.createPDF(order);
            }
        });


        showSubOrderStatisticsButton.setOnAction(e->{
            if (Utility.fieldsAreEmpty(orderPane.getChildren())) {
                EmptyFieldsDialog emptyFieldsDialog = new EmptyFieldsDialog();
            } else {
                OrderStats orderStats = new OrderStats(DataInterface.getCurrentFlight().getOrders());
            }
        });




        deleteSubOrderButton.setOnAction(e-> {

            if (Utility.fieldsAreEmpty(orderPane.getChildren())) {
                Scene scene =  DataInterface.flightsTable.getScene();
                VBox b = (VBox) scene.getRoot();
                b.getChildren().remove(FlightsTable.getOdsuComponent());

            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("Do you really want to delete the suborder?");
                alert.setHeaderText("Warning");
                Optional<ButtonType> result =  alert.showAndWait();

                result.ifPresent(c->{
                    if (c == ButtonType.OK) {

                        DataInterface.getCurrentFlight().getOrders().remove(order);


                        DataInterface.getInstance().getContracts().remove(order);
                        Scene flightsTableScene = DataInterface.flightsTable.getScene();
                        VBox flightsTableBox = (VBox) flightsTableScene.getRoot();
                        flightsTableBox.getChildren().remove(FlightsTable.getOdsuComponent());

                        TreeItem<Flight> treeItem = (TreeItem<Flight>) DataInterface.getFlightsTable().getSelectionModel().getSelectedItem();

                        TreeItem<Flight> parent = treeItem.getParent();
                        parent.getChildren().remove(treeItem);


                        DataInterface.flightsTable.refresh();


                    } else {
                        return;
                    }
                });

            }



        });




        Image image = new Image(getClass().getResourceAsStream("/Icons/save.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(16);
        imageView.setFitWidth(16);
        saveButton.setGraphic(imageView);


        buttonBox.getChildren().addAll(saveButton, deleteSubOrderButton, showSubOrderStatisticsButton, printButton, closeButton);


        GridPane informationPane = new GridPane();

        GridPane orderPane = new GridPane();
        mainBox.setPadding(new Insets(10));
        orderPane.setHgap(10);
        informationPane.setHgap(10);  // Set horizontal gap for better spacing
        informationPane.setPadding(new Insets(10));
        orderPane.setPadding(new Insets(10));



        saveButton.setOnAction(e->{
            if (Utility.fieldsAreEmpty(orderPane.getChildren())) {
                EmptyFieldsDialog fieldsDialog = new EmptyFieldsDialog();
            } else {



                allFieldsCorrect = true;
                ObservableList<Node> nodes =  orderPane.getChildren();


                Label label = null;
                for (Node node : nodes) {

                    if (node instanceof Label) {
                        label = (Label) node;
                    }

                    if (node instanceof TextField) {
                        TextField field = (TextField) node;
                        checkField(label,field);
                        if (allFieldsCorrect == false)
                            return;
                    }
                }


                if (allFieldsCorrect) {
                    for (Node node : nodes) {

                        if (node instanceof Label) {
                            label = (Label) node;
                        }

                        if (node instanceof TextField) {
                            TextField field = (TextField) node;




                            performUpdate(label, field, suborder);













                        }
                    }


                    suborder.setChanges(order.getChanges());
                    suborder.setLastChange(LocalDateTime.now());
                    suborder.setCreationDate(LocalDateTime.now());



                    if (allFieldsCorrect) {

                        ObservableList<TreeItem<Flight>> listItems = DataInterface.flightsTable.getRoot().getChildren();

                        DataInterface.getInstance().getCurrentItem().getChildren().add(new TreeItem<>(new Flight(suborder.getUAKEY(),"Suborder","","","","","","","","","","")));

                        DataInterface.getInstance().getSubordersList().add(suborder);
                        order.getSubOrdersList().add(suborder);
                        DataInterface.flightsTable.refresh();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Success");
                        alert.setHeaderText("Success");
                        alert.setContentText("Changes successfully saved!");
                        alert.showAndWait();
                    }
                }

            }




        });


        Label aukeyLabel = new Label("Order ID");
        Label uakeyLabel = new Label("Suborder ID");

        TextField aukeyField = new TextField(suborder.getAUKEY());
        TextField uakeyField = new TextField(suborder.getUAKEY());

        aukeyField.setEditable(false);
        uakeyField.setEditable(false);
        aukeyField.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, null, null)));
        uakeyField.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, null, null)));

        informationPane.add(aukeyLabel, 0, 0);
        informationPane.add(aukeyField, 1, 0);

        informationPane.add(uakeyLabel, 0, 1);
        informationPane.add(uakeyField, 1, 1);

        int row = 2; // Start the row index for custom fields
        int col = 0; // Start the column index for custom fields

        int size = order.getCSVRows().size();





        for (String s : labelNames) {

            if (s.equals("UAKEY") || s.equals("AUKEY"))
                continue;

            Label label = new Label(s);
            label.setId(s);
            label.setText(uaKeyMap.get(s));
            TextField field = new TextField();
            field.setId(label.getId());



            field.textProperty().addListener((observable, oldValue, newValue) -> {



            });

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


        ObservableList<Node> nodes = (ObservableList<Node>) orderPane.getChildren();







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

                    allFieldsCorrect = false;
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Wrong value");
                    alert.setContentText("Wrong value at: " + labelId + ": " + field.getText());
                    alert.showAndWait();
                    return;
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void performUpdate(Label label, TextField field, Suborder suborderItem) {
        String labelId = label.getId();
        String methodName = "set"+labelId;

        try {

            Method method = Suborder.class.getDeclaredMethod(methodName, String.class);
            Object result = method.invoke(suborderItem,field.getText().trim());


            suborderItem.setRows(suborderItem.getCSVRows());


        } catch (Exception e) {
            ErrorDialog dialog = new ErrorDialog("Internal error. Restart the programm.");
        }
    }


}