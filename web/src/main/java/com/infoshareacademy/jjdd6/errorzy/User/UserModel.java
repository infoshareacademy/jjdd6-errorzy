package com.infoshareacademy.jjdd6.errorzy.User;

import com.infoshareacademy.jjdd6.errorzy.Place;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "USERS")
public class UserModel {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "administration_role")
    @NotNull
    private Boolean administrationRole;

    @Column(name = "promoted_points")
    @NotNull
    private String promotedPoints;

    @ManyToMany
    @@JoinTable(name = "POINTS_TO_USERS",
    joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "place_name", referencedColumnName = "name"))
    private List<Place> places;

    public UserModel() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAdministrationRole() {
        return administrationRole;
    }

    public void setAdministrationRole(Boolean administrationRole) {
        this.administrationRole = administrationRole;
    }

    public String getPromotedPoints() {
        return promotedPoints;
    }

    public void setPromotedPoints(String promotedPoints) {
        this.promotedPoints = promotedPoints;
    }

    public UserModel(@Email String email, @NotNull Boolean administrationRole, @NotNull String promotedPoints) {
        this.email = email;
        this.administrationRole = administrationRole;
        this.promotedPoints = promotedPoints;
    }

}
