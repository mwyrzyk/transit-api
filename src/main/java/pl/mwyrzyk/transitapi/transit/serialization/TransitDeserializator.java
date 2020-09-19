package pl.mwyrzyk.transitapi.transit.serialization;

import pl.mwyrzyk.transitapi.transit.dto.TransitDto;
import pl.mwyrzyk.transitapi.transit.entity.Transit;

public final class TransitDeserializator {

    public static Transit toEntity(TransitDto transitDto) {
        Transit transit = new Transit();
        transit.setDestinationAddress(transitDto.getDestinationAddress());
        transit.setSourceAddress(transitDto.getSourceAddress());
        transit.setPrice(transitDto.getPrice());
        transit.setDate(transitDto.getDate());
        return transit;
    }
}
