package com.infoshareacademy.jjdd6;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class City {
    private int uid;
    private double lat;
    private double lng;
    private int zoom;
    private String mapsIcon;
    private String alias;
    private int breakCity;
    private String name;
    private int numPlaces;
    private int refreshRate;
    private String bounds;
    private int bookedBikes;
    private int setPointBikes;
    private int availableBikes;
    private String bikeTypes;
    private List<Place> placeList;

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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    public String getMapsIcon() {
        return mapsIcon;
    }

    public void setMapsIcon(String mapsIcon) {
        this.mapsIcon = mapsIcon;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getBreakCity() {
        return breakCity;
    }

    public void setBreakCity(int breakCity) {
        this.breakCity = breakCity;
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

    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public String getBounds() {
        return bounds;
    }

    public void setBounds(String bounds) {
        this.bounds = bounds;
    }

    public int getBookedBikes() {
        return bookedBikes;
    }

    public void setBookedBikes(int bookedBikes) {
        this.bookedBikes = bookedBikes;
    }

    public int getSetPointBikes() {
        return setPointBikes;
    }

    public void setSetPointBikes(int setPointBikes) {
        this.setPointBikes = setPointBikes;
    }

    public int getAvailableBikes() {
        return availableBikes;
    }

    public void setAvailableBikes(int availableBikes) {
        this.availableBikes = availableBikes;
    }

    public String getBikeTypes() {
        return bikeTypes;
    }

    public void setBikeTypes(String bikeTypes) {
        this.bikeTypes = bikeTypes;
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






