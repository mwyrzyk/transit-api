package pl.mwyrzyk.transitapi.geocoding.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "lng",
        "lat"
})
public class Point {

    @JsonProperty("lng")
    private Double lng;
    @JsonProperty("lat")
    private Double lat;

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getPointAsQueryparam() {
       return String.valueOf(lat) + ',' + lng;
    }
}