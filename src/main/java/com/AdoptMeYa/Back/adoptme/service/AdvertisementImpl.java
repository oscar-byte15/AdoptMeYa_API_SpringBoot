package com.AdoptMeYa.Back.adoptme.service;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.Advertisement;
import com.AdoptMeYa.Back.adoptme.domain.persistence.AdvertisementRepository;
import com.AdoptMeYa.Back.adoptme.domain.service.AdvertisementService;
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
public class AdvertisementImpl implements AdvertisementService {
    @Autowired
    private AdvertisementRepository _advertisementRepository;
    @Autowired
    private Validator _validator;

    @Override
    public List<Advertisement> listAdvertisementsByUserId(Long userId) {
        return _advertisementRepository.ListAdvertisementByUserId(userId);
    }

    @Override
    public Page<Advertisement> listAdvertisements(Pageable pageable) {
        return _advertisementRepository.findAll(pageable);
    }

    @Override
    public ResponseEntity<?> delete(Long advertisementId) {
        return _advertisementRepository.findById(advertisementId).map(advertisement ->{
            _advertisementRepository.delete(advertisement);
            return ResponseEntity.ok().build();
        } ).orElseThrow(() -> new ResourceNotFoundException("Advertisement: ", advertisementId));
    }

    @Override
    public Advertisement create(Advertisement advertisement) {
        return _advertisementRepository.save(advertisement);
    }

    @Override
    public Advertisement update(Long advertisementId, Advertisement request) {
       Set<ConstraintViolation<Advertisement>> violations=_validator.validate(request);
       if(!violations.isEmpty())
           throw new ResourceValidationException("Advertisement", violations);
       if(!_advertisementRepository.existsById(advertisementId))
           throw new ResourceNotFoundException("Publication", advertisementId);

        return _advertisementRepository.findById(advertisementId).map(
              advertisement -> {
                  return _advertisementRepository.save(
                          advertisement.withTitle(request.getTitle())
                                  .withDescription(request.getDescription())
                                  .withDiscount(request.getDiscount())
                                  .withUrl(request.getUrl())
                                  .withPromoted(request.getPromoted())

                          );
              }
        ).orElseThrow(() -> new ResourceNotFoundException("Advertisement: ", advertisementId));
    }

    @Override
    public List<Advertisement> ListAllAdvertisements() {
        return _advertisementRepository.findAll();
    }

    @Override
    public Advertisement getById(Long id) {
        return _advertisementRepository.getById(id);
    }
}
