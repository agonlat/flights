package com.example.fluganzeigetafel.Flights.Utility;


import com.example.fluganzeigetafel.CustomDialogs.LoadFlightsDialog;
import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Flights.Data.Flight;
import com.example.fluganzeigetafel.Flights.Manager.PrintManager;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class UtilityMethods {


    public static String getAirlineCode(String input) {

        if (input.isBlank()) {
            return "";
        }

        String airline = "";

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == ' ') {
                return airline;
            }

            if (i == 3 && !Character.isDigit(input.charAt(i - 1)) && Character.isDigit(currentChar)) {
                return airline+""+currentChar;
            }

            if (i == 2 && Character.isDigit(input.charAt(i + 1))) {
                return airline+ currentChar;
            }

            airline = airline + currentChar;
        }

        return airline;
    }

    public static void setSearchButtonAction(Button searchButton) {

        if (DataInterface.getInstance().getFlights().isEmpty()) {
            LoadFlightsDialog dil = new LoadFlightsDialog();
            return;
        }

        Stage stage1 = new Stage();
        stage1.setWidth(stage1.getWidth() + 100);
        stage1.setResizable(false);
        Label label1 = new Label("Flight no or control no");
        TextField field = new TextField();

        Button submit = new Button("Search");
        Button cancel = new Button("Cancel");

        cancel.setOnAction(b -> stage1.close());

        VBox box = new VBox();
        box.setPadding(new Insets(0, 5, 0, 5));
        HBox hbox = new HBox();
        box.setSpacing(5);
        hbox.setSpacing(5);
        HBox.setHgrow(cancel, Priority.ALWAYS);
        HBox.setHgrow(submit, Priority.ALWAYS);
        hbox.getChildren().addAll(cancel, submit);
        box.getChildren().addAll(label1, field, hbox);
        hbox.setPadding(new Insets(0, 0, 5, 0));


        submit.setOnAction(g -> {
            if (ValidationUtil.checkFlightNumberFormat(field.getText().trim())) {
                if (ValidationUtil.checkFlightNumberExistence(field.getText().trim()) != null) {
                    Flight f = ValidationUtil.checkFlightNumberExistence(field.getText().trim());
                    String pattern = "FNR: " + f.getFnr() +
                            " KNR: " + f.getKnr() +
                            " REG: " + f.getReg() +
                            " TYP: " + f.getTyp() +
                            " HA0: " + f.getHa0() +
                            " LSK: " + f.getLsk() +
                            " STT: " + f.getStt() +
                            " ITT: " + f.getItt() +
                            " POS: " + f.getPos() +
                            " TER: " + f.getTer() +
                            " MAD: " + f.getMad() +
                            " SAA: " + f.getSaa();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION, pattern, new ButtonType("Print", ButtonBar.ButtonData.APPLY));
                    alert.setTitle("Information");



                    alert.setContentText(pattern);
                    alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    Optional<ButtonType> opt = alert.showAndWait();

                    if (opt.isPresent() && opt.get().getButtonData() == ButtonBar.ButtonData.APPLY) {
                        PrintManager controller = new PrintManager();
                        controller.createPDF(f);

                    }

                } else {
                    Alert alertF = new Alert(Alert.AlertType.INFORMATION);

                    alertF.setTitle("Information");
                    alertF.setContentText("Flight not found!");
                    alertF.showAndWait();
                }


            } else {
                Alert alertF = new Alert(Alert.AlertType.INFORMATION);
                alertF.setTitle("Information");
                alertF.setContentText("Flight does not match the pattern!");
                alertF.showAndWait();
            }

        });
        stage1.setScene(new Scene(box));
        stage1.showAndWait();

    }

    public static String leaveOneWhiteSpace(String input) {
        StringBuilder result = new StringBuilder();
        int spaceCount = 0;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (Character.isWhitespace(currentChar)) {
                // If it's the first space encountered, append it
                if (spaceCount == 0) {
                    result.append(currentChar);
                }

                spaceCount++;
            } else {
                // Reset space count when a non-space character is encountered
                spaceCount = 0;
                result.append(currentChar);
            }
        }

        return result.toString();
    }

}