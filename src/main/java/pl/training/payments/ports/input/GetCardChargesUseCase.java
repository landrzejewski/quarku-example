package pl.training.payments.ports.input;

import pl.training.commons.model.Page;
import pl.training.commons.model.ResultPage;
import pl.training.payments.ports.model.CardNumber;
import pl.training.payments.ports.model.Charge;

public interface GetCardChargesUseCase {

    ResultPage<Charge> getCharges(CardNumber cardNumber, Page page);

}
