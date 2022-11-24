package com.AdoptMeYa.Back.adoptme.api;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.Pet;
import com.AdoptMeYa.Back.adoptme.domain.service.PetService;
import com.AdoptMeYa.Back.adoptme.mapping.PetMapper;
import com.AdoptMeYa.Back.adoptme.resource.CreatePetResource;
import com.AdoptMeYa.Back.adoptme.resource.PetResource;
import com.AdoptMeYa.Back.adoptme.resource.UpdatePetResource;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pets")
public class PetController {
    @Autowired
    private PetService petService;

    @Autowired
    private PetMapper mapper;


    @GetMapping
    public List<PetResource> getAll() {
        return  mapper.toListResource(petService.getAll());
    }

    @GetMapping("/publicationId={id}")
    public List<PetResource> ReadPetsByPublicationId(@PathVariable("id") Long id) {
        return  mapper.toListResource(petService.ReadPetsByPublicationId(id));
    }

    @GetMapping("/userId={id}")
    public List<PetResource> ReadPetsByUserId(@PathVariable("id") Long id) {
        return  mapper.toListResource(petService.ReadPetsByUserId(id));
    }


    @PostMapping
    public PetResource createPet(@RequestBody CreatePetResource request){
        return mapper.toResource(petService.create(mapper.toModel(request)));
    }

    @GetMapping("/{id}")
    public PetResource getById(@PathVariable("id") Long id){
        return mapper.toResource(petService.getById(id));
    }

    @PutMapping("/{id}")
    public PetResource put(@RequestBody UpdatePetResource request, @PathVariable("id") Long id){
        return mapper.toResource(petService.update(mapper.toModel(request), id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) {
        return petService.delete(id);
    }

    @GetMapping("/attention={attention}")
    public List<PetResource> ReadPetsByAttention(@PathVariable("attention") String attention) {
        return mapper.toListResource(petService.ReadPetsByAttention(attention));
    }

    @GetMapping("/type={type}")
    public List<PetResource> ReadPetsByType(@PathVariable("type") String type) {
        return mapper.toListResource(petService.ReadPetsByType(type));
    }

    @GetMapping("/gender={gender}")
    public List<PetResource> ReadPetsByGender(@PathVariable("gender") String gender) {
        return mapper.toListResource(petService.ReadPetsByGender(gender));
    }

    @GetMapping("/gender={gender}&attention={attention}")
    public List<PetResource> ReadPetsByGenderAttention(@PathVariable String gender, @PathVariable String attention) {
        return mapper.toListResource(petService.ReadPetsByGenderAttention(gender, attention));
    }

    @GetMapping("/type={type}&attention={attention}")
    public List<PetResource> ReadPetsByTypeAttention(@PathVariable String type, @PathVariable String attention) {
        return mapper.toListResource(petService.ReadPetsByTypeAttention(type, attention));
    }

    @GetMapping("/type={type}&attention={gender}")
    public List<PetResource> ReadPetsByTypeGender(@PathVariable String type, @PathVariable String gender) {
        return mapper.toListResource(petService.ReadPetsByTypeGender(type, gender));
    }

    @GetMapping("/type={type}&attention={gender}&attention={attention}")
    public List<PetResource> ReadPetsByTypeGenderAttention(@PathVariable String type, @PathVariable String gender,
                                                           @PathVariable String attention) {
        return mapper.toListResource(petService.ReadPetsByTypeGenderAttention(type, gender, attention));
    }



}
