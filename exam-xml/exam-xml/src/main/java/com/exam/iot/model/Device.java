package com.exam.iot.model;

/**
 * Representa un dispositivo IoT registrado en el sistema.
 */
public class Device {

    private Integer id;
    private String name;
    private String serialNumber;
    private String type;
    private double maxValue;
    private double minValue;
    private long samplingPeriod;   // ms entre mediciones esperadas
    private long timeTolerance;    // ms de tolerancia respecto al samplingPeriod
    private String unit;
    private String ubicacion;      // "Ubicación" pedido en el enunciado
    private String estado;         // "Estate" pedido en el enunciado (estado del dispositivo)

    public Device() {
    }

    public Device(Integer id, String name, String serialNumber, String type,
                  double maxValue, double minValue, long samplingPeriod, long timeTolerance,
                  String unit, String ubicacion, String estado) {
        this.id = id;
        this.name = name;
        this.serialNumber = serialNumber;
        this.type = type;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.samplingPeriod = samplingPeriod;
        this.timeTolerance = timeTolerance;
        this.unit = unit;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getMaxValue() { return maxValue; }
    public void setMaxValue(double maxValue) { this.maxValue = maxValue; }

    public double getMinValue() { return minValue; }
    public void setMinValue(double minValue) { this.minValue = minValue; }

    public long getSamplingPeriod() { return samplingPeriod; }
    public void setSamplingPeriod(long samplingPeriod) { this.samplingPeriod = samplingPeriod; }

    public long getTimeTolerance() { return timeTolerance; }
    public void setTimeTolerance(long timeTolerance) { this.timeTolerance = timeTolerance; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Device{id=" + id + ", name='" + name + "', serialNumber='" + serialNumber +
                "', type='" + type + "', unit='" + unit + "'}";
    }
}
