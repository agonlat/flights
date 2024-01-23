package com.example.fluganzeigetafel.Orders.Data;

import com.example.fluganzeigetafel.CustomDialogs.ErrorDialog;
import com.example.fluganzeigetafel.CustomDialogs.QuestionDialog;
import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Flights.Data.Flight;
import com.example.fluganzeigetafel.Flights.Data.TabPaneView;
import com.example.fluganzeigetafel.Orders.CSVRow;
import com.example.fluganzeigetafel.Orders.Order;
import com.example.fluganzeigetafel.Orders.Print.Printer;
import com.example.fluganzeigetafel.Orders.Suborders.SubOrderTable;
import com.example.fluganzeigetafel.Orders.Suborders.Suborder;
import com.example.fluganzeigetafel.Orders.Suborders.Utils;
import com.example.fluganzeigetafel.Orders.Validation.Validation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.lang.reflect.Method;
import java.util.*;

public class GraphicPane {

    Map<String, List<String>> expectedColumnsMap = new HashMap<>();
    private String val;
    boolean first = true;
    TabPane tabPane;
boolean subPaneCreated = false;

    public GraphicPane(HBox hbox, OrderTable orderTable) {


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

        Button delete = new Button("Delete Contract");
        Button createSubcontractButton = new Button("Create subcontract");
        Button createContractButton = new Button("Create contract");
        Button print = new Button("Print contract");
        Button printAll = new Button("Print all contracts");


        DataInterface.getInstance().getTabPaneView().getSelectionModel().selectedItemProperty().addListener((observable, oldTab, newTab) -> {
            if (oldTab != null) {
                if (oldTab.getText().contains("DISPO")) {
                    DataInterface.getInstance().setOpen(false);
                    DataInterface.getInstance().setPendingStatus(false);

                }
            }
        });

        createSubcontractButton.setOnAction(e->{








                DataInterface.getInstance().setOpen(true);



                        TabPaneView paneView = DataInterface.getInstance().getTabPaneView();


                        Flight f = (Flight) DataInterface.flightsTable.getSelectionModel().getSelectedItem();


                        Suborder suborder = new Suborder();
                        TreeItem<String> item = null;


                        SubOrderTable table = new SubOrderTable();
                        Order cc = f.getContractByAukey(orderTable.getOrder().getAUKEY());

                        String val = cc.getDISPO();



            suborder.setAUKEY(orderTable.getOrder().getAUKEY());
            String resultString = orderTable.getOrder().getAUKEY();
                    suborder.setUAKEY(resultString);







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


            switch (val) {
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

                    list = (ArrayList<String>) dispoSystems.get(val);
                    break;
                default:
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("An internal error occured. Please try again.");
                alert.setHeaderText("ERROR");
                alert.setTitle("Error");
                alert.showAndWait();

            }


            ArrayList<String> labelNames = list;
            Stage stage = new Stage();
            stage.setResizable(false);
            BorderPane pane = new BorderPane();
            Label order = new Label("Suborder");

            HBox buttonBox = new HBox();
            Button cancel = new Button("Cancel");
            Button placeOrder = new Button("Place order");
            Button clear = new Button("Clear all");

            buttonBox.getChildren().addAll(cancel, clear,placeOrder);
            HBox.setHgrow(cancel, Priority.ALWAYS);
            HBox.setHgrow(placeOrder, Priority.ALWAYS);

            pane.setBottom(buttonBox);
            BorderPane.setAlignment(buttonBox, Pos.CENTER_RIGHT);
            BorderPane.setMargin(buttonBox, new Insets(10,10,10,10));





            pane.setTop(order);
            pane.setMargin(order, new Insets(10, 10, 10, 10));
            GridPane gridPane = new GridPane();
            gridPane.setVgap(10);
            gridPane.setHgap(5);
            pane.setCenter(gridPane);
            BorderPane.setMargin(gridPane, new Insets(10, 10, 10, 10)); // Adjust the Insets as needed
            Scene scene = new Scene(pane);
            stage.setScene(scene);

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


            gridPane.getColumnConstraints().addAll(new ColumnConstraints(), new ColumnConstraints(), new ColumnConstraints(), new ColumnConstraints(), new ColumnConstraints(), new ColumnConstraints());

            int rowIndex = 0; // Track the current row index

            for (String s : labelNames) {

                Label label = new Label(s);
                label.setId(s);
                label.setText(uaKeyMap.get(s));
                TextField field = new TextField();
                field.setId(label.getId());

                if (s.equals("UAKEY")) {
                    field.setText(Utils.generateUAKEY());
                    field.setEditable(false);
                    Background background = new Background(new BackgroundFill(Color.LIGHTGREY,null,null));
                    field.setBackground(background);
                }


                if (s.equals("AUKEY")) {
                    field.setText(orderTable.getOrder().getAUKEY());
                    field.setEditable(false);
                    Background background = new Background(new BackgroundFill(Color.LIGHTGREY,null,null));
                    field.setBackground(background);
                }

                if (rowIndex < 18) {
                    gridPane.add(label, 0, rowIndex); // Add label to the first column
                    gridPane.add(field, 1, rowIndex); // Add text field to the second column
                } else if (rowIndex < 36) {

                    gridPane.add(label, 2, rowIndex - 18); // Add label to the third column
                    gridPane.add(field, 3, rowIndex - 18); // Add text field to the fourth column
                } else {
                    gridPane.add(label, 4, rowIndex - 36); // Add label to the third column
                    gridPane.add(field, 5, rowIndex - 36); // Add text field to the fourth column
                }

                rowIndex++; // Move to the next row
            }

            clear.setOnAction(cleaner->{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Do you really want to clear all fields?");
                alert.setTitle("Warning");
                alert.setHeaderText("Warning");
                Optional<ButtonType> result = alert.showAndWait();

                result.ifPresent(es->{
                    if (result.get().equals(ButtonType.OK)) {
                        for (Node node : gridPane.getChildren()) {
                            if (node instanceof TextField) {
                                TextField field = (TextField) node;

                                if (field.isEditable()) {
                                    field.setText("");
                                }
                            }
                        }
                    }  else {
                        return;
                    }
                });



            });
            ArrayList<CSVRow> csvRows = new ArrayList<>();
            Suborder subOrder = new Suborder();

            for (Node node : gridPane.getChildren()) {
                if (node instanceof  TextField) {
                    TextField field = (TextField) node;

                    field.focusedProperty().addListener((obs, oldVal, newVal) -> {
                        if (!newVal && oldVal) {
                            if (!field.getText().isEmpty()) {
                                try {
                                    Class<?> validationClass = Class.forName("com.example.fluganzeigetafel.Orders.Validation.Validation");


                                    String methodName = field.getId();
                                    Method method = validationClass.getDeclaredMethod("check" + methodName.trim(), String.class);
                                    boolean resu = (boolean) method.invoke(null, field.getText());
                                    if (resu == false) {
                                        ErrorDialog dialog1 = new ErrorDialog("Wrong value at: " + field.getId());

                                        return;
                                    } else {
                                        CSVRow row = new CSVRow(methodName, field.getText().trim());
                                        csvRows.add(row);
                                        Class<?> subOrderClass = Class.forName("com.example.fluganzeigetafel.Orders.Suborders.Suborder");
                                        String setterName = "set"+field.getId();
                                        Method subMethod = subOrderClass.getDeclaredMethod(setterName, String.class);

                                        subMethod.invoke(subOrder, field.getText());
                                    }
                                } catch (Exception ex) {
                                    ex.printStackTrace(); // Handle reflection-related exceptions
                                }
                            }
                        }
                    });



                };

            }


            cancel.setOnAction(ee-> {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Warning");
                alert.setContentText("Do you really want to cancel?");

                Optional<ButtonType> r =       alert.showAndWait();

                r.ifPresent(k ->{
                    if (r.get().equals(ButtonType.OK)) {
                        stage.close();
                    } else {
                        return;
                    }
                });


            });




                        HBox box = new HBox();

                        Button deleteB = new Button("Delete subcontract");


                        SubOrderTable finalTable1 = table;
                        SubOrderTable finalTable2 = table;

                        deleteB.setMinWidth(250);
                        SubOrderTable finalTable = table;
                        deleteB.setOnAction(event -> {
                            int index = DataInterface.getInstance().getTabPaneView().getSelectionModel().getSelectedIndex();

                            QuestionDialog dialog = new QuestionDialog();


                            dialog.showAndWait().ifPresent(result -> {
                                Order c = null;
                                if (result == ButtonType.OK) {


                                    c = f.getContractByAukey(orderTable.getOrder().getAUKEY());
                                    Suborder delSub = c.getSubOrderByUAKEY(finalTable.getSubOrder().getUAKEY());

                                    DataInterface.getInstance().getTabPaneView().getTabs().remove(index);


                                    c.deleteSubOrder(delSub.getUAKEY());
                                } else {

                                }
                            });
                        });

                        TreeItem<String> selectedItem = null;
            SubOrderTable table1 = new SubOrderTable();

            VBox vbox = new VBox();
            vbox.getChildren().addAll(deleteB);




            HBox.setHgrow(table, Priority.ALWAYS);


            stage.show();

                placeOrder.setOnAction(es-> {

                    for (Node node : gridPane.getChildren()) {
                        if (node instanceof TextField) {
                            TextField field = (TextField) node;
                            if (field.getText().isBlank()) {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setContentText("There are empty fields. Cannot proceed!");
                                alert.setTitle("ERROR");
                                alert.showAndWait();
                                return;
                            }
                        }
                    }


                    DataInterface.getInstance().getUakeyDatabase().add(resultString);
                    box.getChildren().addAll(table1, vbox);
                    Tab tab = new Tab("Subcontract" + resultString + "_DISPO_" + val, box);

                    table1.getItems().addAll(csvRows);
                    table1.setSubOrder(suborder);

                    orderTable.getOrder().addSubOrderToSubOrdersList(suborder);

                    tab.setContent(table1);

                    if (!subPaneCreated) {
                        tabPane = new TabPane();
                        subPaneCreated = true;
                        Tab selectedTab = DataInterface.getInstance().getTabPaneView().getSelectionModel().getSelectedItem();


                        Node content = selectedTab.getContent();

                        Tab originalTab = new Tab(selectedTab.getText(), content);
                        originalTab.setClosable(false);




                        tabPane.getTabs().addAll(originalTab,tab);
                        selectedTab.setContent(tabPane);

                    }
                    else {
                        tabPane.getTabs().add(tab);
                    }
                });





                DataInterface.getInstance().setPendingStatus(true);




        });





        delete.setMinWidth(250);



        delete.setOnAction(e -> {

            int index = DataInterface.getInstance().getTabPaneView().getSelectionModel().getSelectedIndex();

            QuestionDialog dialog = new QuestionDialog();

            dialog.showAndWait().ifPresent(result -> {
                if (result == ButtonType.OK)
                    DataInterface.getInstance().getTabPaneView().getTabs().remove(index);
                Flight f = (Flight) DataInterface.flightsTable.getSelectionModel().getSelectedItem();

                Tab tab = DataInterface.getInstance().getTabPaneView().getSelectionModel().getSelectedItem();
                OrderTable table = null;
                HBox selectedContent = (HBox) tab.getContent();
                for (Node node : selectedContent.getChildren()) {
                    if (node instanceof OrderTable) {
                        table = (OrderTable) node;
                        break;
                    }
                }

                f.deleteTable(table);


            });




        });


        print.setOnAction(e -> {
            Printer printer = new Printer();
            Tab tab = DataInterface.getInstance().getTabPaneView().getSelectionModel().getSelectedItem();
            OrderTable table = null;
            HBox selectedContent = (HBox) tab.getContent();
            for (Node node : selectedContent.getChildren()) {
                if (node instanceof OrderTable) {
                    table = (OrderTable) node;
                    break;
                }
            }
            printer.createPDF(table.getOrder());
        });

        printAll.setOnAction(e -> {
            Printer printer = new Printer();
            Flight f = (Flight) DataInterface.getFlightsTable().getSelectionModel().getSelectedItem();
            printer.createPDFMULT(f.getContracts());
        });

        createContractButton.setOnAction(e -> {

                    String items[] = {"CLEAN", "OPTIBUS", "LUCHS", "COBRA2", "MAUSGEP", "FUCHS2", "PUMA2", "PND-ABF",
                            "PND-ANK", "KFZ", "ENTEISUNG", "BAGTR", "MAUSLAST"};
            ChoiceDialog dialog = new ChoiceDialog(items[0], items);


            String aukey = Utils.generateUAKEY();
            OrderTable currentTable = null;
            Flight f = null;

            Tab currentTab = DataInterface.getInstance().getTabPaneView().getSelectionModel().getSelectedItem();
            HBox contentBox = (HBox) currentTab.getContent();
            for (Node node : contentBox.getChildren()) {
                if (node instanceof OrderTable) {
                    currentTable = (OrderTable) node;
                    f = (Flight) DataInterface.flightsTable.getSelectionModel().getSelectedItem();
                }
            }



                    Optional<String> res = dialog.showAndWait();

            OrderTable finalCurrentTable = currentTable;
            Flight finalF = f;
            res.ifPresent(result -> {




                        finalCurrentTable.getOrder().setAUKEY(aukey);







                                    Stage stage = new Stage();
                                    stage.setResizable(false);
                                    BorderPane pane = new BorderPane();
                                    Label order = new Label("Order");

                                    HBox buttonBox = new HBox();
                                    Button cancel = new Button("Cancel");
                                    Button placeOrder = new Button("Place order");
                                    Button clean = new Button("Clean");


                                    buttonBox.getChildren().addAll(cancel, clean,placeOrder);
                                    HBox.setHgrow(cancel, Priority.ALWAYS);
                                    HBox.setHgrow(placeOrder, Priority.ALWAYS);

                                    pane.setBottom(buttonBox);
                                    BorderPane.setAlignment(buttonBox, Pos.CENTER_RIGHT);
                                    BorderPane.setMargin(buttonBox, new Insets(10,10,10,10));





                                    pane.setTop(order);
                                    pane.setMargin(order, new Insets(10, 10, 10, 10));
                                    GridPane gridPane = new GridPane();
                                    gridPane.setVgap(10);
                                    gridPane.setHgap(10);
                                    pane.setCenter(gridPane);
                                    BorderPane.setMargin(gridPane, new Insets(10, 10, 10, 10)); // Adjust the Insets as needed
                                    Scene scene = new Scene(pane);
                                    stage.setScene(scene);

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



                                    ArrayList<String> labelNames = new ArrayList<>(expectedColumnsMap.get(result));

                                    gridPane.getColumnConstraints().addAll(new ColumnConstraints(), new ColumnConstraints(), new ColumnConstraints(), new ColumnConstraints(), new ColumnConstraints(), new ColumnConstraints());

                                    int rowIndex = 0; // Track the current row index

                                    for (String s : labelNames) {
                                        Label label = new Label(s);
                                        label.setId(s);
                                        label.setText(map.get(s));
                                        TextField field = new TextField();
                                        field.setId(label.getId());

                                        if (label.getId().equals("AUKEY")) {
                                            field.setText(aukey);
                                            field.setEditable(false);
                                            Background background = new Background(new BackgroundFill(Color.LIGHTGREY, null, null));
                                            field.setBackground(background);


                                        }

                                        if (label.getId().equals("AUKNS")) {
                                            if (finalF.getLsk().trim().equals("S")) {
                                                field.setText(finalF.getKnr());
                                                field.setEditable(false);
                                                Background background = new Background(new BackgroundFill(Color.LIGHTGREY, null, null));
                                                field.setBackground(background);


                                            }
                                        }

                                        if (label.getId().equals("AUKNL")) {
                                            if (finalF.getLsk().trim().equals("L")) {
                                                field.setText(finalF.getKnr());
                                                field.setEditable(false);
                                                Background background = new Background(new BackgroundFill(Color.LIGHTGREY, null, null));
                                                field.setBackground(background);


                                            }
                                        }

                                        if (rowIndex < 15) {
                                            gridPane.add(label, 0, rowIndex); // Add label to the first column
                                            gridPane.add(field, 1, rowIndex); // Add text field to the second column
                                        } else if (rowIndex < 30) {



                                            gridPane.add(label, 2, rowIndex - 15); // Add label to the third column
                                            gridPane.add(field, 3, rowIndex - 15); // Add text field to the fourth column
                                        } else {
                                            gridPane.add(label, 4, rowIndex - 30); // Add label to the third column
                                            gridPane.add(field, 5, rowIndex - 30); // Add text field to the fourth column
                                        }

                                        rowIndex++; // Move to the next row
                                    }
                                    ArrayList<CSVRow> rows = new ArrayList<>();
                        for (Node node : gridPane.getChildren()) {
                            Label label = null;

                            if (node instanceof  TextField) {
                                TextField field = (TextField) node;

                                field.focusedProperty().addListener((obs, oldVal, newVal) -> {
                                    if (!newVal && oldVal) {
                                        if (!field.getText().isEmpty()) {
                                            try {
                                                Class<?> validationClass = Class.forName("com.example.fluganzeigetafel.Orders.Validation.Validation");
                                                String methodName = field.getId();
                                                Method method = validationClass.getDeclaredMethod("check" + methodName.trim(), String.class);
                                                boolean resu = (boolean) method.invoke(null, field.getText());
                                                if (resu == false) {
                                                    ErrorDialog dialog1 = new ErrorDialog("Wrong value: " + field.getText());

                                                    return;
                                                } else {
                                                    CSVRow row = new CSVRow(methodName, field.getText().trim());
                                                    rows.add(row);
                                                }
                                            } catch (Exception ex) {
                                                ex.printStackTrace(); // Handle reflection-related exceptions
                                            }
                                        }
                                    }
                                });



                            };

                        }


                        cancel.setOnAction(ee-> {
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Warning");
                            alert.setHeaderText("Warning");
                            alert.setContentText("Do you really want to cancel?");

                            Optional<ButtonType> r =       alert.showAndWait();

                            r.ifPresent(k ->{
                                if (r.get().equals(ButtonType.OK)) {
                                    stage.close();
                                } else {
                                    return;
                                }
                            });

                        });

                        clean.setOnAction(cleaner->{
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setContentText("Do you really want to clear all fields?");
                            alert.setTitle("Warning");
                            alert.setHeaderText("Warning");
                            Optional<ButtonType> resultC = alert.showAndWait();

                            resultC.ifPresent(es->{
                                if (resultC.get().equals(ButtonType.OK)) {
                                    for (Node node : gridPane.getChildren()) {
                                        if (node instanceof TextField) {
                                            TextField field = (TextField) node;

                                            if (field.isEditable()) {
                                                field.setText("");
                                            }
                                        }
                                    }
                                }  else {
                                    return;
                                }
                            });
                        });

                        placeOrder.setOnAction(ac -> {

                            for (Node node : gridPane.getChildren()) {
                                    if (node instanceof TextField) {
                                        TextField field = (TextField) node;
                                        if (field.getText().isBlank()) {
                                            Alert alert = new Alert(Alert.AlertType.ERROR);
                                            alert.setContentText("There are empty fields. Cannot proceed!");
                                            alert.setTitle("ERROR");
                                            alert.showAndWait();
                                            return;
                                        }
                                    }
                            }






                            createTab(rows);




                        });
                                    stage.show();

                            }
                    );
                });


        delete.setMinWidth(250);
        createSubcontractButton.setMinWidth(250);
        print.setMinWidth(250);
        createContractButton.setMinWidth(250);
        printAll.setMinWidth(250);

        TreeView view =
                getTreeViewOfSubContracts(orderTable);
        VBox box = new VBox();
        VBox.setVgrow(view, Priority.ALWAYS);
        box.getChildren().addAll(delete, createSubcontractButton, createContractButton, print, printAll, view);


        hbox.getChildren().add(box);

    }

    public TreeView getTreeViewOfSubContracts(  OrderTable table) {

        TreeView view = null;
        boolean check = true;
        Flight f = (Flight) DataInterface.flightsTable.getSelectionModel().getSelectedItem();


        TreeItem<String> rootItem = new TreeItem<>("Sub orders");
        rootItem.setExpanded(true);

        OrderTable orderTable = table;

        Order order = orderTable.getOrder();

        Tab tab = DataInterface.getInstance().getTabPaneView().getSelectionModel().getSelectedItem();









            ArrayList<Suborder> suborders = order.getSubOrdersList();


            rootItem.getChildren().clear();

            if (suborders != null) {
                for (Suborder suborder : suborders) {
                    TreeItem<String> item = new TreeItem<>(suborder.getUAKEY());
                    rootItem.getChildren().add(item);
                }



                OrderTable finalTable = orderTable;





            }




        view = new TreeView(rootItem);
        TreeView<String> finalView = view;
        Order finalOrder = order;
        EventHandler<MouseEvent> mouseEventHandle = (MouseEvent event) -> {

            handleMouseClicked(event, finalView, finalOrder);
        };

        if (finalOrder != null && !finalOrder.getSubOrdersList().isEmpty())
        view.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandle);
        return view;
    }
    private void handleMouseClicked(MouseEvent event, TreeView view, Order c) {
        TreeItem<String> sel = (TreeItem<String>) view.getSelectionModel().getSelectedItem();
        String val = sel.getValue();
        Node node = event.getPickResult().getIntersectedNode();
        // Accept clicks only on node cells, and not on empty spaces of the TreeView
        if (node instanceof Text || (node instanceof TreeCell && ((TreeCell) node).getText() != null)) {
            String name = (String) ((TreeItem)view.getSelectionModel().getSelectedItem()).getValue();

            TabPaneView tabPaneView = DataInterface.getInstance().getTabPaneView();
            SubOrderTable subOrderTable = new SubOrderTable();

            Button deleteB = new Button("Delete");
            deleteB.setMinWidth(250);
            VBox vb = new VBox();
            vb.getChildren().add(deleteB);
            deleteB.setOnAction(ee->{
                int index = DataInterface.getInstance().getTabPaneView().getSelectionModel().getSelectedIndex();

                QuestionDialog dialog = new QuestionDialog();
                dialog.showAndWait().ifPresent(result -> {
                    Order cc = null;
                    if (result == ButtonType.OK) {

                        cc = c;
                        Suborder delSub = cc.getSubOrderByUAKEY(val);




                        Tab selectedTab = DataInterface.getInstance().getTabPaneView().getSelectionModel().getSelectedItem();
                        TabPane pane = (TabPane) selectedTab.getContent();

                        Tab subOrderTab = pane.getSelectionModel().getSelectedItem();

                        pane.getTabs().remove(subOrderTab);





                        cc.deleteSubOrder(delSub.getUAKEY());
                        DataInterface.getInstance().getSubcontractsList().remove(delSub);

                        view.refresh();





                    }






                });
            });


            HBox box = new HBox();
            box.getChildren().addAll(subOrderTable, deleteB);
            HBox.setHgrow(subOrderTable, Priority.ALWAYS);




            ArrayList<CSVRow> subRows = c.getSubOrderByUAKEY(val).getCSVRows();
            Suborder suborder = c.getSubOrderByUAKEY(val);
            subOrderTable.setSubOrder(suborder);


            subOrderTable.getItems().addAll(subRows);

if (!subPaneCreated) {
    tabPane = new TabPane();
    subPaneCreated = true;
    Tab selectedTab = DataInterface.getInstance().getTabPaneView().getSelectionModel().getSelectedItem();


    Node content = selectedTab.getContent();

    Tab originalTab = new Tab(selectedTab.getText(), content);
    originalTab.setClosable(false);

    Tab taba = new Tab("Subcontract" + name + "_DISPO_" + c.getDISPO(), box);


    tabPane.getTabs().addAll(originalTab, taba);

    selectedTab.setContent(tabPane);
} else {
    Tab taba = new Tab("Subcontract" + name + "_DISPO_" + c.getDISPO(), box);
    tabPane.getTabs().add(taba);
}

        }
    }
    public void createTab(ArrayList<CSVRow> rows) {
        Button delete = new Button("Delete Contract");
        Button createSubcontractButton = new Button("Create subcontract");
        Button createContractButton = new Button("Create contract");
        Button print = new Button("Print contract");
        Button printAll = new Button("Print all contracts");

        TreeItem<String> rootItem = new TreeItem<>("Sub contracts");
        rootItem.setExpanded(true);


        TreeView view = new TreeView(rootItem);




        delete.setOnAction(e -> {

            int index = DataInterface.getInstance().getTabPaneView().getSelectionModel().getSelectedIndex();

            QuestionDialog dialog = new QuestionDialog();
            dialog.showAndWait().ifPresent(result -> {
                if (result == ButtonType.OK)
                    DataInterface.getInstance().getTabPaneView().getTabs().remove(index);



            });

        });


        print.setOnAction(e -> {
            Printer printer = new Printer();
            Tab tab = DataInterface.getInstance().getTabPaneView().getSelectionModel().getSelectedItem();
            OrderTable table = null;
            HBox selectedContent = (HBox) tab.getContent();
            for (Node node : selectedContent.getChildren()) {
                if (node instanceof OrderTable) {
                    table = (OrderTable) node;
                    break;
                }
            }
            printer.createPDF(table.getOrder());
        });

        printAll.setOnAction(e -> {
            Printer printer = new Printer();
            Flight f = (Flight) DataInterface.getFlightsTable().getSelectionModel().getSelectedItem();
            printer.createPDFMULT(f.getContracts());
        });

        createContractButton.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Input dialog");
            dialog.setContentText("Enter DISPO System");

            Optional<String> result = dialog.showAndWait();

            if (Validation.checkDISPOExistence(result.get())) {

                result.ifPresent(value -> {
                    this.val = value;
                    createTab(rows);

                });
            } else {
                ErrorDialog dialogErr = new ErrorDialog("Wrong input");
            }
        });


        delete.setMinWidth(250);
        createSubcontractButton.setMinWidth(250);
        print.setMinWidth(250);
        createContractButton.setMinWidth(250);
        printAll.setMinWidth(250);


        VBox box = new VBox();
        VBox.setVgrow(view, Priority.ALWAYS);
        box.getChildren().addAll(delete, createSubcontractButton, createContractButton, print, printAll, view);



        OrderTable table = new OrderTable();

        Order order = new Order(val);
        order.setAUKEY(val);



        order.getCSVRows().addAll(rows);

        Flight f = (Flight) DataInterface.flightsTable.getSelectionModel().getSelectedItem();
        f.addTables(table);


        DataInterface.getInstance().getContracts().add(order);

        ObservableList<CSVRow> row = FXCollections.observableArrayList(rows);
        table.setItems(row);


        table.refresh();


        HBox hBox = new HBox();
        HBox.setHgrow(table, Priority.ALWAYS);


        VBox boxx = new VBox();
        boxx.getChildren().addAll(delete, createSubcontractButton, createContractButton, print, printAll, view);
        hBox.getChildren().addAll(table, boxx);


        Tab tab = new Tab("Contract " + order.getAUKEY(), hBox);
        table.setOrder(order);

        f.addContract(order);
        f.addCSV(order.getCSVRows());



        DataInterface.getInstance().getTabPaneView().addTab(tab);
        DataInterface.getInstance().getTabPaneView().getSelectionModel().select(tab);
    }
}
