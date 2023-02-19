package pl.training.payments.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import pl.training.payments.ports.model.Charge;
import pl.training.payments.ports.model.ChargeId;
import pl.training.payments.ports.output.ChargesReader;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor
public class JpaChargesReaderAdapter implements ChargesReader {

    private final JpaChargesRepository chargesRepository;
    private final PaymentsPersistenceMapper mapper;

    @Override
    public Optional<Charge> getById(ChargeId chargeId) {
        return chargesRepository.getById(mapper.toEntity(chargeId))
                .map(mapper::toDomain);
    }

}
