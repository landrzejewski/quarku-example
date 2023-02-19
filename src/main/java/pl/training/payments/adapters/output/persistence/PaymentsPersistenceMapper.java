package pl.training.payments.adapters.output.persistence;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.training.payments.ports.model.*;

import java.util.Currency;

@Mapper(componentModel = "cdi")
public interface PaymentsPersistenceMapper {

    CardEntity toEntity(Card card);

    default String toEntity(CardNumber cardNumber) {
        return cardNumber.number();
    }

    default String toEntity(CardVerificationCode verificationCode) {
        return verificationCode.number();
    }

    @Mapping(source = "money.amount", target = "amount")
    @Mapping(source = "money.currency", target = "currency")
    @Mapping(source = "chargeStatus", target = "status")
    ChargeEntity toEntity(Charge charge);

    default String toEntity(ChargeId chargeId) {
        return chargeId.value();
    }

    default Charge toDomain(ChargeEntity savedChargeEntity) {
        var cardEntity = savedChargeEntity.getCard();
        var cardNumber = new CardNumber(cardEntity.getNumber());
        var cardVerificationCode = new CardVerificationCode(cardEntity.getVerificationCode());
        var cardExpirationDate = cardEntity.getExpirationDate();
        var card = new Card(cardNumber, cardVerificationCode, cardExpirationDate);
        var currency = Currency.getInstance(savedChargeEntity.getCurrency());
        var money = new Money(savedChargeEntity.getAmount(), currency);
        var chargeId = new ChargeId(savedChargeEntity.getId());
        var chargeTimestamp = savedChargeEntity.getTimestamp();
        var chargeStatus = ChargeStatus.valueOf(savedChargeEntity.getStatus());
        return new Charge(chargeId, money, chargeTimestamp, card, chargeStatus);
    }

}
