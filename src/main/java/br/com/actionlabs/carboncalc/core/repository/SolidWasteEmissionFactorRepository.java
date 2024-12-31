package br.com.actionlabs.carboncalc.core.repository;

import br.com.actionlabs.carboncalc.core.domain.solidWasteEmission.SolidWasteEmissionFactor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolidWasteEmissionFactorRepository
    extends MongoRepository<SolidWasteEmissionFactor, String> {}
