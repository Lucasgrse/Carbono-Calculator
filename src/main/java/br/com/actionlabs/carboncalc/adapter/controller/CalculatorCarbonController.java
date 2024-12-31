package br.com.actionlabs.carboncalc.adapter.controller;

import br.com.actionlabs.carboncalc.adapter.controller.dto.request.calculation.CarbonCalculationResultDTO;
import br.com.actionlabs.carboncalc.adapter.controller.dto.request.calculation.StartCalcRequestDTO;
import br.com.actionlabs.carboncalc.adapter.controller.dto.request.calculation.UpdateCalcInfoRequestDTO;
import br.com.actionlabs.carboncalc.core.usecase.calculator.CreateCalculatorCarbonUseCase;
import br.com.actionlabs.carboncalc.core.usecase.calculator.UpdateCalculatorCarbonUseCase;
import br.com.actionlabs.carboncalc.core.usecase.calculator.input.CreateCalculatorCarbonInput;
import br.com.actionlabs.carboncalc.core.usecase.calculator.input.UpdateCalculatorCarbonInput;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class CalculatorCarbonController {

  private final CreateCalculatorCarbonUseCase createCalculatorCarbonUseCase;
  private final UpdateCalculatorCarbonUseCase updateCalculatorCarbonUseCase;

  public CalculatorCarbonController(
          CreateCalculatorCarbonUseCase createCalculatorCarbonUseCase,
          UpdateCalculatorCarbonUseCase updateCalculatorCarbonUseCase) {
    this.createCalculatorCarbonUseCase = createCalculatorCarbonUseCase;
    this.updateCalculatorCarbonUseCase = updateCalculatorCarbonUseCase;
  }

  @PostMapping("/calculator")
  @ResponseStatus(HttpStatus.CREATED)
  public String startCalculation(@RequestBody @Valid StartCalcRequestDTO request) {
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

  @PutMapping("/calculator/update")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Object updateCalculator(@RequestBody @Valid UpdateCalcInfoRequestDTO request) {
    return updateCalculatorCarbonUseCase.execute(new UpdateCalculatorCarbonInput(
            request.getId(),
            request.getEnergyConsumption(),
            request.getTransportation(),
            request.getSolidWasteTotal(),
            request.getRecyclePercentage()
    ));
  }

  @GetMapping("result/{id}")
  public ResponseEntity<CarbonCalculationResultDTO> getResult(@PathVariable String id) {
    throw new RuntimeException("Not implemented");
  }
}
