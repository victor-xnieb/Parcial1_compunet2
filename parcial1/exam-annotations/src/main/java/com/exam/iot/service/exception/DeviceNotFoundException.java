package com.exam.iot.service.exception;

/** Se lanza cuando se intenta registrar una medicion para un dispositivo que no existe. */
public class DeviceNotFoundException extends RuntimeException {
    public DeviceNotFoundException(String message) {
        super(message);
    }
}
