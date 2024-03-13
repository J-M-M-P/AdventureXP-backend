package dat3.AXP.service;

import dat3.AXP.dto.ActivityDto;
import dat3.AXP.entity.Activity;
import dat3.AXP.entity.Reservation;
import dat3.AXP.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    ActivityRepository activityRepository;

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public ActivityDto getActivityById(int id){
        Activity activity = activityRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "activity not found"));
        return new ActivityDto(activity);
    }

    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public ActivityDto editActivity(ActivityDto request, int id) {
        if (request.getId() != id) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id does not match existing activity");
        }
        Activity activityToEdit = activityRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity id does not exist"));
        updateActivity(activityToEdit, request);
        activityRepository.save(activityToEdit);
        return new ActivityDto(activityToEdit);
    }

    private void updateActivity(Activity original, ActivityDto a) {
        original.setActivityName(a.getActivityName());
        original.setAgeLimit(a.getAgeLimit());
        original.setParticipantLimit(a.getParticipantLimit());
        original.setDescription(a.getDescription());
        original.setImage(a.getImage());
    }

    public ResponseEntity deleteActivity(int id) {
        Activity activity = activityRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found"));
        activityRepository.delete(activity);
        return new ResponseEntity("Activity was deleted!", HttpStatus.OK);
    }

    // Add other business logic methods related to activities
}
