package pl.training.payments.adapters.input.rest;

import lombok.RequiredArgsConstructor;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
@Path("/cards/charges")
@RequiredArgsConstructor
public class CheckCardStatusUseCaseRestAdapter {

    private final PaymentsRestMapper mapper;

    @GET
    @Path("{id:\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12}}")
    public Response checkStatus(@PathParam("id") String chargeId) {
        System.out.println("Check status: " + chargeId);
        throw new IllegalArgumentException();
        //return Response.ok().build();
    }

}
