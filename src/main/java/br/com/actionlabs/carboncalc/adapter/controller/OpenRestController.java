package br.com.actionlabs.carboncalc.adapter.controller;

import br.com.actionlabs.carboncalc.adapter.controller.dto.request.calculation.CarbonCalculationResultDTO;
import br.com.actionlabs.carboncalc.adapter.controller.dto.request.calculation.StartCalcRequestDTO;
import br.com.actionlabs.carboncalc.adapter.controller.dto.request.calculation.UpdateCalcInfoRequestDTO;
import br.com.actionlabs.carboncalc.adapter.controller.dto.response.calculation.StartCalcResponseDTO;
import br.com.actionlabs.carboncalc.adapter.controller.dto.response.calculation.UpdateCalcInfoResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/open")
@RequiredArgsConstructor
@Slf4j
public class OpenRestController {

  @PostMapping("start-calc")
  public ResponseEntity<StartCalcResponseDTO> startCalculation(
      @RequestBody StartCalcRequestDTO request) {
    throw new RuntimeException("Not implemented");
  }

  @PutMapping("info")
  public ResponseEntity<UpdateCalcInfoResponseDTO> updateInfo(
      @RequestBody UpdateCalcInfoRequestDTO request) {
    throw new RuntimeException("Not implemented");
  }

  @GetMapping("result/{id}")
  public ResponseEntity<CarbonCalculationResultDTO> getResult(@PathVariable String id) {
    throw new RuntimeException("Not implemented");
  }
}
