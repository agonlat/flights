package com.example.fluganzeigetafel.Flights.Utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * The TimeHandler class provides utility methods for handling time-related operations.
 */

public class TimeHandler {
    /**
     * Parses the input string and returns the time in the format "HH:mm:ss".
     *
     * @param input The input string representing a date and time in the format "dd.MM.yyyy hh:mm:ss".
     * @return The formatted time string or an empty string if parsing fails.
     */
    public static String getTime(String input) {
        input = input.trim();
        input = input + ":00";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");


        try {
            Date date = inputFormat.parse(input);
            String formattedDate = date.toString().substring(11,19);

            return formattedDate;
        } catch (ParseException e) {


            return "";
        }
    }
    /**
     * Gets the current actual date in the format "dd.MM.yyyy".
     *
     * @return The current actual date string.
     */
    public static String getActualDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }
    /**
     * Converts the input date and time string to UTC format "yyyy-MM-dd'T'HH:mm:ss'Z'".
     *
     * @param input The input date and time string in the format "dd.MM.yyyy HH:mm:ss".
     * @return The converted UTC formatted string or the input string if parsing fails.
     */
    public static String getUTC(String input) {
        try {
            input = input.trim();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            Date date = dateFormat.parse(input);

            SimpleDateFormat dateFormatUTC = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            dateFormatUTC.setTimeZone(TimeZone.getTimeZone("UTC"));

            return dateFormatUTC.format(date);

        } catch (ParseException e) {
            return input;
        }
    }

    public static String getLocalTimeFromUTC(String input) {
        input = input.trim();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date date = dateFormat.parse(input);

            SimpleDateFormat targetSdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");


            return targetSdf.format(date);
        } catch (ParseException e) {
            return input;
        }
    }



}