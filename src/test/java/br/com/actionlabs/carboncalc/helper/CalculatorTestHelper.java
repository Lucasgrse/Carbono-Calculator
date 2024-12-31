package br.com.actionlabs.carboncalc.helper;

import br.com.actionlabs.carboncalc.adapter.controller.dto.response.TransportationDTO;
import br.com.actionlabs.carboncalc.core.domain.calculateEmission.CalculatorEmissionFactor;
import br.com.actionlabs.carboncalc.core.domain.transportationEmission.TransportationType;
import br.com.actionlabs.carboncalc.core.usecase.calculator.input.CreateCalculatorCarbonInput;
import br.com.actionlabs.carboncalc.core.usecase.calculator.input.UpdateCalculatorCarbonInput;

import java.time.LocalDateTime;
import java.util.List;

public class CalculatorTestHelper {

    public static CalculatorEmissionFactor buildCalculatorEmission(
            String id,
            String name,
            String email,
            String phoneNumber,
            String uf,
            String typeEmission,
            double energyConsumption,
            double transportEmission,
            double recyclableWaste,
            double nonRecyclableWaste,
            LocalDateTime createdAt) {
        if (id == null) id = "12345678";
        if (name == null) name = "Test Name";
        if (email == null) email = "default@email.com";
        if (phoneNumber == null) phoneNumber = "4002-0922";
        if (uf == null) uf = "SP";
        if(typeEmission == null) typeEmission = TransportationType.CAR.toString();
        if (energyConsumption == 0) energyConsumption = 100.0;
        if (transportEmission == 0) transportEmission = 10.0;
        if (recyclableWaste == 0) recyclableWaste = 5.0;
        if (nonRecyclableWaste == 0) nonRecyclableWaste = 2.0;
        if (createdAt == null) createdAt = LocalDateTime.now();

        return new CalculatorEmissionFactor(id, name, email, phoneNumber, uf, typeEmission,
                energyConsumption, transportEmission, recyclableWaste, nonRecyclableWaste, createdAt);
    }

    public static CreateCalculatorCarbonInput buildFakeCreateCalculatorCarbonInput(
            String name,
            String email,
            String phoneNumber,
            String uf,
            double energyConsumption,
            TransportationType transportType,
            double distance,
            double wasteProduction
    ) {
        if (name == null) name = "Test Calculator";
        if (email == null) email = "test@email.com";
        if (phoneNumber == null) phoneNumber = "4002-0922";
        if (uf == null) uf = "SP";
        if (energyConsumption == 0) energyConsumption = 50.0;
        if (transportType == null) transportType = TransportationType.CAR;
        if (distance == 0) distance = 1.35;
        if (wasteProduction == 0) wasteProduction = 5.2;

        return new CreateCalculatorCarbonInput(name, email, phoneNumber, uf,
                energyConsumption, transportType, distance, wasteProduction);
    }

    public static UpdateCalculatorCarbonInput buildFakeUpdateCalculatorInput(
            String id,
            int energyConsumption,
            List<TransportationDTO> transportation,
            int solidWasteTotal,
            double recyclePercentage
    ) {
        if (id == null) id = "123";
        if (energyConsumption == 0) energyConsumption = 50;
        if (transportation == null || transportation.isEmpty()) {
            transportation = List.of(
                    new TransportationDTO(TransportationType.CAR, 2),
                    new TransportationDTO(TransportationType.MOTORCYCLE, 1)
            );
        }
        if (solidWasteTotal == 0) solidWasteTotal = 5;
        if (recyclePercentage == 0) recyclePercentage = 0.3;

        return new UpdateCalculatorCarbonInput(id, energyConsumption, transportation, solidWasteTotal, recyclePercentage);
    }
}
