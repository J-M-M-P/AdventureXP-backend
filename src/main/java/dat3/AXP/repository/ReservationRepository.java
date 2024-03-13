package dat3.AXP.repository;

import dat3.AXP.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByCompanyId(Integer companyId);
}
