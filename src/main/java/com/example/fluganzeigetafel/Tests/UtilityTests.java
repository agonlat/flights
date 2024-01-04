package com.example.fluganzeigetafel.Tests;

import com.example.fluganzeigetafel.Flights.Utility.UtilityMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class UtilityTests {

    @Test
    public void testGetAirlineCode() {
        // X3 45, LH 23, SRR4114, 4567887
        String firstTest = UtilityMethods.getAirlineCode("X3 45");
        String secondTest = UtilityMethods.getAirlineCode("LH 23");
        String thirdTest = UtilityMethods.getAirlineCode("SRR4114");
        String fourthTest = UtilityMethods.getAirlineCode("4567887");

        Assertions.assertEquals("X3", firstTest);
        Assertions.assertEquals("LH", secondTest);
        Assertions.assertEquals("SRR", thirdTest);
        Assertions.assertEquals("456", fourthTest);
        Assertions.assertEquals("", "");

    }

    public void testLeaveOneWhiteSpace() {
        String firstTest = UtilityMethods.leaveOneWhiteSpace("X3  45");
        Assertions.assertEquals("X3  45", firstTest);
    }

}
