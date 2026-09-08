package com.exam.iot.repository;

import com.exam.iot.model.Measurement;

import java.util.Collection;
import java.util.List;

public interface MeasurementRepository {
    Measurement save(Measurement measurement);
    Collection<Measurement> findAll();
    List<Measurement> findByAssetId(Integer assetId);
    int nextId();
}
