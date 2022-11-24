package com.AdoptMeYa.Back.adoptme.api;

import com.AdoptMeYa.Back.adoptme.domain.service.PublicationService;
import com.AdoptMeYa.Back.adoptme.mapping.PublicationMapper;
import com.AdoptMeYa.Back.adoptme.resource.CreatePublicationResource;
import com.AdoptMeYa.Back.adoptme.resource.PublicationResource;
import com.AdoptMeYa.Back.adoptme.resource.UpdatePublicationResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/publications")
public class PublicationController {
    @Autowired
    private PublicationService publicationService;
    @Autowired
    private PublicationMapper mapper;
    
    @GetMapping
    public Page<PublicationResource> getAllPublication(Pageable pageable) {
        return  mapper.modelListToPage(publicationService.getAll() , pageable);
    }
    @GetMapping("/{publicationId}")
    public PublicationResource getPostById(@PathVariable("publicationId") Long publicationId) {
        return mapper.toResource(publicationService.getById(publicationId));
    }

    @PostMapping
    public PublicationResource createPost(@RequestBody CreatePublicationResource request) {

        return mapper.toResource(publicationService.create(mapper.toModel(request)));
    }

    @PutMapping("{publicationId}")
    public PublicationResource updatePost(@PathVariable Long publicationId, @RequestBody UpdatePublicationResource request) {
        return mapper.toResource(publicationService.update(publicationId, mapper.toModel(request)));
    }
    @PatchMapping("{publicationId}")
    public PublicationResource patchPost(@PathVariable Long publicationId, @RequestBody UpdatePublicationResource request) {
        return mapper.toResource(publicationService.update(publicationId, mapper.toModel(request)));
    }

    @DeleteMapping("{publicationId}")
    public ResponseEntity<?> deletePost(@PathVariable Long publicationId) {
        return publicationService.delete(publicationId);
    }

}
