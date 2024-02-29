package com.dera.exceptions;

public class NullArgumentException extends IllegalArgumentException {
    public NullArgumentException(String message) {
        super(message);
    }
}
