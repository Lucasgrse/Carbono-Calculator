package br.com.actionlabs.carboncalc.core.repository;

import br.com.actionlabs.carboncalc.core.domain.transportationEmission.TransportationType;
import br.com.actionlabs.carboncalc.core.domain.transportationEmission.TransportationEmissionFactor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportationEmissionFactorRepository
    extends MongoRepository<TransportationEmissionFactor, TransportationType> {}
