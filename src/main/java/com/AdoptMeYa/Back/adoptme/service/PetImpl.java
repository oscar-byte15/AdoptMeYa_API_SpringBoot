package com.AdoptMeYa.Back.adoptme.service;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.Pet;
import com.AdoptMeYa.Back.adoptme.domain.persistence.PetRepository;
import com.AdoptMeYa.Back.adoptme.domain.service.PetService;
import com.AdoptMeYa.Back.shared.exception.ResourceNotFoundException;
import com.AdoptMeYa.Back.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
public class PetImpl implements PetService {
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private Validator validator;

    @Override
    public List<Pet> getAll() {
        return petRepository.findAll();
    }

    @Override
    public Page<Pet> getAll(Pageable pageable) {
        return petRepository.findAll(pageable);
    }

    @Override
    public Pet create(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public Pet getById(Long id) {
        return petRepository.getById(id);
    }

    @Override
    public Pet update(Pet request, Long id) {
        Set<ConstraintViolation<Pet>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException("Pet", violations);

        if(!petRepository.existsById(id))
            throw new ResourceNotFoundException("Pet", id);

        return petRepository.findById(id).map(pet -> {
            return petRepository.save(
                pet.withAge(request.getAge())
                .withAttention(request.getAttention())
                .withIsAdopted(request.getIsAdopted())
                .withName(request.getName())
                .withRace(request.getRace())
                .withType(request.getType())
                
            );}).orElseThrow(() -> new ResourceNotFoundException("Pet", id ));
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return petRepository.findById(id).map(pet -> {
            petRepository.delete(pet);
            return ResponseEntity.ok().build();

        }).orElseThrow(() -> new ResourceNotFoundException("Pet", id));
    }

    @Override
    public List<Pet> ReadPetsByPublicationId(Long id){

        return petRepository.ReadPetsByPublicationId(id);
    }

    @Override
    public List<Pet> ReadPetsByUserId(Long id){
        return petRepository.ReadPetsByUserId(id);
    }

    @Override
    public List<Pet> ReadPetsByAttention(String attention) {
        return petRepository.ReadPetsByAttention(attention);
    }

    @Override
    public List<Pet> ReadPetsByType(String type) {
        return petRepository.ReadPetsByType(type);
    }

    @Override
    public List<Pet> ReadPetsByGender(String gender) {
        return petRepository.ReadPetsByGender(gender);
    }

    @Override
    public List<Pet> ReadPetsByGenderAttention(String gender, String attention) {
        return petRepository.ReadPetsByGenderAttention(gender, attention);
    }

    @Override
    public List<Pet> ReadPetsByTypeAttention(String type, String attention) {
        return petRepository.ReadPetsByTypeAttention(type, attention);
    }

    @Override
    public List<Pet> ReadPetsByTypeGender(String type, String gender) {
        return petRepository.ReadPetsByTypeGender(type, gender);
    }

    @Override
    public List<Pet> ReadPetsByTypeGenderAttention(String type, String gender, String attention) {
        return petRepository.ReadPetsByTypeGenderAttention(type, gender, attention);
    }

}
