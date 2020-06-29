package com.lelyak.edu.utils;

import lombok.experimental.UtilityClass;

import java.util.Formatter;

@UtilityClass
public class StringUtils {

    public final String NEW_LINE = System.getProperty("line.separator");

    public String appendStrings(String message, Object... params) {
        try (Formatter format = new Formatter()) {
            return format.format(message, params).toString();
        }
    }
}
