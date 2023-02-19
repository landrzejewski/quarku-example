package pl.training.payments.ports.output;

import pl.training.payments.ports.model.ChargeId;

public interface ChargeIdGenerator {

    ChargeId nextId();

}
