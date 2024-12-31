package br.com.actionlabs.carboncalc.core.usecase.calculator.input;

public class FindCalculatorCarbonInput {

    private String id;

    public FindCalculatorCarbonInput(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
