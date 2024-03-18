package dat3.AXP.CompanyTests;

import dat3.AXP.dto.CompanyDto;
import dat3.AXP.entity.Company;
import dat3.AXP.repository.CompanyRepository;
import dat3.AXP.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CompanyTests {

    @Mock
    private CompanyRepository companyRepository;

    @InjectMocks
    private CompanyService companyService;

    @Test
    public void testGetAllCompanies() {
        // Mocking data
        List<Company> companies = new ArrayList<>();
        companies.add(new Company("Company 1"));
        companies.add(new Company("Company 2"));

        when(companyRepository.findAll()).thenReturn(companies);

        // Calling the service method
        List<String> companyNames = companyService.getAllCompanies();

        // Verifying the result
        assertEquals(2, companyNames.size());
        assertEquals("Company 1", companyNames.get(0));
        assertEquals("Company 2", companyNames.get(1));
    }

    @Test
    public void testAddCompany() {
        // Mocking data
        CompanyDto companyDto = new CompanyDto();
        companyDto.setCompanyName("New Company");

        when(companyRepository.save(any())).thenReturn(new Company("New Company"));

        // Calling the service method
        CompanyDto addedCompany = companyService.addCompany(companyDto);

        // Verifying the result
        assertEquals("New Company", addedCompany.getCompanyName());
    }
}
