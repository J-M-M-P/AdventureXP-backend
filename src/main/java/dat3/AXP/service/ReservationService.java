package dat3.AXP.service;

import dat3.AXP.dto.ReservationDto;
import dat3.AXP.entity.Reservation;
import dat3.AXP.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
//        return reservationRepository.findAll();
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations;
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Optional<Reservation> getReservationById(int id){
        return reservationRepository.findById(id);
    }

    public ReservationDto editReservation(ReservationDto request, int id) {
        if (request.getId() != id) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id does not match existing reservation");
        }
        Reservation reservationToEdit = reservationRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation id does not exist"));
        updateReservation(reservationToEdit, request);
        reservationRepository.save(reservationToEdit);
        return new ReservationDto(reservationToEdit);
    }

    private void updateReservation(Reservation original, ReservationDto r) {
        original.setDateTime(r.getDateTime());
        original.setBookedStatus(r.isBookedStatus());
    }

    // Add other business logic methods related to activities
}
