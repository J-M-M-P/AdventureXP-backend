package dat3.AXP.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.AXP.entity.Company;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyDto {
    private Integer id;

    private String companyName;
    private String contactPerson;
    private Integer contactInfo;
    private Integer cvr;


    public CompanyDto(Company c, boolean b){
        this.id = c.getId();
        this.companyName = c.getCompanyName();
        this.contactPerson = c.getContactPerson();
        this.contactInfo = c.getContactInfo();
        this.cvr = c.getCvr();
    }

}
