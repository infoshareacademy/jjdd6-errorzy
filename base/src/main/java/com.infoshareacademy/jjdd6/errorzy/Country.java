package com.infoshareacademy.jjdd6.errorzy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Entity
@Table(name = "COUNTRIES")
public class Country {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    private List<City> cityList;
    @Column(name = "lateral")
    @NotNull
    private double lat;
    @Column(name = "longitudinal")
    @NotNull
    private double lng;
    @Column(name = "country_name")
    @NotNull
    private String countryName;

    @Transient
    private String name;
    @Transient
    private String country;
    @Transient
    private int availableBikes;


    public Country() {
    }

    public Country(List<City> cityList, double lat, double lng, String countryName) {
        this.cityList = cityList;
        this.lat = lat;
        this.lng = lng;
        this.countryName = countryName;
    }

    @XmlElement(name = "city")
    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @XmlAttribute(name = "country_name")
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
        return "Country{" +
                "cityList=" + cityList +
                ", lat=" + lat +
                ", lng=" + lng +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}