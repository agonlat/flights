package com.example.fluganzeigetafel.Flights.Utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeHandler {

   public static String getTime(String input) {
        input = input.trim();



        SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");


        try {
            Date date = inputFormat.parse(input);
            String formattedDate = date.toString().substring(11,19);



            return formattedDate;
        } catch (ParseException e) {
            // Handle parsing exception

            return "";
        }
    }

    public static String getActualDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

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
