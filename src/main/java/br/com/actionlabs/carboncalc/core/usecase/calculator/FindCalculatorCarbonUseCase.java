package br.com.actionlabs.carboncalc.core.usecase.calculator;

import br.com.actionlabs.carboncalc.core.domain.calculateEmission.CalculatorEmissionFactor;
import br.com.actionlabs.carboncalc.core.repository.CalculatorEmissionInterface;
import br.com.actionlabs.carboncalc.core.usecase.UseCase;
import br.com.actionlabs.carboncalc.core.usecase.calculator.input.FindCalculatorCarbonInput;
import br.com.actionlabs.carboncalc.core.voter.calculator.FindCalculatorEmissionVoter;
import org.springframework.stereotype.Service;

@Service
public class FindCalculatorCarbonUseCase implements UseCase<FindCalculatorCarbonInput, CalculatorEmissionFactor> {

    private final CalculatorEmissionInterface calculatorEmissionInterface;
    private final FindCalculatorEmissionVoter findCalculatorEmissionVoter;

    public FindCalculatorCarbonUseCase(CalculatorEmissionInterface calculatorEmissionInterface, FindCalculatorEmissionVoter findCalculatorEmissionVoter) {
        this.calculatorEmissionInterface = calculatorEmissionInterface;
        this.findCalculatorEmissionVoter = findCalculatorEmissionVoter;
    }

    @Override
    public CalculatorEmissionFactor execute(FindCalculatorCarbonInput input) {
        findCalculatorEmissionVoter.invoke(input);

        return calculatorEmissionInterface.findById(input.getId()).orElseThrow();
    }
}
