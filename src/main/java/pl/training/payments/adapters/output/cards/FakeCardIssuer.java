package pl.training.payments.adapters.output.cards;

import pl.training.payments.ports.model.ChargeRequest;
import pl.training.payments.ports.output.CardIssuer;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FakeCardIssuer implements CardIssuer {

    @Override
    public boolean authorizeTransaction(ChargeRequest chargeRequest) {
        return true;
    }

}
