package com.AdoptMeYa.Back.adoptme.resource;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.Pet;
import com.AdoptMeYa.Back.adoptme.domain.model.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublicationResource {
    private Long id;
    private String comment;
    private int userId;
    private int petId;
}
