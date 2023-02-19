package pl.training.payments.ports.output;

import pl.training.payments.ports.model.ChargeRequest;

public interface CardIssuer {

    boolean authorizeTransaction(ChargeRequest chargeRequest);

}
