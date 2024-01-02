package Tests;

import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Flights.Data.Flight;
import com.example.fluganzeigetafel.Flights.Utility.ValidationUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidationTests {
    @Test
    public void testCheckTERValid() {
        boolean result = ValidationUtil.checkTER("1");
        Assertions.assertTrue(result);
    }

    @Test
    public void testCheckTERInvalid() {
        boolean result = ValidationUtil.checkTER("3");
        Assertions.assertFalse(result);
    }

    @Test
    public void testCheckSAAValid() {
        boolean result = ValidationUtil.checkSAA("20");
        Assertions.assertTrue(result);
    }

    @Test
    public void testCheckSAAInvalid() {
        boolean result = ValidationUtil.checkSAA("100");
        Assertions.assertFalse(result);
    }

    @Test
    public void testCheckFlightNumberFormatValid() {
        boolean result = ValidationUtil.checkFlightNumberFormat("LH123");
        Assertions.assertTrue(result);
    }

    @Test
    public void testCheckFlightNumberFormatInvalid() {
        boolean result = ValidationUtil.checkFlightNumberFormat("INVALID");
        Assertions.assertFalse(result);
    }

    @Test
    public void testCheckFlightNumberExistenceExisting() {
        Flight existingFlight = new Flight();
        existingFlight.setFnr("LH123");
        DataInterface.getInstance().getFlights().add(existingFlight);

        Flight result = ValidationUtil.checkFlightNumberExistence("LH123");
        Assertions.assertEquals(existingFlight, result);
    }

    @Test
    public void testCheckFlightNumberExistenceNonExisting() {
        Flight result = ValidationUtil.checkFlightNumberExistence("NonExisting");
        Assertions.assertNull(result);
    }

    @Test
    public void testCheckNewInternalTimeFormatValid() {
        boolean result = ValidationUtil.checkNewInternalTimeFormat("01.01.2023 12:00:00");
        Assertions.assertTrue(result);
    }

    @Test
    public void testCheckNewInternalTimeFormatInvalid() {
        boolean result = ValidationUtil.checkNewInternalTimeFormat("INVALID_FORMAT");
        Assertions.assertFalse(result);
    }

    @Test
    public void testCheckNewInternalTimeValueValid() {
        boolean result = ValidationUtil.checkNewInternalTimeValue("01.01.2023 12:00:00", "01.01.2023 12:30:00");
        Assertions.assertTrue(result);
    }

    @Test
    public void testCheckNewInternalTimeValueInvalid() {
        boolean result = ValidationUtil.checkNewInternalTimeValue("01.01.2023 12:30:00", "01.01.2023 12:00:00");
        Assertions.assertFalse(result);
    }

    @Test
    public void testCheckNewPositionValid() {
        boolean result = ValidationUtil.checkNewPosition("123A");
        Assertions.assertTrue(result);
    }

    @Test
    public void testCheckNewPositionInvalid() {
        boolean result = ValidationUtil.checkNewPosition("INVALID");
        Assertions.assertFalse(result);
    }
}
