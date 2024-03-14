package dat3.AXP.service;

import dat3.AXP.dto.CompanyDto;
import dat3.AXP.entity.Company;
import dat3.AXP.repository.CompanyRepository;
import org.springframework.stereotype.Service;
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
        Company newCompany = new Company("Company 1");
        updateCompany(newCompany, request);
        return new CompanyDto(newCompany, false);
    }

    private void updateCompany(Company original, CompanyDto dto){
        original.setCompanyName(dto.getCompanyName());
        original.setContactPerson(dto.getContactPerson());
        original.setContactInfo(dto.getContactInfo());
        original.setCvr(dto.getCvr());
    }
}
