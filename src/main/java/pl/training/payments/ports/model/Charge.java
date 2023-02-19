package pl.training.payments.ports.model;

import lombok.With;

import java.time.Instant;

public record Charge(ChargeId id, Money money, Instant timestamp, Card card, @With ChargeStatus chargeStatus) {
}
