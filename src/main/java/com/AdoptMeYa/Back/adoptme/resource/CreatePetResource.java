package com.AdoptMeYa.Back.adoptme.resource;
import com.AdoptMeYa.Back.adoptme.domain.model.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.Publication;

@Setter
@Getter
public class CreatePetResource {

    @NotNull
    private String type;

    @NotNull
    private String name;

    @NotNull
    private String attention;

    @NotNull
    private String race;

    @NotNull
    private Integer age;

    @NotNull
    private String isAdopted;

    @NotNull
    private String gender;

    @NotNull
    private User user;

    private Publication publication;
}
