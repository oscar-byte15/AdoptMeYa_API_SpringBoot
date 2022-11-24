package com.AdoptMeYa.Back.adoptme.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationResource {
    private Long id;
    private Long uerIdFrom;
    private Long useridAt;
    private String message;
    private Boolean approved;
}
