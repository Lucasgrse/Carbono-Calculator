package br.com.actionlabs.carboncalc.calculator;

import br.com.actionlabs.carboncalc.adapter.controller.dto.response.transportation.TransportationDTO;
import br.com.actionlabs.carboncalc.core.domain.calculateEmission.CalculatorEmissionFactor;
import br.com.actionlabs.carboncalc.core.domain.transportationEmission.TransportationEmissionFactor;
import br.com.actionlabs.carboncalc.core.domain.transportationEmission.TransportationType;
import br.com.actionlabs.carboncalc.core.repository.CalculatorEmissionInterface;
import br.com.actionlabs.carboncalc.core.repository.TransportationEmissionFactorRepository;
import br.com.actionlabs.carboncalc.core.usecase.calculator.UpdateCalculatorCarbonUseCase;
import br.com.actionlabs.carboncalc.core.usecase.calculator.input.UpdateCalculatorCarbonInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static br.com.actionlabs.carboncalc.helper.CalculatorTestHelper.buildCalculatorEmission;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UpdateCalculatorCarbonUseCaseTest {

    @Mock
    private CalculatorEmissionInterface calculatorEmissionInterface;

    @Mock
    private TransportationEmissionFactorRepository transportationEmissionFactorRepository;

    private UpdateCalculatorCarbonUseCase updateCalculatorCarbonUseCase;

    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.openMocks(this);
        updateCalculatorCarbonUseCase = new UpdateCalculatorCarbonUseCase(
                calculatorEmissionInterface,
                transportationEmissionFactorRepository
        );
    }

    @Test
    public void mustThrowExceptionWhenCalculationNotFound() {
        UpdateCalculatorCarbonInput fakeInput = new UpdateCalculatorCarbonInput(
                null,
                250,
                List.of(
                        new TransportationDTO(TransportationType.CAR, 1500),
                        new TransportationDTO(TransportationType.MOTORCYCLE, 300)
                ),
                3,
                500
        );
        when(calculatorEmissionInterface.findById(fakeInput.getId()))
                .thenReturn(Optional.empty());

        try {
            updateCalculatorCarbonUseCase.execute(fakeInput);
            fail("Esperado IllegalArgumentException não foi lançada");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
        verify(calculatorEmissionInterface).findById(fakeInput.getId());
    }

    @Test
    public void mustThrowExceptionWhenEmissionFactorNotFound() {
        UpdateCalculatorCarbonInput fakeInput = new UpdateCalculatorCarbonInput(
                "677359d5ba4644762261df2d",
                250,
                List.of(
                        new TransportationDTO(TransportationType.CAR, 1500),
                        new TransportationDTO(TransportationType.MOTORCYCLE, 300)
                ),
                3,
                500
        );
        CalculatorEmissionFactor existingCalculation = new CalculatorEmissionFactor();
        existingCalculation.setId(fakeInput.getId());
        existingCalculation.setEnergyConsumption(100.0);
        when(calculatorEmissionInterface.findById(fakeInput.getId()))
                .thenReturn(Optional.of(existingCalculation));

        when(transportationEmissionFactorRepository.findById(TransportationType.CAR))
                .thenReturn(Optional.empty());

        try {
            updateCalculatorCarbonUseCase.execute(fakeInput);
            fail("Deveria ter lançado uma exceção IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Fator de emissão não encontrado para o tipo: null"));
        }
    }

    @Test
    public void mustSuccessfullyUpdateCalculationWithValidTransportEmissionFactors() {
        // Entrada de dados para atualização do cálculo
        UpdateCalculatorCarbonInput fakeInput = new UpdateCalculatorCarbonInput(
                "677359d5ba4644762261df2d",
                250,
                List.of(
                        new TransportationDTO(TransportationType.CAR, 1500),
                        new TransportationDTO(TransportationType.MOTORCYCLE, 300)
                ),
                3,
                500
        );

        TransportationEmissionFactor carFactor = new TransportationEmissionFactor(TransportationType.CAR, 0.1);
        when(transportationEmissionFactorRepository.findById(TransportationType.CAR))
                .thenReturn(Optional.of(carFactor));  // Retorna o fator para CAR

        TransportationEmissionFactor motorcycleFactor = new TransportationEmissionFactor(TransportationType.MOTORCYCLE, 0.08);
        when(transportationEmissionFactorRepository.findById(TransportationType.MOTORCYCLE))
                .thenReturn(Optional.of(motorcycleFactor));  // Retorna o fator para MOTORCYCLE

        CalculatorEmissionFactor fakeCalculation = buildCalculatorEmission(
                "677359d5ba4644762261df2d", "Test Name", "default@email.com", "4002-0922", "SP",
                TransportationType.CAR.toString(), 100.0, 10.0, 5.0, 2.0, LocalDateTime.now());
        when(calculatorEmissionInterface.findById(fakeInput.getId()))
                .thenReturn(Optional.of(fakeCalculation));  // Retorna um cálculo com o ID fornecido

        doAnswer(invocation -> {
            CalculatorEmissionFactor argument = invocation.getArgument(0);
            argument.setId("677359d5ba4644762261df2d");
            return argument;
        }).when(calculatorEmissionInterface).save(any(CalculatorEmissionFactor.class));

        try {
            Object result = updateCalculatorCarbonUseCase.execute(fakeInput);

            verify(transportationEmissionFactorRepository).findById(TransportationType.CAR);
            verify(transportationEmissionFactorRepository).findById(TransportationType.MOTORCYCLE);
            verify(calculatorEmissionInterface).findById(fakeInput.getId());
            verify(calculatorEmissionInterface).save(any(CalculatorEmissionFactor.class));

            assertNotNull(result);
        } catch (IllegalArgumentException e) {
            fail("Não deveria ter lançado exceção, mas ocorreu: " + e.getMessage());
        }
    }
}
