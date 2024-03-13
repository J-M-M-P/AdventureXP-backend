package dat3.AXP.repository;

import dat3.AXP.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAll(); // Change return type to List<Employee>
}
