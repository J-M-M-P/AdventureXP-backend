package dat3.AXP.entity;

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

    @ManyToMany(mappedBy = "activities")
    private Set<Reservation> reservations = new HashSet<>();

public Activity(String activityName, int ageLimit, int participantLimit, String description, String image) {
    this.activityName = activityName;
    this.ageLimit = ageLimit;
    this.participantLimit = participantLimit;
    this.description = description;
    this.image = image;
}
}