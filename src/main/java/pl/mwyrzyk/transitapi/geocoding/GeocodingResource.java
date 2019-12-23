package pl.mwyrzyk.transitapi.geocoding;

import pl.mwyrzyk.transitapi.geocoding.dto.GeocodeDto;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

public interface GeocodingResource {

    @GET
    @Path("/")
    GeocodeDto translateAddress(@QueryParam(value = "q") String q, @QueryParam(value = "key") String key, @DefaultValue("1") @QueryParam(value = "limit") Integer limit);
}
