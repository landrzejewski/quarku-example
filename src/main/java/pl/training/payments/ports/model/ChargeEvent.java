package pl.training.payments.ports.model;

public record ChargeEvent(ChargeId id, ChargeEventType type) {
}
