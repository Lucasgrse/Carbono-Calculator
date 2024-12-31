package br.com.actionlabs.carboncalc.core.repository;

import br.com.actionlabs.carboncalc.core.domain.calculateEmission.CalculatorEmissionFactor;

import java.util.Optional;

public interface CalculatorEmissionInterface {

    Object save(CalculatorEmissionFactor calculator);

    Optional<CalculatorEmissionFactor> findById(String id);
}
