package pl.mwyrzyk.transitapi.routing.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "distance",
        "weight",
        "time",
        "transfers",
        "snapped_waypoints"
})
public class Path {

    @JsonProperty("distance")
    private Double distance;
    @JsonProperty("weight")
    private Double weight;
    @JsonProperty("time")
    private Integer time;
    @JsonProperty("transfers")
    private Integer transfers;
    @JsonProperty("snapped_waypoints")
    private String snappedWaypoints;
    @JsonProperty("distance")
    public Double getDistance() {
        return distance;
    }

    @JsonProperty("distance")
    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @JsonProperty("weight")
    public Double getWeight() {
        return weight;
    }

    @JsonProperty("weight")
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @JsonProperty("time")
    public Integer getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(Integer time) {
        this.time = time;
    }

    @JsonProperty("transfers")
    public Integer getTransfers() {
        return transfers;
    }

    @JsonProperty("transfers")
    public void setTransfers(Integer transfers) {
        this.transfers = transfers;
    }

    @JsonProperty("snapped_waypoints")
    public String getSnappedWaypoints() {
        return snappedWaypoints;
    }

    @JsonProperty("snapped_waypoints")
    public void setSnappedWaypoints(String snappedWaypoints) {
        this.snappedWaypoints = snappedWaypoints;
    }
}