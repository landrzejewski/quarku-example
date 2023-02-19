package pl.training.payments.adapters.output.persistence;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.Instant;

@Entity(name = "charge")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class ChargeEntity {

    @Id
    private String id;
    private BigDecimal amount;
    private String currency;
    private Instant timestamp;
    @ManyToOne
    private CardEntity card;
    private String status;

}
