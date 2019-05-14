package com.infoshareacademy.jjdd6.errorzy;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class City {

    private Long id;
    private Country country;
    private List<Place> placeList;
    private double lat;
    private double lng;
    private String name;
    private int numPlaces;
    private int availableBikes;

    public City() {
    }

    public City(double lat, double lng, String name, List<Place> placeList) {
        this.lat = lat;
        this.lng = lng;
        this.name = name;
        this.placeList = placeList;
    }

    @XmlElement(name = "place")
    public List<Place> getPlaceList() {
        return placeList;
    }

    public void setPlaceList(List<Place> placeList) {
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
        return "City{" +
                "lat=" + lat +
                ", lng=" + lng +
                ", name='" + name + '\'' +
                ", placeList=" + placeList +
                '}';
    }
}
