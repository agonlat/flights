package com.example.fluganzeigetafel.Handler;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.fluganzeigetafel.Contract.Contract;
import com.example.fluganzeigetafel.CustomDialogs.ErrorDialog;
import com.example.fluganzeigetafel.Data.DataInterface;
import com.example.fluganzeigetafel.Data.Flight;
import com.example.fluganzeigetafel.Utility.TimeHandler;


public class FileHandler {


    public ArrayList<Flight> readCSV_File(final String path) {
        boolean chk = true;

        List<Flight> list = new ArrayList<>();

        try {
            BufferedReader bf = new BufferedReader(new FileReader(path));
            String line;

            while ((line = bf.readLine()) != null) {
                if (chk) {
                    chk = false;
                    continue;
                }

                    String[] values = line.split(",");
                Flight flight = new Flight(
                        values[0],  // fnr
                        values[1],  // knr
                        values[2],  // reg
                        values[3],  // typ
                        values[4],  // ha0
                        values[5],  // lsk
                        values[6],  // stt
                        values[7],  // itt
                        values[8],  // pos
                        values[9],  // ter
                        values[10], // mad
                        values[11]  // saa
                );

                if (!flight.getStt().isBlank())
                    flight.setStt(TimeHandler.getActualDate() + " " + TimeHandler.getTime(flight.getStt()));

                if (!flight.getItt().isBlank())
                    flight.setItt(TimeHandler.getActualDate() + " " + TimeHandler.getTime(flight.getItt()));

                list.add(flight);
                ArrayList<Contract> contractList = DataInterface.getInstance().getContracts();

                for (Contract contract : contractList) {
                    String aukey = contract.getAUKEY();
                    if (aukey.equals(flight.getKnr())) {
                        flight.getContracts().add(contract);
                    }


            }


        }
            return (ArrayList<Flight>) list;
        } catch (FileNotFoundException e) {
            ErrorDialog dialog = new ErrorDialog("File not found. Check file path");


        } catch (IOException e) {
            ErrorDialog dialog = new ErrorDialog("Problems occured while reading the file. Check structure of the file");
        }


        return null;
    }


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
