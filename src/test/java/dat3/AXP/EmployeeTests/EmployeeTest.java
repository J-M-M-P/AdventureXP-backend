package dat3.AXP.EmployeeTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import dat3.AXP.entity.Employee;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

    @Test
    public void testEmployeeConstructorAndGetters() {
        // Create a sample employee
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setPhone(123456789);

        // Check if the constructor and getters work as expected
        assertEquals(1, employee.getId());
        assertEquals("John", employee.getFirstName());
        assertEquals("Doe", employee.getLastName());
        assertEquals(123456789, employee.getPhone());
    }
}