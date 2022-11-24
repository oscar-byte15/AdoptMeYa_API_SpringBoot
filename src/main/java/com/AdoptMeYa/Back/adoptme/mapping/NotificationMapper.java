package com.AdoptMeYa.Back.adoptme.mapping;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.Notification;
import com.AdoptMeYa.Back.adoptme.resource.*;
import com.AdoptMeYa.Back.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class NotificationMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public NotificationResource toResource(Notification model){return mapper.map(model, NotificationResource.class);}

    public Notification toModel(CreateNotification resource) {
        return mapper.map(resource, Notification.class);
    }

    public Page<NotificationResource> modelListToPage(List<Notification> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, NotificationResource.class), pageable, modelList.size());
    }
    public Notification toModel(UpdateNotificationResource resource) {
        return mapper.map(resource, Notification.class);
    }


}
