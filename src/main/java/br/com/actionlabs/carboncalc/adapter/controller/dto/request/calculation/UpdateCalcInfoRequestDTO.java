package br.com.actionlabs.carboncalc.adapter.controller.dto.request.calculation;

import br.com.actionlabs.carboncalc.adapter.controller.dto.response.TransportationDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class UpdateCalcInfoRequestDTO {
  private String id;
  @NotNull
  @NotEmpty(message = "O consumo de energia não pode ser vazio.")
  private int energyConsumption;
  @NotNull
  @NotEmpty(message = "A lista de transporte não pode estar vazia.")
  private List<TransportationDTO> transportation;
  @NotNull
  @NotEmpty(message = "O valor de resíduo não reciclável não pode ser vazio.")
  private int solidRecycleWaste;
  @NotNull
  @NotEmpty(message = "O valor de resíduo reciclável não pode ser vazio.")
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
