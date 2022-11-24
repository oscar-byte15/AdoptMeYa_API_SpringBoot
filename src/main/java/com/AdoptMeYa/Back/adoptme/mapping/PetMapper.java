package com.AdoptMeYa.Back.adoptme.mapping;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.Pet;
import com.AdoptMeYa.Back.adoptme.resource.CreatePetResource;
import com.AdoptMeYa.Back.adoptme.resource.PetResource;
import com.AdoptMeYa.Back.adoptme.resource.UpdatePetResource;
import com.AdoptMeYa.Back.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class PetMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public PetResource toResource(Pet model) {
        return mapper.map(model, PetResource.class);
    }

    public Pet toModel(CreatePetResource resource) {
        return mapper.map(resource, Pet.class);
    }

    public Page<PetResource> modelListToPage(List<Pet> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, PetResource.class), pageable, modelList.size());
    }
    public Pet toModel(UpdatePetResource resource) {
        return mapper.map(resource, Pet.class);
    }

    public List<PetResource> toListResource(List<Pet> modelList){
        return mapper.mapList(modelList, PetResource.class);
    }
}
