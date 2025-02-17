package br.com.actionlabs.carboncalc.core.usecase.calculator;

import br.com.actionlabs.carboncalc.adapter.controller.dto.response.TransportationDTO;
import br.com.actionlabs.carboncalc.core.domain.calculateEmission.CalculatorEmissionFactor;
import br.com.actionlabs.carboncalc.core.domain.transportationEmission.TransportationEmissionFactor;
import br.com.actionlabs.carboncalc.core.repository.CalculatorEmissionInterface;
import br.com.actionlabs.carboncalc.core.repository.TransportationEmissionFactorRepository;
import br.com.actionlabs.carboncalc.core.usecase.UseCase;
import br.com.actionlabs.carboncalc.core.usecase.calculator.input.UpdateCalculatorCarbonInput;
import br.com.actionlabs.carboncalc.core.voter.calculator.UpdateCalculatorEmissionVoter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UpdateCalculatorCarbonUseCase implements UseCase<UpdateCalculatorCarbonInput, Object> {

    private final CalculatorEmissionInterface calculatorEmissionInterface;
    private final UpdateCalculatorEmissionVoter updateCalculatorEmissionVoter;
    private final TransportationEmissionFactorRepository transportationEmissionFactorRepository;

    public UpdateCalculatorCarbonUseCase(
            CalculatorEmissionInterface calculatorEmissionInterface,
            UpdateCalculatorEmissionVoter updateCalculatorEmissionVoter,
            TransportationEmissionFactorRepository transportationEmissionFactorRepository

    ) {
        this.calculatorEmissionInterface = calculatorEmissionInterface;
        this.updateCalculatorEmissionVoter = updateCalculatorEmissionVoter;
        this.transportationEmissionFactorRepository = transportationEmissionFactorRepository;
    }

    @Override
    public Object execute(UpdateCalculatorCarbonInput input) {
        updateCalculatorEmissionVoter.invoke(input);

        Optional<CalculatorEmissionFactor> findCalculation = calculatorEmissionInterface.findById(input.getId());

        if (findCalculation.isPresent()) {
            CalculatorEmissionFactor existingCalculation = findCalculation.get();

            double totalTransportEmission = calculateTransportEmission(input.getTransportation());

            existingCalculation.setEnergyConsumption(input.getEnergyConsumption());
            existingCalculation.setTransportEmission(totalTransportEmission);
            existingCalculation.setRecyclableWaste(input.getRecyclePercentage() * 2);
            existingCalculation.setNonRecyclableWaste(input.getSolidWasteTotal());


            return calculatorEmissionInterface.save(existingCalculation);

        } else {
            throw new IllegalArgumentException();
        }
    }

    private double calculateTransportEmission(List<TransportationDTO> transportationList) {
        return transportationList.stream()
                .mapToDouble(transport -> {
                    TransportationEmissionFactor factor = transportationEmissionFactorRepository.findById(transport.getType())
                            .orElseThrow();
                    return transport.getMonthlyDistance() * factor.getFactor();
                })
                .sum();
    }
}
