package pl.training.payments.adapters.input.rest;

import lombok.RequiredArgsConstructor;
import pl.training.payments.ports.input.CheckChargeStatusUseCase;

import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
@Path("/cards/charges")
@RequiredArgsConstructor
public class CheckCardStatusUseCaseRestAdapter {

    private final CheckChargeStatusUseCase checkChargeStatusUseCase;
    private final PaymentsRestMapper mapper;

    @GET
    @Path("{id:\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12}}")
    public ChargeStatusDto checkStatus(@PathParam("id") String chargeIdDto) {
        var chargeId = mapper.toDomain(chargeIdDto);
        var chargeStatus = checkChargeStatusUseCase.checkStatus(chargeId);
        return mapper.toDto(chargeStatus);
    }

}
