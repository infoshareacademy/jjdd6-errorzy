package com.infoshareacademy.jjdd6;

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
    private String countryCallingCode;
    private String systemOperatorAddress;
    private String country;
    private String countryName;
    private String terms;
    private String policy;
    private String website;
    private int bookedBikes;
    private int setPointBikes;
    private int availableBikes;
    private String pricing;

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

    public String getCountryCallingCode() {
        return countryCallingCode;
    }

    public void setCountryCallingCode(String countryCallingCode) {
        this.countryCallingCode = countryCallingCode;
    }

    public String getSystemOperatorAddress() {
        return systemOperatorAddress;
    }

    public void setSystemOperatorAddress(String systemOperatorAddress) {
        this.systemOperatorAddress = systemOperatorAddress;
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
                ", countryName='" + countryName + '\'' +
                '}';
    }
}