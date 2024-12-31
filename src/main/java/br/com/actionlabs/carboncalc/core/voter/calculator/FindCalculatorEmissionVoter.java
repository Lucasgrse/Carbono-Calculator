package br.com.actionlabs.carboncalc.core.voter.calculator;

import br.com.actionlabs.carboncalc.core.repository.CalculatorEmissionInterface;
import br.com.actionlabs.carboncalc.core.usecase.calculator.input.FindCalculatorCarbonInput;
import br.com.actionlabs.carboncalc.core.voter.Voter;
import br.com.actionlabs.carboncalc.infra.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class FindCalculatorEmissionVoter implements Voter<FindCalculatorCarbonInput> {

    private final CalculatorEmissionInterface calculatorEmissionInterface;

    public FindCalculatorEmissionVoter(CalculatorEmissionInterface calculatorEmissionInterface) {
        this.calculatorEmissionInterface = calculatorEmissionInterface;
    }

    @Override
    public void invoke(FindCalculatorCarbonInput useCaseInput) {
        if(useCaseInput.getId() == null || useCaseInput.getId().isEmpty()){
            throw new IllegalArgumentException("Id não está disponível");
        }

        if(calculatorEmissionInterface.findById(useCaseInput.getId()).isEmpty()){
            throw new NotFoundException("Cálculo de Carbono não encontrado.");
        }
    }
}
