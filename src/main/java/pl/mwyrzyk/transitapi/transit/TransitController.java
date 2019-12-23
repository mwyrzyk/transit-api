package pl.mwyrzyk.transitapi.transit;

import pl.mwyrzyk.transitapi.transit.dto.TransitDto;
import pl.mwyrzyk.transitapi.transit.serialization.TransitSerializator;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import java.net.URI;

@Path("/")
@RequestScoped
public class TransitController {

    @Inject
    TransitService transitService;

    @Context
    private UriInfo uriInfo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/transits")
    public Response registerTransit(TransitDto transitDto) {
            Integer id = transitService.registerTransit(TransitSerializator.toEntity(transitDto));
            URI uri = uriInfo.getAbsolutePathBuilder().path("/{id}").build(id);
            return Response.created(uri).build();
        }

}