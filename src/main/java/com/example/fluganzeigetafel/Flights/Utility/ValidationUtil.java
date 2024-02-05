package com.example.fluganzeigetafel.Flights.Utility;

import com.example.fluganzeigetafel.CustomDialogs.ErrorDialog;
import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Flights.Data.Flight;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidationUtil {


    
/**
     * Checks if the provided terminal value is within the allowed range (1 or 2).
     *
     * @param terminal The input terminal value to be checked.
     * @return True if the terminal value is valid, false otherwise.
     */
    public static boolean checkTER(final String terminal) {
        try {
            int ter = Integer.parseInt(terminal);
            if (ter == 1 || ter == 2)
                return true;


        } catch (NumberFormatException e) {
            ErrorDialog dialog = new ErrorDialog("Only numbers between 1 and 2 are allowed!");
        }

        return false;
    }


     /**
     * Checks if the provided status value is one of the allowed values.
     *
     * @param status The input status value to be checked.
     * @return True if the status value is valid, false otherwise.
     */
    public static boolean checkSAA(final String status) {
        ArrayList values = new ArrayList(Arrays.asList(01,03,05,15,20,22,23,25,27,30,35,38,43,46,48,51,53,56,57,60,61
                ,63,64,65,66,67,72,80,86,88,94,96,97,98,99));


        try {
            int sta = Integer.parseInt(status);

            if (!values.contains(sta)) {
                return false;
            }



        } catch (NumberFormatException e) {
            ErrorDialog dialog = new ErrorDialog("Only one of these status is allowed: 01,03,05,15,20,22,23,25,27,30,35,38,43,46,48,51,53,56,57,60,61\n" +
                    "                ,63,64,65,66,67,72,80,86,88,94,96,97,98,99 ");

        }

        return true;
    }
/**
     * Checks if the provided flight number follows a specific format.
     *
     * @param flightNo The input flight number to be checked.
     * @return True if the flight number format is valid, false otherwise.
     */

    public static boolean checkFlightNumberFormat(final String flightNo) {



        if (flightNo.isBlank())
            return false;

        String regex = "^(?:[A-Z]{2} [0-9]{3,4}[A-Z]?|[0-9]{6}|[A-Z]{3}[0-9]{4}|[A-Z]{1}[0-9] [0-9]{3}|[A-Z]{1}[0-9] [0-9]{4})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(flightNo);

        if (!matcher.matches())
            return false;


        return true;
    }
/**
     * Checks if a flight with the provided flight number exists in the data.
     *
     * @param flightNo The input flight number to be checked.
     * @return The Flight object if the flight number exists, otherwise returns null.
     */
    public static Flight checkFlightNumberExistence(final String flightNo) {

        if (checkFlightNumberFormat(flightNo)) {
            DataInterface dataInterface = DataInterface.getInstance();

            for (Flight flight : dataInterface.getFlights()) {

                if (flight.getFnr().trim().equals(flightNo) || flight.getKnr().trim().equals(flightNo))
                    return flight;
            }

        }
        return null;
    }

    public static boolean checkNewInternalTimeFormat(final String itt) {
        if (itt.isBlank())
            return false;

        String regex = "(\\b[0-9]{2}\\.[0-9]{2}\\.(?:[0-9]{4}|[0-9]{2})\\s(?:[01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]\\b)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(itt);



        if (!matcher.matches() )
            return false;



        return true;
    }

    /**
     * Checks if the provided internal time format is valid.
     *
     * @param itt The input internal time format to be checked.
     * @return True if the internal time format is valid, false otherwise.
     */

    public static boolean checkNewInternalTimeValue(final String itt1, final String itt2) {
        if (itt1.isBlank() || itt2.isBlank())
            return true;



        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        try {

            Date dateInput = dateFormat.parse(itt1);
            Date dateStand = dateFormat.parse(itt2);

            if (dateInput.compareTo(dateStand) < 0)
                return true;



            return  true;
        } catch (ParseException e) {
            return false;
        }

    }

    /**
     * Checks if the provided new internal time value is valid compared to a given standard time.
     *
     * @param itt1 The input new internal time value to be checked.
     * @param itt2 The standard time value for comparison.
     * @return True if the new internal time value is valid, false otherwise.
     */
    public static boolean checkNewPosition(final String pos) {

        if (pos.isBlank())
            return false;

        String regex = "^[0-9]{3}[ABSNWE]?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pos);

        if (!matcher.matches())
            return false;

        return true;
    }



}
