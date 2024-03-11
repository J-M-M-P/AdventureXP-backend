package dat3.AXP.dto;

import dat3.AXP.entity.Activity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ActivityDto {
    private int id;
    private String activityName;
    private int ageLimit;
    private int participantLimit;
    private String description;
    private String image;

    public ActivityDto(Activity a) {
        this.id = a.getId();
        this.activityName = a.getActivityName();
        this.ageLimit = a.getAgeLimit();
        this.participantLimit = a.getParticipantLimit();
        this.description = a.getDescription();
        this.image = a.getImage();
    }
}
