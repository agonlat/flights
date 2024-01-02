package com.example.fluganzeigetafel.Contract.Data;

import com.example.fluganzeigetafel.Contract.CSVRow;
import com.example.fluganzeigetafel.Contract.Contract;
import com.example.fluganzeigetafel.Contract.Subcontracts.Subcontract;
import com.example.fluganzeigetafel.Contract.Validation.Validation;
import com.example.fluganzeigetafel.CustomDialogs.ErrorDialog;
import com.example.fluganzeigetafel.DataInterface;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.util.ArrayList;

public class ContractTable extends TableView {
    public Contract getContract() {

        return contract;
    }

    public  Subcontract findSubContractByAUKEY(String aukey) {
        ArrayList<Contract> contracts = DataInterface.getInstance().getContracts();

        for (Contract contract : contracts) {
            for (Subcontract subcontract : contract.getSubContractsList()) {
                if (subcontract.getAUKEY().equals(aukey)) {
                    return subcontract;
                }
            }


        }
        return null; // Contract not found
    }

    public static Contract findContractByAUKEY(String aukey) {
        ArrayList<Contract> contracts = DataInterface.getInstance().getContracts();

        for (Contract contract : contracts) {
            if (contract.getAUKEY().equals(aukey)) {
                return contract;
            }
        }

        return null; // Contract not found
    }


    public void setContract(Contract contract) {
       this.contract = contract;
    }

    private static Contract contract = new Contract();

    public  ArrayList<CSVRow> getCsvRows() {
        return csvRows;
    }

    private  ArrayList<CSVRow> csvRows = new ArrayList<>();

    public  void addRows(ArrayList<CSVRow> rows) {
        for (CSVRow row : rows) {
            this.csvRows.add(row);
        }
    }


    public ContractTable() {
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
                                 contract.setATTBE(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "ATTEN":
                             column.setEditable(true);
                             if (Validation.checkATTEN(newValue)) {
                                 row.setValue(newValue);
                                 contract.setATTEN(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "AUAGE":
                             column.setEditable(true);
                             if (Validation.checkAUAGE(newValue)) {
                                 row.setValue(newValue);
                                 contract.setAUAGE(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;


                         case "AUPIR":
                             column.setEditable(true);
                             if (Validation.checkAUPIR(newValue)) {
                                 row.setValue(newValue);
                                 contract.setAUPIR(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "AUSAA":
                             column.setEditable(true);
                             if (Validation.checkAUSAA(newValue)) {
                                 row.setValue(newValue);

                                 contract.setAUSAA(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "AUSAU":
                             column.setEditable(true);
                             if (Validation.checkAUSAU(newValue)) {
                                 row.setValue(newValue);
                                 contract.setAUSAU(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "DISPO":
                             column.setEditable(true);
                             if (Validation.checkDISPO(newValue)) {
                                 row.setValue(newValue);
                                 contract.setDISPO(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "EINHE":
                             column.setEditable(true);
                             if (Validation.checkEINHE(newValue)) {
                                 row.setValue(newValue);
                                 contract.setEINHE(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "ETTBE":
                             column.setEditable(true);
                             if (Validation.checkETTBE(newValue)) {
                                 row.setValue(newValue);
                                 contract.setETTBE(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "ETTEN":
                             column.setEditable(true);
                             if (Validation.checkETTEN(newValue)) {
                                 row.setValue(newValue);
                                 contract.setETTEN(newValue);this.refresh();

                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "FGKEY":
                             column.setEditable(true);
                             if (Validation.checkFGKEY(newValue)) {
                                 row.setValue(newValue);
                                 contract.setFGKEY(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "JTP":
                             column.setEditable(true);
                             if (Validation.checkJTP(newValue)) {
                                 row.setValue(newValue);
                                 contract.setJTP(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "KEYLK":
                             column.setEditable(true);
                             if (Validation.checkKEYLK(newValue)) {
                                 row.setValue(newValue);
                                 contract.setKEYLK(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "KEYLE":
                             column.setEditable(true);
                             if (Validation.checkKEYLE(newValue)) {
                                 row.setValue(newValue);
                                 contract.setKEYLE(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "KEYLF":
                             column.setEditable(true);
                             if (Validation.checkKEYLF(newValue)) {
                                 row.setValue(newValue);
                                 contract.setKEYLF(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "LUPDN":
                             column.setEditable(true);
                             if (Validation.checkLUPDN(newValue)) {
                                 row.setValue(newValue);
                                 contract.setLUPDN(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "LUPDT":
                             column.setEditable(true);
                             if (Validation.checkLUPDT(newValue)) {
                                 row.setValue(newValue);
                                 contract.setLUPDT(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "LUPDV":
                             column.setEditable(true);
                             if (Validation.checkLUPDV(newValue)) {
                                 row.setValue(newValue);
                                 contract.setLUPDV(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "MENGE":
                             column.setEditable(true);
                             if (Validation.checkMENGE(newValue)) {
                                 row.setValue(newValue);
                                 contract.setMENGE(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "ORTFR":
                             column.setEditable(true);
                             if (Validation.checkORTFR(newValue)) {
                                 row.setValue(newValue);
                                 contract.setORTFR(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "ORTTO":
                             column.setEditable(true);
                             if (Validation.checkORTTO(newValue)) {
                                 row.setValue(newValue);
                                 contract.setORTTO(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "STTBE":
                             column.setEditable(true);
                             if (Validation.checkSTTBE(newValue)) {
                                 row.setValue(newValue);
                                 contract.setSTTBE(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "STTEN":
                             column.setEditable(true);
                             if (Validation.checkSTTEN(newValue)) {
                                 row.setValue(newValue);
                                 contract.setSTTEN(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "UAZAK":
                             column.setEditable(true);
                             if (Validation.checkUAZAK(newValue)) {
                                 row.setValue(newValue);
                                 contract.setUAZAK(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "UAZPL":
                             column.setEditable(true);
                             if (Validation.checkUAZPL(newValue)) {
                                 row.setValue(newValue);
                                 contract.setUAZPL(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;


                         case "XAU":
                             column.setEditable(true);
                             if (Validation.checkXAU(newValue)) {
                                 row.setValue(newValue);
                                 contract.setXAU(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "ZINFO":
                             column.setEditable(true);
                             if (Validation.checkZINFO(newValue)) {
                                 row.setValue(newValue);
                                 contract.setZINFO(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "DIB":
                             column.setEditable(true);
                             if (Validation.checkDIB(newValue)) {
                                 row.setValue(newValue);
                                 contract.setDIB(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "PLKEY":
                             column.setEditable(true);
                             if (Validation.checkPLKEY(newValue)) {
                                 row.setValue(newValue);
                                 contract.setPLKEY(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "AUDAT":
                             column.setEditable(true);
                             if (Validation.checkAUDAT(newValue)) {
                                 row.setValue(newValue);
                                 contract.setAUDAT(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "AUABF":
                             column.setEditable(true);
                             if (Validation.checkAUABF(newValue)) {
                                 row.setValue(newValue);
                                 contract.setAUABF(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "ATT20":
                             column.setEditable(true);
                             if (Validation.checkATT20(newValue)) {
                                 row.setValue(newValue);
                                 contract.setATT20(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "RELFK":
                             column.setEditable(true);
                             if (Validation.checkRELFK(newValue)) {
                                 row.setValue(newValue);
                                 contract.setRELFK(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "CINFO":
                             column.setEditable(true);
                             if (Validation.checkCINFO(newValue)) {
                                 row.setValue(newValue);
                                 contract.setCINFO(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "FDAEN":
                             column.setEditable(true);
                             if (Validation.checkFDAEN(newValue)) {
                                 row.setValue(newValue);
                                 contract.setFDAEN(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "FLAGS":
                             column.setEditable(true);
                             if (Validation.checkFLAGS(newValue)) {
                                 row.setValue(newValue);
                                 contract.setFLAGS(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "MITAR":
                             column.setEditable(true);
                             if (Validation.checkMITAR(newValue)) {
                                 row.setValue(newValue);
                                 contract.setMITAR(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "MAD":
                             column.setEditable(true);
                             if (Validation.checkMAD(newValue)) {
                                 row.setValue(newValue);
                                 contract.setMAD(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "STLIK":
                             column.setEditable(true);
                             if (Validation.checkSTLIK(newValue)) {
                                 row.setValue(newValue);
                                 contract.setSTLIK(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "PKART":
                             column.setEditable(true);
                             if (Validation.checkPKART(newValue)) {
                                 row.setValue(newValue);
                                 contract.setPKART(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "PKL":
                             column.setEditable(true);
                             if (Validation.checkPKL(newValue)) {
                                 row.setValue(newValue);
                                 contract.setPKL(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "PKLAS":
                             column.setEditable(true);
                             if (Validation.checkPKLAS(newValue)) {
                                 row.setValue(newValue);
                                 contract.setPKLAS(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "PKLEA":
                             column.setEditable(true);
                             if (Validation.checkPKLEA(newValue)) {
                                 row.setValue(newValue);
                                 contract.setPKLEA(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "PKNAM":
                             column.setEditable(true);
                             if (Validation.checkPKNAM(newValue)) {
                                 row.setValue(newValue);
                                 contract.setPKNAM(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
                             }
                             break;

                         case "EINH2":
                             column.setEditable(true);
                             if (Validation.checkEINH2(newValue)) {
                                 row.setValue(newValue);
                                 contract.setEINH2(newValue);
                                 this.refresh();
                             } else {
                                 ErrorDialog dialog = new ErrorDialog("Wrong input!");
                                 row.setValue(e.getOldValue());
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
                                 row.setValue(e.getOldValue());
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
                                 row.setValue(e.getOldValue());
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
                                 row.setValue(e.getOldValue());
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
                                 row.setValue(e.getOldValue());
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
                                 row.setValue(e.getOldValue());
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
