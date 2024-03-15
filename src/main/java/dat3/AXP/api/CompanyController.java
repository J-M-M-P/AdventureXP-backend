package dat3.AXP.api;

import dat3.AXP.dto.CompanyDto;
import dat3.AXP.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<String> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @PostMapping
    public CompanyDto addCompany(@RequestBody CompanyDto request){
        return companyService.addCompany(request);
    }


   }
