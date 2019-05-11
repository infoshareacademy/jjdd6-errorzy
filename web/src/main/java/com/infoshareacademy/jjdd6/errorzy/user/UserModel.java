package com.infoshareacademy.jjdd6.errorzy.user;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

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

    @Column(name = "role_administration")
    @NotNull
    private Boolean roleAdministration;

    @Column(name = "promoted_points")
    @NotNull
    private String promotedPoints;

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

    public Boolean getRoleAdministration() {
        return roleAdministration;
    }

    public void setRoleAdministration(Boolean roleAdministration) {
        this.roleAdministration = roleAdministration;
    }

    public String getPromotedPoints() {
        return promotedPoints;
    }

    public void setPromotedPoints(String promotedPoints) {
        this.promotedPoints = promotedPoints;
    }

    public UserModel(@Email String email, @NotNull Boolean roleAdministration, @NotNull String promotedPoints) {
        this.email = email;
        this.roleAdministration = roleAdministration;
        this.promotedPoints = promotedPoints;
    }

}
