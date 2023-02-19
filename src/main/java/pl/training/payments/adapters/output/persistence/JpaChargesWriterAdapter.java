package pl.training.payments.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import pl.training.payments.ports.model.Charge;
import pl.training.payments.ports.output.ChargesWriter;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
public class JpaChargesWriterAdapter implements ChargesWriter {

    private final JpaChargesRepository chargesWriter;
    private final PaymentsPersistenceMapper mapper;

    @Override
    public Charge save(Charge charge) {
        var chargeEntity = mapper.toEntity(charge);
        var savedChargeEntity = chargesWriter.save(chargeEntity);
        return mapper.toDomain(savedChargeEntity);
    }

}
