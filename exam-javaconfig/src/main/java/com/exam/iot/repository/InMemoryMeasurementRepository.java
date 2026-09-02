package com.exam.iot.repository;

import com.exam.iot.model.Measurement;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InMemoryMeasurementRepository implements MeasurementRepository {

    private final Map<Integer, Measurement> storage = new ConcurrentHashMap<>();
    private final AtomicInteger idSequence = new AtomicInteger(0);

    public InMemoryMeasurementRepository() {
        Measurement m1 = new Measurement(idSequence.incrementAndGet(), 2000L, 25.5, 1);
        Measurement m2 = new Measurement(idSequence.incrementAndGet(), 4000L, 26.0, 1);
        storage.put(m1.getId(), m1);
        storage.put(m2.getId(), m2);
    }

    @Override
    public Measurement save(Measurement measurement) {
        if (measurement.getId() == null) {
            measurement.setId(idSequence.incrementAndGet());
        }
        storage.put(measurement.getId(), measurement);
        return measurement;
    }

    @Override
    public Collection<Measurement> findAll() {
        return storage.values();
    }

    @Override
    public List<Measurement> findByAssetId(Integer assetId) {
        return storage.values().stream()
                .filter(m -> m.getAssetId().equals(assetId))
                .collect(Collectors.toList());
    }

    @Override
    public int nextId() {
        return idSequence.incrementAndGet();
    }
}
