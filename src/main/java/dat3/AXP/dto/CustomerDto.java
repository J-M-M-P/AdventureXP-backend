package dat3.AXP.dto;

import dat3.AXP.entity.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDto {
    private int id;
    private String name;
    private int age;
    private String phoneNumber;
    private String email;
    private Set<ReservationDto> reservations;

    public CustomerDto(Customer c){
        this.id = c.getId();
        this.name = c.getName();
        this.age = c.getAge();
        this.phoneNumber = c.getPhoneNumber();
        this.email = c.getEmail();
        this.reservations = c.getReservations().stream().map(ReservationDto::new).collect(Collectors.toSet());
    }
}
