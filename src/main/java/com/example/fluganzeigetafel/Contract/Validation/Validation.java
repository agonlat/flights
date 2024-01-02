package com.example.fluganzeigetafel.Contract.Validation;

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
        return input.length() <= 10;
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
