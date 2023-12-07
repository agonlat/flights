package com.example.fluganzeigetafel.Utility;

import com.example.fluganzeigetafel.Data.DataInterface;
import com.example.fluganzeigetafel.Data.Flight;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {

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

    public static boolean checkNewInternalTimeValue(final String itt1, final String itt2) {
        if (itt1.isBlank() || itt2.isBlank())
            return true;



        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        try {

            Date dateInput = dateFormat.parse(itt1);
            Date dateStand = dateFormat.parse(itt2);

            if (dateInput.compareTo(dateStand) < 0)
                return false;



            return  true;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
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
