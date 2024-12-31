package br.com.actionlabs.carboncalc.core.domain.energyEmission;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("energyEmissionFactor")
public class EnergyEmissionFactor {
    @Id
    private String uf;
    private double factor;

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

  public double getFactor() {
    return factor;
  }

  public void setFactor(double factor) {
    this.factor = factor;
  }
}
