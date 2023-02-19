package pl.training.payments.ports.output;

import pl.training.payments.ports.model.ChargeEvent;

public interface ChargeEventsPublisher {

    void publish(ChargeEvent event);

}
