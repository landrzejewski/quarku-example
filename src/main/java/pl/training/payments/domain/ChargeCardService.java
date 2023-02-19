package pl.training.payments.domain;

import lombok.RequiredArgsConstructor;
import pl.training.payments.ports.input.ChargeCardUseCase;
import pl.training.payments.ports.model.Charge;
import pl.training.payments.ports.model.ChargeId;
import pl.training.payments.ports.model.ChargeRequest;
import pl.training.payments.ports.model.ChargeStatus;
import pl.training.payments.ports.output.*;

import static pl.training.payments.ports.model.ChargeStatus.CONFIRMED;
import static pl.training.payments.ports.model.ChargeStatus.REJECTED;

@RequiredArgsConstructor
public class ChargeCardService implements ChargeCardUseCase {

    private final CardIssuer cardIssuer;
    private final ChargeIdGenerator idGenerator;
    private final TimeProvider timeProvider;
    private final ChargesWriter chargesWriter;
    //private final ChargeEventsPublisher eventsPublisher;

    @Override
    public ChargeId charge(ChargeRequest chargeRequest) {
        var status = cardIssuer.authorizeTransaction(chargeRequest) ? CONFIRMED : REJECTED;
        var charge = chargeFromRequest(chargeRequest, status);
        chargesWriter.save(charge);
        return charge.id();
    }

    private Charge chargeFromRequest(ChargeRequest chargeRequest, ChargeStatus chargeStatus) {
        var id = idGenerator.nextId();
        var money = chargeRequest.money();
        var timestamp = timeProvider.getTimeStamp();
        var card = chargeRequest.card();
        return new Charge(id, money, timestamp, card, chargeStatus);
    }

}
