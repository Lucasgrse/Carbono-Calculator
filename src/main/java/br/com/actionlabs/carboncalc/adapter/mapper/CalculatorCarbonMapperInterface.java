package br.com.actionlabs.carboncalc.adapter.mapper;

import br.com.actionlabs.carboncalc.adapter.controller.dto.response.CalculatorCarbonResponseDTO;
import br.com.actionlabs.carboncalc.core.domain.calculateEmission.CalculatorEmissionFactor;

public interface CalculatorCarbonMapperInterface {

    CalculatorCarbonResponseDTO calculatorCarbonResponseDTO(CalculatorEmissionFactor calculatorEmissionFactor);
}
