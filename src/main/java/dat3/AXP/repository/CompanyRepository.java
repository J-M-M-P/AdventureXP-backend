package dat3.AXP.repository;

import dat3.AXP.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
    List<Company>findAllById(Integer id);
}
