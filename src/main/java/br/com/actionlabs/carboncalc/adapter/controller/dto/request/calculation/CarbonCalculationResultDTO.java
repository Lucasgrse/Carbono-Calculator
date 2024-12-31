package br.com.actionlabs.carboncalc.adapter.controller.dto.request.calculation;

import lombok.Data;

@Data
public class CarbonCalculationResultDTO {
  private double energy;
  private double transportation;
  private double solidWaste;
  private double total;
}
