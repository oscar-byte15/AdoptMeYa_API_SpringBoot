package com.AdoptMeYa.Back.adoptme.resource;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.District;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.Pet;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class UserResource {
    private Long id;
    private String email;
    private String password;
    private String type;
    private String user;
    private String ruc;
    private String dni;
    private String phone;
    private String name;
    private String lastname;
    private District district;
}
