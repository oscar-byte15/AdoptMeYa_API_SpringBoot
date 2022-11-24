package com.AdoptMeYa.Back.adoptme.api;
import com.AdoptMeYa.Back.adoptme.domain.service.NotificationService;
import com.AdoptMeYa.Back.adoptme.mapping.NotificationMapper;
import com.AdoptMeYa.Back.adoptme.resource.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private NotificationMapper mapper;
    @GetMapping
    public Page<NotificationResource> getAllNotifications(Pageable pageable) {
        return  mapper.modelListToPage(notificationService.getAll() , pageable);
    }
    @GetMapping("/{notificationId}")
    public NotificationResource getNotificationById(@PathVariable("notificationId") Long notificationId) {
        return mapper.toResource(notificationService.getById(notificationId));
    }
    @PostMapping
    public NotificationResource createNotification(@RequestBody CreateNotification request) {

        return mapper.toResource(notificationService.create(mapper.toModel(request)));
    }

    @PutMapping("{notificationId}")
    public NotificationResource updateNotification(@PathVariable Long notificationId, @RequestBody UpdateNotificationResource request) {
        return mapper.toResource(notificationService.update(notificationId, mapper.toModel(request)));
    }

    @DeleteMapping("{notificationId}")
    public ResponseEntity<?> deleteNotification(@PathVariable Long notificationId) {
        return notificationService.delete(notificationId);
    }
}
