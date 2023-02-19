package pl.training.payments.adapters.input.rest;

import pl.training.commons.rest.ExceptionDto;
import pl.training.payments.ports.model.ChargeNotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.time.Instant;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Provider
public class ChargeNotFoundExceptionMapper implements ExceptionMapper<ChargeNotFoundException> {

    @Override
    public Response toResponse(ChargeNotFoundException chargeNotFoundException) {
        return Response.status(NOT_FOUND)
                .entity(new ExceptionDto(Instant.now(), "Charge not found"))
                .build();
    }

}
