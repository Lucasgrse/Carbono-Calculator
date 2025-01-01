package br.com.actionlabs.carboncalc.adapter.controller.dto.request.calculation;

import br.com.actionlabs.carboncalc.core.domain.transportationEmission.TransportationType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CalculatorCarbonRequestDTO {
    @NotNull
    @NotEmpty(message = "O campo nome não pode ser vazio.")
    private String name;
    @NotNull
    @NotEmpty(message = "O campo email não pode ser vazio.")
    private String email;
    @NotNull
    @NotEmpty(message = "O campo estado não pode ser vazio.")
    private String uf;
    @NotNull
    @NotEmpty(message = "O campo telefone não pode ser vazio.")
    private String phoneNumber;
    public double energyConsumption;
    public TransportationType type;
    public double distance;
    public double wasteProduction;

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getUf() {
    return uf;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }
}
