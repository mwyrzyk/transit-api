package pl.mwyrzyk.transitapi.geocoding.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "osm_id",
        "extent",
        "country",
        "city",
        "postcode",
        "point",
        "osm_type",
        "osm_key",
        "housenumber",
        "street",
        "osm_value",
        "name",
        "state"
})
public class Hit {

    @JsonProperty("osm_id")
    private Integer osmId;

    @JsonProperty("extent")
    private List<Double> extent = null;

    @JsonProperty("country")
    private String country;

    @JsonProperty("city")
    private String city;

    @JsonProperty("postcode")
    private String postcode;

    @JsonProperty("point")
    private Point point;

    @JsonProperty("osm_type")
    private String osmType;

    @JsonProperty("osm_key")
    private String osmKey;

    @JsonProperty("housenumber")
    private String housenumber;

    @JsonProperty("street")
    private String street;

    @JsonProperty("osm_value")
    private String osmValue;

    @JsonProperty("name")
    private String name;

    @JsonProperty("state")
    private String state;


    public Integer getOsmId() {
        return osmId;
    }

    public void setOsmId(Integer osmId) {
        this.osmId = osmId;
    }

    public List<Double> getExtent() {
        return extent;
    }

    public void setExtent(List<Double> extent) {
        this.extent = extent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public String getOsmType() {
        return osmType;
    }

    public void setOsmType(String osmType) {
        this.osmType = osmType;
    }

    public String getOsmKey() {
        return osmKey;
    }

    public void setOsmKey(String osmKey) {
        this.osmKey = osmKey;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getOsmValue() {
        return osmValue;
    }

    public void setOsmValue(String osmValue) {
        this.osmValue = osmValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}