package com.example.fluganzeigetafel.Contract.Handler;

import com.example.fluganzeigetafel.Contract.CSVRow;
import com.example.fluganzeigetafel.Contract.Contract;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHandler {
    public ArrayList<Contract> readCSV_toList(String filepath) {
        boolean check = true;

        ArrayList<Contract> list = new ArrayList<>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filepath));
            String line;
            int i = 0;
            while ((line = bf.readLine()) != null && i < 53) {
                if (check) {
                    check = false;
                    continue;
                }

                String[] values = line.split(",");
                String[] cols = {
                        "ATTBE", "ATTEN", "AUAGE", "AUKEY", "AUKNL", "AUKNS", "AUPIR", "AUSAA", "AUSAU", "DISPO",
                        "EINHE", "ETTBE", "ETTEN", "FGKEY", "JTP", "KEYLK", "KEYLE", "KEYLF", "LUPDN", "LUPDT",
                        "LUPDV", "MENGE", "ORTFR", "ORTTO", "STTBE", "STTEN", "UAZAK", "UAZPL", "XAU", "ZINFO",
                        "DIB", "PLKEY", "AUDAT", "AUABF", "ATT20", "RELFK", "CINFO", "FDAEN", "FLAGS", "MITAR",
                        "MAD", "STLIK", "PKART", "PKL", "PKLAS", "PKLEA", "PKNAM", "PLE", "EINH2", "EINH3",
                        "EINH4", "MENG2", "MENG3", "MENG4"
                };



                i++;

                Contract contract = new Contract(
                        values[Arrays.asList(cols).indexOf("ATTBE")],      // ATTBE
                        values[Arrays.asList(cols).indexOf("ATTEN")],      // ATTEN
                        values[Arrays.asList(cols).indexOf("AUAGE")],      // AUAGE
                        values[Arrays.asList(cols).indexOf("AUKEY")],     // AUKEY
                        values[Arrays.asList(cols).indexOf("AUKNL")],      // AUKNL
                        values[Arrays.asList(cols).indexOf("AUKNS")],      // AUKNS
                        values[Arrays.asList(cols).indexOf("AUPIR")],      // AUPIR
                        values[Arrays.asList(cols).indexOf("AUSAA")],        // AUSAA (assuming AUSAA is an enum)
                        values[Arrays.asList(cols).indexOf("AUSAU")],      // AUSAU
                        values[Arrays.asList(cols).indexOf("DISPO")],      // DISPO
                        values[Arrays.asList(cols).indexOf("EINHE")],      // EINHE
                        values[Arrays.asList(cols).indexOf("ETTBE")],      // ETTBE
                        values[Arrays.asList(cols).indexOf("ETTEN")],      // ETTEN
                        values[Arrays.asList(cols).indexOf("FGKEY")],      // FGKEY
                        values[Arrays.asList(cols).indexOf("JTP")],        // JTP
                        values[Arrays.asList(cols).indexOf("KEYLK")],      // KEYLK
                        values[Arrays.asList(cols).indexOf("KEYLE")],      // KEYLE
                        values[Arrays.asList(cols).indexOf("KEYLF")],      // KEYLF
                        values[Arrays.asList(cols).indexOf("LUPDN")],      // LUPDN
                        values[Arrays.asList(cols).indexOf("LUPDT")],      // LUPDT
                        values[Arrays.asList(cols).indexOf("LUPDV")],      // LUPDV
                        values[Arrays.asList(cols).indexOf("MENGE")],      // MENGE
                        values[Arrays.asList(cols).indexOf("ORTFR")],      // ORTFR
                        values[Arrays.asList(cols).indexOf("ORTTO")],      // ORTTO
                        values[Arrays.asList(cols).indexOf("STTBE")],      // STTBE
                        values[Arrays.asList(cols).indexOf("STTEN")],      // STTEN
                        values[Arrays.asList(cols).indexOf("UAZAK")],      // UAZAK
                        values[Arrays.asList(cols).indexOf("UAZPL")],      // UAZPL
                        values[Arrays.asList(cols).indexOf("XAU")],        // XAU
                        values[Arrays.asList(cols).indexOf("ZINFO")],      // ZINFO
                        values[Arrays.asList(cols).indexOf("DIB")],        // DIB
                        values[Arrays.asList(cols).indexOf("PLKEY")],      // PLKEY
                        values[Arrays.asList(cols).indexOf("AUDAT")],      // AUDAT
                        values[Arrays.asList(cols).indexOf("AUABF")],      // AUABF
                        values[Arrays.asList(cols).indexOf("ATT20")],      // ATT20
                        values[Arrays.asList(cols).indexOf("RELFK")],      // RELFK
                        values[Arrays.asList(cols).indexOf("CINFO")],      // CINFO
                        values[Arrays.asList(cols).indexOf("FDAEN")],      // FDAEN
                        values[Arrays.asList(cols).indexOf("FLAGS")],      // FLAGS
                        values[Arrays.asList(cols).indexOf("MITAR")],      // MITAR
                        values[Arrays.asList(cols).indexOf("MAD")],        // MAD
                        values[Arrays.asList(cols).indexOf("STLIK")],      // STLIK
                        values[Arrays.asList(cols).indexOf("PKART")],      // PKART
                        values[Arrays.asList(cols).indexOf("PKL")],        // PKL
                        values[Arrays.asList(cols).indexOf("PKLAS")],      // PKLAS
                        values[Arrays.asList(cols).indexOf("PKLEA")],      // PKLEA
                        values[Arrays.asList(cols).indexOf("PKNAM")],      // PKNAM
                        values[Arrays.asList(cols).indexOf("PLE")],        // PLE
                        values[Arrays.asList(cols).indexOf("EINH2")],      // EINH2
                        values[Arrays.asList(cols).indexOf("EINH3")],      // EINH3
                        values[Arrays.asList(cols).indexOf("EINH4")],      // EINH4
                        values[Arrays.asList(cols).indexOf("MENG2")],      // MENG2
                        values[Arrays.asList(cols).indexOf("MENG3")],      // MENG3
                        values[Arrays.asList(cols).indexOf("MENG4")]       // MENG4
                );

                for (int j = 0; j < values.length; j++) {
                    CSVRow row = new CSVRow(cols[j], values[j]);
                    contract.getCSVRows().add(row);
                }





                list.add(contract);

            }





        return list;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
