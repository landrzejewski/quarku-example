package pl.training.payments.adapters.output.persistence;

import pl.training.payments.ports.model.Charge;
import pl.training.payments.ports.output.ChargesWriter;

public class ChargesRepository implements ChargesWriter {

    @Override
    public Charge save(Charge charge) {
        return charge;
    }

}
