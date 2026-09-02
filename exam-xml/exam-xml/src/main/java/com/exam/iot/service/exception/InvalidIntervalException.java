package com.exam.iot.service.exception;

/** Se lanza cuando la diferencia de tiempo respecto a la medicion anterior no cumple samplingPeriod +/- timeTolerance. */
public class InvalidIntervalException extends RuntimeException {
    public InvalidIntervalException(String message) {
        super(message);
    }
}
