package com.AdoptMeYa.Back.adoptme.domain.service;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.Notification;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface NotificationService {


    List<Notification> getAll();

    Notification getById(Long Id);
    Notification create(Notification notification);
    Notification update(Long Id, Notification request);
    ResponseEntity<?> delete(Long Id);

}
