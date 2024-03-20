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
    private boolean bookedStatus;
    private Integer companyId;
    private Integer customerId;
    private String reservationDay;
    private String reservationTime;
    private Integer reservationWeek;
    private Integer activityId;

    public ReservationDto(Reservation r) {
        this.id = r.getId();
        this.reservationDay = r.getReservationDay();
        this.reservationTime = r.getReservationTime();
        this.reservationWeek = r.getReservationWeek();
        this.activityId = r.getActivity().getId();
        this.bookedStatus = r.isBookedStatus();
        if (r.getCompany() != null) {
            this.companyId = r.getCompany().getId(); // Set companyId if company is not null
        }
        if (r.getCustomer() != null) {
            this.customerId = r.getCustomer().getId();
        }
//        if (r.getActivity() != null) {
//
//        }
    }
}
