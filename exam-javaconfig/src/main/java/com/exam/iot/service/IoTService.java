package com.exam.iot.service;

import com.exam.iot.model.Device;
import com.exam.iot.model.Measurement;

import java.util.Collection;

public interface IoTService {

    /**
     * Registra una nueva medicion para el dispositivo indicado, validando
     * todas las reglas de negocio del enunciado.
     */
    Measurement addMeasurement(Integer assetId, long timestamp, double valor);

    Collection<Measurement> getAllMeasurements();

    Device getDevice(Integer id);
}
