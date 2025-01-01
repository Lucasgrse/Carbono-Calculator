package br.com.actionlabs.carboncalc.adapter.controller.dto.request.calculation;

import br.com.actionlabs.carboncalc.adapter.controller.dto.response.TransportationDTO;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class UpdateCalculatorCarbonRequestDTO {
  private String id;
  @Min(value = 1, message = "O consumo de energia deve ser maior que zero.")
  private int energyConsumption;
  @NotNull(message = "A lista de transporte não pode ser nula.")
  @NotEmpty(message = "A lista de transporte deve conter ao menos um item.")
  private List<TransportationDTO> transportation;
  @Min(value = 0, message = "O valor de resíduo reciclável não pode ser negativo.")
  private int solidRecycleWaste;
  @Min(value = 0, message = "O valor de resíduo não reciclável não pode ser negativo.")
  private double solidNonRecycleWaste;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getEnergyConsumption() {
    return energyConsumption;
  }

  public List<TransportationDTO> getTransportation() {
    return transportation;
  }

  public int getSolidRecycleWaste() {
    return solidRecycleWaste;
  }

  public double getSolidNonRecycleWaste() {
    return solidNonRecycleWaste;
  }
}
