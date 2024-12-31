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
}
