package com.AdoptMeYa.Back.adoptme.mapping;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.Advertisement;
import com.AdoptMeYa.Back.adoptme.domain.model.entity.Pet;
import com.AdoptMeYa.Back.adoptme.resource.*;
import com.AdoptMeYa.Back.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class AdvertisementMapper {
    @Autowired
            //definido en shared mapping
    EnhancedModelMapper _mapper;

    public AdvertisementResource toResource(Advertisement model){
        return _mapper.map(model,AdvertisementResource.class);
    }
    public Page<AdvertisementResource> modelListToPage(List<Advertisement> modelList, Pageable pageable) {
        return new PageImpl<>(_mapper.mapList(modelList, AdvertisementResource.class), pageable, modelList.size());
    }
    //te tiene que devolver el valor del inicio
    public Advertisement toModel(CreateAdvertisementResource resource) {
        return _mapper.map(resource, Advertisement.class);
    }

    public Advertisement toModel(UpdateAdvertisementResource resource) {
        return _mapper.map(resource, Advertisement.class);
    }
    public List<AdvertisementResource> toListResource(List<Advertisement> modelList){
        return _mapper.mapList(modelList, AdvertisementResource.class);
    }
}
