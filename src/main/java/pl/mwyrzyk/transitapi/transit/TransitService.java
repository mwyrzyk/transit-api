package pl.mwyrzyk.transitapi.transit;

import pl.mwyrzyk.transitapi.config.ApplicationProperties;
import pl.mwyrzyk.transitapi.exception.ApplicationException;
import pl.mwyrzyk.transitapi.routing.dto.Path;
import pl.mwyrzyk.transitapi.routing.dto.RouteDto;
import pl.mwyrzyk.transitapi.transit.entity.Transit;
import pl.mwyrzyk.transitapi.geocoding.dto.GeocodeDto;
import pl.mwyrzyk.transitapi.geocoding.GeocodingResource;
import pl.mwyrzyk.transitapi.geocoding.dto.Hit;
import pl.mwyrzyk.transitapi.geocoding.dto.Point;
import pl.mwyrzyk.transitapi.routing.RoutingResource;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class TransitService {

    @Inject
    ApplicationProperties applicationProperties;

    @Inject
    GeocodingResource geocodingResource;

    @Inject
    RoutingResource routingResource;

    @Inject
    TransitRepository transitRepository;

    public Integer registerTransit(Transit transit) {
        transit.setDistance(calculateDistance(transit.getSourceAddress(), transit.getDestinationAddress()));
        return transitRepository.create(transit);
    }


    private Integer calculateDistance(String sourceAddress, String destinationAddress) {
        final String geocodingApiKey = applicationProperties.getProperty("geocoding-api-key");
        final List<String> points = new ArrayList<>();

        points.add(extractAddress(geocodingResource.translateAddress(sourceAddress, geocodingApiKey, 1)));
        points.add(extractAddress(geocodingResource.translateAddress(destinationAddress, geocodingApiKey, 1)));

        return extractRoute(routingResource.designateRoutes(points, false, false, geocodingApiKey));
    }

    private String extractAddress(GeocodeDto geocodeDto) {
        return Optional.ofNullable(geocodeDto)
                .map(GeocodeDto::getHits)
                .map(hits -> hits.isEmpty() ? null : hits.get(0))
                .map(Hit::getPoint)
                .map(Point::getPointAsQueryparam)
                .orElseThrow(() -> new ApplicationException(Response.Status.BAD_REQUEST, "Address not found"));
    }

    private Integer extractRoute(RouteDto routeDto) {
       return Optional.ofNullable(routeDto)
                .map(RouteDto::getPaths)
                .map(paths -> paths.isEmpty() ? null : paths.get(0))
                .map(Path::getDistance)
                .map(Double::intValue)
                .orElseThrow(() -> new ApplicationException(Response.Status.BAD_REQUEST, "Route not found"));

    }
}
