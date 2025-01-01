package br.com.actionlabs.carboncalc.adapter.controller;

import br.com.actionlabs.carboncalc.adapter.controller.dto.request.calculation.StartCalcRequestDTO;
import br.com.actionlabs.carboncalc.adapter.controller.dto.request.calculation.UpdateCalcInfoRequestDTO;
import br.com.actionlabs.carboncalc.core.domain.calculateEmission.CalculatorEmissionFactor;
import br.com.actionlabs.carboncalc.core.usecase.calculator.CreateCalculatorCarbonUseCase;
import br.com.actionlabs.carboncalc.core.usecase.calculator.FindCalculatorCarbonUseCase;
import br.com.actionlabs.carboncalc.core.usecase.calculator.UpdateCalculatorCarbonUseCase;
import br.com.actionlabs.carboncalc.core.usecase.calculator.input.CreateCalculatorCarbonInput;
import br.com.actionlabs.carboncalc.core.usecase.calculator.input.FindCalculatorCarbonInput;
import br.com.actionlabs.carboncalc.core.usecase.calculator.input.UpdateCalculatorCarbonInput;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class CalculatorCarbonController {

  private final CreateCalculatorCarbonUseCase createCalculatorCarbonUseCase;
  private final UpdateCalculatorCarbonUseCase updateCalculatorCarbonUseCase;
  private final FindCalculatorCarbonUseCase findCalculatorCarbonUseCase;

  public CalculatorCarbonController(
          CreateCalculatorCarbonUseCase createCalculatorCarbonUseCase,
          UpdateCalculatorCarbonUseCase updateCalculatorCarbonUseCase,
          FindCalculatorCarbonUseCase findCalculatorCarbonUseCase) {
    this.createCalculatorCarbonUseCase = createCalculatorCarbonUseCase;
    this.updateCalculatorCarbonUseCase = updateCalculatorCarbonUseCase;
    this.findCalculatorCarbonUseCase = findCalculatorCarbonUseCase;
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
            request.getSolidRecycleWaste(),
            request.getSolidNonRecycleWaste()
    ));
  }

  @GetMapping("/calculator/{id}")
  public CalculatorEmissionFactor getResult(@PathVariable String id) {
    return findCalculatorCarbonUseCase.execute(new FindCalculatorCarbonInput(id));
  }
}
