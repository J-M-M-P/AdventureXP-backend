package dat3.AXP.repository;

import dat3.AXP.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
//    List<Activity> findActivitiesById(Integer activityId );
}
