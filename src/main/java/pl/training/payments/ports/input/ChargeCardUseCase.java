package pl.training.payments.ports.input;

import pl.training.payments.ports.model.ChargeId;
import pl.training.payments.ports.model.ChargeRequest;

public interface ChargeCardUseCase {

    ChargeId charge(ChargeRequest chargeRequest);

}
