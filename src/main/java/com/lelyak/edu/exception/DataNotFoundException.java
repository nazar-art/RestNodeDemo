package com.lelyak.edu.exception;

import com.lelyak.edu.utils.StringUtils;

public class DataNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 0L;

    private static final String DATA_NOT_FOUND_EXCEPTION = "node with id: %1$s not found for %2$s node";

    public DataNotFoundException(long id, String nodeType) {
        super(StringUtils.appendStrings(DATA_NOT_FOUND_EXCEPTION, String.valueOf(id), nodeType));
    }
}
