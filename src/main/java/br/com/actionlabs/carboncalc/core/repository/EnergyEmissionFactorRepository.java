package br.com.actionlabs.carboncalc.core.repository;


import br.com.actionlabs.carboncalc.core.domain.energyEmission.EnergyEmissionFactor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyEmissionFactorRepository extends MongoRepository<EnergyEmissionFactor, String> {

}
