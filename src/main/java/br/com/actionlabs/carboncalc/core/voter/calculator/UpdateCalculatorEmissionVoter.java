package br.com.actionlabs.carboncalc.core.voter.calculator;

import br.com.actionlabs.carboncalc.adapter.controller.dto.response.TransportationDTO;
import br.com.actionlabs.carboncalc.core.repository.CalculatorEmissionInterface;
import br.com.actionlabs.carboncalc.core.repository.TransportationEmissionFactorRepository;
import br.com.actionlabs.carboncalc.core.usecase.calculator.input.UpdateCalculatorCarbonInput;
import br.com.actionlabs.carboncalc.core.voter.Voter;
import br.com.actionlabs.carboncalc.infra.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UpdateCalculatorEmissionVoter implements Voter<UpdateCalculatorCarbonInput> {

    private final CalculatorEmissionInterface calculatorEmissionInterface;
    private final TransportationEmissionFactorRepository transportationEmissionFactorRepository;

    public UpdateCalculatorEmissionVoter(CalculatorEmissionInterface calculatorEmissionInterface, TransportationEmissionFactorRepository transportationEmissionFactorRepository) {
        this.calculatorEmissionInterface = calculatorEmissionInterface;
        this.transportationEmissionFactorRepository = transportationEmissionFactorRepository;
    }

    @Override
    public void invoke(UpdateCalculatorCarbonInput useCaseInput) {

        if(calculatorEmissionInterface.findById(useCaseInput.getId()).isEmpty()){
            throw new NotFoundException("Cálculo de Carbono não encontrado.");
        }

        for (TransportationDTO transport : useCaseInput.getTransportation()) {
            if (transportationEmissionFactorRepository.findById(transport.getType()).isEmpty()) {
                throw new NotFoundException("Tipo de transporte não encontrado.");
            }
        }
    }
}
