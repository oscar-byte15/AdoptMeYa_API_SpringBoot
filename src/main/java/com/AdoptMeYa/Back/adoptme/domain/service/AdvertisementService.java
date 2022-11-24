package com.AdoptMeYa.Back.adoptme.domain.service;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.Advertisement;
import com.AdoptMeYa.Back.adoptme.domain.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdvertisementService {
    List<Advertisement> listAdvertisementsByUserId(Long userId);
    Page<Advertisement> listAdvertisements(Pageable pageable);
    ResponseEntity<?> delete(Long advertisementId);
    Advertisement create(Advertisement advertisement);
    Advertisement update(Long advertisementId, Advertisement request);
    List<Advertisement>ListAllAdvertisements();
    Advertisement getById(Long id);
}
