package br.com.actionlabs.carboncalc.calculator;

import br.com.actionlabs.carboncalc.core.domain.calculateEmission.CalculatorEmissionFactor;
import br.com.actionlabs.carboncalc.core.domain.energyEmission.EnergyEmissionFactor;
import br.com.actionlabs.carboncalc.core.domain.transportationEmission.TransportationType;
import br.com.actionlabs.carboncalc.core.repository.CalculatorEmissionInterface;
import br.com.actionlabs.carboncalc.core.repository.EnergyEmissionFactorRepository;
import br.com.actionlabs.carboncalc.core.repository.SolidWasteEmissionFactorRepository;
import br.com.actionlabs.carboncalc.core.repository.TransportationEmissionFactorRepository;
import br.com.actionlabs.carboncalc.core.usecase.calculator.CreateCalculatorCarbonUseCase;
import br.com.actionlabs.carboncalc.core.usecase.calculator.input.CreateCalculatorCarbonInput;
import br.com.actionlabs.carboncalc.helper.CalculatorTestHelper;
import br.com.actionlabs.carboncalc.helper.EnergyEmissionTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CreateCalculatorCarbonUseCaseTest {

    @Mock
    private CalculatorEmissionInterface calculatorEmissionInterface;

    @Mock
    private EnergyEmissionFactorRepository energyEmissionFactorRepository;

    @Mock
    private SolidWasteEmissionFactorRepository solidWasteEmissionFactorRepository;

    @Mock
    private TransportationEmissionFactorRepository transportationEmissionFactorRepository;

    private CreateCalculatorCarbonUseCase createCalculatorCarbonUseCase;

    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.openMocks(this);
        createCalculatorCarbonUseCase = Mockito.spy(new CreateCalculatorCarbonUseCase(
                calculatorEmissionInterface,
                energyEmissionFactorRepository,
                solidWasteEmissionFactorRepository,
                transportationEmissionFactorRepository

        ) {
            @Override
            protected double calculateEnergyEmission(String uf, double energyConsumption) {
                return 100.0;
            }

            @Override
            protected double calculateTransportEmission(TransportationType transportType, double distance) {
                return 150.0;
            }

            @Override
            protected double calculateWasteEmissionRecyclable(String uf, double wasteProduction) {
                return 50.0;
            }

            @Override
            protected double calculateWasteEmissionNonRecyclable(String uf, double wasteProduction) {
                return 30.0;
            }
        });
    }

    @Test
    public void mustSuccessfullyCreateACarbonCalculator() {
        CreateCalculatorCarbonInput fakeInput = CalculatorTestHelper.buildFakeCreateCalculatorCarbonInput(
                "Gabriel",
                "utilidadesTeste@gmail.com",
                "31987624-4040",
                "SP",
                1.25,
                TransportationType.PUBLIC_TRANSPORT,
                5.0,
                2.0
        );

        doAnswer(invocation -> {
            CalculatorEmissionFactor argument = invocation.getArgument(0);
            argument.setId("123");
            return argument;
        }).when(calculatorEmissionInterface).save(any(CalculatorEmissionFactor.class));

        String result = createCalculatorCarbonUseCase.execute(fakeInput);

        verify(calculatorEmissionInterface).save(any(CalculatorEmissionFactor.class));
        assertEquals("123", result);
    }
}