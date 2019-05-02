package com.infoshareacademy.jjdd6.errorzy.promotedPointsServices;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROMOTED_POINTS")
public class PromotedPointModel {

    @Id
    @Column(name = "added_point_id")
    private int addingPointId;

    public int getAddingPointId() {
        return addingPointId;
    }

    public void setAddingPointId(int addingPointId) {
        this.addingPointId = addingPointId;
    }

    public PromotedPointModel(int addingPointId) {
        this.addingPointId = addingPointId;
    }
}