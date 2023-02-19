package pl.training.payments.adapters.input.rest;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
public class ChargeRequestDto {

    private Double amount;
    @Pattern(regexp = "[A-Z]+")
    @NotBlank
    private String currencyCode;
    private String cardNumber;
    private String cardVerificationCode;
    private LocalDate cardExpirationDate;

}
