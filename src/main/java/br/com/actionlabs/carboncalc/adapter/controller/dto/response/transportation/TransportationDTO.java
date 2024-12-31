package br.com.actionlabs.carboncalc.adapter.controller.dto.response.transportation;

import br.com.actionlabs.carboncalc.core.domain.transportationEmission.TransportationType;
import lombok.Data;

@Data
public class TransportationDTO {
  private TransportationType type;
  private int monthlyDistance;
}
