package pl.training.payments.adapters.output.persistence;

import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
@RequiredArgsConstructor
public class JpaChargesWriter {

    private final EntityManager entityManager;

    public ChargeEntity save(ChargeEntity chargeEntity) {
        fetchCard(chargeEntity);
        entityManager.persist(chargeEntity);
        return chargeEntity;
    }

    private void fetchCard(ChargeEntity chargeEntity) {
        var cardEntity = chargeEntity.getCard();
        try {
            var existingCard = entityManager.createNamedQuery(CardEntity.GET_BY_NUMBER, CardEntity.class)
                    .setParameter("number", cardEntity.getNumber())
                    .getSingleResult();
            cardEntity.setId(existingCard.getId());
        } catch (NoResultException noResultException) {
            entityManager.persist(cardEntity);
        }
    }

}
