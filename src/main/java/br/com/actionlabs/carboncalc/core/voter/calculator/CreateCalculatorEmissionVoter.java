package br.com.actionlabs.carboncalc.core.voter.calculator;

import br.com.actionlabs.carboncalc.core.repository.EnergyEmissionFactorRepository;
import br.com.actionlabs.carboncalc.core.repository.SolidWasteEmissionFactorRepository;
import br.com.actionlabs.carboncalc.core.repository.TransportationEmissionFactorRepository;
import br.com.actionlabs.carboncalc.core.usecase.calculator.input.CreateCalculatorCarbonInput;
import br.com.actionlabs.carboncalc.core.voter.Voter;
import br.com.actionlabs.carboncalc.infra.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CreateCalculatorEmissionVoter implements Voter<CreateCalculatorCarbonInput> {

    private final EnergyEmissionFactorRepository energyEmissionFactorRepository;
    private final SolidWasteEmissionFactorRepository solidWasteEmissionFactorRepository;
    private final TransportationEmissionFactorRepository transportationEmissionFactorRepository;

    public CreateCalculatorEmissionVoter(
            EnergyEmissionFactorRepository energyEmissionFactorRepository,
            SolidWasteEmissionFactorRepository solidWasteEmissionFactorRepository,
            TransportationEmissionFactorRepository transportationEmissionFactorRepository
    ) {
        this.energyEmissionFactorRepository = energyEmissionFactorRepository;
        this.solidWasteEmissionFactorRepository = solidWasteEmissionFactorRepository;
        this.transportationEmissionFactorRepository = transportationEmissionFactorRepository;
    }

    @Override
    public void invoke(CreateCalculatorCarbonInput useCaseInput){
        if (energyEmissionFactorRepository.findById(useCaseInput.getUf()).isEmpty()) {
            throw new NotFoundException("Região indicada não encontrada.");
        }

        if (transportationEmissionFactorRepository.findById(useCaseInput.transportType).isEmpty()) {
            throw new NotFoundException("Tipo de transporte não encontrado.");
        }

        if (solidWasteEmissionFactorRepository.findById(useCaseInput.getUf()).isEmpty()) {
            throw new NotFoundException("Fator de emissão de resíduos não encontrado para a região.");
        }
    }
}
