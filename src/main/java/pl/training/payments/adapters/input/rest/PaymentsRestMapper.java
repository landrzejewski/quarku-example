package pl.training.payments.adapters.input.rest;

import org.mapstruct.Mapper;
import pl.training.payments.ports.model.*;

import java.math.BigDecimal;
import java.util.Currency;

@Mapper(componentModel = "cdi")
public interface PaymentsRestMapper {

    default ChargeRequest toDomain(ChargeRequestDto chargeRequestDto) {
        var amount = BigDecimal.valueOf(chargeRequestDto.getAmount());
        var currency = Currency.getInstance(chargeRequestDto.getCurrencyCode());
        var money = new Money(amount, currency);
        var cardNumber = new CardNumber(chargeRequestDto.getCardNumber());
        var cardVerificationCode = new CardVerificationCode(chargeRequestDto.getCardVerificationCode());
        var card = new Card(cardNumber, cardVerificationCode, chargeRequestDto.getCardExpirationDate());
        return new ChargeRequest(money, card);
    }

    ChargeIdDto toDto(ChargeId chargeId);

}
