package pl.training.payments.domain;

import lombok.RequiredArgsConstructor;
import pl.training.payments.ports.input.CheckChargeStatusUseCase;
import pl.training.payments.ports.model.Charge;
import pl.training.payments.ports.model.ChargeId;
import pl.training.payments.ports.model.ChargeNotFoundException;
import pl.training.payments.ports.model.ChargeStatus;
import pl.training.payments.ports.output.ChargesReader;

@RequiredArgsConstructor
public class CheckChargeStatusService implements CheckChargeStatusUseCase {

    private final ChargesReader chargesReader;

    @Override
    public ChargeStatus checkStatus(ChargeId chargeId) {
        return chargesReader.getById(chargeId)
                .map(Charge::chargeStatus)
                .orElseThrow(ChargeNotFoundException::new);
    }

}
