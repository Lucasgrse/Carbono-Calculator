package br.com.actionlabs.carboncalc.adapter.controller;

import br.com.actionlabs.carboncalc.adapter.controller.dto.request.calculation.CalculatorCarbonRequestDTO;
import br.com.actionlabs.carboncalc.adapter.controller.dto.request.calculation.UpdateCalculatorCarbonRequestDTO;
import br.com.actionlabs.carboncalc.adapter.controller.dto.response.CalculatorCarbonResponseDTO;
import br.com.actionlabs.carboncalc.adapter.mapper.CalculatorCarbonMapper;
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
  private final CalculatorCarbonMapper calculatorCarbonMapper;

  public CalculatorCarbonController(
          CreateCalculatorCarbonUseCase createCalculatorCarbonUseCase,
          UpdateCalculatorCarbonUseCase updateCalculatorCarbonUseCase,
          FindCalculatorCarbonUseCase findCalculatorCarbonUseCase,
          CalculatorCarbonMapper calculatorCarbonMapper) {
    this.createCalculatorCarbonUseCase = createCalculatorCarbonUseCase;
    this.updateCalculatorCarbonUseCase = updateCalculatorCarbonUseCase;
    this.findCalculatorCarbonUseCase = findCalculatorCarbonUseCase;
    this.calculatorCarbonMapper = calculatorCarbonMapper;
  }

  @PostMapping("/calculator")
  @ResponseStatus(HttpStatus.CREATED)
  public String startCalculation(
          @RequestBody @Valid CalculatorCarbonRequestDTO request
  ) {
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
  public Object updateCalculator(
          @RequestBody @Valid UpdateCalculatorCarbonRequestDTO request
  ) {
    return updateCalculatorCarbonUseCase.execute(new UpdateCalculatorCarbonInput(
            request.getId(),
            request.getEnergyConsumption(),
            request.getTransportation(),
            request.getSolidRecycleWaste(),
            request.getSolidNonRecycleWaste()
    ));
  }

  @GetMapping("/calculator/{id}")
  public CalculatorCarbonResponseDTO getResult(
          @PathVariable String id
  ) {
    FindCalculatorCarbonInput input = new FindCalculatorCarbonInput(id);
    CalculatorEmissionFactor findCalculator = findCalculatorCarbonUseCase.execute(input);
    return calculatorCarbonMapper.calculatorCarbonResponseDTO(findCalculator);
  }
}
