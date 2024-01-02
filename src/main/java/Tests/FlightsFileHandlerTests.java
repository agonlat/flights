package Tests;

import com.example.fluganzeigetafel.Flights.Data.Flight;
import com.example.fluganzeigetafel.Flights.Handler.FileHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class FlightsFileHandlerTests {
    @Test
    public void testReadCSV_File() {
        FileHandler handler = new FileHandler();
        ArrayList<Flight> flights = handler.readCSV_File("testFlightsCSV.csv");

        // Assuming the content of "testFlightsCSV.csv" file matches the provided data
        Flight firstFlight = flights.get(0);
        Assertions.assertEquals("LH 2309", firstFlight.getFnr());
        Assertions.assertEquals("515349", firstFlight.getKnr());
        Assertions.assertEquals("DAILA", firstFlight.getReg());
        Assertions.assertEquals("A319", firstFlight.getTyp());
        Assertions.assertEquals("", firstFlight.getHa0());
        Assertions.assertEquals("F", firstFlight.getLsk());
        Assertions.assertEquals("16.10.2023 00:00:00", firstFlight.getStt());
        Assertions.assertEquals("16.10.2023 00:20:00", firstFlight.getItt());
        Assertions.assertEquals("210B", firstFlight.getPos());
        Assertions.assertEquals("", firstFlight.getTer());
        Assertions.assertEquals("GH", firstFlight.getMad());
        Assertions.assertEquals("88", firstFlight.getSaa());

        Flight secondFlight = flights.get(1);
        Assertions.assertEquals("DE  154E", secondFlight.getFnr());
        Assertions.assertEquals("386634", secondFlight.getKnr());
        Assertions.assertEquals("DAICG", secondFlight.getReg());
        Assertions.assertEquals("A320", secondFlight.getTyp());
        Assertions.assertEquals("", secondFlight.getHa0());
        Assertions.assertEquals("F", secondFlight.getSaa());
        Assertions.assertEquals("16.10.2023 03:55:00", secondFlight.getStt());
        Assertions.assertEquals("16.10.2023 02:42:00", secondFlight.getItt());
        Assertions.assertEquals("H41B", secondFlight.getPos());
        Assertions.assertEquals("", secondFlight.getTer());
        Assertions.assertEquals("GH", secondFlight.getMad());
        Assertions.assertEquals("88", secondFlight.getSaa());

    }




}
