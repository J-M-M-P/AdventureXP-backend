package dat3.AXP.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name ="equipment")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private boolean status;
    private int totalUnits;
    private int defectiveUnits;
    //activityId references activities table
    @ManyToOne
    @JoinColumn(name = "activity_id_fk")
    private Activity activity;

}
