package com.infoshareacademy.jjdd6.errorzy;

import javax.xml.bind.annotation.XmlAttribute;


public class Bike {

    private Long id;
    private Place place;
    private int number;
    private int bikeType;

    public Bike() {
    }

    public Bike(int number, int bikeType) {
        this.number = number;
        this.bikeType = bikeType;
    }

    @XmlAttribute(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @XmlAttribute(name = "bike_type")
    public int getBikeType() {
        return bikeType;
    }

    public void setBikeType(int bikeType) {
        this.bikeType = bikeType;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "number=" + number +
                ", bikeType=" + bikeType +
                '}';
    }
}
