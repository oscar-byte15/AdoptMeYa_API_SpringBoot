package com.AdoptMeYa.Back.adoptme.mapping;

import java.io.Serializable;
import java.util.List;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.Publication;
import com.AdoptMeYa.Back.adoptme.resource.CreatePublicationResource;
import com.AdoptMeYa.Back.adoptme.resource.PublicationResource;
import com.AdoptMeYa.Back.adoptme.resource.UpdatePublicationResource;
import com.AdoptMeYa.Back.shared.mapping.EnhancedModelMapper;
import org.springframework.data.domain.PageImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PublicationMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;


    // Object Mapping
    public PublicationResource toResource(Publication model) {
        return mapper.map(model, PublicationResource.class);
    }

    public Page<PublicationResource> modelListToPage(List<Publication> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, PublicationResource.class), pageable, modelList.size());
    }

    public Publication toModel(CreatePublicationResource resource) {
        return mapper.map(resource, Publication.class);
    }

    public Publication toModel(UpdatePublicationResource resource) {
        return mapper.map(resource, Publication.class);
    }
}
