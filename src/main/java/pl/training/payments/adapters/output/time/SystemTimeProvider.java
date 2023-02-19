package pl.training.payments.adapters.output.time;

import pl.training.payments.ports.output.TimeProvider;

import javax.enterprise.context.ApplicationScoped;
import java.time.Instant;

@ApplicationScoped
public class SystemTimeProvider implements TimeProvider {

    @Override
    public Instant getTimeStamp() {
        return Instant.now();
    }

}
