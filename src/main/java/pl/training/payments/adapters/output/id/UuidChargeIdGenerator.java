package pl.training.payments.adapters.output.id;

import pl.training.payments.ports.model.ChargeId;
import pl.training.payments.ports.output.ChargeIdGenerator;

import java.util.UUID;

public class UuidChargeIdGenerator implements ChargeIdGenerator {

    @Override
    public ChargeId nextId() {
        var uuid = UUID.randomUUID().toString();
        return new ChargeId(uuid);
    }

}
