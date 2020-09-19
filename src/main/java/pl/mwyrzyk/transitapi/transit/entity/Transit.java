package pl.mwyrzyk.transitapi.transit.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NamedNativeQueries({@NamedNativeQuery(name = "Transit.sumDistanceAndPriceBetweenDates",
        query = "SELECT SUM (distance) as distance, SUM(price) as price from transit where :since <= date AND date <= :till")})
public class Transit {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="source_address")
    private String sourceAddress;

    @Column(name="destination_address")
    private String destinationAddress;

    private Integer distance;

    private int price;

    private LocalDate date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
