package br.com.actionlabs.carboncalc.helper;

import br.com.actionlabs.carboncalc.core.domain.energyEmission.EnergyEmissionFactor;

public class EnergyEmissionTestHelper {

    public static EnergyEmissionFactor buildEnergyEmissionFactor(
            String uf,
            double factor) {


        if (uf == null) uf = "SP";
        if (factor == 0) factor = 0.27;

        return new EnergyEmissionFactor(uf, factor);
    }
}
