package br.com.actionlabs.carboncalc.core.usecase.calculator.input;

import br.com.actionlabs.carboncalc.adapter.controller.dto.response.TransportationDTO;

import java.util.List;

public class UpdateCalculatorCarbonInput {
    private String id;
    private int energyConsumption;
    private List<TransportationDTO> transportation;
    private int solidWasteTotal;
    private double recyclePercentage;

    public UpdateCalculatorCarbonInput(String id, int energyConsumption, List<TransportationDTO> transportation, int solidWasteTotal, double recyclePercentage) {
        this.id = id;
        this.energyConsumption = energyConsumption;
        this.transportation = transportation;
        this.solidWasteTotal = solidWasteTotal;
        this.recyclePercentage = recyclePercentage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(int energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    public List<TransportationDTO> getTransportation() {
        return transportation;
    }

    public void setTransportation(List<TransportationDTO> transportation) {
        this.transportation = transportation;
    }

    public int getSolidWasteTotal() {
        return solidWasteTotal;
    }

    public void setSolidWasteTotal(int solidWasteTotal) {
        this.solidWasteTotal = solidWasteTotal;
    }

    public double getRecyclePercentage() {
        return recyclePercentage;
    }

    public void setRecyclePercentage(double recyclePercentage) {
        this.recyclePercentage = recyclePercentage;
    }

}
