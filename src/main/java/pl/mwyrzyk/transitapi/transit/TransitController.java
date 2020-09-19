package pl.mwyrzyk.transitapi.transit;

import pl.mwyrzyk.transitapi.transit.dto.DailyReportDto;
import pl.mwyrzyk.transitapi.transit.dto.TransitDto;
import pl.mwyrzyk.transitapi.transit.serialization.TransitDeserializator;
import pl.mwyrzyk.transitapi.transit.serialization.TransitSerializator;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.time.LocalDate;

@Path("/")
@RequestScoped
public class TransitController {

    @Inject
    TransitService transitService;

    @Context
    private UriInfo uriInfo;

    //TODO Validate input
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/transits")
    public Response registerTransit(@Valid TransitDto transitDto) {
        Integer id = transitService.registerTransit(TransitDeserializator.toEntity(transitDto));
        URI uri = uriInfo.getAbsolutePathBuilder().path("/{id}").build(id);
        return Response.created(uri).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/reports/daily")
    public DailyReportDto dailyReport(@NotNull @QueryParam("start_date") String startDate, @NotNull @QueryParam("end_date") String endDate) {
        return TransitSerializator.toDailyReport(transitService.getDailyReport(LocalDate.parse(startDate), LocalDate.parse(endDate)));
    }

}