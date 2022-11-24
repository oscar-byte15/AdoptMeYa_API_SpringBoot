package com.AdoptMeYa.Back.adoptme.service;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.District;
import com.AdoptMeYa.Back.adoptme.domain.persistence.DistrictRepository;
import com.AdoptMeYa.Back.adoptme.domain.service.DistrictService;
import com.AdoptMeYa.Back.shared.exception.ResourceNotFoundException;
import com.AdoptMeYa.Back.shared.exception.ResourceValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;


@Service
public class DistrictImpl implements DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private Validator validator;

    @Override
    public List<District> getAll(){ return districtRepository.findAll(); }

    @Override
    public Page<District> getAll(Pageable pageable){return districtRepository.findAll(pageable);}

    @Override
    public District create(District district){return districtRepository.save(district);}

    @Override
    public District getById(Long id){return districtRepository.getById(id);}

    @Override
    public District update(District request, Long id)
    {
        Set<ConstraintViolation<District>> violations = validator.validate(request);
        if(!violations.isEmpty())
            throw new ResourceValidationException("District",violations);

        if(!districtRepository.existsById(id))
            throw new ResourceNotFoundException("District",id);

        return districtRepository.findById(id).map(district->
        {
            return districtRepository.save(request);}).orElseThrow(()->new ResourceNotFoundException("District",id));
    }

    @Override
    public ResponseEntity<?>delete(Long id)
    {
        return districtRepository.findById(id).map(district ->
        {
            districtRepository.delete(district);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException("District",id));
    }
}
