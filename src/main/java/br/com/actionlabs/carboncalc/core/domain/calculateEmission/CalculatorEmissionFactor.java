package br.com.actionlabs.carboncalc.core.domain.calculateEmission;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("calculatorEmissionFactor")
public class CalculatorEmissionFactor {
    @Id
    private String id; // ID único do cálculo
    private String name;
    private String email;
    private String phoneNumber;
    private String uf;
    private String typeEmission;
    private double energyConsumption;
    private double transportEmission;
    private double recyclableWaste;
    private double nonRecyclableWaste;
    private LocalDateTime createdAt;

    public CalculatorEmissionFactor(String name, String email, String phoneNumber, String uf) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.uf = uf;
    }
    public CalculatorEmissionFactor(
            String id,
            String name,
            String email,
            String phoneNumber,
            String uf,
            String typeEmission,
            double energyConsumption,
            double transportEmission,
            double recyclableWaste,
            double nonRecyclableWaste,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.uf = uf;
        this.typeEmission = typeEmission;
        this.energyConsumption = energyConsumption;
        this.transportEmission = transportEmission;
        this.recyclableWaste = recyclableWaste;
        this.nonRecyclableWaste = nonRecyclableWaste;
        this.createdAt = createdAt;
    }

    public CalculatorEmissionFactor() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTypeEmission() {
        return typeEmission;
    }

    public void setTypeEmission(String typeEmission) {
        this.typeEmission = typeEmission;
    }

    public double getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(double energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    public double getTransportEmission() {
        return transportEmission;
    }

    public void setTransportEmission(double transportEmission) {
        this.transportEmission = transportEmission;
    }

    public double getRecyclableWaste() {
        return recyclableWaste;
    }

    public void setRecyclableWaste(double recyclableWaste) {
        this.recyclableWaste = recyclableWaste;
    }

    public double getNonRecyclableWaste() {
        return nonRecyclableWaste;
    }

    public void setNonRecyclableWaste(double nonRecyclableWaste) {
        this.nonRecyclableWaste = nonRecyclableWaste;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}