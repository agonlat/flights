package com.example.fluganzeigetafel.Flights.Handler;

import com.example.fluganzeigetafel.CustomDialogs.ErrorDialog;
import com.example.fluganzeigetafel.Flights.Data.Flight;
import com.example.fluganzeigetafel.Flights.Utility.TimeHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

 /**
     * This class is responsible for handling methods for CSV-Files.
     */
public class FileHandler {

 /**
     * This method reads a CSV-File and converts it to an ArrayList of Flights.
     * @param path The path as a String
     * @return ArrayList<Flight> returns the Flights as an ArrayList
     */
    public ArrayList<Flight> readCSV_File(final String path) {
        boolean isHeadersLine = true;

        List<Flight> list = new ArrayList<>();

        try {
            BufferedReader bf = new BufferedReader(new FileReader(path));
            String line;

            while ((line = bf.readLine()) != null) {
                if (isHeadersLine) {
                    isHeadersLine = false;
                    continue;
                }

                    String[] values = line.split(",");
                Flight flight = new Flight(
                        values[0].replace("\"", "").trim(),  // fnr
                        values[1].replace("\"", "").trim(),  // knr
                        values[2].replace("\"", "").trim(),  // reg
                        values[3].replace("\"", "").trim(),  // typ
                        values[4].replace("\"", "").trim(),  // ha0
                        values[5].replace("\"", "").trim(),  // lsk
                        values[6].replace("\"", "").trim(),  // stt
                        values[7].replace("\"", "").trim(),  // itt
                        values[8].replace("\"", "").trim(),  // pos
                        values[9].replace("\"", "").trim(),  // ter
                        values[10].replace("\"", "").trim(), // mad
                        values[11].replace("\"", "").trim()  // saa
                );

                if (!flight.getStt().isBlank())
                    flight.setStt(TimeHandler.getActualDate() + " " + TimeHandler.getTime(flight.getStt()));

                if (!flight.getItt().isBlank())
                    flight.setItt(TimeHandler.getActualDate() + " " + TimeHandler.getTime(flight.getItt()));

                list.add(flight);





        }






            return (ArrayList<Flight>) list;
        } catch (FileNotFoundException e) {
            ErrorDialog dialog = new ErrorDialog("File not found. Check file path");


        } catch (IOException e) {
            ErrorDialog dialog = new ErrorDialog("Problems occured while reading the file. Check structure of the file");
        }





        return null;
    }

 /**
     * This method writes Data, specifically Flights, to a CSV-File and returns a boolean.
     * @param flights The flights as ArrayList to be exported to CSV
     * @return true If the flights were exported successfully
     * @return false If an error occured while exporting
     */
    public boolean writeToCSV_File(final ArrayList<Flight> flights) {
        String filename = "output.csv"; // Specify the desired file name
        String path = System.getProperty("user.dir") + File.separator + filename; // Combine directory and filename
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            bw.write(String.join(",", Arrays.asList("fnr", "knr", "reg", "typ", "ha0", "lsk", "stt", "itt", "pos", "ter", "mad", "saa")));

            bw.newLine();
            for (Flight flight : flights) {



                String[] flightData = {
                        flight.getFnr(), flight.getKnr(), flight.getReg(), flight.getTyp(), flight.getHa0(),
                        flight.getLsk(), flight.getStt(), flight.getItt(), flight.getPos(), flight.getTer(),
                        flight.getMad(), flight.getSaa()
                };



                bw.write(String.join(",", Arrays.asList(flightData)));
                bw.newLine();
            }

            File file = new File(path);
            java.awt.Desktop.getDesktop().open(file);


            return true;


        } catch (IllegalArgumentException e) {
            ErrorDialog errorDialog = new ErrorDialog("An internal error occured");
        } catch (IOException e) {
            ErrorDialog errorDialog = new ErrorDialog("An internal error occured");
        }
        return false;
    }


}
