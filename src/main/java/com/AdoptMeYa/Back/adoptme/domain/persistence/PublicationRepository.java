package com.AdoptMeYa.Back.adoptme.domain.persistence;

import org.springframework.stereotype.Repository;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.Publication;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {
    
}
