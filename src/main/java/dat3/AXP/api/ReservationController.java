package dat3.AXP.api;

import dat3.AXP.dto.ReservationDto;
import dat3.AXP.entity.Reservation;
import dat3.AXP.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @GetMapping
    public List<ReservationDto> getAllReservations(@RequestParam(required = false) Integer companyId) {
        return reservationService.getAllReservations(companyId);
    }

    @GetMapping("/{id}")
    public ReservationDto getReservationById(@PathVariable int id){
        return reservationService.getReservationById(id);
    }

    @PostMapping
    public Reservation createReservation(@RequestBody ReservationDto reservationDto) {
        return reservationService.createReservation(reservationDto);
    }


    @PutMapping(path = "/{id}")
    public ReservationDto updateReservation(@RequestBody ReservationDto request, @PathVariable int id) {
        return reservationService.editReservation(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteReservation(@PathVariable int id) {
        return reservationService.deleteReservation(id);
    }
}
