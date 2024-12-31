package br.com.actionlabs.carboncalc.infra.repository.mongo;

import br.com.actionlabs.carboncalc.core.domain.calculateEmission.CalculatorEmissionFactor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CalculatorEmissionMongo extends MongoRepository<CalculatorEmissionFactor, String> {
}
