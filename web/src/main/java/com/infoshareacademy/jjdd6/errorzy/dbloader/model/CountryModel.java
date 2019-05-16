package com.infoshareacademy.jjdd6.errorzy.dbloader.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "COUNTRIES")
public class CountryModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    private List<CityModel> cityList;

    @Column(name = "lateral_coordinate")
    private double lat;

    @Column(name = "longitudinal_coordinate")
    private double lng;

    @Column(name = "country_name", length = 32, unique = true)
    @NotNull
    private String countryName;

    @Transient
    private String name;
    @Transient
    private String country;
    @Transient
    private int availableBikes;

    public CountryModel() {
    }

    public CountryModel(double lat, double lng, String countryName) {
        this.lat = lat;
        this.lng = lng;
        this.countryName = countryName;
    }

    public List<CityModel> getCityList() {
        return cityList;
    }

    public void setCityList(List<CityModel> cityList) {
        this.cityList = cityList;
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

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getAvailableBikes() {
        return availableBikes;
    }

    public void setAvailableBikes(int availableBikes) {
        this.availableBikes = availableBikes;
    }

    @Override
    public String toString() {
        return "CountryModel{" +
                "cityList=" + cityList +
                ", lat=" + lat +
                ", lng=" + lng +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}