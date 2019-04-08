package com.infoshareacademy.jjdd6.errorzy;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Place {

    private int uid;
    private double lat;
    private double lng;
    private String name;
    private int spot;
    private int number;
    private int bikes;
    private int booked_bikes;
    private int bike_racks;
    private int free_racks;
    private String terminal_type;
    private int[] bike_numbers;
    private String bike_types;
    private int place_type;
    private List<Bike> bikeList;

    public Place() {
    }

    public Place(double lat, double lng, String name, int number, List<Bike> bikeList) {
        this.lat = lat;
        this.lng = lng;
        this.name = name;
        this.number = number;
        this.bikeList = bikeList;
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

    @XmlAttribute(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpot() {
        return spot;
    }

    public void setSpot(int spot) {
        this.spot = spot;
    }

    @XmlAttribute(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBikes() {
        return bikes;
    }

    public void setBikes(int bikes) {
        this.bikes = bikes;
    }

    public int getBooked_bikes() {
        return booked_bikes;
    }

    public void setBooked_bikes(int booked_bikes) {
        this.booked_bikes = booked_bikes;
    }

    public int getBike_racks() {
        return bike_racks;
    }

    public void setBike_racks(int bike_racks) {
        this.bike_racks = bike_racks;
    }

    public int getFree_racks() {
        return free_racks;
    }

    public void setFree_racks(int free_racks) {
        this.free_racks = free_racks;
    }

    public String getTerminal_type() {
        return terminal_type;
    }

    public void setTerminal_type(String terminal_type) {
        this.terminal_type = terminal_type;
    }

    public int[] getBike_numbers() {
        return bike_numbers;
    }

    public void setBike_numbers(int[] bike_numbers) {
        this.bike_numbers = bike_numbers;
    }

    public String getBike_types() {
        return bike_types;
    }

    public void setBike_types(String bike_types) {
        this.bike_types = bike_types;
    }

    public int getPlace_type() {
        return place_type;
    }

    public void setPlace_type(int place_type) {
        this.place_type = place_type;
    }

    @XmlElement(name = "bike")
    public List<Bike> getBikeList() {
        return bikeList;
    }

    public void setBikeList(List<Bike> bikeList) {
        this.bikeList = bikeList;
    }

    @Override
    public String toString() {
        return "Place{" +
                "lat=" + lat +
                ", lng=" + lng +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", bikeList=" + bikeList +
                '}';
    }
}
