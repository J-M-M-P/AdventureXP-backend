package dat3.AXP.CustomerTests;

import dat3.AXP.dto.CustomerDto;
import dat3.AXP.entity.Customer;
import dat3.AXP.repository.CustomerRepository;
import dat3.AXP.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllCustomers() {
        // Given
        List<Customer> customers = Arrays.asList(
                new Customer("Alice", 25, "123", "alice@example.com"),
                new Customer("Bob", 30, "456", "bob@example.com")
        );
        when(customerRepository.findAll()).thenReturn(customers);

        // When
        List<Customer> result = customerService.getAllCustomers();

        // Then
        assertEquals(2, result.size());
        assertEquals(customers, result);
    }

    @Test
    void testGetCustomerById() {
        // Given
        int id = 1;
        Customer customer = new Customer("Alice", 25, "123", "alice@example.com");
        when(customerRepository.findById(id)).thenReturn(Optional.of(customer));

        // When
        CustomerDto result = customerService.getCustomerById(id);

        // Then
        assertNotNull(result);
        assertEquals(customer.getName(), result.getName());
        assertEquals(customer.getAge(), result.getAge());
        assertEquals(customer.getPhoneNumber(), result.getPhoneNumber());
        assertEquals(customer.getEmail(), result.getEmail());
    }

    @Test
    void testGetCustomerByIdNotFound() {
        // Given
        int id = 1;
        when(customerRepository.findById(id)).thenReturn(Optional.empty());

        // When / Then
        assertThrows(ResponseStatusException.class, () -> customerService.getCustomerById(id));
    }
}
