package dat3.AXP.service;

import dat3.AXP.dto.ReservationDto;
import dat3.AXP.entity.Company;
import dat3.AXP.entity.Reservation;
import dat3.AXP.repository.CompanyRepository;
import dat3.AXP.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    private CompanyRepository companyRepository;


    public ReservationService(ReservationRepository reservationRepository, CompanyRepository companyRepository){
        this.reservationRepository = reservationRepository;
        this.companyRepository = companyRepository;
    }
    public List<ReservationDto> getAllReservations(Integer companyId) {
        List<Reservation> reservations = companyId == null ? reservationRepository.findAll() : reservationRepository.findByCompanyId(companyId);
        List<ReservationDto> reservationResponses = reservations.stream().map(ReservationDto::new).toList();
        return reservationResponses;
    }

    public ReservationDto getReservationById(int id){
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "reservation not found"));
        return new ReservationDto(reservation);
    }

    public Reservation createReservation(ReservationDto reservationDto) {
        Reservation reservation = new Reservation(reservationDto.getDateTime(), reservationDto.isBookedStatus());
        Company company = companyRepository.findById(reservationDto.getCompanyId())
                .orElseThrow(() -> new NoSuchElementException("Company not found"));
        reservation.setCompany(company);
        return reservationRepository.save(reservation);
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

    public ResponseEntity deleteReservation(int id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "reservation not found"));
        reservationRepository.delete(reservation);
        return new ResponseEntity("reservation was deleted!", HttpStatus.OK);
    }

    // Add other business logic methods related to activities
}
