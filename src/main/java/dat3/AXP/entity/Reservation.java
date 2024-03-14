
package dat3.AXP.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime dateTime;
    private boolean bookedStatus;

    @ManyToOne
    private Customer customer;

    @JsonIgnoreProperties("reservations")// Ignore 'reservations' field during serialization of Reservation
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "reservation_activity",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id")
    )
    private Set<Activity> activities = new HashSet<>();

    public Reservation(LocalDateTime dateTime, boolean bookedStatus) {
        this.dateTime = dateTime;
        this.bookedStatus= bookedStatus;
    }

    @ManyToOne
    private Company company;

    public void addCompany(Company company){ company.addReservation(this);}

}
