package com.AdoptMeYa.Back.adoptme.api;
import com.AdoptMeYa.Back.adoptme.domain.service.AdvertisementService;
import com.AdoptMeYa.Back.adoptme.mapping.AdvertisementMapper;
import com.AdoptMeYa.Back.adoptme.resource.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/advertisements")
public class AdvertisementController {
    @Autowired
    private AdvertisementService advertisementService;
    @Autowired
    private AdvertisementMapper mapper;

    @GetMapping
    public Page<AdvertisementResource> getAll(Pageable pageable) {
        return  mapper.modelListToPage(advertisementService.ListAllAdvertisements(), pageable);
    }

    @GetMapping("/{advertisementId}")
    public AdvertisementResource getAdvertisementById(@PathVariable("advertisementId") Long advertisementId) {
        return mapper.toResource(advertisementService.getById(advertisementId));
    }
    @GetMapping("/userId={id}")
    public List<AdvertisementResource> ListAdvertisementsByUserId(@PathVariable("id") Long id) {
        return  mapper.toListResource(advertisementService.listAdvertisementsByUserId(id));
    }
    @PostMapping
    public AdvertisementResource createPost(@RequestBody CreateAdvertisementResource request) {
        return mapper.toResource(advertisementService.create(mapper.toModel(request)));
    }

    @PutMapping("/{advertisementId}")
    public AdvertisementResource updatePost(@PathVariable Long advertisementId, @RequestBody UpdateAdvertisementResource request) {
        return mapper.toResource(advertisementService.update(advertisementId, mapper.toModel(request)));
    }

    @DeleteMapping("/{advertisementId}")
    public ResponseEntity<?> deletePost(@PathVariable Long advertisementId) {
        return advertisementService.delete(advertisementId);
    }

}
