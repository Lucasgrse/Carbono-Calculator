package br.com.actionlabs.carboncalc.adapter.controller.dto.request.calculation;

import br.com.actionlabs.carboncalc.adapter.controller.dto.response.transportation.TransportationDTO;
import lombok.Data;

import java.util.List;

@Data
public class UpdateCalcInfoRequestDTO {
  private String id;
  private int energyConsumption;
  private List<TransportationDTO> transportation;
  private int solidWasteTotal;
  private double recyclePercentage;

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
