package pl.training.payments;

import jdk.jfr.Percentage;
import pl.training.payments.adapters.output.cards.FakeCardIssuer;
import pl.training.payments.adapters.output.id.UuidChargeIdGenerator;
import pl.training.payments.adapters.output.persistence.ChargesRepository;
import pl.training.payments.adapters.output.time.SystemTimeProvider;
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

    @Produces
    public CardIssuer cardIssuer() {
        return new FakeCardIssuer();
    }

    @Produces
    public ChargeIdGenerator chargeIdGenerator() {
        return new UuidChargeIdGenerator();
    }

    @Produces
    public TimeProvider timeProvider() {
        return new SystemTimeProvider();
    }

    @Produces
    public ChargesWriter chargesWriter() {
        return new ChargesRepository();
    }

}
