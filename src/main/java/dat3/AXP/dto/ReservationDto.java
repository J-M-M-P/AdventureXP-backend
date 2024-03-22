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
    private String bookingType; // New field for booking type
    private String reservationName; // New field for name
    private Integer companyId; // New field for company ID
    private Integer companyCVR; // New field for company CVR
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
        this.bookingType = r.getBookingType();
        this.reservationName = r.getReservationName();
        this.companyCVR = r.getCompanyCVR();
        if (r.getCompany() != null) {
            this.companyId = r.getCompany().getId();
        }
        if (r.getCustomer() != null) {
            this.customerId = r.getCustomer().getId();
        }
    }
}
