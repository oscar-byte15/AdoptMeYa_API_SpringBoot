package com.AdoptMeYa.Back.adoptme.service;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.Publication;
import com.AdoptMeYa.Back.adoptme.domain.persistence.PublicationRepository;
import com.AdoptMeYa.Back.adoptme.domain.service.PublicationService;
import com.AdoptMeYa.Back.shared.exception.ResourceNotFoundException;
import com.AdoptMeYa.Back.shared.exception.ResourceValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PublicationImpl implements PublicationService{

    @Autowired
    private PublicationRepository publicationRepository;

    @Autowired
    private Validator validator;

    // C
    @Override
    public Publication create(Publication publication) {
        return publicationRepository.save(publication);
    }
    // R
    @Override
    public List<Publication> getAll() {
        return publicationRepository.findAll();
    }
    @Override
    public Page<Publication> getAll(Pageable pageable) {
        return publicationRepository.findAll(pageable);

    }
    @Override
    public Publication getById(Long publicationId) {
        return publicationRepository.getById(publicationId);
        
    }
    // U
    @Override
    public Publication update(Long publicationId, Publication request) {
        //return publicationRepository.save(p)
        Set<ConstraintViolation<Publication>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException("Publication", violations);
        
        if(!publicationRepository.existsById(publicationId))
            throw new ResourceNotFoundException("Publication", publicationId);

        return publicationRepository.findById(publicationId).map(publication -> {
            return publicationRepository.save(
                publication.withComment(request.getComment())
                .withPet(request.getPet())
                .withUser(request.getUser())
                );
 
        }).orElseThrow(() -> new ResourceNotFoundException("Publication", publicationId ));
    }
    @Override
    // D
    public ResponseEntity<?> delete(Long publicationtId) {
        return publicationRepository.findById(publicationtId).map(publication -> {
            publicationRepository.delete(publication);
            return ResponseEntity.ok().build();

        }).orElseThrow(() -> new ResourceNotFoundException("Publication", publicationtId));
    }
}