package com.AdoptMeYa.Back.adoptme.resource;

import javax.validation.constraints.NotNull;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.Pet;
import com.AdoptMeYa.Back.adoptme.domain.model.entity.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreatePublicationResource {
    @NotNull
    private String comment;
    @NotNull
    private User user;
    @NotNull
    private Pet pet;

}
