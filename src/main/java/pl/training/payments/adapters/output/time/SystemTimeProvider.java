package pl.training.payments.adapters.output.time;

import pl.training.payments.ports.output.TimeProvider;

import java.time.Instant;

public class SystemTimeProvider implements TimeProvider {

    @Override
    public Instant getTimeStamp() {
        return Instant.now();
    }

}
