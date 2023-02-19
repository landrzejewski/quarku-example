package pl.training.payments;

import pl.training.payments.domain.ChargeCardService;
import pl.training.payments.domain.CheckChargeStatusService;
import pl.training.payments.ports.input.ChargeCardUseCase;
import pl.training.payments.ports.input.CheckChargeStatusUseCase;
import pl.training.payments.ports.output.*;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class PaymentsConfiguration {

    @Produces
    public ChargeCardUseCase chargeCardUseCase(CardIssuer cardIssuer, ChargeIdGenerator chargeIdGenerator,
                                               TimeProvider timeProvider, ChargesWriter chargesWriter) {
        return new ChargeCardService(cardIssuer, chargeIdGenerator, timeProvider, chargesWriter);
    }

    @Produces
    public CheckChargeStatusUseCase checkChargeStatusUseCase(ChargesReader chargesReader) {
        return new CheckChargeStatusService(chargesReader);
    }

}
