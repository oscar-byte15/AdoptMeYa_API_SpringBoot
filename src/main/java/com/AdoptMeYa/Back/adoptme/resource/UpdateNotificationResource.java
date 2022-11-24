package com.AdoptMeYa.Back.adoptme.resource;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UpdateNotificationResource {
    private Long id;
    @NotNull
    private Long uerIdFrom;
    @NotNull
    private Long useridAt;
    @NotNull
    private String message;
    @NotNull
    private Long publicationId;
    @NotNull
    private Boolean approved;
}
