package pl.training.payments;

import pl.training.payments.domain.ChargeCardService;
import pl.training.payments.ports.input.ChargeCardUseCase;
import pl.training.payments.ports.output.CardIssuer;
import pl.training.payments.ports.output.ChargeIdGenerator;
import pl.training.payments.ports.output.ChargesWriter;
import pl.training.payments.ports.output.TimeProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class PaymentsConfiguration {

    @Produces
    public ChargeCardUseCase chargeCardUseCase(CardIssuer cardIssuer, ChargeIdGenerator chargeIdGenerator,
                                               TimeProvider timeProvider, ChargesWriter chargesWriter) {
        return new ChargeCardService(cardIssuer, chargeIdGenerator, timeProvider, chargesWriter);
    }

}
