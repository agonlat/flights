package com.example.fluganzeigetafel.Tests;

import com.example.fluganzeigetafel.Flights.Data.Flight;
import com.example.fluganzeigetafel.Flights.Handler.FileHandler;
import com.example.fluganzeigetafel.Flights.Utility.TimeHandler;
import org.junit.*;

import java.util.ArrayList;

public class FlightsFileHandlerTests {
    @Test
    public void testReadCSV_File() {
        FileHandler handler = new FileHandler();
        ArrayList<Flight> flights = handler.readCSV_File("src/main/resources/testFlightsCSV.csv");

        // Assuming the content of "testFlightsCSV.csv" file matches the provided data
        Flight firstFlight = flights.get(0);
        Assert.assertEquals("LH 2309", firstFlight.getFnr());
        Assert.assertEquals("515349", firstFlight.getKnr());
        Assert.assertEquals("DAILA", firstFlight.getReg());
        Assert.assertEquals("A319", firstFlight.getTyp());
        Assert.assertEquals("", firstFlight.getHa0());
        Assert.assertEquals("F", firstFlight.getLsk());
        Assert.assertEquals(TimeHandler.getActualDate()+" 00:00:00", firstFlight.getStt());
        Assert.assertEquals(TimeHandler.getActualDate()+" 00:20:00", firstFlight.getItt());
        Assert.assertEquals("210B", firstFlight.getPos());
        Assert.assertEquals("", firstFlight.getTer());
        Assert.assertEquals("GH", firstFlight.getMad());
        Assert.assertEquals("88", firstFlight.getSaa());

        Flight secondFlight = flights.get(1);
        Assert.assertEquals("DE  154E", secondFlight.getFnr());
        Assert.assertEquals("386634", secondFlight.getKnr());
        Assert.assertEquals("DAICG", secondFlight.getReg());
        Assert.assertEquals("A320", secondFlight.getTyp());
        Assert.assertEquals("", secondFlight.getHa0());
        Assert.assertEquals("GH", secondFlight.getMad());
        Assert.assertEquals(TimeHandler.getActualDate()+" 03:55:00", secondFlight.getStt());
        Assert.assertEquals(TimeHandler.getActualDate()+" 02:42:00", secondFlight.getItt());
        Assert.assertEquals("H41B", secondFlight.getPos());
        Assert.assertEquals("", secondFlight.getTer());
        Assert.assertEquals("GH", secondFlight.getMad());
        Assert.assertEquals("88", secondFlight.getSaa());

    }




}
