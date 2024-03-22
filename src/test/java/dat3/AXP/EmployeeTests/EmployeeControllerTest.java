package dat3.AXP.EmployeeTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import dat3.AXP.api.EmployeeController;
import dat3.AXP.dto.EmployeeDto;
import dat3.AXP.entity.Employee;
import dat3.AXP.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeServiceMock;

    @InjectMocks
    private EmployeeController employeeController;

    @Test
    public void testGetAllEmployees() {
        // Mocking data
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

        List<EmployeeDto> mockEmployeeList = new ArrayList<>();
        mockEmployeeList.add(new EmployeeDto(employee1, false));
        mockEmployeeList.add(new EmployeeDto(employee2, false));

        // Mocking service method to return the mock data
        when(employeeServiceMock.getAllEmployees()).thenReturn(mockEmployeeList);

        // Calling the controller method
        List<EmployeeDto> result = employeeController.getAllEmployees();

        // Verifying that the service method was called
        verify(employeeServiceMock, times(1)).getAllEmployees();

        // Asserting the result
        assertEquals(mockEmployeeList.size(), result.size());
        assertEquals(mockEmployeeList, result);
    }
}
