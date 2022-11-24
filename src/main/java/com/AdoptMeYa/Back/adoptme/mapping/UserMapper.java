package com.AdoptMeYa.Back.adoptme.mapping;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.User;
import com.AdoptMeYa.Back.adoptme.resource.*;
import com.AdoptMeYa.Back.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class UserMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public UserResource toResource(User model) {
        return mapper.map(model, UserResource.class);
    }

    public User toModel(CreateUserResource resource) {
        return mapper.map(resource, User.class);
    }

    public List<UserResource> toListResource(List<User> modelList){
        return mapper.mapList(modelList, UserResource.class);
    }


    public Page<UserResource> modelListToPage(List<User> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, UserResource.class), pageable, modelList.size());
    }
    public User toModel(UpdateUserResource resource) {
        return mapper.map(resource, User.class);
    }
}
