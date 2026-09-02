package com.exam.iot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * VARIANTE 1: DI por anotaciones.
 * Spring escanea el paquete com.exam.iot buscando clases marcadas con
 * @Repository, @Service, @Component, etc. y arma el contexto solo.
 */
@Configuration
@ComponentScan(basePackages = "com.exam.iot")
public class AppConfig {
}
