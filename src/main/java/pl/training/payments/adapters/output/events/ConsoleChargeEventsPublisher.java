package pl.training.payments.adapters.output.events;

import lombok.extern.java.Log;
import pl.training.payments.ports.model.ChargeEvent;
import pl.training.payments.ports.output.ChargeEventsPublisher;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Log
public class ConsoleChargeEventsPublisher implements ChargeEventsPublisher {

    @Override
    public void publish(ChargeEvent event) {
        log.info("New event: " + event);
    }

}
