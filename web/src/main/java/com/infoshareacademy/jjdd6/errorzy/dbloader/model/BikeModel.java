package com.infoshareacademy.jjdd6.errorzy.dbloader.model;

import javax.persistence.*;

@Entity
@Table(name = "BIKES",
        uniqueConstraints = @UniqueConstraint(columnNames = {"bike_number", "place_id"}))

public class BikeModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "place_id")
    private PlaceModel place;

    @Column(name = "bike_number")
    private int number;

    @Column(name = "bike_type")
    private int bikeType;

    public BikeModel() {
    }

    public BikeModel(int number, int bikeType, PlaceModel placeModel) {
        this.number = number;
        this.bikeType = bikeType;
        this.place = placeModel;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBikeType() {
        return bikeType;
    }

    public void setBikeType(int bikeType) {
        this.bikeType = bikeType;
    }

    @Override
    public String toString() {
        return "BikeModel{" +
                "number=" + number +
                ", bikeType=" + bikeType +
                '}';
    }
}
