
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
    private String bookingType; // New field for booking type
    private String reservationName; // New field for name
    private Integer companyCVR; // New field for company CVR

    @ManyToOne
    private Customer customer;

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
