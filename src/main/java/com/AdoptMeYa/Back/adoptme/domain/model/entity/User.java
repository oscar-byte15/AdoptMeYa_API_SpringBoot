package com.AdoptMeYa.Back.adoptme.domain.model.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@With
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String password;

    @NotNull
    @NotBlank
    private String type;

    @NotNull
    @NotBlank
    @Column(name = "userType")
    private String user;

    @NotNull
    @NotBlank
    private String ruc;

    @NotNull
    @NotBlank
    private String dni;

    @NotNull
    @NotBlank
    private String phone;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String lastname;

    @ManyToOne(optional=false)
    @NotNull
    @JoinColumn(name= "district_id")
    private District district;



}
