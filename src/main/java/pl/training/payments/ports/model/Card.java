package pl.training.payments.ports.model;

import java.time.LocalDate;

public record Card(CardNumber number, CardVerificationCode verificationCode, LocalDate expirationDate) {
}
