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
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String companyName;
    private String contactPerson;
    int contactInfo;
    int cvr;

    @OneToMany(mappedBy = "id", cascade = CascadeType.PERSIST)
    private Set<Reservation> reservations;
    public void addReservation(Reservation reservation){
        this.reservations.add(reservation);
        reservation.setCompany(this);
    }

    public Company(String companyName){this.companyName = companyName;}
}
