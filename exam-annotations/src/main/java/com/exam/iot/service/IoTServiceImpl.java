package com.exam.iot.service;

import com.exam.iot.model.Device;
import com.exam.iot.model.Measurement;
import com.exam.iot.repository.DeviceRepository;
import com.exam.iot.repository.MeasurementRepository;
import com.exam.iot.service.exception.DeviceNotFoundException;
import com.exam.iot.service.exception.DuplicateTimestampException;
import com.exam.iot.service.exception.InvalidIntervalException;
import com.exam.iot.service.exception.OutOfRangeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class IoTServiceImpl implements IoTService {

    private final DeviceRepository deviceRepository;
    private final MeasurementRepository measurementRepository;

    // Inyeccion por constructor via @Autowired (desde Spring 4.3 es opcional si solo
    // hay un constructor, pero se deja explicito para que quede claro en el examen).
    @Autowired
    public IoTServiceImpl(DeviceRepository deviceRepository, MeasurementRepository measurementRepository) {
        this.deviceRepository = deviceRepository;
        this.measurementRepository = measurementRepository;
    }

    @Override
    public Measurement addMeasurement(Integer assetId, long timestamp, double valor) {
        Device device = deviceRepository.findById(assetId);
        if (device == null) {
            throw new DeviceNotFoundException("No existe un dispositivo con id " + assetId + ".");
        }

        // Regla 1: rango del dispositivo
        if (valor < device.getMinValue() || valor > device.getMaxValue()) {
            throw new OutOfRangeException("El valor " + valor + " esta fuera del rango permitido ["
                    + device.getMinValue() + ", " + device.getMaxValue() + "] para el dispositivo " + assetId + ".");
        }

        List<Measurement> existing = measurementRepository.findByAssetId(assetId);

        // Regla 2: timestamp duplicado para el mismo dispositivo
        boolean duplicated = existing.stream().anyMatch(m -> m.getTimestamp() == timestamp);
        if (duplicated) {
            throw new DuplicateTimestampException("Ya existe una medicion con timestamp " + timestamp
                    + " para el dispositivo " + assetId + ".");
        }

        // Regla 3: la diferencia respecto a la medicion anterior debe respetar samplingPeriod +/- timeTolerance
        Optional<Measurement> previous = existing.stream()
                .filter(m -> m.getTimestamp() < timestamp)
                .max((a, b) -> Long.compare(a.getTimestamp(), b.getTimestamp()));

        if (previous.isPresent()) {
            long diff = timestamp - previous.get().getTimestamp();
            long expected = device.getSamplingPeriod();
            long tolerance = device.getTimeTolerance();
            if (Math.abs(diff - expected) > tolerance) {
                throw new InvalidIntervalException("La diferencia de tiempo (" + diff
                        + " ms) respecto a la medicion anterior no esta dentro del rango permitido ("
                        + (expected - tolerance) + " - " + (expected + tolerance) + " ms).");
            }
        }

        Measurement measurement = new Measurement(measurementRepository.nextId(), timestamp, valor, assetId);
        return measurementRepository.save(measurement);
    }

    @Override
    public Collection<Measurement> getAllMeasurements() {
        return measurementRepository.findAll();
    }

    @Override
    public Device getDevice(Integer id) {
        return deviceRepository.findById(id);
    }
}
