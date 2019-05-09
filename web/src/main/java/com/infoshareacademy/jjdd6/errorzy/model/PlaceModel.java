package com.infoshareacademy.jjdd6.errorzy.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "PLACES")
public class PlaceModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    @ManyToOne
//    @JoinColumn(name = "city_id")
    @Transient
    private CityModel city;

    @OneToMany(mappedBy = "place")
    private List<BikeModel> bikeList;

    @Column(name = "lateral_coordinate")
    private double lat;

    @Column(name = "longitudinal_coordinate")
    private double lng;

    @Column(name = "place_name")
    @NotNull
    private String name;

    @Column(name = "place_number")
    private int number;

    @Transient
    private int bikes;
    @Transient
    private String bikeNumbers;

    public PlaceModel() {
    }

    public PlaceModel(double lat, double lng, String name, int number, List<BikeModel> bikeList) {
        this.lat = lat;
        this.lng = lng;
        this.name = name;
        this.number = number;
        this.bikeList = bikeList;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getBikeNumbers() {
        return bikeNumbers;
    }

    public void setBikeNumbers(String bikeNumbers) {
        this.bikeNumbers = bikeNumbers;
    }

    public List<BikeModel> getBikeList() {
        return bikeList;
    }

    public void setBikeList(List<BikeModel> bikeList) {
        this.bikeList = bikeList;
    }

    @Override
    public String toString() {
        return "PlaceModel{" +
                "lat=" + lat +
                ", lng=" + lng +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", bikeList=" + bikeList +
                '}';
    }
}
