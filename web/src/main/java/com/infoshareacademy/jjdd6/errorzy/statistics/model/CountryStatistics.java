package com.infoshareacademy.jjdd6.errorzy.statistics.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "COUNTRY_STATISTICS")
public class CountryStatistics {


    @Id
    @Column(name = "country", length = 200)
    private String country;

    @Column(name = "number_of_visits")
    @NotNull
    private Long numberOfVisits;

    public CountryStatistics() {
    }

    public CountryStatistics(String name, Long numberOfVisits) {
        this.country = name;
        this.numberOfVisits = numberOfVisits;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String name) {
        this.country = name;
    }

    public Long getNumberOfVisits() {
        return numberOfVisits;
    }

    public void setNumberOfVisits(Long numberOfVisits) {
        this.numberOfVisits = numberOfVisits;
    }

    @Override
    public String toString() {
        return "CountryStatistics{" +
                "country='" + country + '\'' +
                ", numberOfVisits=" + numberOfVisits +
                '}';
    }
}
