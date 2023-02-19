package pl.training.payments.adapters.input.rest;

import lombok.RequiredArgsConstructor;
import pl.training.payments.ports.input.ChargeCardUseCase;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
@Path("/cards/charges")
@RequiredArgsConstructor
public class ChardCardUseCaseRestAdapter {

    private final ChargeCardUseCase chargeCardUseCase;
    private final PaymentsRestMapper mapper;

    @POST
    public Response charge(@Valid ChargeRequestDto chargeRequestDto, @Context UriInfo uriInfo) {
        var chargeRequest = mapper.toDomain(chargeRequestDto);
        var chargeId = chargeCardUseCase.charge(chargeRequest);
        var locationUri = uriInfo.getAbsolutePathBuilder()
                .path(chargeId.value())
                .build();
        return Response.created(locationUri)
                .entity(mapper.toDto(chargeId))
                .build();
    }

}
