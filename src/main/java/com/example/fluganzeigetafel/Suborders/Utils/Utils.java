package com.example.fluganzeigetafel.Suborders.Utils;

import com.example.fluganzeigetafel.DataInterface;

import java.util.Random;

/**
 * This class is used for Utility methods, making the work more convenient.
 */
public class Utils {
    /**
     * Creates a unique UAKEY for Suborder.
     * If the generated key is already existent, plus one is added to preserve the uniqueness.
     * @return Unique UAKEY as a String
     */
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