package com.AdoptMeYa.Back.adoptme.resource;
import javax.validation.constraints.NotNull;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.User;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CreateAdvertisementResource {
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private Float discount;
    @NotNull
    private String url;
    @NotNull
    private Boolean promoted;
    @NotNull
    private int userId;
}
