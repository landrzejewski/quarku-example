package pl.training.payments.ports.model;

public record CardVerificationCode(String number) {

    private static final String CODE_PATTERN = "^\\d{3,4}";

    public CardVerificationCode {
        if (!number.matches(CODE_PATTERN)) {
            throw new IllegalArgumentException();
        }
    }
    
}
