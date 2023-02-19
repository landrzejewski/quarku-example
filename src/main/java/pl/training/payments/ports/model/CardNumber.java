package pl.training.payments.ports.model;

public record CardNumber(String number) {

    private static final String NUMBER_PATTERN = "^\\d{13,19}";

    public CardNumber {
        if (!number.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException();
        }
    }

}
