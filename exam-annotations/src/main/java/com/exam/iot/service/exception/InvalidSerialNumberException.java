package com.exam.iot.service.exception;

/** Se lanza cuando el serialNumber de un dispositivo supera los 20 caracteres. */
public class InvalidSerialNumberException extends RuntimeException {
    public InvalidSerialNumberException(String message) {
        super(message);
    }
}
