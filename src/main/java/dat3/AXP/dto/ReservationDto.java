package dat3.AXP.dto;

import dat3.AXP.entity.Reservation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ReservationDto {
    private Integer id;
    private LocalDateTime dateTime;
    private boolean bookedStatus;
    private Integer companyId;

    public ReservationDto(Reservation r) {
        this.id = r.getId();
        this.dateTime = r.getDateTime();
        this.bookedStatus = r.isBookedStatus();
        if (r.getCompany() != null) {
            this.companyId = r.getCompany().getId(); // Set companyId if company is not null
        }    }
}
