package pl.training.payments.ports.output;

import pl.training.payments.ports.model.Charge;

public interface ChargesWriter {

    Charge save(Charge charge);

}
