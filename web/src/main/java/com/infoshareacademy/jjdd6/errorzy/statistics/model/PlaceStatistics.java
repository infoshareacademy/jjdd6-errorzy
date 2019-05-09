package com.infoshareacademy.jjdd6.errorzy.statistics.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PLACE_STATISTICS")
public class PlaceStatistics {

    @Id
    @Column(name = "place")
    private String place;

    @Column(name = "number_of_visits")
    private Long numberOfVisits;

    public PlaceStatistics() {
    }

    public PlaceStatistics(String name, Long numberOfVisits) {
        this.place = name;
        this.numberOfVisits = numberOfVisits;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String name) {
        this.place = name;
    }

    public Long getNumberOfVisits() {
        return numberOfVisits;
    }

    public void setNumberOfVisits(Long numberOfVisits) {
        this.numberOfVisits = numberOfVisits;
    }
}
