package dat3.AXP.api;

import dat3.AXP.dto.ReservationDto;
import dat3.AXP.entity.Reservation;
import dat3.AXP.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    @PutMapping(path = "/{id}")
    public ReservationDto updateReservation(@RequestBody ReservationDto request, @PathVariable int id) {
        return reservationService.editReservation(request, id);
    }
}
