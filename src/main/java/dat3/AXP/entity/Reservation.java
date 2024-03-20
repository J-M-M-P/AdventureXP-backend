
package dat3.AXP.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private boolean bookedStatus;
    private String reservationDay;
    private String reservationTime;
    private Integer reservationWeek;

    @ManyToOne
    private Customer customer;

//    @JsonIgnoreProperties("reservations")// Ignore 'reservations' field during serialization of Reservation
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "reservation_activity",
//            joinColumns = @JoinColumn(name = "reservation_id"),
//            inverseJoinColumns = @JoinColumn(name = "activity_id")
//    )
//    private Set<Activity> activities = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    public Reservation(String reservationDay, boolean bookedStatus, String reservationTime, Integer reservationWeek) {
        this.reservationDay = reservationDay;
        this.bookedStatus= bookedStatus;
        this.reservationTime = reservationTime;
        this.reservationWeek = reservationWeek;
    }

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public void addCompany(Company company){ company.addReservation(this);}

}
