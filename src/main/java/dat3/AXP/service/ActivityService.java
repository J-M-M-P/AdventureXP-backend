package dat3.AXP.service;

import dat3.AXP.entity.Activity;
import dat3.AXP.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    ActivityRepository activityRepository;

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    // Add other business logic methods related to activities
}
