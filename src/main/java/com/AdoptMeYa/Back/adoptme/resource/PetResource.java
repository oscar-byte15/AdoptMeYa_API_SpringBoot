package com.AdoptMeYa.Back.adoptme.resource;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.Publication;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetResource {
    private Long id;
    private String type;
    private String name;
    private String attention;
    private String race;
    private Integer age;
    private String isAdopted;
    private String gender;
    private Long userId;
    private Long publicationId;
}
