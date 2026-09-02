package com.exam.iot.service.exception;

/** Se lanza cuando el valor de una medición esta fuera del rango [minValue, maxValue] del dispositivo. */
public class OutOfRangeException extends RuntimeException {
    public OutOfRangeException(String message) {
        super(message);
    }
}
