package com.infoshareacademy.jjdd6.errorzy.promotedPoints;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PROMOTED_POINTS")
public class PromotedPointsModel {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "place")
    @NotNull
    private String name;

    @ManyToMany
    @JoinTable(name = "PLACES_TO_PROMOTED_POINTS",
    joinColumns = @JoinColumn(name = "promoted_point_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "place_id", referencedColumnName = "name"))

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public PromotedPointsModel(@NotNull Long placeId) {
        this.placeId = placeId;
    }


}
