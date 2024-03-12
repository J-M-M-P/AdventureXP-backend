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
    private Activity activity;


    public EquipmentDto(Equipment e) {
        this.id = e.getId();
        this.name = e.getName();
        this.status = e.isStatus();
        this.totalUnits = e.getTotalUnits();
        this.defectiveUnits = e.getDefectiveUnits();
        this.activity = e.getActivity();
    }
}
