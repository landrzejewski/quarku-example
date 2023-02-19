package pl.training.payments.adapters.output.persistence;

import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@ApplicationScoped
@RequiredArgsConstructor
public class JpaChargesRepository {

    private final EntityManager entityManager;
    private final JpaCardsRepository cardsRepository;

    public ChargeEntity save(ChargeEntity chargeEntity) {
        var card = chargeEntity.getCard();
        cardsRepository.getIdByNumber(card.getNumber())
                .ifPresentOrElse(card::setId, () -> cardsRepository.save(card));
        entityManager.persist(chargeEntity);
        return chargeEntity;
    }

    public Optional<ChargeEntity> getById(String id) {
        return Optional.ofNullable(entityManager.find(ChargeEntity.class, id));
    }

}
