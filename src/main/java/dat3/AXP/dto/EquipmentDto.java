package dat3.AXP.dto;

import dat3.AXP.entity.Activity;
import dat3.AXP.entity.Equipment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EquipmentDto {
    private Integer id;
    private String name;
    private boolean status;
    private int totalUnits;
    private int defectiveUnits;
    private int activityId;
    private String activityName;


    public EquipmentDto(Equipment e) {
        this.id = e.getId();
        this.name = e.getName();
        this.status = e.isStatus();
        this.totalUnits = e.getTotalUnits();
        this.defectiveUnits = e.getDefectiveUnits();
        if (e.getActivity() != null) {
            this.activityId = e.getActivity().getId();
            this.activityName = e.getActivity().getActivityName();
            // Assign other necessary fields from Activity entity
        }
    }
}
