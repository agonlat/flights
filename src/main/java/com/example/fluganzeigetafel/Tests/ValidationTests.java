package com.example.fluganzeigetafel.Tests;

import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Flights.Data.Flight;
import com.example.fluganzeigetafel.Flights.Utility.ValidationUtil;
import org.junit.Test;
import org.junit.*;

public class ValidationTests {
    @Test
    public void testCheckTERValid() {
        boolean result = ValidationUtil.checkTER("1");
        Assert.assertTrue(result);
    }

    @Test
    public void testCheckTERInvalid() {
        boolean result = ValidationUtil.checkTER("3");
        Assert.assertFalse(result);
    }

    @Test
    public void testCheckSAAValid() {
        boolean result = ValidationUtil.checkSAA("20");
        Assert.assertTrue(result);
    }

    @Test
    public void testCheckSAAInvalid() {
        boolean result = ValidationUtil.checkSAA("100");
        Assert.assertFalse(result);
    }

    @Test
    public void testCheckFlightNumberFormatValid() {
        boolean result = ValidationUtil.checkFlightNumberFormat("LH 123");
        Assert.assertTrue(result);
    }

    @Test
    public void testCheckFlightNumberFormatInvalid() {
        boolean result = ValidationUtil.checkFlightNumberFormat("INVALID");
        Assert.assertFalse(result);
    }

    @Test
    public void testCheckFlightNumberExistenceExisting() {
        Flight existingFlight = new Flight();
        existingFlight.setKnr("515349");
        existingFlight.setFnr("LH132");
        DataInterface.getInstance().getFlights().add(existingFlight);

        Flight result = ValidationUtil.checkFlightNumberExistence("515349");
        Assert.assertNotNull(result);
        Assert.assertEquals(existingFlight.getKnr().trim(), result.getKnr().trim());
    }

    @Test
    public void testCheckFlightNumberExistenceNonExisting() {
        Flight result = ValidationUtil.checkFlightNumberExistence("NonExisting");
        Assert.assertNull(result);
    }

    @Test
    public void testCheckNewInternalTimeFormatValid() {
        boolean result = ValidationUtil.checkNewInternalTimeFormat("01.01.2023 12:00:00");
        Assert.assertTrue(result);
    }

    @Test
    public void testCheckNewInternalTimeFormatInvalid() {
        boolean result = ValidationUtil.checkNewInternalTimeFormat("INVALID_FORMAT");
        Assert.assertFalse(result);
    }

    @Test
    public void testCheckNewInternalTimeValueValid() {
        boolean result = ValidationUtil.checkNewInternalTimeValue("01.01.2023 12:00:00", "01.01.2023 14:30:00");
        Assert.assertTrue(result);
    }

    @Test
    public void testCheckNewInternalTimeValueInvalid() {
        boolean result = ValidationUtil.checkNewInternalTimeValue("01.01.2023 12:30:00", "01.01.2023 12.00:00");
        Assert.assertFalse(result);
    }

    @Test
    public void testCheckNewPositionValid() {
        boolean result = ValidationUtil.checkNewPosition("123A");
        Assert.assertTrue(result);
    }

    @Test
    public void testCheckNewPositionInvalid() {
        boolean result = ValidationUtil.checkNewPosition("INVALID");
        Assert.assertFalse(result);
    }
}
