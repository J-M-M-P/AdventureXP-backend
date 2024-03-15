package dat3.AXP.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private boolean status;
    private int totalUnits;
    private int defectiveUnits;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    public Equipment(String name, boolean status, int totalUnits, int defectiveUnits) {
        this.name = name;
        this.status = status;
        this.totalUnits = totalUnits;
        this.defectiveUnits = defectiveUnits;
    }

}
