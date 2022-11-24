package com.AdoptMeYa.Back.adoptme.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class UpdateDistrictResource {
    @NotNull
    private String district;

    @NotNull
    private String description;
}
