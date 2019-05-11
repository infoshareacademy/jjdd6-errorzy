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
    private int bookedBikes;
    private int bikeRacks;
    private int freeRacks;
    private String terminalType;
    private String bikeNumbers;
    private String bikeTypes;
    private int placeType;
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

    @XmlAttribute(name = "bikes")
    public int getBikes() {
        return bikes;
    }

    public void setBikes(int bikes) {
        this.bikes = bikes;
    }

    public int getBookedBikes() {
        return bookedBikes;
    }

    public void setBookedBikes(int bookedBikes) {
        this.bookedBikes = bookedBikes;
    }

    public int getBikeRacks() {
        return bikeRacks;
    }

    public void setBikeRacks(int bikeRacks) {
        this.bikeRacks = bikeRacks;
    }

    public int getFreeRacks() {
        return freeRacks;
    }

    public void setFreeRacks(int freeRacks) {
        this.freeRacks = freeRacks;
    }

    public String getTerminalType() {
        return terminalType;
    }

    public void setTerminalType(String terminalType) {
        this.terminalType = terminalType;
    }

    @XmlAttribute(name = "bike_numbers")
    public String getBikeNumbers() {
        return bikeNumbers;
    }

    public void setBikeNumbers(String bikeNumbers) {
        this.bikeNumbers = bikeNumbers;
    }

    public String getBikeTypes() {
        return bikeTypes;
    }

    public void setBikeTypes(String bikeTypes) {
        this.bikeTypes = bikeTypes;
    }

    public int getPlaceType() {
        return placeType;
    }

    public void setPlaceType(int placeType) {
        this.placeType = placeType;
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
