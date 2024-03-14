package dat3.AXP.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String activityName;
    private int ageLimit;
    private int participantLimit;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String image;


    //New changes - make a new junction table "activity_equipment"
    //@ManyToMany
    //@JoinTable(
    //        name = "activity_equipment",
    //        joinColumns = @JoinColumn(name = "activity_id"),
    //        inverseJoinColumns = @JoinColumn(name = "equipment_id")
    //)
    //private Set<Equipment> equipments = new HashSet<>();

    //@JsonIgnoreProperties("activities") // Ignorer 'activities'-feltet under serialisering af Reservation
    //@ManyToMany(mappedBy = "activities", fetch = FetchType.EAGER)
    //private Set<Reservation> reservations = new HashSet<>();


    //Code as it was before changes
    @JsonIgnoreProperties("activities") // Ignore 'activities' field during serialization of Reservation
    @ManyToMany(mappedBy = "activities", fetch = FetchType.EAGER)
    private Set<Reservation> reservations = new HashSet<>();

    @OneToMany
    private Set<Equipment> equipment = new HashSet<>();

    public Activity(String activityName, int ageLimit, int participantLimit, String description, String image) {
        this.activityName = activityName;
        this.ageLimit = ageLimit;
        this.participantLimit = participantLimit;
        this.description = description;
        this.image = image;
    }

}