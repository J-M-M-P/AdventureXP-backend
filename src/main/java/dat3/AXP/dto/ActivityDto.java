package dat3.AXP.dto;

import dat3.AXP.entity.Activity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

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
    private Set<EquipmentDto> equipmentDtos;

    public ActivityDto(Activity a) {
        this.id = a.getId();
        this.activityName = a.getActivityName();
        this.ageLimit = a.getAgeLimit();
        this.participantLimit = a.getParticipantLimit();
        this.description = a.getDescription();
        this.image = a.getImage();
        this.equipmentDtos = a.getEquipment().stream().map(EquipmentDto::new).collect(Collectors.toSet());
    }
}
