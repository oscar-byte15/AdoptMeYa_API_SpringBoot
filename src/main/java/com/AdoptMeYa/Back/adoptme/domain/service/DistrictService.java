package com.AdoptMeYa.Back.adoptme.domain.service;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.District;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface DistrictService {
    List<District> getAll();

    Page<District> getAll(Pageable pageable);

    District create(District district);

    District getById(Long id);

    District update(District district, Long id);

    ResponseEntity<?>delete(Long id);

}
