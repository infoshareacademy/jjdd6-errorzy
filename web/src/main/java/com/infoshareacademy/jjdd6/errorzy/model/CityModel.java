package com.infoshareacademy.jjdd6.errorzy.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Entity
@Table(name = "CITIES")
public class CityModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryModel country;

    @OneToMany(mappedBy = "city")
    private List<PlaceModel> placeList;

    @Column(name = "lateral_coordinate", columnDefinition = "DECIMAL(10,6)")
    private double lat;

    @Column(name = "longitudinal_coordinate", columnDefinition = "DECIMAL(10,6)")
    private double lng;


    @Column(name = "city_name")
    @NotNull
    private String name;

    @Transient
    private int numPlaces;
    @Transient
    private int availableBikes;

    public CityModel() {
    }

    public CityModel(double lat, double lng, String name, List<PlaceModel> placeList) {
        this.lat = lat;
        this.lng = lng;
        this.name = name;
        this.placeList = placeList;
    }

    @XmlElement(name = "place")
    public List<PlaceModel> getPlaceList() {
        return placeList;
    }

    public void setPlaceList(List<PlaceModel> placeList) {
        this.placeList = placeList;
    }

    @XmlAttribute(name = "lat")
    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    @XmlAttribute(name = "lng")
    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @XmlAttribute(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumPlaces() {
        return numPlaces;
    }

    public void setNumPlaces(int numPlaces) {
        this.numPlaces = numPlaces;
    }

    public int getAvailableBikes() {
        return availableBikes;
    }

    public void setAvailableBikes(int availableBikes) {
        this.availableBikes = availableBikes;
    }

    @Override
    public String toString() {
        return "CityModel{" +
                "lat=" + lat +
                ", lng=" + lng +
                ", name='" + name + '\'' +
                ", placeList=" + placeList +
                '}';
    }
}
