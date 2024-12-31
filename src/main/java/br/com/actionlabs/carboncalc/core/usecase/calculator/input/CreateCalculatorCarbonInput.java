package br.com.actionlabs.carboncalc.core.usecase.calculator.input;

import br.com.actionlabs.carboncalc.core.domain.transportationEmission.TransportationType;

public class CreateCalculatorCarbonInput {
    private String name;
    private String email;
    private String phoneNumber;
    private String uf;
    public double energyConsumption;
    public TransportationType transportType;
    public double distance;
    public double wasteProduction;

    public CreateCalculatorCarbonInput(
            String name,
            String email,
            String phoneNumber,
            String uf,
            double energyConsumption,
            TransportationType transportType,
            double distance,
            double wasteProduction
    ) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.uf = uf;
        this.energyConsumption = energyConsumption;
        this.transportType = transportType;
        this.distance = distance;
        this.wasteProduction = wasteProduction;
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
}
