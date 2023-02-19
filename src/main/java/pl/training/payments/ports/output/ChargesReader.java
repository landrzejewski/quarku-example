package pl.training.payments.ports.output;

import pl.training.payments.ports.model.Charge;
import pl.training.payments.ports.model.ChargeId;

import java.util.Optional;

public interface ChargesReader {

    Optional<Charge> getById(ChargeId chargeId);

}
