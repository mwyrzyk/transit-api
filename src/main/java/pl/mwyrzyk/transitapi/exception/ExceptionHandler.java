package pl.mwyrzyk.transitapi.exception;

import javax.ejb.EJBException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionHandler implements ExceptionMapper<EJBException> {

    public Response toResponse(EJBException e) {

        if (e instanceof ApplicationException)
            return Response.status(((ApplicationException) e).getStatus()).entity(e.getMessage()).build();
        else
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Unexpected server error").build();
    }
}