package br.com.actionlabs.carboncalc.infra.repository;

import br.com.actionlabs.carboncalc.core.domain.calculateEmission.CalculatorEmissionFactor;
import br.com.actionlabs.carboncalc.core.repository.CalculatorEmissionInterface;
import br.com.actionlabs.carboncalc.infra.repository.mongo.CalculatorEmissionMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CalculatorEmissionRepository implements CalculatorEmissionInterface {

    private final CalculatorEmissionMongo mongoRepository;

    @Autowired
    public CalculatorEmissionRepository(CalculatorEmissionMongo mongoRepository) {
        this.mongoRepository = mongoRepository;
    }

    @Override
    public CalculatorEmissionFactor save(CalculatorEmissionFactor calculator){
        return mongoRepository.save(calculator);
    }
}
