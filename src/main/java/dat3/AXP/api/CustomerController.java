package dat3.AXP.api;

import dat3.AXP.dto.CustomerDto;
import dat3.AXP.entity.Customer;
import dat3.AXP.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

//    @GetMapping
//    public List<CustomerDto> getAllCustomers() {
//        return customerService.getAllCustomers();
//    }
    @GetMapping
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers().stream()
                .map(CustomerDto::new)
                .collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

}
