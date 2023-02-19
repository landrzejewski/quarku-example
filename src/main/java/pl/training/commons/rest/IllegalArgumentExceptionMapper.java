package pl.training.commons.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import java.time.Instant;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

@Provider
public class IllegalArgumentExceptionMapper implements ExceptionMapper<IllegalArgumentException> {

    @Override
    public Response toResponse(IllegalArgumentException e) {
        return Response.status(BAD_REQUEST)
                .entity(new ExceptionDto(Instant.now(), "Illegal argument"))
                .build();
    }

}
