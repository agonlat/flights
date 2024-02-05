package com.example.fluganzeigetafel.Orders.Forms;

import com.example.fluganzeigetafel.CustomDialogs.CloseDialog;
import com.example.fluganzeigetafel.CustomDialogs.EmptyFieldsDialog;
import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Flights.Data.Flight;
import com.example.fluganzeigetafel.Flights.Data.FlightsTable;
import com.example.fluganzeigetafel.Orders.Order;
import com.example.fluganzeigetafel.Orders.Print.Printer;
import com.example.fluganzeigetafel.Suborders.Forms.SuborderForm;
import com.example.fluganzeigetafel.Suborders.Utils.Utils;
import com.example.fluganzeigetafel.Orders.Utilis.Utility;
import com.example.fluganzeigetafel.Orders.Validation.Validation;
import com.example.fluganzeigetafel.Orders.Statistics.OrderStats;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.*;

/**
 * The OrderForm class represents a graphical user interface for managing orders,
 * providing operations such as editing, generating suborders, and printing.
 */

public class OrderForm {
    static boolean allFieldsCorrect = true;
    private Map<Label, TextField> changeDetection;
    private boolean isChanged;
    static Order orderS;
    private Font customFont;
    Map<String, List<String>> expectedColumnsMap = new HashMap<>();




    
    public VBox createOrderForm()  {
        

        VBox mainBox = new VBox();
        HBox buttonBox = new HBox();
        GridPane informationPane = new GridPane();

        GridPane orderPane = new GridPane();
        expectedColumnsMap.put("CLEAN", Arrays.asList(
                "ATT20", "ATTBE", "ATTEN", "AUAGE", "AUDAT", "AUKEY", "AUKNL", "AUKNS", "AUSAA", "DISPO",
                "ETTBE", "ETTEN", "ETTEN", "FGKEY", "JTP", "LUPDN", "LUPDT", "LUPDV", "STTBE", "STTEN", "STTEN",
                "UAZAK", "XAU", "ZINFO"
        ));

        // DISPO: OPTIBUS
        expectedColumnsMap.put("OPTIBUS", Arrays.asList(
                "AUKEY", "DISPO", "DIB", "JTP", "AUSAA", "AUSAU", "AUKNL", "AUKNS", "FGKEY", "ORTFR",
                "ORTTO","EINHE", "UAZPL", "UAZAK", "AUAGE", "STTBE", "STTEN", "ETTBE", "ETTEN", "ATTBE",
                "ATTEN", "ATT20", "ZINFO", "LUPDN", "LUPDT", "LUPDV", "KEYLK", "KEYLE", "KEYLF", "XAU",
                "AUDAT", "AUABF", "MITAR", "FLAGS", "CINFO", "MAD"
        ));


        expectedColumnsMap.put("LUCHS", Arrays.asList(
                "AUKEY", "DISPO", "DIB", "JTP", "AUSAA", "AUSAU", "AUKNL", "AUKNS", "FGKEY", "PLKEY", "ORTFR",
                "ORTTO", "MENGE", "EINHE", "UAZPL", "UAZAK", "AUAGE", "STTBE", "STTEN", "ETTBE", "ETTEN", "ATTBE",
                "ATTEN", "ATT20", "AUPIR", "ZINFO", "LUPDN", "LUPDT", "LUPDV", "XAU",
                "AUDAT", "AUABF", "FDAEN", "FLAGS", "CINFO", "MAD"
        ));

        expectedColumnsMap.put("COBRA2", Arrays.asList(
                "AUKEY", "DISPO", "DIB", "JTP", "AUSAA", "AUKNL", "AUKNS", "FGKEY", "PLKEY", "ORTFR",
                "ORTTO", "EINHE", "UAZPL", "UAZAK", "AUAGE", "STTBE", "STTEN", "ETTBE", "ETTEN", "ATTBE",
                "ATTEN", "ATT20", "AUPIR", "ZINFO", "LUPDN", "LUPDT", "LUPDV", "KEYLK", "KEYLE", "KEYLF", "XAU",
                "AUDAT", "AUABF", "MITAR", "FDAEN", "FLAGS", "CINFO", "MAD"
        ));

        expectedColumnsMap.put("MAUSGEP", Arrays.asList(
                "ATT20", "AUABF", "AUAGE", "AUAGE", "AUAGE", "AUAGE", "AUDAT", "AUKEY", "AUKNL",
                "AUKNS", "AUPIR", "AUPIR", "AUSAA", "AUSAU", "CINFO", "DIB", "DISPO", "ETTBE", "ETTEN",
                "FLAGS", "JTP", "KEYLE", "KEYLF", "KEYLK", "LUPDN", "LUPDT", "LUPDV",
                "MENGE", "MENG3", "MITAR",  "ORTFR", "ORTTO", "STTBE", "STTEN",
                "UAZAK", "XAU", "ZINFO"
        ));

        expectedColumnsMap.put("FUCHS2", Arrays.asList(
                "ATT20", "ATTBE", "ATTEN", "AUABF", "AUAGE", "AUAGE", "AUDAT", "AUKEY", "AUKNL", "AUKNS",
                "AUSAA", "DIB", "DISPO", "ETTBE", "ETTEN",
                "FLAGS", "JTP", "KEYLE", "KEYLF", "KEYLK", "LUPDN", "LUPDT", "LUPDV",
                "ORTFR", "STLIK", "STTBE", "STTEN", "UAZAK", "XAU", "ZINFO"
        ));

        expectedColumnsMap.put("PUMA2", Arrays.asList(
                "AUKEY", "DISPO", "JTP", "AUSAA", "AUKNL", "AUKNS", "FGKEY", "ORTFR", "ORTTO", "UAZAK", "AUAGE",
                "STTBE", "STTEN", "ETTBE", "ETTEN", "ATTBE", "ATTEN", "ATT20", "ZINFO", "LUPDN", "LUPDT", "LUPDV",
                "KEYLK", "KEYLE", "KEYLF", "XAU", "AUDAT", "AUABF", "FLAGS", "MAD", "STLIK"
        ));

        expectedColumnsMap.put("PND-ABF", Arrays.asList(
                "ATT20", "AUDAT", "AUKEY", "AUKNS",
                "AUSAA", "AUSAU", "CINFO", "DIB", "DISPO", "EINHE", "ETTBE", "ETTEN", "FDAEN", "FGKEY",
                "JTP", "KEYLE", "KEYLF", "KEYLK", "LUPDN", "LUPDT", "LUPDV", "MENGE",
                "ORTTO", "STTBE", "STTEN", "UAZAK", "XAU",
                "ZINFO"
        ));

        expectedColumnsMap.put("PND-ANK", Arrays.asList(
                "AUKEY", "AUPIR", "AUAGE", "DISPO", "JTP", "DIB", "ORTFR",
                "ORTTO", "EINHE", "EINH2", "MITAR", "UAZPL", "CINFO", "FDAEN", "KEYLF", "KEYLE",
                "KEYLK", "MENGE", "MENG2", "MENG3", "MENG4", "STTBE", "STTEN", "ETTBE", "ETTEN",
                "ATTBE", "ATTEN", "AUSAA", "AUSAU", "LUPDT", "LUPDV", "XAU"
        ));

        expectedColumnsMap.put("KFZ", Arrays.asList(
                "AUKEY", "DISPO", "DIB", "JTP", "AUSAA", "AUSAU", "FGKEY",
                "PLKEY", "MENGE",
                "STTBE", "STTEN", "ETTBE", "ETTEN", "ATTBE", "ATTEN", "AUPIR",
                "ZINFO", "LUPDN", "LUPDT", "LUPDV", "AUABF", "MITAR", "FLAGS", "CINFO",
                "RELFK"
        ));


        expectedColumnsMap.put("ENTEISUNG", Arrays.asList(
                "DISPO", "DIB", "JTP", "AUSAA", "AUKNS",
                "ORTFR", "ORTTO", "MENG2", "EINH2", "MENG3", "EINH3",
                "MENG4", "EINH4", "UAZAK", "AUAGE", "STTBE", "STTEN", "ETTBE", "ETTEN",
                "ATTBE", "ATTEN", "ATT20", "ZINFO", "LUPDN", "LUPDT", "LUPDV", "KEYLK",
                "KEYLE", "KEYLF", "XAU", "AUDAT", "FLAGS"

        ));

// Add columns for DISPO "BAGTR"
        expectedColumnsMap.put("BAGTR", Arrays.asList(
                "DISPO", "DIB", "JTP", "AUSAA", "AUSAU", "AUKNL", "AUKNS", "FGKEY", "PLKEY",
                "ORTFR", "ORTTO", "MENGE", "EINHE", "MENG2", "EINH2", "MENG3", "EINH3",
                "MENG4", "EINH4", "UAZPL", "UAZAK", "AUAGE", "STTBE", "STTEN", "ETTBE", "ETTEN",
                "ATTBE", "ATTEN", "ATT20", "AUPIR", "ZINFO", "LUPDN", "LUPDT", "LUPDV", "KEYLK",
                "KEYLE", "KEYLF", "XAU", "AUDAT", "AUABF", "MITAR", "FDAEN", "FLAGS", "CINFO",
                "MAD", "STLIK", "PKART", "PKL", "PKLAS", "PKLEA", "PKNAM"
        ));

        expectedColumnsMap.put("MAUSLAST", Arrays.asList(
                "DISPO", "JTP", "DIB", "AUKEY",
                "ORTFR", "MENGE",
                "UAZAK", "STTBE", "STTEN",
                "ATT20", "UPDN", "LUPDT", "LUPDV", "KEYLK",
                "KEYLE", "KEYLF", "XAU", "UDAT"));


        String items[] = {"CLEAN", "OPTIBUS", "LUCHS", "COBRA2", "MAUSGEP", "FUCHS2", "PUMA2", "PND-ABF",
                "PND-ANK", "KFZ", "ENTEISUNG", "BAGTR", "MAUSLAST"};
        ChoiceDialog dialog = new ChoiceDialog(items[0], items);

        Optional<String> res = dialog.showAndWait();

        res.ifPresent(result->{

            String aukey = Utils.generateUAKEY();
            Order order = new Order();
            order.setAUKEY(aukey);
            order.setDISPO(result);


            ArrayList<String> labelNames = new ArrayList<>(expectedColumnsMap.get(result));




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





            Button generateSuborderButton = new Button("Generate suborder");
            Button printButton = new Button("Print");
            Button deleteOrderButton = new Button("Delete");
            Button saveButton = new Button("Save");
            Button showOrderStatisticsButton = new Button("Show data about all orders");
            Button closeButton = new Button("Close");

            closeButton.setOnAction(e-> {


                if (CloseDialog.createCloseDialog()) {

                    Scene scene =  DataInterface.flightsTable.getScene();
                    VBox b = (VBox) scene.getRoot();
                    b.getChildren().remove(FlightsTable.getOdsuComponent());
                    FlightsTable.setOdsuComponent(null);
                    DataInterface.flightsTable.refresh();
                }
                else {
                    return;
                }




            });

            printButton.setOnAction(e->{

                if (Utility.fieldsAreEmpty(orderPane.getChildren())) {
                    EmptyFieldsDialog emptyFieldsDialog = new EmptyFieldsDialog();
                }
                else {
                    Printer printer = new Printer();
                    printer.createPDF(order);
                }

            });


            showOrderStatisticsButton.setOnAction(e->{
                if (Utility.fieldsAreEmpty(orderPane.getChildren())) {
                    EmptyFieldsDialog emptyFieldsDialog = new EmptyFieldsDialog();
                } else {
                    OrderStats orderStats = new OrderStats(DataInterface.getCurrentFlight().getOrders());
                }


            });


            generateSuborderButton.setOnAction(e->{

                if (Utility.fieldsAreEmpty(orderPane.getChildren())) {
                    EmptyFieldsDialog emptyFieldsDialog = new EmptyFieldsDialog();
                }
                else {
                    Scene scene = DataInterface.flightsTable.getScene();
                    VBox b = (VBox) scene.getRoot();
                    b.getChildren().remove(FlightsTable.getOdsuComponent());

                    SuborderForm suborderForm = new SuborderForm();
                    VBox box = suborderForm.createSubOrderForm(order);
                    b.getChildren().add(box);

                    FlightsTable.setOdsuComponent(box);
                }

            });

            deleteOrderButton.setOnAction(e-> {

                if (Utility.fieldsAreEmpty(orderPane.getChildren())) {
                    Scene scene =  DataInterface.flightsTable.getScene();
                    VBox b = (VBox) scene.getRoot();
                    b.getChildren().remove(FlightsTable.getOdsuComponent());
                    FlightsTable.setOdsuComponent(null);
                    DataInterface.flightsTable.refresh();
                } else{
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning");
                    alert.setContentText("Do you really want to delete the order?");
                    alert.setHeaderText("Warning");
                    Optional<ButtonType> resultAction =  alert.showAndWait();

                    resultAction.ifPresent(c->{
                        if (c == ButtonType.OK) {

                            DataInterface.getCurrentFlight().getOrders().remove(order);


                            DataInterface.getInstance().getContracts().remove(order);
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


            buttonBox.getChildren().addAll(saveButton, deleteOrderButton, showOrderStatisticsButton, generateSuborderButton, printButton, closeButton);


            mainBox.setPadding(new Insets(10));
            orderPane.setHgap(10);
            informationPane.setHgap(10);  // Set horizontal gap for better spacing
            informationPane.setPadding(new Insets(10));
            orderPane.setPadding(new Insets(10));



            saveButton.setOnAction(e->{

                if (Utility.fieldsAreEmpty(orderPane.getChildren())) {
                    EmptyFieldsDialog emptyFieldsDialog = new EmptyFieldsDialog();
                }
                 else {
                    allFieldsCorrect = true;
                    ObservableList<Node> nodes = orderPane.getChildren();


                    Label label = null;
                    for (Node node : nodes) {

                        if (node instanceof Label) {
                            label = (Label) node;
                        }

                        if (node instanceof TextField) {
                            TextField field = (TextField) node;

                            checkField(label, field);
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


                                if (allFieldsCorrect)
                                    performUpdate(label, field, order);


                            }
                        }


                           order.setChanges(order.getChanges());
                           order.setLastChange(LocalDateTime.now());
                           order.setCreationDate(LocalDateTime.now());

                           DataInterface.getInstance().getContracts().add(order);
                           DataInterface.getCurrentFlight().getOrders().add(order);

                           DataInterface.getInstance().getCurrentItem().getParent().getChildren().add(
                                   new TreeItem<Flight>(new Flight(order.getAUKEY(), "Order","","","","","","","","","","")));


                        if (allFieldsCorrect) {
                            DataInterface.flightsTable.refresh();
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Success");
                            alert.setHeaderText("Success");
                            alert.setContentText("Changes successfully changed!");
                            alert.showAndWait();
                        }
                    }


                }
                }
                 );


                Label aukeyLabel = new Label("Order ID");
                Label dispoLabel = new Label("Disposition system");

                TextField aukeyField = new TextField(aukey);
                TextField dispoField = new TextField(result);

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

                for (String s: labelNames) {

                    if (s.equals("DISPO") || s.equals("AUKEY"))
                        continue;

                    Label label = new Label(map.get(s));
                    label.setId(s);
                    TextField field = new TextField();

                    field.setText("");



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











            });



        return mainBox;
    }
    public VBox createOrderForm(Order order) {
        orderS = order;
        isChanged = false;
        changeDetection = new HashMap<>();


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
            if (CloseDialog.createCloseDialog()) {
                Scene scene =  DataInterface.flightsTable.getScene();
                VBox b = (VBox) scene.getRoot();
                b.getChildren().remove(FlightsTable.getOdsuComponent());
                FlightsTable.setOdsuComponent(null);
                DataInterface.flightsTable.refresh();
            } else {
                return;
            }


        });

        printButton.setOnAction(e->{
            Printer printer = new Printer();
            printer.createPDF(order);
        });


        showOrderStatisticsButton.setOnAction(e->{
            OrderStats orderStats = new OrderStats(DataInterface.getCurrentFlight().getOrders());

        });


        generateSuborderButton.setOnAction(e->{
            Scene scene =  DataInterface.flightsTable.getScene();
            VBox b = (VBox) scene.getRoot();
            b.getChildren().remove(FlightsTable.getOdsuComponent());

            SuborderForm suborderForm = new SuborderForm();
            VBox box = suborderForm.createSubOrderForm(order);
            b.getChildren().add(box);

            FlightsTable.setOdsuComponent(box);


        });

        deleteOrderButton.setOnAction(e-> {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("Do you really want to delete the order?");
            alert.setHeaderText("Warning");
           Optional<ButtonType> result =  alert.showAndWait();

           result.ifPresent(c->{
               if (c == ButtonType.OK) {

                   DataInterface.getCurrentFlight().getOrders().remove(order);


                   DataInterface.getInstance().getContracts().remove(order);
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


                            if (allFieldsCorrect)
                             performUpdate(label, field, order);











                     }
                 }


                     order.setChanges(order.getChanges()+1);
                     order.setLastChange(LocalDateTime.now());





if (allFieldsCorrect) {
    DataInterface.flightsTable.refresh();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Success");
    alert.setHeaderText("Success");
    alert.setContentText("Changes successfully changed!");
    alert.showAndWait();
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
            TextField field = new TextField();
            field.setText(order.getCSVRows().get(i).getValue());



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
    private static void performUpdate(Label label, TextField field, Order orderItem) {
        String labelId = label.getId();
        String methodName = "set"+labelId;

        try {

            Method method = Order.class.getDeclaredMethod(methodName, String.class);
            Object result = method.invoke(orderItem,field.getText().trim());

            orderItem.setRows(Order.generateListOfCSVRows(orderItem));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
