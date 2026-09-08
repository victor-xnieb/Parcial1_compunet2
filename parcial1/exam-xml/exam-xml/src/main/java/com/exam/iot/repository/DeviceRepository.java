package com.exam.iot.repository;

import com.exam.iot.model.Device;

import java.util.Collection;

public interface DeviceRepository {
    Device findById(Integer id);
    Collection<Device> findAll();
    Device save(Device device);
}
