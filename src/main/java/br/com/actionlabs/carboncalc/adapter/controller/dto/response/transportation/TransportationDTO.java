package br.com.actionlabs.carboncalc.adapter.controller.dto.response.transportation;

import br.com.actionlabs.carboncalc.core.domain.transportationEmission.TransportationType;
import lombok.Data;

@Data
public class TransportationDTO {
  private TransportationType type;
  private int monthlyDistance;

  public TransportationDTO(TransportationType type, int monthlyDistance) {
    this.type = type;
    this.monthlyDistance = monthlyDistance;
  }

  public TransportationType getType() {
    return type;
  }

  public void setType(TransportationType type) {
    this.type = type;
  }

  public int getMonthlyDistance() {
    return monthlyDistance;
  }

  public void setMonthlyDistance(int monthlyDistance) {
    this.monthlyDistance = monthlyDistance;
  }
}
