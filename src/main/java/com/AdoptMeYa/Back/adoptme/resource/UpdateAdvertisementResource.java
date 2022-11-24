package com.AdoptMeYa.Back.adoptme.resource;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAdvertisementResource {
    private Long id;
    @NotNull
    private Long user_id;
    @NotNull
    private String title;
    @NotNull
    private String description;

    private Float discount;

    private String url;

    private Boolean promoted;
}
