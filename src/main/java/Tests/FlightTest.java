package Tests;

import com.example.fluganzeigetafel.Flights.Data.Flight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        Assertions.assertEquals("F123", flight.getFnr());
        Assertions.assertEquals("K456", flight.getKnr());
        Assertions.assertEquals("ABC123", flight.getReg());
        Assertions.assertEquals("Boeing 737", flight.getTyp());
        Assertions.assertEquals("HA123", flight.getHa0());
        Assertions.assertEquals("LSK456", flight.getLsk());
        Assertions.assertEquals("Scheduled", flight.getStt());
        Assertions.assertEquals("2023-12-20T12:00:00Z", flight.getItt());
        Assertions.assertEquals("123A", flight.getPos());
        Assertions.assertEquals("1", flight.getTer());
        Assertions.assertEquals("MAD123", flight.getMad());
        Assertions.assertEquals("01", flight.getSaa());
    }
}
