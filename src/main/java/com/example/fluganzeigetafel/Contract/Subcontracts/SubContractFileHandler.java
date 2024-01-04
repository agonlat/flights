package com.example.fluganzeigetafel.Contract.Subcontracts;

import com.example.fluganzeigetafel.Contract.Contract;
import com.example.fluganzeigetafel.DataInterface;
import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SubContractFileHandler {

    public ArrayList<Subcontract> readCSVtoListOfSubContracts(String path) {
        boolean check = true;


        ArrayList<Subcontract> listOfSubContracts = new ArrayList<>();

        try {

            String[] values = null;
            CSVReader reader = new CSVReader(new FileReader(path));

            while ((values = reader.readNext()) != null) {
                if (check) {
                    check = false;
                    continue;
                }

                ArrayList<String> headersList = new ArrayList<>(List.of("ATTBE", "ATTEN", "AUKEY", "CBDFK", "ETTBE", "ETTEN", "INDNR", "LUPDN", "LUPDT", "LUPDV", "LZUAU",
                        "MENGE", "STTBE", "STTEN", "UAKEY", "UAPIR", "UASAA", "UASAU", "XUA", "ZINFO", "DFKEY", "ORTFR", "ORTTO",
                        "UAART", "UAREE", "FGKEY", "UAABF", "REKEY", "SPREK", "ATT30", "ATT50", "ATT55", "ATT60", "ATT70", "ATT75",
                        "ATTER", "UAAGE", "EINHE", "ATT20", "QKB", "SAA20", "SAAOF", "SKA", "STT20", "URK", "RELFK", "UAINF",
                        "ETT30", "UAKSL", "SPKEY", "MENG2", "CINFO", "ATT40", "STLIK", "OKEYN", "ABI", "EBI", "SBI", "TOURK", "EINH2",
                        "EINH3", "EINH4", "MENG3", "MENG4", "XCABA"));


                Subcontract subcontract = new Subcontract(
                        values[headersList.indexOf("ATTBE")],
                        values[headersList.indexOf("ATTEN")],
                        values[headersList.indexOf("AUKEY")],
                        values[headersList.indexOf("CBDFK")],
                        values[headersList.indexOf("ETTBE")],
                        values[headersList.indexOf("ETTEN")],
                        values[headersList.indexOf("INDNR")],
                        values[headersList.indexOf("LUPDN")],
                        values[headersList.indexOf("LUPDT")],
                        values[headersList.indexOf("LUPDV")],
                        values[headersList.indexOf("LZUAU")],
                        values[headersList.indexOf("MENGE")],
                        values[headersList.indexOf("STTBE")],
                        values[headersList.indexOf("STTEN")],
                        values[headersList.indexOf("UAKEY")],
                        values[headersList.indexOf("UAPIR")],
                        values[headersList.indexOf("UASAA")],
                        values[headersList.indexOf("UASAU")],
                        values[headersList.indexOf("XUA")],
                        values[headersList.indexOf("ZINFO")],
                        values[headersList.indexOf("DFKEY")],
                        values[headersList.indexOf("ORTFR")],
                        values[headersList.indexOf("ORTTO")],
                        values[headersList.indexOf("UAART")],
                        values[headersList.indexOf("UAREE")],
                        values[headersList.indexOf("FGKEY")],
                        values[headersList.indexOf("UAABF")],
                        values[headersList.indexOf("REKEY")],
                        values[headersList.indexOf("SPREK")],
                        values[headersList.indexOf("ATT30")],
                        values[headersList.indexOf("ATT50")],
                        values[headersList.indexOf("ATT55")],
                        values[headersList.indexOf("ATT60")],
                        values[headersList.indexOf("ATT70")],
                        values[headersList.indexOf("ATT75")],
                        values[headersList.indexOf("ATTER")],
                        values[headersList.indexOf("UAAGE")],
                        values[headersList.indexOf("EINHE")],
                        values[headersList.indexOf("ATT20")],
                        values[headersList.indexOf("QKB")],
                        values[headersList.indexOf("SAA20")],
                        values[headersList.indexOf("SAAOF")],
                        values[headersList.indexOf("SKA")],
                        values[headersList.indexOf("STT20")],
                        values[headersList.indexOf("URK")],
                        values[headersList.indexOf("RELFK")],
                        values[headersList.indexOf("UAINF")],
                        values[headersList.indexOf("ETT30")],
                        values[headersList.indexOf("UAKSL")],
                        values[headersList.indexOf("SPKEY")],
                        values[headersList.indexOf("MENG2")],
                        values[headersList.indexOf("CINFO")],
                        values[headersList.indexOf("ATT40")],
                        values[headersList.indexOf("STLIK")],
                        values[headersList.indexOf("OKEYN")],
                        values[headersList.indexOf("ABI")],
                        values[headersList.indexOf("EBI")],
                        values[headersList.indexOf("SBI")],
                        values[headersList.indexOf("TOURK")],
                        values[headersList.indexOf("EINH2")],
                        values[headersList.indexOf("EINH3")],
                        values[headersList.indexOf("EINH4")],
                        values[headersList.indexOf("MENG3")],
                        values[headersList.indexOf("MENG4")],
                        values[headersList.indexOf("XCABA")]
                );


                listOfSubContracts.add(subcontract);


            }


            return listOfSubContracts;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }




    public void addSubContractsToContracts(ArrayList<Subcontract> list) {

        ArrayList<Contract> contractList = DataInterface.getInstance().getContracts();

        ArrayList<Subcontract> subcontractsList = list;






        for (Contract contract : contractList) {
            for (Subcontract subcontract : list) {
                if (contract.getAUKEY().trim().equals(subcontract.getAUKEY())) {
                    if (!contract.getSubContractsList().contains(subcontract))
                        contract.addSubContractToSubContractList(subcontract);

                    }
                }
            }

        }







    }







