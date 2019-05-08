package com.infoshareacademy.jjdd6.errorzy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;

@Entity
@Table(name = "BIKES")
public class Bike {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @Column(name = "bike_number")
    @NotNull
    private int number;

    @Column(name = "bike_type")
    private int bikeType;

    public Bike() {
    }

    public Bike(int number, int bikeType) {
        this.number = number;
        this.bikeType = bikeType;
    }

    @XmlAttribute(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @XmlAttribute(name = "bike_type")
    public int getBikeType() {
        return bikeType;
    }

    public void setBikeType(int bikeType) {
        this.bikeType = bikeType;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "number=" + number +
                ", bikeType=" + bikeType +
                '}';
    }
}
