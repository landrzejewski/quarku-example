package pl.training.payments.adapters.output.persistence;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NamedQuery(name = CardEntity.GET_BY_NUMBER, query = "select c from card c where c.number = :number")
@Entity(name = "card")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class CardEntity {

    public static final String GET_BY_NUMBER = "cardGetByNumber";

    @GeneratedValue
    @Id
    private Long id;
    @Column(name = "card_number", unique = true)
    private String number;
    @Column(name = "verification_code")
    private String verificationCode;
    @Column(name = "expiration_cate")
    private LocalDate expirationDate;

}
