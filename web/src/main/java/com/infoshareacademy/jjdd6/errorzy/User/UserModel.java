package com.infoshareacademy.jjdd6.errorzy.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "USERS")
public class UserModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

@Column(name = "mail")
    @NotNull
    private String mail;

@Column(name = "admin")
    @NotNull
    private String admin;

@Column(name = "promoted_points")
@NotNull
    private String promotedPoints;

@Column



}
