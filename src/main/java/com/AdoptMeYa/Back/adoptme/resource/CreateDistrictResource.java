package com.AdoptMeYa.Back.adoptme.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateDistrictResource {

    @NotNull
    private String district;
    @NotNull
    private String description; 

}
