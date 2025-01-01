package br.com.actionlabs.carboncalc.adapter.controller.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CalculatorCarbonResponseDTO {
    private String id;
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

    public CalculatorCarbonResponseDTO(
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
}
