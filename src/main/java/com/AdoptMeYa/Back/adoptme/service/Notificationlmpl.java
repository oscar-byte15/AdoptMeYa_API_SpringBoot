package com.AdoptMeYa.Back.adoptme.service;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.Notification;
import com.AdoptMeYa.Back.adoptme.domain.persistence.NotificationRepository;
import com.AdoptMeYa.Back.adoptme.domain.service.NotificationService;
import com.AdoptMeYa.Back.shared.exception.ResourceNotFoundException;
import com.AdoptMeYa.Back.shared.exception.ResourceValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
public class Notificationlmpl implements NotificationService {


    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private Validator validator;

    @Override
    public Notification create(Notification notification){return notificationRepository.save(notification);}

    @Override
    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }

    @Override
    public Notification getById(Long Id) {
        return notificationRepository.getById(Id);

    }

    @Override
    public ResponseEntity<?> delete(Long Id) {
        return notificationRepository.findById(Id).map(notification -> {
            notificationRepository.delete(notification);
            return ResponseEntity.ok().build();

        }).orElseThrow(() -> new ResourceNotFoundException("Notification", Id));
    }

    @Override
    public Notification update(Long Id, Notification request) {

        Set<ConstraintViolation<Notification>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException("Notification", violations);

        if(!notificationRepository.existsById(Id))
            throw new ResourceNotFoundException("Notification", Id);

        return notificationRepository.findById(Id)
                .map(notification -> {
            return notificationRepository.save(

                    notification.withApproved(request.getApproved())
                            .withMessage(request.getMessage())
                            .withUseridAt(request.getUseridAt())
                            .withUerIdFrom(request.getUerIdFrom())
                            .withApproved(request.getApproved())

                    );}).orElseThrow(() -> new ResourceNotFoundException("Notification", Id ));
    }
}
