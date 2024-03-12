package dat3.AXP.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.AXP.entity.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer phone;


    public EmployeeDto(Employee e, boolean b) {
        this.id = e.getId();
        this.firstName = e.getFirstName();
        this.lastName = e.getLastName();
        this.phone = e.getPhone();
    }
}
