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

    private Subcontract subcontract = new Subcontract();

    public Subcontract getSubcontract() {
    return subcontract;
    }


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
            column.setCellFactory(TextFieldTableCell.forTableColumn());
            if (s.equals("Value")) {

                column.setOnEditCommit(e -> {
                    CSVRow row = e.getRowValue();

                    String newValue = e.getNewValue();

                    String des = row.getDesignation();

                    switch (des) {
                        case "ATTBE":
                            column.setEditable(true);
                            if (Validation.checkATTBE(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setATTBE(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "ATTEN":
                            column.setEditable(true);
                            if (Validation.checkATTEN(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setATTEN(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "AUKEY":
                            column.setEditable(true);
                            if (Validation.checkAUKEY(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setAUKEY(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;

                        case "ETTBE":
                            column.setEditable(true);
                            if (Validation.checkETTBE(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setETTBE(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "ETTEN":
                            column.setEditable(true);
                            if (Validation.checkETTEN(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setETTEN(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "INDNR":
                            column.setEditable(true);
                            if (Validation.checkINDNR(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setINDNR(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "LUPDN":
                            column.setEditable(true);
                            if (Validation.checkLUPDN(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setLUPDN(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "LUPDT":
                            column.setEditable(true);
                            if (Validation.checkLUPDT(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setLUPDT(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "LUPDV":
                            column.setEditable(true);
                            if (Validation.checkLUPDV(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setLUPDV(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "LZUAU":
                            column.setEditable(true);
                            if (Validation.checkLZUAU(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setLZUAU(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "MENGE":
                            column.setEditable(true);
                            if (Validation.checkMENGE(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setMENGE(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;

                        case "STTBE":
                            column.setEditable(true);
                            if (Validation.checkSTTBE(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setSTTBE(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "STTEN":
                            column.setEditable(true);
                            if (Validation.checkSTTEN(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setSTTEN(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "UAKEY":
                            column.setEditable(true);
                            if (Validation.checkUAKEY(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setUAKEY(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "UAPIR":
                            column.setEditable(true);
                            if (Validation.checkUAPIR(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setUAPIR(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "UASAA":
                            column.setEditable(true);
                            if (Validation.checkUASAA(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setUASAA(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "UASAU":
                            column.setEditable(true);
                            if (Validation.checkUASAU(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setUASAU(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "XUA":
                            column.setEditable(true);
                            if (Validation.checkXUA(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setXUA(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "ZINFO":
                            column.setEditable(true);
                            if (Validation.checkZINFO(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setZINFO(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;

                        case "ORTFR":
                            column.setEditable(true);
                            if (Validation.checkORTFR(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setORTFR(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "ORTTO":
                            column.setEditable(true);
                            if (Validation.checkORTTO(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setORTTO(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;

                        case "UAREE":
                            column.setEditable(true);
                            if (Validation.checkUAREE(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setUAREE(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "FGKEY":
                            column.setEditable(true);
                            if (Validation.checkFGKEY(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setFGKEY(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "UAABF":
                            column.setEditable(true);
                            if (Validation.checkUAABF(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setUAABF(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;

                        case "SPREK":
                            column.setEditable(true);
                            if (Validation.checkSPREK(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setSPREK(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "ATT30":
                            column.setEditable(true);
                            if (Validation.checkATT30(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setATT30(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "ATT50":
                            column.setEditable(true);
                            if (Validation.checkATT50(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setATT50(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "ATT55":
                            column.setEditable(true);
                            if (Validation.checkATT55(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setATT55(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "ATT60":
                            column.setEditable(true);
                            if (Validation.checkATT60(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setATT60(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "ATT70":
                            column.setEditable(true);
                            if (Validation.checkATT70(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setATT70(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "ATT75":
                            column.setEditable(true);
                            if (Validation.checkATT75(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setATT75(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "ATTER":
                            column.setEditable(true);
                            if (Validation.checkATTER(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setATTER(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "UAAGE":
                            column.setEditable(true);
                            if (Validation.checkUAAGE(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setUAAGE(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "EINHE":
                            column.setEditable(true);
                            if (Validation.checkEINHE(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setEINHE(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "ATT20":
                            column.setEditable(true);
                            if (Validation.checkATT20(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setATT20(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "QKB":
                            column.setEditable(true);
                            if (Validation.checkQKB(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setQKB(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "SAA20":
                            column.setEditable(true);
                            if (Validation.checkSAA20(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setSAA20(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "SAAOF":
                            column.setEditable(true);
                            if (Validation.checkSAAOF(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setSAAOF(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;

                        case "SKA":
                            column.setEditable(true);
                            if (Validation.checkSKA(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setSKA(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "STT20":
                            column.setEditable(true);
                            if (Validation.checkSTT20(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setSTT20(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "URK":
                            column.setEditable(true);
                            if (Validation.checkURK(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setURK(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "RELFK":
                            column.setEditable(true);
                            if (Validation.checkRELFK(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setRELFK(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "UAINF":
                            column.setEditable(true);
                            if (Validation.checkUAINF(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setUAINF(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "ETT30":
                            column.setEditable(true);
                            if (Validation.checkETT30(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setETT30(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "UAKSL":
                            column.setEditable(true);
                            if (Validation.checkUAKSL(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setUAKSL(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "SPKEY":
                            column.setEditable(true);
                            if (Validation.checkSPKEY(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setSPKEY(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "MENG2":
                            column.setEditable(true);
                            if (Validation.checkMENG2(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setMENG2(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "CINFO":
                            column.setEditable(true);
                            if (Validation.checkCINFO(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setCINFO(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "ATT40":
                            column.setEditable(true);
                            if (Validation.checkATT40(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setATT40(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "STLIK":
                            column.setEditable(true);
                            if (Validation.checkSTLIK(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setSTLIK(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "OKEYN":
                            column.setEditable(true);
                            if (Validation.checkOKEYN(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setOKEYN(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "ABI":
                            column.setEditable(true);
                            if (Validation.checkABI(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setABI(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "EBI":
                            column.setEditable(true);
                            if (Validation.checkEBI(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setEBI(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "SBI":
                            column.setEditable(true);
                            if (Validation.checkSBI(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setSBI(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "TOURK":
                            column.setEditable(true);
                            if (Validation.checkTOURK(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setTOURK(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;

                        case "EINH2":
                            column.setEditable(true);
                            if (Validation.checkEINH2(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setEINH2(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "EINH3":
                            column.setEditable(true);
                            if (Validation.checkEINH3(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setEINH3(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "EINH4":
                            column.setEditable(true);
                            if (Validation.checkEINH4(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setEINH4(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "MENG3":
                            column.setEditable(true);
                            if (Validation.checkMENG3(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setMENG3(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }
                            break;
                        case "MENG4":
                            column.setEditable(true);
                            if (Validation.checkMENG4(newValue)) {
                                row.setValue(newValue);
                                getSubcontract().setMENG4(newValue);
                                this.refresh();
                            } else {
                                ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                this.refresh();
                            }

                            break;


                        default:
                            this.refresh();


                    }


                });




            }
            this.getColumns().add(column);

        }}

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
    }

    public void setSubContract(Subcontract subcontract) {
        this.subcontract = subcontract;
    }
    }


