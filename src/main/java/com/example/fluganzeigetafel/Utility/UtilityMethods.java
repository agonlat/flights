package com.example.fluganzeigetafel.Utility;



public class UtilityMethods {
    public static String getAirlineCode(String input) {
        // X3 45, LH 23, SRR4114, 4567887
        if (input.isBlank()) {
            return "";
        }

        String airline = "";

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == ' ') {
                return airline;
            }

            if (i == 3 && !Character.isDigit(input.charAt(i - 1)) && Character.isDigit(currentChar)) {
                return airline+""+currentChar;
            }

            if (i == 2 && Character.isDigit(input.charAt(i + 1))) {
                return airline+ currentChar;
            }

            airline = airline + currentChar;
        }

        return airline;
    }
}
