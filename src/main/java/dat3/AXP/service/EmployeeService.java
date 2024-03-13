package dat3.AXP.service;

import dat3.AXP.dto.EmployeeDto;
import dat3.AXP.entity.Employee;
import dat3.AXP.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDto> getAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeResponses = employees.stream().map((e) -> new EmployeeDto(e,false)).toList();
        return employeeResponses;
    }

}
