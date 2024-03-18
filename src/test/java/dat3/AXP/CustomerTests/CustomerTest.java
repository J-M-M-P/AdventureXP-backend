package dat3.AXP.CustomerTests;

import dat3.AXP.entity.Customer;
import dat3.AXP.entity.Reservation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class CustomerTest {

    @InjectMocks
    private Customer customer;

    @Test
    public void testCustomerCreation() {
        // Given
        String name = "John Doe";
        int age = 30;
        String phoneNumber = "1234567890";
        String email = "john@example.com";

        // When
        customer = new Customer(name, age, phoneNumber, email);

        // Then
        assertNotNull(customer);
        assertEquals(name, customer.getName());
        assertEquals(age, customer.getAge());
        assertEquals(phoneNumber, customer.getPhoneNumber());
        assertEquals(email, customer.getEmail());
    }

    @Test
    public void testReservationAssociation() {
        // Given
        Reservation reservation = new Reservation();
        reservation.setCustomer(customer);

        // When
        customer.getReservations().add(reservation);

        // Then
        assertEquals(1, customer.getReservations().size());
        assertEquals(customer, reservation.getCustomer());
    }
}
