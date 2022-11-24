package com.AdoptMeYa.Back.adoptme.api;

import com.AdoptMeYa.Back.adoptme.domain.service.DistrictService;
import com.AdoptMeYa.Back.adoptme.mapping.DistrictMapper;
import com.AdoptMeYa.Back.adoptme.resource.CreateDistrictResource;
import com.AdoptMeYa.Back.adoptme.resource.DistrictResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/districts")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @Autowired
    private DistrictMapper mapper;

    @GetMapping
    public List<DistrictResource> getAll()
    {
        return mapper.toListResource(districtService.getAll());
    }

    @PostMapping
    public DistrictResource createDistrict(@RequestBody CreateDistrictResource request)
    {
        return mapper.toResource(districtService.create(mapper.toModel(request)));
    }
    @GetMapping("/{id}")
    public DistrictResource getById(@PathVariable("id") Long id)
    {
        return mapper.toResource(districtService.getById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id){return districtService.delete(id);}


}
