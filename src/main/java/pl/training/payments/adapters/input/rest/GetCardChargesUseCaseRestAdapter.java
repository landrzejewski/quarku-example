package pl.training.payments.adapters.input.rest;

import lombok.RequiredArgsConstructor;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
@Path("/cards")
@RequiredArgsConstructor
public class GetCardChargesUseCaseRestAdapter {

    private final PaymentsRestMapper mapper;

    @GET
    @Path("{cardNumber}/charges")
    public Response getCharges(
            @PathParam("cardNumber") String cardNumber,
            @QueryParam("pageSize") @DefaultValue("5") int pageSize,
            @QueryParam("pageNumber") @DefaultValue("0") int pageNumber) {
        System.out.println("Get charges for " + cardNumber);
        return Response.ok().build();
    }

}
