package pl.mwyrzyk.transitapi.routing;

import pl.mwyrzyk.transitapi.routing.dto.RouteDto;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

public interface RoutingResource {

    @GET
    @Path("/")
    RouteDto designateRoutes(@QueryParam(value = "point") List<String> point, @DefaultValue("false") @QueryParam(value = "calc_points") Boolean calcPoints, @DefaultValue("false") @QueryParam(value = "instructions") Boolean instructions, @QueryParam(value = "key") String key);
}
