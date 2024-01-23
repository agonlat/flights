package com.example.fluganzeigetafel.Tests;

import com.example.fluganzeigetafel.Flights.Utility.UtilityMethods;
import org.junit.Test;
import org.junit.*;


public class UtilityTests {

    @Test
    public void testGetAirlineCode() {
        // X3 45, LH 23, SRR4114, 4567887
        String firstTest = UtilityMethods.getAirlineCode("X3 45");
        String secondTest = UtilityMethods.getAirlineCode("LH 23");
        String thirdTest = UtilityMethods.getAirlineCode("SRR4114");
        String fourthTest = UtilityMethods.getAirlineCode("4567887");

        Assert.assertEquals("X3", firstTest);
        Assert.assertEquals("LH", secondTest);
        Assert.assertEquals("SRR", thirdTest);
        Assert.assertEquals("456", fourthTest);
        Assert.assertEquals("", "");

    }

    @Test
    public void testLeaveOneWhiteSpace() {
        String firstTest = UtilityMethods.leaveOneWhiteSpace("X3  45");
        Assert.assertEquals("X3 45", firstTest);
    }

}
