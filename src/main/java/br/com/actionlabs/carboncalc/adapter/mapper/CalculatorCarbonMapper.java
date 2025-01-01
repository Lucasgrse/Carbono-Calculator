package br.com.actionlabs.carboncalc.adapter.mapper;

import br.com.actionlabs.carboncalc.adapter.controller.dto.response.CalculatorCarbonResponseDTO;
import br.com.actionlabs.carboncalc.core.domain.calculateEmission.CalculatorEmissionFactor;
import org.springframework.stereotype.Component;

@Component
public class CalculatorCarbonMapper implements  CalculatorCarbonMapperInterface{

    @Override
    public CalculatorCarbonResponseDTO calculatorCarbonResponseDTO(CalculatorEmissionFactor calculator) {
        return new CalculatorCarbonResponseDTO(
                calculator.getId(),
                calculator.getName(),
                calculator.getEmail(),
                calculator.getPhoneNumber(),
                calculator.getUf(),
                calculator.getTypeEmission(),
                calculator.getEnergyConsumption(),
                calculator.getTransportEmission(),
                calculator.getRecyclableWaste(),
                calculator.getNonRecyclableWaste(),
                calculator.getCreatedAt()
        );
    }
}
