package com.example.fluganzeigetafel.Contract.Subcontracts;

import com.example.fluganzeigetafel.Contract.CSVRow;
import com.example.fluganzeigetafel.Contract.Validation.Validation;
import com.example.fluganzeigetafel.CustomDialogs.ErrorDialog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.util.*;

public class SubContractTable extends TableView {
    public SubContractTable() {
        this.setEditable(true);
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

    public SubContractTable createGenericTable(String dispo) {

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
            case "COBRA":
            case "MAUSGEP":
            case "KFZ":
            case "PANDA":
            case "FUCHS":
            case "ENTEISUNG":
            case "BAGTR":

                ArrayList<String> list = (ArrayList<String>) dispoSystems.get(dispo);

                for (String str : list) {
                    CSVRow row = new CSVRow(str, "");
                    rows.add(row);
                }

                ObservableList<CSVRow> lists = FXCollections.observableArrayList(rows);
                this.setItems(lists);
                break;
            default:
                System.out.println("Invalid dispo value" + dispo);
        }

return this;
    }}


