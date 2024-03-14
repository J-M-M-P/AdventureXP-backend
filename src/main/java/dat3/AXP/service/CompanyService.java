package dat3.AXP.service;

import dat3.AXP.dto.CompanyDto;
import dat3.AXP.entity.Company;
import dat3.AXP.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    public List<String> getAllCompanies(){
        List<Company> companies = companyRepository.findAll();
        return companies.stream().map(Company::getCompanyName).toList();
    }

    public CompanyDto addCompany(CompanyDto request){
        Company newCompany = new Company();
        updateCompany(newCompany, request);
        companyRepository.save(newCompany);
        return new CompanyDto(newCompany, false);
    }

    private void updateCompany(Company original, CompanyDto c){ original.setCompanyName(c.getCompanyName());}

//    public void createTenCompanies() {
//        List<Company> companies = new ArrayList<>();
//        for (int i = 1; i <= 10; i++) {
//            Company company = new Company("Company " + i);
//            // Set other properties if needed
//            companies.add(company);
//        }
//        companyRepository.saveAll(companies);
//    }
}
