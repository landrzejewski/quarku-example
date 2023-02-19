package pl.training.payments.adapters.output.persistence;

import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor
public class JpaCardsRepository {

    private static final String CARD_NUMBER_PARAMETER = "number";

    private final EntityManager entityManager;

    public Optional<Long> getIdByNumber(String cardNumber) {
        try {
            var cardId = entityManager.createNamedQuery(CardEntity.GET_ID_BY_NUMBER, Long.class)
                    .setParameter(CARD_NUMBER_PARAMETER, cardNumber)
                    .getSingleResult();
            return Optional.of(cardId);
        } catch (NoResultException noResultException) {
            return Optional.empty();
        }
    }

    public void save(CardEntity cardEntity) {
        entityManager.persist(cardEntity);
    }

}
