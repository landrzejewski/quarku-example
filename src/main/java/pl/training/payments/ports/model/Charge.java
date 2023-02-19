package pl.training.payments.ports.model;

import java.time.Instant;

public record Charge(ChargeId id, Money money, Instant timestamp, Card card, ChargeStatus chargeStatus) {
}
