package com.example.fluganzeigetafel.Orders.Suborders;

import com.example.fluganzeigetafel.DataInterface;

import java.util.Random;

public class Utils {
    public static String generateUAKEY() {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            builder.append(random.nextInt(10));
        }

        for (String key : DataInterface.getInstance().getUakeyDatabase()) {
            if (key.trim().equals(builder.toString())) {
                return String.valueOf(Integer.parseInt(builder.toString()) + 1);
            }
        }

        return  builder.toString();
    }
}
