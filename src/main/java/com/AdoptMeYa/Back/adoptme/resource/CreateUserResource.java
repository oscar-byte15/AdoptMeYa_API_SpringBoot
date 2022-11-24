package com.AdoptMeYa.Back.adoptme.resource;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.District;
@Setter
@Getter
public class CreateUserResource {
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

    @NotNull
    private District district;

}
