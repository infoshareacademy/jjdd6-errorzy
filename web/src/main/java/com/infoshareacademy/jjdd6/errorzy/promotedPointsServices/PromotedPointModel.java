package com.infoshareacademy.jjdd6.errorzy.promotedPointsServices;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PROMOTED_POINTS")
public class PromotedPointModel {

    @Id
    @Column(name = "point_name")
    @NotNull
    private String name;

    @Id
    @Column(name = "city")
    @NotNull
    private  String city;

    @Id
    @Column(name = "place")
    @NotNull
    private String place;



