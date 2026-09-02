package com.exam.iot.repository;

import com.exam.iot.model.Device;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryDeviceRepository implements DeviceRepository {

    private final Map<Integer, Device> storage = new ConcurrentHashMap<>();

    public InMemoryDeviceRepository() {
        // Seed: al menos 1 dispositivo, como pide el enunciado.
        Device seed = new Device(
                1,
                "Temp_Reactor_Principal",
                "TMP-AX34-7789",
                "sensor de temperatura",
                300.0,
                -100.0,
                2000L,
                200L,
                "celsius",
                "Planta 1 - Reactor A",
                "Activo"
        );
        storage.put(seed.getId(), seed);
    }

    @Override
    public Device findById(Integer id) {
        return storage.get(id);
    }

    @Override
    public Collection<Device> findAll() {
        return storage.values();
    }

    @Override
    public Device save(Device device) {
        storage.put(device.getId(), device);
        return device;
    }
}
