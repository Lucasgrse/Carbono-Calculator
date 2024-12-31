package br.com.actionlabs.carboncalc.adapter.controller;

import br.com.actionlabs.carboncalc.adapter.controller.dto.request.calculation.CarbonCalculationResultDTO;
import br.com.actionlabs.carboncalc.adapter.controller.dto.request.calculation.StartCalcRequestDTO;
import br.com.actionlabs.carboncalc.adapter.controller.dto.request.calculation.UpdateCalcInfoRequestDTO;
import br.com.actionlabs.carboncalc.adapter.controller.dto.response.calculation.UpdateCalcInfoResponseDTO;
import br.com.actionlabs.carboncalc.core.usecase.calculator.CreateCalculatorCarbonUseCase;
import br.com.actionlabs.carboncalc.core.usecase.calculator.input.CreateCalculatorCarbonInput;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class CalculatorCarbonController {

  private final CreateCalculatorCarbonUseCase createCalculatorCarbonUseCase;

    public CalculatorCarbonController(CreateCalculatorCarbonUseCase createCalculatorCarbonUseCase) {
        this.createCalculatorCarbonUseCase = createCalculatorCarbonUseCase;
    }

    @PostMapping("/calculator")
  @ResponseStatus(HttpStatus.CREATED)
  public String startCalculation(
      @RequestBody @Valid StartCalcRequestDTO request) {

    return createCalculatorCarbonUseCase.execute(new CreateCalculatorCarbonInput(
            request.getName(),
            request.getEmail(),
            request.getPhoneNumber(),
            request.getUf(),
            request.energyConsumption,
            request.type,
            request.distance,
            request.wasteProduction)
    );


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
