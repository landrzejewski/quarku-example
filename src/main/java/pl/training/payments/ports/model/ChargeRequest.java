package pl.training.payments.ports.model;

public record ChargeRequest(Money money, Card card) {
}
