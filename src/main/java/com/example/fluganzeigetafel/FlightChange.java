package com.example.fluganzeigetafel;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class FlightChange {
    private Label flightNoLabel;
    private TextField flightNoTextField;
    private TextField newIttTextField;
    private TextField newPosTextField;
    private Label newPosLabel;
    private Label newTerminalLabel;
    private Label newSaaLabel;
    private ComboBox newTerminalCombo;
    private  ComboBox newSAACombo;
    private Tooltip tooltipITT;
    private Tooltip tooltipFlightNo;
    private Tooltip tooltipPOS;
    private Tooltip tooltipSAA;
    private Tooltip tooltipTER;
    private Button cancelButton;
    private  Button approveButton;

    private Label flightInfo;

private GridPane gridPane;

    private void updateApproveButtonState() {
        approveButton.setDisable(
                flightNoTextField.getText().trim().isEmpty() ||
                        (newIttTextField.getText().trim().isEmpty() &&
                                newPosTextField.getText().trim().isEmpty() &&
                                (newSAACombo.getValue() == null || newSAACombo.getValue().toString().isEmpty()) &&
                                (newTerminalCombo.getValue() == null || newTerminalCombo.getValue().toString().isEmpty()))
        );
    }

    public FlightChange() {
        Stage stage = new Stage();
        stage.setResizable(false);

        stage.initModality(Modality.WINDOW_MODAL);

        // Create labels and text fields
        flightNoLabel = new Label("Flight No:");
         flightNoTextField = new TextField();

        Label newIttLabel = new Label("New Itt:");
        newIttTextField = new TextField();

         newPosLabel = new Label("New Pos:");
         newPosTextField = new TextField();

         newTerminalLabel = new Label("New Terminal:");
         newTerminalCombo = new ComboBox();

         newSaaLabel = new Label("New Saa:");
         newSAACombo = new ComboBox();

         flightInfo = new Label("");

        newTerminalCombo.getItems().addAll(new ArrayList(Arrays.asList(1,2, "")));


        newSAACombo.getItems().addAll(new ArrayList(Arrays.asList(01,03,05,15,20,22,23,25,27,30,35,38,43,46,48,51,53,56,57,60,61
                ,63,64,65,66,67,72,80,86,88,94,96,97,98,99)));


         tooltipFlightNo = new Tooltip(
                "Airline:\n" +
                        "- 3-character code\n" +
                        "- Optionally, space at the 3rd position\n" +
                        "- Uppercase letters or numbers\n" +
                        "Route number:\n" +
                        "- 4-digit number\n" +
                        "- Numerical only\n" +
                        "Flight function:\n" +
                        "- Either an uppercase letter or a space\n" +
                        "Must always be present\n" +
                        "Examples: LH 2309, SRR6188, LH 2075, TG 924\n" +
                        "Structure of the control number:\n" +
                        "6-digit, unique ID of a flight. Must always be present"
        );

         tooltipITT = new Tooltip(
                "Internal time for on-block or off-block\n" +
                        "Format DD.MM.YYYY HH:mm:ss\n" +
                        "Can be empty!"
        );

         tooltipPOS = new Tooltip(
                "4-digit parking position on the apron\n" +
                        "Space on the right\n" +
                        "Uppercase letters and numbers\n" +
                        "Can be empty\n" +
                        "Examples: 145, 545E"
        );

         tooltipSAA = new Tooltip("Select the new flight status from the list with predefined values");
         tooltipTER = new Tooltip("Select the new terminal from the list with predefined values");


        newIttTextField.setTooltip(tooltipITT);
        flightNoTextField.setTooltip(tooltipFlightNo);
        newPosTextField.setTooltip(tooltipPOS);
        newTerminalCombo.setTooltip(tooltipTER);
        newSAACombo.setTooltip(tooltipTER);



        flightNoTextField.textProperty().addListener((observable, newValue, oldValue)-> {
            if (!flightNoTextField.getText().trim().isEmpty() && ValidationUtil.checkFlightNumberFormat(flightNoTextField.getText().trim())
            ) {
                Flight f = ValidationUtil.checkFlightNumberExistence(flightNoTextField.getText().trim());

                if (f != null) {


                    newTerminalCombo.setValue(f.getTer());
                    newSAACombo.setValue(f.getSaa());
                    flightInfo.setText("FNR: " + f.getFnr() + " " + "KNR: " + f.getKnr() + " " + "ITT: "+ f.getItt() + " " + "TER: "+ f.getTer() + " " + "POS: " + f.getPos()
                            + " " + "SAA: " + f.getSaa());
                    stage.setWidth(450);
                    ColumnConstraints columnConstraints = new ColumnConstraints();
                    columnConstraints.setFillWidth(true);
                    columnConstraints.setHgrow(Priority.ALWAYS);

                    gridPane.getColumnConstraints().add(columnConstraints);
                }
            }

            if (flightNoTextField.getText().isBlank())
                flightInfo.setText("");
        });






         cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e->  {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Confirm Cancel");
            alert.setContentText("Are you sure you want to cancel?");


            ButtonType yesButton = new ButtonType("Yes");
            ButtonType noButton = new ButtonType("No");

            alert.getButtonTypes().setAll(yesButton, noButton);


            ButtonType res = alert.showAndWait().orElse(noButton);

            if (res == ButtonType.YES)
                stage.close();

           });

        approveButton = new Button("Approve");
        approveButton.setDisable(true);

        // Listener for flightNoTextField
        flightNoTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            updateApproveButtonState();
        });

        flightNoTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {  // Check flight number format when losing focus
                if (!ValidationUtil.checkFlightNumberFormat(flightNoTextField.getText().trim())) {
                    ErrorDialog dialog = new ErrorDialog("Check flight number format!");
                    // Optionally, you can choose to disable the approveButton here as well.
                }
            }
        });

// Listener for newIttTextField
        newIttTextField.textProperty().addListener((observable, oldValue, newValue) ->
                updateApproveButtonState());

// Listener for newPosTextField
        newPosTextField.textProperty().addListener((observable, oldValue, newValue) ->
                updateApproveButtonState());

// Listener for newSAACombo
        newSAACombo.valueProperty().addListener((observable, oldValue, newValue) ->
                updateApproveButtonState());

// Listener for newTerminalCombo
        newTerminalCombo.valueProperty().addListener((observable, oldValue, newValue) ->
                updateApproveButtonState());





        approveButton.setOnAction(e -> {
            Flight flightToUpdate;

            String flightNo = flightNoTextField.getText().trim();
            String newItt = newIttTextField.getText().trim();
            String newPos = newPosTextField.getText().trim();

            if (flightNo.isBlank()) {
                ErrorDialog dialog = new ErrorDialog("Flight number should not be empty!");
                return; // Stop execution if flight number is empty
            }

            if (!ValidationUtil.checkFlightNumberFormat(flightNo)) {
                ErrorDialog dialog = new ErrorDialog("Check flight number format!");
                return; // Stop execution if flight number format is incorrect
            }

            flightToUpdate = ValidationUtil.checkFlightNumberExistence(flightNo);

            if (flightToUpdate == null) {
                ErrorDialog dialog = new ErrorDialog("Flight not found!");
                return; // Stop execution if flight is not found
            }

            // Update ITT if the field is not empty and format is correct
            // Update ITT if the field is not empty and format is correct
            if (!newItt.isBlank()) {

                if (ValidationUtil.checkNewInternalTimeFormat(newItt)) {
                    if (ValidationUtil.checkNewInternalTimeValue(newItt, flightToUpdate.getItt())) {
                        flightToUpdate.setItt(newItt);
                    } else {
                        ErrorDialog dialog = new ErrorDialog("New ITT cannot be smaller than the given time!");
                        return; // Stop execution if new ITT is invalid
                    }
                } else {
                    ErrorDialog dialog = new ErrorDialog("Check ITT format!");
                    return; // Stop execution if ITT format is incorrect
                }
            }


            // Update POS if the field is not empty and format is correct
            // Update POS if the field is not empty and format is correct
            if (!newPos.isBlank()) {
                if (ValidationUtil.checkNewPosition(newPos)) {
                    flightToUpdate.setPos(newPos);
                } else {
                    ErrorDialog dialog = new ErrorDialog("Check the format of POS!");
                    return; // Stop execution if new POS is invalid
                }
            }


            // Update Terminal if the combo box selection is not null
            if (newTerminalCombo.getValue() != null) {
                flightToUpdate.setTer(newTerminalCombo.getValue().toString());
            }

            // Update SAA if the combo box selection is not null
            if (newSAACombo.getValue() != null) {
                flightToUpdate.setSaa(newSAACombo.getValue().toString());
            }


            DataInterface.flightsTable.refresh();
        });

         gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);



        // Add labels and text fields to the grid pane
        gridPane.addRow(0, flightNoLabel, flightNoTextField);
        gridPane.addRow(1, newIttLabel, newIttTextField);
        gridPane.addRow(2, newPosLabel, newPosTextField);
        gridPane.addRow(3, newTerminalLabel, newTerminalCombo);
        gridPane.addRow(4, newSaaLabel, newSAACombo);
        GridPane.setColumnSpan(flightInfo, 2);
        gridPane.addRow(5, flightInfo);


        // Add buttons to the grid pane
        gridPane.addRow(6, cancelButton, approveButton);

        Scene scene = new Scene(gridPane);
        stage.setScene(scene);

        stage.setTitle("Change flight");
        stage.showAndWait();
    }

}
