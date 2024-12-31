package br.com.actionlabs.carboncalc.core.repository;

import br.com.actionlabs.carboncalc.core.domain.calculateEmission.CalculatorEmissionFactor;

public interface CalculatorEmissionInterface {

    Object save(CalculatorEmissionFactor calculator);
}
