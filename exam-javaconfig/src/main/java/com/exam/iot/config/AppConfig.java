package com.exam.iot.config;

import com.exam.iot.repository.DeviceRepository;
import com.exam.iot.repository.InMemoryDeviceRepository;
import com.exam.iot.repository.InMemoryMeasurementRepository;
import com.exam.iot.repository.MeasurementRepository;
import com.exam.iot.service.IoTService;
import com.exam.iot.service.IoTServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * VARIANTE 3: Java Config. Aqui no hay @ComponentScan: cada bean se crea
 * a mano dentro de un metodo @Bean, y la inyeccion se hace pasando el
 * resultado de un @Bean como parametro de otro (Spring resuelve el orden solo).
 */
@Configuration
public class AppConfig {

    @Bean
    public DeviceRepository deviceRepository() {
        return new InMemoryDeviceRepository();
    }

    @Bean
    public MeasurementRepository measurementRepository() {
        return new InMemoryMeasurementRepository();
    }

    @Bean
    public IoTService ioTService(DeviceRepository deviceRepository, MeasurementRepository measurementRepository) {
        return new IoTServiceImpl(deviceRepository, measurementRepository);
    }
}
