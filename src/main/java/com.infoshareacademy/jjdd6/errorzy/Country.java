package com.infoshareacademy.jjdd6.errorzy;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;


public class Country {

    private List<City> cityList;
    private double lat;
    private double lng;
    private String name;
    private int zoom;
    private String hotline;
    private String domain;
    private String language;
    private String email;
    private String timezone;
    private String currency;
    private String country_calling_code;
    private String system_operator_address;
    private String country;
    private String country_name;
    private String terms;
    private String policy;
    private String website;
    private int booked_bikes;
    private int set_point_bikes;
    private int available_bikes;
    private String pricing;

    public Country() {
    }

    public Country(List<City> cityList, double lat, double lng, String country_name) {
        this.cityList = cityList;
        this.lat = lat;
        this.lng = lng;
        this.country_name = country_name;
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

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    public String getHotline() {
        return hotline;
    }

    public void setHotline(String hotline) {
        this.hotline = hotline;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCountry_calling_code() {
        return country_calling_code;
    }

    public void setCountry_calling_code(String country_calling_code) {
        this.country_calling_code = country_calling_code;
    }

    public String getSystem_operator_address() {
        return system_operator_address;
    }

    public void setSystem_operator_address(String system_operator_address) {
        this.system_operator_address = system_operator_address;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @XmlAttribute(name = "country_name")
    public String getCountry_name() {
        return country_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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

    public String getPricing() {
        return pricing;
    }

    public void setPricing(String pricing) {
        this.pricing = pricing;
    }

    @Override
    public String toString() {
        return "Country{" +
                "cityList=" + cityList +
                ", lat=" + lat +
                ", lng=" + lng +
                ", country_name='" + country_name + '\'' +
                '}';
    }
}