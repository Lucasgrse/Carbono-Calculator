package br.com.actionlabs.carboncalc.adapter.controller.dto.request.calculation;

import br.com.actionlabs.carboncalc.core.domain.transportationEmission.TransportationType;
import lombok.Data;

@Data
public class StartCalcRequestDTO {
    private String name;
    private String email;
    private String uf;
    private String phoneNumber;
    public double energyConsumption;
    public TransportationType type;
    public double distance;
    public double wasteProduction;

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

  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}
