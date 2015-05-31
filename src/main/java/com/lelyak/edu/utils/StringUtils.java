package com.lelyak.edu.utils;

import java.util.Formatter;

public final class StringUtils {

    public static final String NEW_LINE = System.getProperty("line.separator");

    private StringUtils() {
    }

    public static String appendStrings(String message, Object... params) {
        try (Formatter format = new Formatter()) {
            return format.format(message, params).toString();
        }
    }
}
