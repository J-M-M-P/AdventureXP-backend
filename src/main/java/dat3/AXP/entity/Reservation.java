
package dat3.AXP.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;
    private boolean bookedStatus;

    @ManyToMany
    @JoinTable(
            name = "reservation_activity",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id")
    )
    private Set<Activity> activities;

    public Reservation(String date, boolean bookedStatus) {
        this.date = date;
        this.bookedStatus= bookedStatus;
    }
}
