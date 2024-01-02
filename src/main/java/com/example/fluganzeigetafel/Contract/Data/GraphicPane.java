package com.example.fluganzeigetafel.Contract.Data;

import com.example.fluganzeigetafel.Contract.CSVRow;
import com.example.fluganzeigetafel.Contract.Contract;
import com.example.fluganzeigetafel.Contract.Print.Printer;
import com.example.fluganzeigetafel.Contract.Subcontracts.SubContractFileHandler;
import com.example.fluganzeigetafel.Contract.Subcontracts.SubContractTable;
import com.example.fluganzeigetafel.Contract.Subcontracts.Subcontract;
import com.example.fluganzeigetafel.Contract.Validation.Validation;
import com.example.fluganzeigetafel.CustomDialogs.ErrorDialog;
import com.example.fluganzeigetafel.CustomDialogs.QuestionDialog;
import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Flights.Data.Flight;
import com.example.fluganzeigetafel.Flights.Data.TabPaneView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.*;

public class GraphicPane {

    Map<String, List<String>> expectedColumnsMap = new HashMap<>();
    private String val;


    public GraphicPane(HBox hbox, ContractTable contractTable) {

        expectedColumnsMap.put("CLEAN", Arrays.asList(
                "ATT20", "ATTBE", "ATTEN", "AUAGE", "AUDAT", "AUKEY", "AUKNL", "AUKNS", "AUSAA", "DISPO",
                "ETTBE", "ETTEN", "ETTEN", "FGKEY", "JTP", "LUPDN", "LUPDT", "LUPDV", "STTBE", "STTEN", "STTEN",
                "UAZAK", "XAU", "ZINFO"
        ));

        // DISPO: OPTIBUS
        expectedColumnsMap.put("OPTIBUS", Arrays.asList(
                "AUKEY", "DISPO", "DIB", "JTP", "AUSAA", "AUSAU", "AUKNL", "AUKNS", "FGKEY", "PLKEY", "ORTFR",
                "ORTTO", "MENGE", "EINHE", "UAZPL", "UAZAK", "AUAGE", "STTBE", "STTEN", "ETTBE", "ETTEN", "ATTBE",
                "ATTEN", "ATT20", "AUPIR", "ZINFO", "LUPDN", "LUPDT", "LUPDV", "KEYLK", "KEYLE", "KEYLF", "XAU",
                "AUDAT", "AUABF", "MITAR", "FDAEN", "FLAGS", "CINFO", "MAD"
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
                "MENGE", "MENG3", "MITAR", "MITAR", "MITAR", "ORTFR", "ORTTO", "STTBE", "STTEN",
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
        TreeView view = getTreeViewOfSubContracts();

        createSubcontractButton.setOnAction(e->{
            TabPaneView paneView = DataInterface.getInstance().getTabPaneView();







                    Flight f = (Flight) DataInterface.flightsTable.getSelectionModel().getSelectedItem();




                    SubContractTable table = new SubContractTable();
                     String val = f.getContracts().get(0).getDISPO();

                    table.createGenericTable(f.getContracts().get(0).getDISPO());

                    HBox box = new HBox();

                    Button deleteB = new Button("Delete subcontract");
                    deleteB.setMinWidth(250);
                    deleteB.setOnAction(event->{
                        int index = DataInterface.getInstance().getTabPaneView().getSelectionModel().getSelectedIndex();

                        QuestionDialog dialog = new QuestionDialog();
                        dialog.showAndWait().ifPresent(result -> {
                            Contract c = null;
                            if (result == ButtonType.OK) {
                                 c = f.getContractByAukey(contractTable.getContract().getAUKEY());

                            }






                        });
                    });
                    VBox vbox = new VBox();
                    vbox.getChildren().add(deleteB);


                     box.getChildren().addAll(table, vbox);
                     System.out.println(table.getItems().size());
                     HBox.setHgrow(table, Priority.ALWAYS);

                    Tab tab = new Tab("Subcontract" + contractTable.getContract().getAUKEY() + "_DISPO_" + val,box);

                    DataInterface.getInstance().getTabPaneView().getTabs().add(tab);


        });









        delete.setOnAction(e -> {

            int index = DataInterface.getInstance().getTabPaneView().getSelectionModel().getSelectedIndex();

            QuestionDialog dialog = new QuestionDialog();
            dialog.showAndWait().ifPresent(result -> {
                if (result == ButtonType.OK)
                    DataInterface.getInstance().getTabPaneView().getTabs().remove(index);
                Flight f = (Flight) DataInterface.flightsTable.getSelectionModel().getSelectedItem();

                Tab tab = DataInterface.getInstance().getTabPaneView().getSelectionModel().getSelectedItem();
                ContractTable table = null;
                HBox selectedContent = (HBox) tab.getContent();
                for (Node node : selectedContent.getChildren()) {
                    if (node instanceof ContractTable) {
                        table = (ContractTable) node;
                        break;
                    }
                }

                f.deleteTable(table);


            });




        });


        print.setOnAction(e -> {
            Printer printer = new Printer();
            Tab tab = DataInterface.getInstance().getTabPaneView().getSelectionModel().getSelectedItem();
            ContractTable table = null;
            HBox selectedContent = (HBox) tab.getContent();
            for (Node node : selectedContent.getChildren()) {
                if (node instanceof ContractTable) {
                    table = (ContractTable) node;
                    break;
                }
            }
            printer.createPDF(table.getContract());
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
                    createTab();

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


        hbox.getChildren().add(box);


    }

    public TreeView getTreeViewOfSubContracts() {
        boolean check = true;
        Flight f = (Flight) DataInterface.flightsTable.getSelectionModel().getSelectedItem();
        Contract contract = null;

        TreeItem<String> rootItem = new TreeItem<>("Sub contracts");
        rootItem.setExpanded(true);
        SubContractFileHandler fl = new SubContractFileHandler();
        ArrayList<Subcontract> sub = fl.readCSVtoListOfSubContracts("src/main/resources/TestSUBCONTRACT.csv");
        fl.addSubContractsToContracts(sub);

        // Iterate through all tabs in the TabPane
        TreeView<String> view = null;
        for (Tab tab : DataInterface.getInstance().getTabPaneView().getTabs()) {
            if (check) {
                check = false;
                continue;

            }

            ContractTable table = null;


            HBox selectedContent = (HBox) tab.getContent();
            for (Node node : selectedContent.getChildren()) {
                if (node instanceof ContractTable) {
                    table = (ContractTable) node;
                    break;
                }
            }
            // Found a tab with ContractTable, get the ContractTable and retrieve the contract

             contract = table.getContract();


            if (!contract.getSubContractsList().isEmpty()) {

                for (Subcontract subcontract : contract.getSubContractsList()) {
                    TreeItem<String> treeItem = new TreeItem<>(subcontract.getAUKEY());
                    rootItem.getChildren().add(treeItem);
                }
            }

            // You may return the TreeView or perform further actions


            ContractTable finalTable = table;





              /*      TabPaneView tabPaneView = DataInterface.getInstance().getTabPaneView();
                    SubContractTable subContractTable = new SubContractTable();

                    // Use newValue.getValue() to get the value of the selected tree item
                    String aukeyValue = newValue.getValue();

                    // Assuming you have a method to find a Subcontract by AUKEY in your SubContractFileHandler
                    Subcontract subcontract = finalTable.findSubContractByAUKEY(aukeyValue);
                    subContractTable.getItems().addAll(subcontract.getCSVRows());

                    Tab taba = new Tab(aukeyValue, subContractTable);
                    tabPaneView.addTab(taba);
                }

*/


        }
        view = new TreeView(rootItem);
        TreeView<String> finalView = view;
        Contract finalContract = contract;
        EventHandler<MouseEvent> mouseEventHandle = (MouseEvent event) -> {

            handleMouseClicked(event, finalView, finalContract);
        };

        view.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandle);
        return view;
    }
    private void handleMouseClicked(MouseEvent event, TreeView view, Contract c) {
        Node node = event.getPickResult().getIntersectedNode();
        // Accept clicks only on node cells, and not on empty spaces of the TreeView
        if (node instanceof Text || (node instanceof TreeCell && ((TreeCell) node).getText() != null)) {
            String name = (String) ((TreeItem)view.getSelectionModel().getSelectedItem()).getValue();

            TabPaneView tabPaneView = DataInterface.getInstance().getTabPaneView();
            SubContractTable subContractTable = new SubContractTable();

            Button deleteB = new Button("Delete");
            deleteB.setMinWidth(250);
            VBox vb = new VBox();
            vb.getChildren().add(deleteB);


            HBox box = new HBox();
            box.getChildren().addAll(subContractTable, deleteB);
            HBox.setHgrow(subContractTable, Priority.ALWAYS);





            subContractTable.getItems().addAll(DataInterface.getInstance().getContracts().get(0).getSubContractsList().get(0).getCSVRows());



            Tab taba = new Tab("Subcontract" + name+ "_DISPO_"+c.getDISPO(), box);
            tabPaneView.addTab(taba);

        }
    }
    public void createTab() {
        Button delete = new Button("Delete Contract");
        Button createSubcontractButton = new Button("Create subcontract");
        Button createContractButton = new Button("Create contract");
        Button print = new Button("Print contract");
        Button printAll = new Button("Print all contracts");

        TreeItem<String> rootItem = new TreeItem<>("Sub contracts");
        rootItem.setExpanded(true);


        TreeView view = new TreeView(rootItem);


        TreeItem<String> sub = new TreeItem<>("Subcontract 1");
        rootItem.getChildren().addAll(sub);


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
            ContractTable table = null;
            HBox selectedContent = (HBox) tab.getContent();
            for (Node node : selectedContent.getChildren()) {
                if (node instanceof ContractTable) {
                    table = (ContractTable) node;
                    break;
                }
            }
            printer.createPDF(table.getContract());
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
                    createTab();

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


        ContractTable table = new ContractTable();
        Contract contract = new Contract(val);
        List<String> expectedColumns = expectedColumnsMap.get(val);


        for (int j = 0; j < expectedColumns.size(); j++) {
            String val = "";


            CSVRow row = new CSVRow(expectedColumns.get(j), val);
            contract.getCSVRows().add(row);

        }

        Flight f = (Flight) DataInterface.flightsTable.getSelectionModel().getSelectedItem();
        f.addTables(table);

        DataInterface.getInstance().getContracts().add(contract);
        ObservableList<CSVRow> row = FXCollections.observableArrayList(contract.getCSVRows());
        table.setItems(row);


        table.refresh();


        HBox hBox = new HBox();
        HBox.setHgrow(table, Priority.ALWAYS);


        VBox boxx = new VBox();
        boxx.getChildren().addAll(delete, createSubcontractButton, createContractButton, print, printAll, view);
        hBox.getChildren().addAll(table, boxx);


        Tab tab = new Tab("Contract " + val, hBox);
        table.setContract(contract);

        f.addContract(contract);
        f.addCSV(contract.getCSVRows());
        System.out.println(f.getContracts().size());


        DataInterface.getInstance().getTabPaneView().addTab(tab);
        DataInterface.getInstance().getTabPaneView().getSelectionModel().select(tab);
    }
}
      class CustomTreeCell extends TreeCell<String> {
        public CustomTreeCell() {
            this.setOnMouseClicked(event -> {
                if (!isEmpty() && getTreeItem() != null) {
                    System.out.println("Item clicked: " + getItem());
                    // Add your custom logic here
                }
            });


        }}