package pl.training.payments.adapters.output.persistence;

import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
@RequiredArgsConstructor
public class JpaChargesWriter {

    private final EntityManager entityManager;

    public ChargeEntity save(ChargeEntity chargeEntity) {
        entityManager.persist(chargeEntity.getCard());
        entityManager.persist(chargeEntity);
        return chargeEntity;
    }

}
