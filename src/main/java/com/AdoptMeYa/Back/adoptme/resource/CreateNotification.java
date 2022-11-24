package com.AdoptMeYa.Back.adoptme.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.Publication;

@Getter
@Setter
public class CreateNotification {
    @NotNull private Long uerIdFrom;
    @NotNull private Long useridAt;
    @NotNull private String message;
    @NotNull private Publication publication;
    @NotNull private Boolean approved;
}
