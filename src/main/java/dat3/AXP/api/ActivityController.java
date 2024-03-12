package dat3.AXP.api;

import dat3.AXP.dto.ActivityDto;
import dat3.AXP.dto.ReservationDto;
import dat3.AXP.entity.Activity;
import dat3.AXP.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @GetMapping
    public List<Activity> getAllActivities() {
        return activityService.getAllActivities();
    }

    @GetMapping(path = "/{id}")
    public ActivityDto getActivityById(@PathVariable int id) {
        return activityService.getActivityById(id);
    }

    @PostMapping
    public Activity createActivity(@RequestBody Activity activity) {
        return activityService.createActivity(activity);
    }

    @PutMapping(path = "/{id}")
    public ActivityDto updateActivity(@RequestBody ActivityDto request, @PathVariable int id) {
        return activityService.editActivity(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteActivity(@PathVariable int id) {
        return activityService.deleteActivity(id);
    }

    // Add other CRUD methods for activities
}
