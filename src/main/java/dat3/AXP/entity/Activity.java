package dat3.AXP.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    //Code as it was before changes
    @JsonIgnoreProperties("activities") // Ignore 'activities' field during serialization of Reservation
    @ManyToMany(mappedBy = "activities", fetch = FetchType.EAGER)
    private Set<Reservation> reservations = new HashSet<>();

    @JsonBackReference
    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
    private Set<Equipment> equipment = new HashSet<>();

    public Activity(String activityName, int ageLimit, int participantLimit, String description, String image) {
        this.activityName = activityName;
        this.ageLimit = ageLimit;
        this.participantLimit = participantLimit;
        this.description = description;
        this.image = image;
    }

}