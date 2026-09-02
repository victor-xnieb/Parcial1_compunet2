package com.exam.iot.service.exception;

/** Se lanza cuando ya existe una medicion con el mismo timestamp para el mismo dispositivo. */
public class DuplicateTimestampException extends RuntimeException {
    public DuplicateTimestampException(String message) {
        super(message);
    }
}
