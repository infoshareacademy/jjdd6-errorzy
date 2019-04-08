package com.infoshareacademy.jjdd6.errorzy;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class City {
    private int uid;
    private double lat;
    private double lng;
    private int zoom;
    private String maps_icon;
    private String alias;
    private int break_city;
    private String name;
    private int num_places;
    private int refresh_rate;
    private String bounds;
    private int booked_bikes;
    private int set_point_bikes;
    private int available_bikes;
    private String bike_types;
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

    public String getMaps_icon() {
        return maps_icon;
    }

    public void setMaps_icon(String maps_icon) {
        this.maps_icon = maps_icon;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getBreak_city() {
        return break_city;
    }

    public void setBreak_city(int break_city) {
        this.break_city = break_city;
    }

    @XmlAttribute(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum_places() {
        return num_places;
    }

    public void setNum_places(int num_places) {
        this.num_places = num_places;
    }

    public int getRefresh_rate() {
        return refresh_rate;
    }

    public void setRefresh_rate(int refresh_rate) {
        this.refresh_rate = refresh_rate;
    }

    public String getBounds() {
        return bounds;
    }

    public void setBounds(String bounds) {
        this.bounds = bounds;
    }

    public int getBooked_bikes() {
        return booked_bikes;
    }

    public void setBooked_bikes(int booked_bikes) {
        this.booked_bikes = booked_bikes;
    }

    public int getSet_point_bikes() {
        return set_point_bikes;
    }

    public void setSet_point_bikes(int set_point_bikes) {
        this.set_point_bikes = set_point_bikes;
    }

    public int getAvailable_bikes() {
        return available_bikes;
    }

    public void setAvailable_bikes(int available_bikes) {
        this.available_bikes = available_bikes;
    }

    public String getBike_types() {
        return bike_types;
    }

    public void setBike_types(String bike_types) {
        this.bike_types = bike_types;
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






