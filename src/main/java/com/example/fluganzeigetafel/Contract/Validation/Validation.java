package com.example.fluganzeigetafel.Contract.Validation;

import com.example.fluganzeigetafel.Contract.Subcontracts.Subcontract;
import com.example.fluganzeigetafel.DataInterface;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Character.isDigit;

public class Validation {
    public static boolean checkAUKEY(String input) {
        try {
            int value = Integer.parseInt(input);
            // Additional checks if needed
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // V10
    public static boolean checkDISPO(String input) {
        // Additional checks if needed

        String[] validValues = {"CLEAN", "OPTIBUS", "LUCHS", "COBRA2", "MAUSGEP", "FUCHS2", "PUMA2", "MAUSLAST", "PND-ABF", "PANDA-ANK", "KFZ", "ENTEISUNG", "BAGTR"};

        for (String validValue : validValues) {
            if (input.equals(validValue)) {
                return true;
            }
        }

        return false;
    }

    // V1
    public static boolean checkDIB(String input) {
        // Additional checks if needed
        return input.length() == 1;
    }

    // N2
    public static boolean checkJTP(String input) {
        try {
            int value = Integer.parseInt(input);
            // Additional checks if needed
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // N6
    public static boolean checkAUSAA(String input) {
        try {
            int value = Integer.parseInt(input);
            // Additional checks if needed
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // V16
    public static boolean checkAUSAU(String input) {
        // Additional checks if needed
        return input.length() <= 16;
    }

    // V3
    public static boolean checkAUKNL(String input) {
        // Additional checks if needed
        return input.length() <= 3;
    }

    // N3
    public static boolean checkAUKNS(String input) {
        try {
            int value = Integer.parseInt(input);
            // Additional checks if needed
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // N6
    public static boolean checkFGKEY(String input) {
        try {
            int value = Integer.parseInt(input);
            // Additional checks if needed
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // N6
    public static boolean checkPLKEY(String input) {
        try {
            int value = Integer.parseInt(input);
            // Additional checks if needed
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // D14
    public static boolean checkORTFR(String input) {
        // Additional checks if needed
        // You might want to use SimpleDateFormat to parse and validate the date
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            Date date = dateFormat.parse(input);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    // D14
    public static boolean checkORTTO(String input) {
        // Additional checks if needed
        // You might want to use SimpleDateFormat to parse and validate the date
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            Date date = dateFormat.parse(input);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    // N6
    public static boolean checkMENGE(String input) {
        try {
            int value = Integer.parseInt(input);
            // Additional checks if needed
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // V16
    public static boolean checkEINHE(String input) {
        // Additional checks if needed
        return input.length() <= 16;
    }

    // N6
    public static boolean checkMENG2(String input) {
        try {
            int value = Integer.parseInt(input);
            // Additional checks if needed
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // V3
    public static boolean checkEINH2(String input) {
        // Additional checks if needed
        return input.length() <= 3;
    }

    // N6
    public static boolean checkMENG3(String input) {
        try {
            int value = Integer.parseInt(input);
            // Additional checks if needed
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // V3
    public static boolean checkEINH3(String input) {
        // Additional checks if needed
        return input.length() <= 3;
    }

    // N6
    public static boolean checkMENG4(String input) {
        try {
            int value = Integer.parseInt(input);
            // Additional checks if needed
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // V3
    public static boolean checkEINH4(String input) {
        // Additional checks if needed
        return input.length() <= 3;
    }

    // V10
    public static boolean checkUAZPL(String input) {
        // Additional checks if needed
        return input.length() <= 10;
    }

    // V10
    public static boolean checkUAZAK(String input) {
        // Additional checks if needed
        return input.length() <= 10;
    }

    // V10
    public static boolean checkAUAGE(String input) {
        // Additional checks if needed
        return input.length() <= 10;
    }

    // D14
    public static boolean checkSTTBE(String input) {
        // Additional checks if needed
        // You might want to use SimpleDateFormat to parse and validate the date
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            Date date = dateFormat.parse(input);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    // D14
    public static boolean checkSTTEN(String input) {
        // Additional checks if needed
        // You might want to use SimpleDateFormat to parse and validate the date
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            Date date = dateFormat.parse(input);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    // D14
    public static boolean checkETTBE(String input) {
        // Additional checks if needed
        // You might want to use SimpleDateFormat to parse and validate the date
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            Date date = dateFormat.parse(input);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    // D14
    public static boolean checkETTEN(String input) {
        // Additional checks if needed
        // You might want to use SimpleDateFormat to parse and validate the date
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            Date date = dateFormat.parse(input);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    // D14
    public static boolean checkATTBE(String input) {
        // Additional checks if needed
        // You might want to use SimpleDateFormat to parse and validate the date
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            Date date = dateFormat.parse(input);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    // D14
    public static boolean checkATTEN(String input) {
        // Additional checks if needed
        // You might want to use SimpleDateFormat to parse and validate the date
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            Date date = dateFormat.parse(input);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    // D14
    public static boolean checkATT20(String input) {
        // Additional checks if needed
        // You might want to use SimpleDateFormat to parse and validate the date
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            Date date = dateFormat.parse(input);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    // V1
    public static boolean checkAUPIR(String input) {
        // Additional checks if needed
        return input.length() == 1;
    }

    // V256
    public static boolean checkZINFO(String input) {
        // Additional checks if needed
        return input.length() <= 256;
    }

    // V10
    public static boolean checkLUPDN(String input) {
        // Additional checks if needed
        return input.length() <= 10;
    }

    // V10
    public static boolean checkLUPDT(String input) {
        // Additional checks if needed
        return input.length() <= 10;
    }

    // V10
    public static boolean checkLUPDV(String input) {
        // Additional checks if needed
        return input.length() <= 10;
    }

    // V32
    public static boolean checkKEYLK(String input) {
        // Additional checks if needed
        return input.length() <= 32;
    }

    // V32
    public static boolean checkKEYLE(String input) {
        // Additional checks if needed
        return input.length() <= 32;
    }

    // V32
    public static boolean checkKEYLF(String input) {
        // Additional checks if needed
        return input.length() <= 32;
    }

    // V1
    public static boolean checkXAU(String input) {
        // Additional checks if needed
        return input.length() == 1;
    }

    // V3
    public static boolean checkAUDAT(String input) {
        // Additional checks if needed
        return input.length() <= 3;
    }

    // V10
    public static boolean checkAUABF(String input) {
        // Additional checks if needed
        return input.length() <= 10;
    }

    // N19
    public static boolean checkMITAR(String input) {
        try {
            long value = Long.parseLong(input);
            // Additional checks if needed
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // D14
    public static boolean checkFDAEN(String input) {
        // Additional checks if needed
        // You might want to use SimpleDateFormat to parse and validate the date
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            Date date = dateFormat.parse(input);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    // N19
    public static boolean checkFLAGS(String input) {
        try {
            long value = Long.parseLong(input);
            // Additional checks if needed
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static boolean checkUAKEY_Existence(String value) {
        for (Subcontract subcontract : DataInterface.getInstance().getSubcontractsList()) {
            if (subcontract.getUAKEY().trim().equals(value)) {

                return true;
            }
        }

        return false;
    }

    // Check if REFKEY is a number with max 10 digits
    public static boolean checkREFKEY(String value) {
        return value.matches("\\d{1,10}");
    }

    // Check if UAABF is a string with max 10 characters
    public static boolean checkUAABF(String value) {
        return value.matches(".{1,10}");
    }

    // Check if UAREE is a string with max 3 characters
    public static boolean checkUAREE(String value) {
        return value.matches(".{1,3}");
    }

    public static boolean checkUAAR(String value) {
        return value.matches("\\d{8}");
    }

    // Check if UASAU is a number with max 2 digits
    public static boolean checkUASAU(String value) {
        return value.matches("\\d{1,2}");
    }

    // Check if UASAA is a number with max 2 digits
    public static boolean checkUASAA(String value) {
        return value.matches("\\d{1,2}");
    }

    // Check if UAPIR is a single character
    public static boolean checkUAPIR(String value) {
        return value.matches(".");
    }

    // Check if UAKEY is a number with max 10 digits
    public static boolean checkUAKEY(String value) {
        return value.matches("\\d{1,10}");
    }

    // Check if CZAU is a string (no specific format mentioned)
    public static boolean checkCZAU(String value) {
        return value.matches(".*");
    }

    // Check if INDNR is a number with max 3 digits
    public static boolean checkINDNR(String value) {
        return value.matches("\\d{1,3}");
    }

    public static boolean checkSAAUF(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkSAA20(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkQKB(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkUAAGE(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkATTER(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkATT75(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkATT70(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkATT60(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkATT55(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkATT50(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkATT30(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkSREK(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkXLBA(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkTOURK(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkSBI(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkEBI(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkABI(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkOKEYN(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkATT40(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkSPKEY(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkUAKSL(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkETT30(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkUAINF(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkURK(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkSTT20(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkSKA(String value) {
        return value.matches("\\w{1,10}");
    }



    public static boolean checkLZUAU(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkXUA(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkUUART(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkSPREK(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkSAAOF(String value) {
        return value.matches("\\w{1,10}");
    }







public static boolean checkDISPOExistence(String input) {
        List<String> list = new ArrayList<>(List.of("BAGTR","CLEAN", "COBRA2", "ENTEISUNG", "FUCHS2", "KFZ", "LUCHS",
                "MAUSGEP", "MAUSLAST", "OPTIBUS", "PND_ABF", "PND_ANK", "PUMA2"));

        if (!list.contains(input))
            return false;

        return true;
}

    // V10
    public static boolean checkCINFO(String input) {
        // Additional checks if needed
        return input.length() <= 10;
    }

    // N19
    public static boolean checkMAD(String input) {
        try {
            long value = Long.parseLong(input);
            // Additional checks if needed
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // V10
    public static boolean checkSTLIK(String input) {
        // Additional checks if needed
        return input.length() <= 10;
    }

    // V12
    public static boolean checkPKART(String input) {
        // Additional checks if needed
        return input.length() <= 12;
    }

    // V1
    public static boolean checkPKL(String input) {
        // Additional checks if needed
        return input.length() == 1;
    }

    // V32
    public static boolean checkPKLAS(String input) {
        // Additional checks if needed
        return input.length() <= 32;
    }

    // V1
    public static boolean checkPKLEA(String input) {
        // Additional checks if needed
        return input.length() == 1;
    }

    // V32
    public static boolean checkPKNAM(String input) {
        // Additional checks if needed
        return input.length() <= 32;
    }

    // N10
    public static boolean checkRELFK(String input) {
        try {
            int value = Integer.parseInt(input);
            // Additional checks if needed
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
