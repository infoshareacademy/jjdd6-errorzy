package com.infoshareacademy.jjdd6.errorzy;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Markers {

    private List<Country> countryList;

    public Markers() {
    }

    public Markers(List<Country> countryList) {
        this.countryList = countryList;
    }

    @XmlElement(name = "country")
    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    @Override
    public String toString() {
        return "Markers{" +
                "countryList=" + countryList +
                '}';
    }
}