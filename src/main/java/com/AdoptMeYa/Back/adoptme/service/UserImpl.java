package com.AdoptMeYa.Back.adoptme.service;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.User;
import com.AdoptMeYa.Back.adoptme.domain.persistence.UserRepository;
import com.AdoptMeYa.Back.adoptme.domain.service.UserService;
import com.AdoptMeYa.Back.shared.exception.ResourceNotFoundException;
import com.AdoptMeYa.Back.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private Validator validator;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public User update(User request, Long id) {
        Set<ConstraintViolation<User>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException("User", violations);

        if(!userRepository.existsById(id))
            throw new ResourceNotFoundException("User", id);

        return userRepository.findById(id).map(
            user -> {
                return userRepository.save(
                    user.withEmail(request.getEmail())
                    .withPassword(request.getPassword())
                    .withType(request.getType())
                    .withUser(request.getUser())
                    .withRuc(request.getRuc())
                    .withDni(request.getDni())
                    .withPhone(request.getPhone())
                    .withName(request.getName())
                    .withLastname(request.getLastname()))
                                        
                    ;}).orElseThrow(() -> new ResourceNotFoundException("User", id ));
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return ResponseEntity.ok().build();

        }).orElseThrow(() -> new ResourceNotFoundException("User", id));
    }
}
