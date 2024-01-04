package com.example.fluganzeigetafel.Tests;

import com.example.fluganzeigetafel.Flights.Utility.TimeHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeHandlerTests {
    @Test
    public void  testGetTimeCorrect() {
        String time1 = TimeHandler.getTime("20.12.2023 16:11:45");
        Assertions.assertEquals("16:11:45", time1);
    }

    @Test
    public void  testGetTimeIncorrectTime() {
        String time1 = TimeHandler.getTime("20.12.2023  6:11:45");
        Assertions.assertEquals("20.12.2023  6:11:45", time1);
    }

    @Test
    public void  testGetTimeIncorrectDate() {
        String time1 = TimeHandler.getTime("20.12.223  16:11:45");
        Assertions.assertEquals("20.12.223  16:11:45", time1);
    }

    @Test
    public void testGetActualDate() {
        String actualDate = TimeHandler.getActualDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String expectedDate = dateFormat.format(new Date());
        Assertions.assertEquals(expectedDate, actualDate);
    }

    @Test
    public void testGetUTC() {
        String input = "25.12.2023 10:30:00";
        String expectedUTC = "2023-12-25T09:30:00Z";

        String actualUTC = TimeHandler.getUTC(input);

        Assertions.assertEquals(expectedUTC, actualUTC);
    }

    @Test
    public void testGetLocalTimeFromUTC() {
        String inputUTC = "2023-12-25T09:30:00Z";
        String expectedLocalTime = "25.12.2023 10:30:00";

        String actualLocalTime = TimeHandler.getLocalTimeFromUTC(inputUTC);

        Assertions.assertEquals(expectedLocalTime, actualLocalTime);
    }

    @Test
    public void testGetLocalTimeFromUTCInvalidInput() {
        String invalidInput = "invalid_utc_format";
        String result = TimeHandler.getLocalTimeFromUTC(invalidInput);
        Assertions.assertEquals(invalidInput, result);
    }

}
