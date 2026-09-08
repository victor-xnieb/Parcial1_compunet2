package com.exam.iot.model;

/**
 * Representa una medición generada por un dispositivo IoT.
 */
public class Measurement {

    private Integer id;
    private long timestamp;
    private double valor;
    private Integer assetId; // id del dispositivo, nombrado "assetId" segun el enunciado

    public Measurement() {
    }

    public Measurement(Integer id, long timestamp, double valor, Integer assetId) {
        this.id = id;
        this.timestamp = timestamp;
        this.valor = valor;
        this.assetId = assetId;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public Integer getAssetId() { return assetId; }
    public void setAssetId(Integer assetId) { this.assetId = assetId; }

    @Override
    public String toString() {
        return "Measurement{id=" + id + ", timestamp=" + timestamp + ", valor=" + valor +
                ", assetId=" + assetId + "}";
    }
}
