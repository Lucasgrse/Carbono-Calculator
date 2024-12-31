package br.com.actionlabs.carboncalc.core.usecase.calculator;

import br.com.actionlabs.carboncalc.core.domain.calculateEmission.CalculatorEmissionFactor;
import br.com.actionlabs.carboncalc.core.domain.energyEmission.EnergyEmissionFactor;
import br.com.actionlabs.carboncalc.core.domain.solidWasteEmission.SolidWasteEmissionFactor;
import br.com.actionlabs.carboncalc.core.domain.transportationEmission.TransportationEmissionFactor;
import br.com.actionlabs.carboncalc.core.domain.transportationEmission.TransportationType;
import br.com.actionlabs.carboncalc.core.repository.CalculatorEmissionInterface;
import br.com.actionlabs.carboncalc.core.repository.EnergyEmissionFactorRepository;
import br.com.actionlabs.carboncalc.core.repository.SolidWasteEmissionFactorRepository;
import br.com.actionlabs.carboncalc.core.repository.TransportationEmissionFactorRepository;
import br.com.actionlabs.carboncalc.core.usecase.UseCase;
import br.com.actionlabs.carboncalc.core.usecase.calculator.input.CreateCalculatorCarbonInput;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreateCalculatorCarbonUseCase implements UseCase<CreateCalculatorCarbonInput, String> {

    private final CalculatorEmissionInterface calculatorEmissionInterface;
    private final EnergyEmissionFactorRepository energyEmissionFactorRepository;
    private final SolidWasteEmissionFactorRepository solidWasteEmissionFactorRepository;
    private final TransportationEmissionFactorRepository transportationEmissionFactorRepository;

    public CreateCalculatorCarbonUseCase(CalculatorEmissionInterface calculatorEmissionInterface, EnergyEmissionFactorRepository energyEmissionFactorRepository, SolidWasteEmissionFactorRepository solidWasteEmissionFactorRepository, TransportationEmissionFactorRepository transportationEmissionFactorRepository) {
        this.calculatorEmissionInterface = calculatorEmissionInterface;
        this.energyEmissionFactorRepository = energyEmissionFactorRepository;
        this.solidWasteEmissionFactorRepository = solidWasteEmissionFactorRepository;
        this.transportationEmissionFactorRepository = transportationEmissionFactorRepository;
    }

    @Override
    public String execute(CreateCalculatorCarbonInput input) {

        double calculateEnergy = calculateEnergyEmission(input.getUf(), input.energyConsumption);
        double calculateTransport = calculateTransportEmission(input.transportType, input.distance);
        double calculateWasteEmissionRecyclable = calculateWasteEmissionRecyclable(input.getUf(), input.wasteProduction);
        double calculateWasteEmissionNonRecyclable = calculateWasteEmissionNonRecyclable(input.getUf(), input.wasteProduction);

        CalculatorEmissionFactor calculation = new CalculatorEmissionFactor();
        calculation.setName(input.getName());
        calculation.setEmail(input.getEmail());
        calculation.setPhoneNumber(input.getPhoneNumber());
        calculation.setUf(input.getUf());
        calculation.setTypeEmission(input.transportType.toString());
        calculation.setEnergyConsumption(calculateEnergy);
        calculation.setTransportEmission(calculateTransport);
        calculation.setRecyclableWaste(calculateWasteEmissionRecyclable);
        calculation.setNonRecyclableWaste(calculateWasteEmissionNonRecyclable);
        calculation.setCreatedAt(LocalDateTime.now());

        Object save = calculatorEmissionInterface.save(calculation);

        return calculation.getId();

    }
    protected double calculateEnergyEmission(String uf, double energyConsumption) {
        EnergyEmissionFactor energy = energyEmissionFactorRepository.findById(uf).orElse(null);
        if (energy != null) {
            return energyConsumption * energy.getFactor();
        } else {
            throw new IllegalArgumentException("Fator de emissão de energia não encontrado para a UF: " + uf);
        }
    }

    protected double calculateTransportEmission(TransportationType type, double distance) {
        TransportationEmissionFactor transport = transportationEmissionFactorRepository.findById(type).orElse(null);
        if (transport != null) {
            return distance * transport.getFactor();
        } else {
            throw new IllegalArgumentException("Fator de emissão de transporte não encontrado para o tipo: " + type);
        }
    }

    protected double calculateWasteEmissionRecyclable(String uf, double wasteProduction) {
        SolidWasteEmissionFactor recyclable = solidWasteEmissionFactorRepository.findById(uf).orElse(null);
        if (recyclable != null) {
            return wasteProduction * recyclable.getRecyclableFactor();
        } else {
            throw new IllegalArgumentException("Fator de emissão de resíduos não encontrado para o tipo: " + uf);
        }
    }

    protected double calculateWasteEmissionNonRecyclable(String wasteType, double wasteProduction) {
        SolidWasteEmissionFactor nonRecyclable = solidWasteEmissionFactorRepository.findById(wasteType).orElse(null);
        if (nonRecyclable != null) {
            return wasteProduction * nonRecyclable.getNonRecyclableFactor();
        } else {
            throw new IllegalArgumentException("Fator de emissão de resíduos não encontrado para o tipo: " + wasteType);
        }
    }
}
