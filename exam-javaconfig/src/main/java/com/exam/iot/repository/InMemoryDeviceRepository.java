package com.exam.iot.repository;

import com.exam.iot.model.Device;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// VARIANTE 2: sin anotaciones @Repository. Es un POJO normal;
// el "bean" se declara y se instancia desde beans.xml.
public class InMemoryDeviceRepository implements DeviceRepository {

    private final Map<Integer, Device> storage = new ConcurrentHashMap<>();

    public InMemoryDeviceRepository() {
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
