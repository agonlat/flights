package com.example.fluganzeigetafel.Orders.Data;

import com.example.fluganzeigetafel.CustomDialogs.ErrorDialog;
import com.example.fluganzeigetafel.Orders.CSVRow;
import com.example.fluganzeigetafel.Orders.Order;
import com.example.fluganzeigetafel.Orders.Validation.Validation;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.util.ArrayList;

public class OrderTable extends TableView {
    public Order getOrder() {

        return order;
    }






    public void setOrder(Order order) {
       this.order = order;
    }

    private Order order = new Order();

    public  ArrayList<CSVRow> getCsvRows() {
        return csvRows;
    }

    private  ArrayList<CSVRow> csvRows = new ArrayList<>();

    public  void addRows(ArrayList<CSVRow> rows) {
        for (CSVRow row : rows) {
            this.csvRows.add(row);
        }
    }


    public OrderTable() {
      this.setEditable(true);
      this.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
      this.setPlaceholder(new Label(""));



        String[] cols = {
                "Designation", "Value"
        };

        for (String s: cols) {
            TableColumn<CSVRow, String> column = new TableColumn<CSVRow, String>(s);
            column.setCellValueFactory(new PropertyValueFactory<>(s.toLowerCase()));



           if (s.equals("Value")) {
               column.setCellFactory(TextFieldTableCell.forTableColumn());
               column.setOnEditCommit(e->{
                   CSVRow row = e.getRowValue();

                 String newValue = e.getNewValue();

                 String des = row.getDesignation();



                     switch (des) {
                         case "ATTBE":
                             column.setEditable(true);
                             if (Validation.checkATTBE(newValue)) {
                                 row.setValue(newValue);
                                 order.setATTBE(newValue);
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
                                 order.setATTEN(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 this.refresh();
                             }
                             break;

                         case "AUAGE":
                             column.setEditable(true);
                             if (Validation.checkAUAGE(newValue)) {
                                 row.setValue(newValue);
                                 order.setAUAGE(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 this.refresh();
                             }
                             break;


                         case "AUPIR":
                             column.setEditable(true);
                             if (Validation.checkAUPIR(newValue)) {
                                 row.setValue(newValue);
                                 order.setAUPIR(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 this.refresh();
                             }
                             break;

                         case "AUSAA":
                             column.setEditable(true);
                             if (Validation.checkAUSAA(newValue)) {
                                 row.setValue(newValue);

                                 order.setAUSAA(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 this.refresh();
                             }
                             break;

                         case "AUSAU":
                             column.setEditable(true);
                             if (Validation.checkAUSAU(newValue)) {
                                 row.setValue(newValue);
                                 order.setAUSAU(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 this.refresh();
                             }
                             break;

                         case "DISPO":
                             column.setEditable(true);
                             if (Validation.checkDISPO(newValue)) {
                                 row.setValue(newValue);
                                 order.setDISPO(newValue);
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
                                 order.setEINHE(newValue);
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
                                 order.setETTBE(newValue);
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
                                 order.setETTEN(newValue);this.refresh();

                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 this.refresh();
                             }
                             break;

                         case "FGKEY":
                             column.setEditable(true);
                             if (Validation.checkFGKEY(newValue)) {
                                 row.setValue(newValue);
                                 order.setFGKEY(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 this.refresh();
                             }
                             break;

                         case "JTP":
                             column.setEditable(true);
                             if (Validation.checkJTP(newValue)) {
                                 row.setValue(newValue);
                                 order.setJTP(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 this.refresh();
                             }
                             break;

                         case "KEYLK":
                             column.setEditable(true);
                             if (Validation.checkKEYLK(newValue)) {
                                 row.setValue(newValue);
                                 order.setKEYLK(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 this.refresh();
                             }
                             break;

                         case "KEYLE":
                             column.setEditable(true);
                             if (Validation.checkKEYLE(newValue)) {
                                 row.setValue(newValue);
                                 order.setKEYLE(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 this.refresh();
                             }
                             break;

                         case "KEYLF":
                             column.setEditable(true);
                             if (Validation.checkKEYLF(newValue)) {
                                 row.setValue(newValue);
                                 order.setKEYLF(newValue);
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
                                 order.setLUPDN(newValue);
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
                                 order.setLUPDT(newValue);
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
                                 order.setLUPDV(newValue);
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
                                 order.setMENGE(newValue);
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
                                 order.setORTFR(newValue);
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
                                 order.setORTTO(newValue);
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
                                 order.setSTTBE(newValue);
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
                                 order.setSTTEN(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 this.refresh();
                             }
                             break;

                         case "UAZAK":
                             column.setEditable(true);
                             if (Validation.checkUAZAK(newValue)) {
                                 row.setValue(newValue);
                                 order.setUAZAK(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 this.refresh();
                             }
                             break;

                         case "UAZPL":
                             column.setEditable(true);
                             if (Validation.checkUAZPL(newValue)) {
                                 row.setValue(newValue);
                                 order.setUAZPL(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 this.refresh();
                             }
                             break;


                         case "XAU":
                             column.setEditable(true);
                             if (Validation.checkXAU(newValue)) {
                                 row.setValue(newValue);
                                 order.setXAU(newValue);
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
                                 order.setZINFO(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 this.refresh();
                             }
                             break;

                         case "DIB":
                             column.setEditable(true);
                             if (Validation.checkDIB(newValue)) {
                                 row.setValue(newValue);
                                 order.setDIB(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 this.refresh();
                             }
                             break;

                         case "PLKEY":
                             column.setEditable(true);
                             if (Validation.checkPLKEY(newValue)) {
                                 row.setValue(newValue);
                                 order.setPLKEY(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 this.refresh();
                             }
                             break;

                         case "AUDAT":
                             column.setEditable(true);
                             if (Validation.checkAUDAT(newValue)) {
                                 row.setValue(newValue);
                                 order.setAUDAT(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 this.refresh();
                             }
                             break;

                         case "AUABF":
                             column.setEditable(true);
                             if (Validation.checkAUABF(newValue)) {
                                 row.setValue(newValue);
                                 order.setAUABF(newValue);
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
                                 order.setATT20(newValue);
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
                                 order.setRELFK(newValue);
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
                                 order.setCINFO(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 this.refresh();
                             }
                             break;

                         case "FDAEN":
                             column.setEditable(true);
                             if (Validation.checkFDAEN(newValue)) {
                                 row.setValue(newValue);
                                 order.setFDAEN(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 this.refresh();
                             }
                             break;

                         case "FLAGS":
                             column.setEditable(true);
                             if (Validation.checkFLAGS(newValue)) {
                                 row.setValue(newValue);
                                 order.setFLAGS(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 this.refresh();
                             }
                             break;

                         case "MITAR":
                             column.setEditable(true);
                             if (Validation.checkMITAR(newValue)) {
                                 row.setValue(newValue);
                                 order.setMITAR(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 this.refresh();
                             }
                             break;

                         case "MAD":
                             column.setEditable(true);
                             if (Validation.checkMAD(newValue)) {
                                 row.setValue(newValue);
                                 order.setMAD(newValue);
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
                                 order.setSTLIK(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 this.refresh();
                             }
                             break;

                         case "PKART":
                             column.setEditable(true);
                             if (Validation.checkPKART(newValue)) {
                                 row.setValue(newValue);
                                 order.setPKART(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 this.refresh();
                             }
                             break;

                         case "PKL":
                             column.setEditable(true);
                             if (Validation.checkPKL(newValue)) {
                                 row.setValue(newValue);
                                 order.setPKL(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 this.refresh();
                             }
                             break;

                         case "PKLAS":
                             column.setEditable(true);
                             if (Validation.checkPKLAS(newValue)) {
                                 row.setValue(newValue);
                                 order.setPKLAS(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 this.refresh();
                             }
                             break;

                         case "PKLEA":
                             column.setEditable(true);
                             if (Validation.checkPKLEA(newValue)) {
                                 row.setValue(newValue);
                                 order.setPKLEA(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 this.refresh();
                             }
                             break;

                         case "PKNAM":
                             column.setEditable(true);
                             if (Validation.checkPKNAM(newValue)) {
                                 row.setValue(newValue);
                                 order.setPKNAM(newValue);
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
                                 order.setEINH2(newValue);
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
                                 //contract.setEINH3(newValue);
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
                                // contract.setEINH4(newValue);
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
                                // contract.setMENG2(newValue);
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
                                 //contract.setMENG3(newValue);
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
                                 //contract.setMENG4(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 this.refresh();
                             }
                             break;


                         default:
                             column.setEditable(false);


                     }



               });
           }



            this.getColumns().add(column);




        }

    }



}
