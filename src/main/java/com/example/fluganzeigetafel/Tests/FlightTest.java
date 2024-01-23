package com.example.fluganzeigetafel.Tests;

import com.example.fluganzeigetafel.Flights.Data.Flight;
import org.junit.Test;
import org.junit.*;

public class FlightTest {
    @Test
    public void testFlightGettersAndSetters() {
        // Create a Flight instance
        Flight flight = new Flight();

        // Set values using setter methods
        flight.setFnr("F123");
        flight.setKnr("K456");
        flight.setReg("ABC123");
        flight.setTyp("Boeing 737");
        flight.setHa0("HA123");
        flight.setLsk("LSK456");
        flight.setStt("Scheduled");
        flight.setItt("2023-12-20T12:00:00Z");
        flight.setPos("123A");
        flight.setTer("1");
        flight.setMad("MAD123");
        flight.setSaa("01");

        // Test getter methods
        Assert.assertEquals("F123", flight.getFnr());
        Assert.assertEquals("K456", flight.getKnr());
        Assert.assertEquals("ABC123", flight.getReg());
        Assert.assertEquals("Boeing 737", flight.getTyp());
        Assert.assertEquals("HA123", flight.getHa0());
        Assert.assertEquals("LSK456", flight.getLsk());
        Assert.assertEquals("Scheduled", flight.getStt());
        Assert.assertEquals("2023-12-20T12:00:00Z", flight.getItt());
        Assert.assertEquals("123A", flight.getPos());
        Assert.assertEquals("1", flight.getTer());
        Assert.assertEquals("MAD123", flight.getMad());
        Assert.assertEquals("01", flight.getSaa());
    }
}
