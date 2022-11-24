package com.AdoptMeYa.Back.adoptme.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
@Getter
@Setter
public class UpdateUserResource {
    private Long id;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String type;

    @NotNull
    private String user;

    @NotNull
    private String ruc;

    @NotNull
    private String dni;

    @NotNull
    private String phone;

    @NotNull
    private String name;

    @NotNull
    private String lastname;
}
