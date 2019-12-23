package pl.mwyrzyk.transitapi.exception;

import javax.ejb.EJBException;
import javax.ws.rs.core.Response;

public class ApplicationException extends EJBException {

    private static final long serialVersionUID = 1239198836314630229L;

    private Response.Status status;

    public ApplicationException(Response.Status status, String message) {
        super(message);
        this.status = status;
    }

    public Response.Status getStatus() {
        return status;
    }

    public void setStatus(Response.Status status) {
        this.status = status;
    }
}
