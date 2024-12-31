package br.com.actionlabs.carboncalc.core.domain.transportationEmission;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("transportationEmissionFactor")
public class TransportationEmissionFactor {
    @Id
    private TransportationType type;
    private double factor;

    public TransportationType getType() {
        return type;
    }

    public void setType(TransportationType type) {
        this.type = type;
    }

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }
}
