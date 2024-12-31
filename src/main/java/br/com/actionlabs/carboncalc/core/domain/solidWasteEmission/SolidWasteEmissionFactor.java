package br.com.actionlabs.carboncalc.core.domain.solidWasteEmission;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("solidWasteEmissionFactor")
public class SolidWasteEmissionFactor {
    @Id
    private String uf;
    private double recyclableFactor;
    private double nonRecyclableFactor;

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public double getRecyclableFactor() {
        return recyclableFactor;
    }

    public void setRecyclableFactor(double recyclableFactor) {
        this.recyclableFactor = recyclableFactor;
    }

    public double getNonRecyclableFactor() {
        return nonRecyclableFactor;
    }

    public void setNonRecyclableFactor(double nonRecyclableFactor) {
        this.nonRecyclableFactor = nonRecyclableFactor;
    }
}
