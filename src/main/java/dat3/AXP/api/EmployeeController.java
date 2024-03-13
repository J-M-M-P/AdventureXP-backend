package dat3.AXP.api;


import dat3.AXP.dto.EmployeeDto;
import dat3.AXP.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){this.employeeService = employeeService;}

    @GetMapping
    public List<EmployeeDto> getAllEmployees(){return employeeService.getAllEmployees();
    }

}
