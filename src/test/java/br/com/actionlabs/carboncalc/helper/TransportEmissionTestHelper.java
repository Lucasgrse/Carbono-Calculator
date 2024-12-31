package br.com.actionlabs.carboncalc.helper;

import br.com.actionlabs.carboncalc.core.domain.transportationEmission.TransportationEmissionFactor;
import br.com.actionlabs.carboncalc.core.domain.transportationEmission.TransportationType;

public class TransportEmissionTestHelper {

    public static TransportationEmissionFactor buildFakeTransportationEmissionFactor(
            TransportationType type,
            double factor
    ) {
        if (type == null) type = TransportationType.CAR;
        if (factor == 0) factor = 2.0;

        return new TransportationEmissionFactor(type, factor);
    }
}
