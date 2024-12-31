package br.com.actionlabs.carboncalc.adapter.controller.dto.request.calculation;

import lombok.Data;

@Data
public class StartCalcRequestDTO {
  private String name;
  private String email;
  private String uf;
  private String phoneNumber;
}
