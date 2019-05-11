package com.infoshareacademy.jjdd6.errorzy.statistics.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CITY_STATISTICS")
public class CityStatistics {

    @Id
    @Column(name = "city")
    private String city;

    @Column(name = "number_of_visits")
    @NotNull
    private Long numberOfVisits;

    public CityStatistics() {
    }

    public CityStatistics(String name, Long numberOfVisits) {
        this.city = name;
        this.numberOfVisits = numberOfVisits;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String name) {
        this.city = name;
    }

    public Long getNumberOfVisits() {
        return numberOfVisits;
    }

    public void setNumberOfVisits(Long numberOfVisits) {
        this.numberOfVisits = numberOfVisits;
    }

    @Override
    public String toString() {
        return "CityStatistics{" +
                "city='" + city + '\'' +
                ", numberOfVisits=" + numberOfVisits +
                '}';
    }
}
