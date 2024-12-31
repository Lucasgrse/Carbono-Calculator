package br.com.actionlabs.carboncalc.core.usecase.calculator;

import br.com.actionlabs.carboncalc.core.domain.calculateEmission.CalculatorEmissionFactor;
import br.com.actionlabs.carboncalc.core.repository.CalculatorEmissionInterface;
import br.com.actionlabs.carboncalc.core.usecase.UseCase;
import br.com.actionlabs.carboncalc.core.usecase.calculator.input.FindCalculatorCarbonInput;
import org.springframework.stereotype.Service;

@Service
public class FindCalculatorCarbonUseCase implements UseCase<FindCalculatorCarbonInput, CalculatorEmissionFactor> {

    private final CalculatorEmissionInterface calculatorEmissionInterface;

    public FindCalculatorCarbonUseCase(CalculatorEmissionInterface calculatorEmissionInterface) {
        this.calculatorEmissionInterface = calculatorEmissionInterface;
    }

    @Override
    public CalculatorEmissionFactor execute(FindCalculatorCarbonInput input) {
        return calculatorEmissionInterface.findById(input.getId()).orElseThrow();
    }
}
