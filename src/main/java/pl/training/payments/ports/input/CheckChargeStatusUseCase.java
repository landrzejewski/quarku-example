package pl.training.payments.ports.input;

import pl.training.payments.ports.model.ChargeId;
import pl.training.payments.ports.model.ChargeStatus;

public interface CheckChargeStatusUseCase {

    ChargeStatus checkStatus(ChargeId chargeId);

}
