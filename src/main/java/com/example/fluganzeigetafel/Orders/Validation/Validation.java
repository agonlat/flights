package com.example.fluganzeigetafel.Orders.Validation;

import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Suborders.Suborder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/**
 * The ValidationUtil class provides methods for validating attributes of orders and suborders.
 * It includes validation for attributes like terminal, status, flight number format, internal time format,
 * internal time values, positions, and more.
 */
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


    public static boolean checkDIB(String input) {
        // Additional checks if needed
        return input.length() == 1;
    }


    public static boolean checkJTP(String input) {
        if (input.length() > 6)
            return false;

        if (input.isBlank())
            return false;

        return true;
    }


    public static boolean checkAUSAA(String input) {
        if (input.length()> 2)
            return false;

        if (input.isBlank())
            return false;
        return true;
    }


    public static boolean checkAUSAU(String input) {
        if (input.length()> 2)
            return false;
        if (input.isBlank())
            return false;
        return true;
    }


    public static boolean checkAUKNL(String input) {
        if (input.length() > 10)
            return false;
        if (input.isBlank())
            return false;

        try {
            int value = Integer.parseInt(input);
            // Additional checks if needed
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean checkAUKNS(String input) {
        if (input.length() > 10)
            return false;
        if (input.isBlank())
            return false;
        try {
            int value = Integer.parseInt(input);
            // Additional checks if needed
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static boolean checkFGKEY(String input) {
        if (input.length() > 32)
            return false;
        if (input.isBlank())
            return false;
        return true;
    }

    public static boolean checkPLKEY(String input) {
        if (input.length() > 6)
            return false;
        if (input.isBlank())
            return false;

        try {
            int value = Integer.parseInt(input);
            // Additional checks if needed
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static boolean checkORTFR(String input) {
        if (input.length() > 16)
            return false;
        if (input.isBlank())
            return false;
        return true;
    }


    public static boolean checkORTTO(String input) {
        if (input.length() > 16)
            return false;
        if (input.isBlank())
            return false;
        return true;
    }


    public static boolean checkMENGE(String input) {
        if (input.length() > 6)
            return false;
        if (input.isBlank())
            return false;
        try {
            int value = Integer.parseInt(input);

            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static boolean checkEINHE(String input) {
        if (input.length() > 3)
            return false;
        if (input.isBlank())
            return false;
        return true;
    }


    public static boolean checkMENG2(String input) {
        if (input.length() > 6)
            return false;
        if (input.isBlank())
            return false;
        try {
            int value = Integer.parseInt(input);
            // Additional checks if needed
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static boolean checkEINH2(String input) {
        if (input.length() > 3)
            return false;
        if (input.isBlank())
            return false;
        return true;
    }


    public static boolean checkMENG3(String input) {
        if (input.length() > 6)
            return false;
        if (input.isBlank())
            return false;
        try {
            int value = Integer.parseInt(input);
            // Additional checks if needed
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static boolean checkEINH3(String input) {
        if (input.length() > 3)
            return false;
        if (input.isBlank())
            return false;
        return true;
    }


    public static boolean checkMENG4(String input) {
        if (input.length() > 6)
            return false;
        if (input.isBlank())
            return false;
        try {
            int value = Integer.parseInt(input);
            // Additional checks if needed
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static boolean checkEINH4(String input) {
        if (input.length() > 3)
            return false;
        if (input.isBlank())
            return false;
        return true;
    }


    public static boolean checkUAZPL(String input) {
        if (input.length()> 3)
            return false;
        if (input.isBlank())
            return false;
        try {
            int value = Integer.parseInt(input);
            // Additional checks if needed
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static boolean checkUAZAK(String input) {
        if (input.length()> 3)
            return false;
        if (input.isBlank())
            return false;
        try {
            int value = Integer.parseInt(input);
            // Additional checks if needed
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static boolean checkAUAGE(String input) {
        if (input.length() >10)
            return false;
        if (input.isBlank())
            return false;
        return true;
    }

    private boolean checkDate(String input) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("d.M.yyyy h:mm a", Locale.ENGLISH);

        try {
            // Attempt to parse the input value as a LocalDateTime
            LocalDateTime localDate = LocalDateTime.parse(input, inputFormatter);
            return true;
        } catch (DateTimeParseException ex) {
            // Parsing failed, indicating an incorrect format
            return false;
        }
    }



    public static boolean checkSTTBE(String input) {
        Validation validation = new Validation();
        return validation.checkDate(input);
    }


    public static boolean checkSTTEN(String input) {
        Validation validation = new Validation();
        return validation.checkDate(input);

    }


    public static boolean checkETTBE(String input) {
        Validation validation = new Validation();
        return validation.checkDate(input);
    }


    public static boolean checkETTEN(String input) {
        Validation validation = new Validation();
        return validation.checkDate(input);
    }


    public static boolean checkATTBE(String input) {
        Validation validation = new Validation();
        return validation.checkDate(input);
    }


    public static boolean checkATTEN(String input) {
        Validation validation = new Validation();
        return validation.checkDate(input);
    }

    public static boolean checkATT20(String input) {
        Validation validation = new Validation();
        return validation.checkDate(input);
    }


    public static boolean checkAUPIR(String input) {
        // Additional checks if needed
        return input.length() == 1;
    }


    public static boolean checkZINFO(String input) {
        if (input.isBlank())
            return false;
        // Additional checks if needed
        return input.length() <= 256;
    }


    public static boolean checkLUPDN(String input) {
        if (input.length()>9)
            return false;

        try {
            Integer.parseInt(input);
            // Additional checks if needed
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }

    }


    public static boolean checkLUPDT(String input) {
        Validation validation = new Validation();
        return validation.checkDate(input);
    }


    public static boolean checkLUPDV(String input) {
        if (input.isBlank())
            return false;
        // Additional checks if needed
        return input.length() <= 30;
    }


    public static boolean checkKEYLK(String input) {
        if (input.length()>32)
            return false;
        if (input.isBlank())
            return false;
        try {
            Integer.parseInt(input);
            // Additional checks if needed
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
        // Additional checks if needed

    }


    public static boolean checkKEYLE(String input) {
        if (input.length()>32)
            return false;
        if (input.isBlank())
            return false;
        try {
            Integer.parseInt(input);
            // Additional checks if needed
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }


    public static boolean checkKEYLF(String input) {
        if (input.length()>32)
            return false;
        if (input.isBlank())
            return false;
        try {
            Integer.parseInt(input);
            // Additional checks if needed
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }


    public static boolean checkXAU(String input) {
        Validation validation = new Validation();
        return validation.checkDate(input);
    }


    public static boolean checkAUDAT(String input) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");

        try {
            // Attempt to parse the input value as a date with the specified format
            formatter.parse(input);
            return true;
        } catch (DateTimeParseException ex) {
            // Parsing failed, indicating an incorrect format
            return false;
        }
    }


    public static boolean checkAUABF(String input) {
        if (input.isBlank())
            return false;
        // Additional checks if needed
        return input.length() <= 10;
    }


    public static boolean checkMITAR(String input) {
        if (input.isBlank())
            return false;
        return input.length() <= 12;
    }


    public static boolean checkFDAEN(String input) {
        if (input.isBlank())
            return false;
        return input.length() == 1;
    }


    public static boolean checkFLAGS(String input) {
        if (input.isBlank())
            return false;
        return input.length() <= 32;
    }


    public static boolean checkUAKEY_Existence(String value) {
        for (Suborder suborder : DataInterface.getInstance().getSubordersList()) {
            if (suborder.getUAKEY().trim().equals(value)) {

                return true;
            }
        }

        return false;
    }


    public static boolean checkREKEY(String value) {
        return value.matches("\\d{1,10}");
    }

    public static boolean checkUAABF(String value) {
        return value.matches(".{1,10}");
    }


    public static boolean checkUAREE(String value) {
        return value.matches(".{1,3}");
    }

    public static boolean checkUAAR(String value) {
        return value.matches("\\d{8}");
    }


    public static boolean checkUASAU(String value) {
        return value.matches("\\d{1,2}");
    }


    public static boolean checkUASAA(String value) {
        return value.matches("\\d{1,2}");
    }


    public static boolean checkUAPIR(String value) {
        return value.matches(".");
    }


    public static boolean checkUAKEY(String value) {
        return value.matches("\\d{1,10}");
    }


    public static boolean checkCZAU(String value) {
        return value.matches(".*");
    }


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
        return value.matches("\\w{1,5}");
    }

    public static boolean checkUAAGE(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkATTER(String value) {
        Validation validation = new Validation();
        return validation.checkDate(value);
    }

    public static boolean checkATT75(String value) {
        Validation validation = new Validation();
        return validation.checkDate(value);
    }

    public static boolean checkATT70(String value) {
        Validation validation = new Validation();
        return validation.checkDate(value);
    }

    public static boolean checkATT60(String value) {
        Validation validation = new Validation();
        return validation.checkDate(value);
    }

    public static boolean checkATT55(String value) {
        Validation validation = new Validation();
        return validation.checkDate(value);
    }

    public static boolean checkATT50(String value) {
        Validation validation = new Validation();
        return validation.checkDate(value);
    }

    public static boolean checkATT30(String value) {
        Validation validation = new Validation();
        return validation.checkDate(value);
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
        if (value.length() > 6)
            return false;
        if (value.isBlank())
            return false;

        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean checkEBI(String value) {
        if (value.length() > 6)
            return false;
        if (value.isBlank())
            return false;
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean checkABI(String value) {
        if (value.length() > 6)
            return false;
        if (value.isBlank())
            return false;
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public static boolean checkOKEYN(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkATT40(String value) {
        Validation validation = new Validation();
        return validation.checkDate(value);
    }

    public static boolean checkSPKEY(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkUAKSL(String value) {
        if (value.length() > 1)
            return false;
        if (value.isBlank())
            return false;
        return true;
    }

    public static boolean checkETT30(String value) {
        Validation validation = new Validation();
        return validation.checkDate(value);
    }

    public static boolean checkUAINF(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkURK(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkSTT20(String value) {
        Validation validation = new Validation();
        return validation.checkDate(value);
    }

    public static boolean checkSKA(String value) {
        return value.matches("\\w{1,50}");
    }



    public static boolean checkLZUAU(String value) {
        return value.matches("\\w{1,10}");
    }

    public static boolean checkXUA(String value) {
        Validation validation = new Validation();
        return validation.checkDate(value);
    }

    public static boolean checkUAART(String value) {
        return value.matches("\\w{1,8}");
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


    public static boolean checkCINFO(String input) {
        if (input.isBlank())
            return false;
        // Additional checks if needed
        return input.length() <= 32;
    }


    public static boolean checkMAD(String input) {
        if (input.isBlank())
            return false;
        return input.length() <= 4;
    }


    public static boolean checkSTLIK(String input) {
        if (input.isBlank())
            return false;
        if (input.length() > 10)
            return false;
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static boolean checkPKART(String input) {
        if (input.isBlank())
            return false;
        // Additional checks if needed
        return input.length() <= 3;
    }


    public static boolean checkPKL(String input) {
        if (input.isBlank())
            return false;
        // Additional checks if needed
        return input.length() <= 32;
    }


    public static boolean checkPKLAS(String input) {
        if (input.isBlank())
            return false;
        // Additional checks if needed
        return input.length() == 1;
    }


    public static boolean checkPKLEA(String input) {
        if (input.isBlank())
            return false;
        // Additional checks if needed
        return input.length() <= 3;
    }


    public static boolean checkPKNAM(String input) {
        if (input.isBlank())
            return false;
        // Additional checks if needed
        return input.length() <= 128;
    }


    public static boolean checkRELFK(String input) {
        if (input.isBlank())
            return false;
        if (input.length() > 10)
            return false;
        try {
            int value = Integer.parseInt(input);
            // Additional checks if needed
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}