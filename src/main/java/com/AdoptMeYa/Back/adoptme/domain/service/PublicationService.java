package com.AdoptMeYa.Back.adoptme.domain.service;
import java.util.List;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.Publication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PublicationService {
    List<Publication> getAll();
    Page<Publication> getAll(Pageable pageable);
    Publication getById(Long publicationId);
    Publication create(Publication publication);
    Publication update(Long publicationId, Publication request);
    ResponseEntity<?> delete(Long publicationtId);
    
}
