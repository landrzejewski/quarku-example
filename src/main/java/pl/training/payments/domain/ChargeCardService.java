package pl.training.payments.domain;

import lombok.RequiredArgsConstructor;
import pl.training.payments.ports.input.ChargeCardUseCase;
import pl.training.payments.ports.model.*;
import pl.training.payments.ports.output.*;

import static pl.training.payments.ports.model.ChargeEventType.*;
import static pl.training.payments.ports.model.ChargeStatus.*;

@RequiredArgsConstructor
public class ChargeCardService implements ChargeCardUseCase {

    private final CardIssuer cardIssuer;
    private final ChargeIdGenerator idGenerator;
    private final TimeProvider timeProvider;
    private final ChargesWriter chargesWriter;
    private final ChargeEventsPublisher eventsPublisher;

    @Override
    public ChargeId charge(ChargeRequest chargeRequest) {
        var charge = chargeFromRequest(chargeRequest);
        eventsPublisher.publish(new ChargeEvent(charge.id(), CHARGE_PROCESSING_STARTED));
        var status = cardIssuer.authorizeTransaction(chargeRequest) ? CONFIRMED : REJECTED;
        var eventType = status == CONFIRMED ? CHARGE_PROCESSING_FINISHED : CHARGE_PROCESSING_FAILED;
        charge = updateStatus(charge, status, eventType);
        chargesWriter.save(charge);
        return charge.id();
    }

    private Charge updateStatus(Charge charge, ChargeStatus newStatus, ChargeEventType chargeEventType) {
        eventsPublisher.publish(new ChargeEvent(charge.id(), chargeEventType));
        return charge.withChargeStatus(newStatus);
    }

    private Charge chargeFromRequest(ChargeRequest chargeRequest) {
        var id = idGenerator.nextId();
        var money = chargeRequest.money();
        var timestamp = timeProvider.getTimeStamp();
        var card = chargeRequest.card();
        return new Charge(id, money, timestamp, card, IN_PROGRESS);
    }

}
