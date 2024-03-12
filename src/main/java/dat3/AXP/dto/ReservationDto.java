package dat3.AXP.dto;

import dat3.AXP.entity.Reservation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReservationDto {
    private Integer id;
    private String date;
    private boolean bookedStatus;

    public ReservationDto(Reservation r) {
        this.id = r.getId();
        this.date = r.getDate();
        this.bookedStatus = r.isBookedStatus();
    }
}
