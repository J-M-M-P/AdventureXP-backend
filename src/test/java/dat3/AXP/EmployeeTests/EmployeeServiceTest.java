package dat3.AXP.EmployeeTests;

import dat3.AXP.dto.EmployeeDto;
import dat3.AXP.entity.Employee;
import dat3.AXP.repository.EmployeeRepository;
import dat3.AXP.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        employeeService = new EmployeeService(employeeRepository);
    }

    @Test
    public void testGetAllEmployees() {
        // Mock data
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setFirstName("John");
        employee1.setLastName("Doe");
        employee1.setPhone(123456789);

        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setFirstName("Jane");
        employee2.setLastName("Doe");
        employee2.setPhone(987654321);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);

        // Mock repository behavior
        when(employeeRepository.findAll()).thenReturn(employees);

        // Call the service method
        List<EmployeeDto> employeeDtos = employeeService.getAllEmployees();

        // Verify the result
        assertEquals(2, employeeDtos.size());

        EmployeeDto employeeDto1 = employeeDtos.get(0);
        assertEquals(1, employeeDto1.getId());
        assertEquals("John", employeeDto1.getFirstName());
        assertEquals("Doe", employeeDto1.getLastName());
        assertEquals(123456789, employeeDto1.getPhone());

        EmployeeDto employeeDto2 = employeeDtos.get(1);
        assertEquals(2, employeeDto2.getId());
        assertEquals("Jane", employeeDto2.getFirstName());
        assertEquals("Doe", employeeDto2.getLastName());
        assertEquals(987654321, employeeDto2.getPhone());
    }
}
