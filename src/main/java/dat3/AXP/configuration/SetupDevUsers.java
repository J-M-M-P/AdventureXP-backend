package dat3.AXP.configuration;

import dat3.AXP.dto.CompanyDto;
import dat3.AXP.dto.ReservationDto;
import dat3.AXP.entity.Activity;
import dat3.AXP.entity.Equipment;
import dat3.AXP.entity.Reservation;
import dat3.AXP.repository.ActivityRepository;
import dat3.AXP.repository.EquipmentRepository;
import dat3.AXP.entity.Customer;
import dat3.AXP.repository.CustomerRepository;
import dat3.AXP.repository.ReservationRepository;
import dat3.AXP.entity.Company;
import dat3.AXP.repository.*;
import dat3.AXP.service.CompanyService;
import dat3.AXP.service.ReservationService;
import dat3.security.entity.Role;
import dat3.security.entity.UserWithRoles;
import dat3.security.repository.RoleRepository;
import dat3.security.repository.UserWithRolesRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Component
public class SetupDevUsers implements ApplicationRunner {

    EquipmentRepository equipmentRepository;
    ReservationRepository reservationRepository;
    ActivityRepository activityRepository;

    EmployeeRepository employeeRepository;

    CompanyRepository companyRepository;

    CompanyService companyService;
    ReservationService reservationService;
    CustomerRepository customerRepository;
    UserWithRolesRepository userWithRolesRepository;
    RoleRepository roleRepository;
    PasswordEncoder pwEncoder;
    String passwordUsedByAll;

    public SetupDevUsers(ReservationRepository reservationRepository, ReservationService reservationService, ActivityRepository activityRepository, EquipmentRepository equipmentRepository, CustomerRepository customerRepository, CompanyRepository companyRepository, CompanyService companyService, EmployeeRepository employeeRepository, UserWithRolesRepository userWithRolesRepository,RoleRepository roleRepository,PasswordEncoder passwordEncoder) {

        this.reservationRepository = reservationRepository;
        this.reservationService = reservationService;
        this.activityRepository = activityRepository;
        this.customerRepository = customerRepository;
        this.companyRepository = companyRepository;
        this.companyService = companyService;
        this.employeeRepository = employeeRepository;
        this.userWithRolesRepository = userWithRolesRepository;
        this.roleRepository = roleRepository;
        this.pwEncoder = passwordEncoder;
        this.equipmentRepository = equipmentRepository;

        passwordUsedByAll = "test12";
    }

    public void run(ApplicationArguments args) {
        setupAllowedRoles();
        setupUserWithRoleUsers();
    }

    private void setupAllowedRoles(){
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));
    }

     /*****************************************************************************************
     IMPORTANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL
     iT'S ONE OF THE TOP SECURITY FLAWS YOU CAN DO
     If you see the lines below in log-outputs on Azure, forget whatever had your attention on, AND FIX THIS PROBLEM
     *****************************************************************************************/
    private void setupUserWithRoleUsers() {
        Role roleUser = roleRepository.findById("USER").orElseThrow(()-> new NoSuchElementException("Role 'user' not found"));
        Role roleAdmin = roleRepository.findById("ADMIN").orElseThrow(()-> new NoSuchElementException("Role 'admin' not found"));
        System.out.println("******************************************************************************");
        System.out.println("********** IMPORTANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ************");
        System.out.println();
        System.out.println("******* NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL ************");
        System.out.println("******* REMOVE THIS BEFORE DEPLOYMENT, AND SETUP DEFAULT USERS DIRECTLY  *****");
        System.out.println("**** ** ON YOUR REMOTE DATABASE                 ******************************");
        System.out.println();
        System.out.println("******************************************************************************");
        UserWithRoles user1 = new UserWithRoles("user1", pwEncoder.encode(passwordUsedByAll), "user1@a.dk");
        UserWithRoles user2 = new UserWithRoles("user2", pwEncoder.encode(passwordUsedByAll), "user2@a.dk");
        UserWithRoles user3 = new UserWithRoles("user3", pwEncoder.encode(passwordUsedByAll), "user3@a.dk");
        UserWithRoles user4 = new UserWithRoles("user4", pwEncoder.encode(passwordUsedByAll), "user4@a.dk");
        user1.addRole(roleUser);
        user1.addRole(roleAdmin);
        user2.addRole(roleUser);
        user3.addRole(roleAdmin);
        userWithRolesRepository.save(user1);
        userWithRolesRepository.save(user2);
        userWithRolesRepository.save(user3);
        userWithRolesRepository.save(user4);
        //---- test data start ---- \\
        Activity activity1 = new Activity("Mini Golf", 0, 5, "Same as golf, just a bit smaller", "imagestringgoeshere....");
        Activity activity2 = new Activity("Go-Kart", 12, 16, "Race your friends in a Go-Kart", "imagestringgoeshere....");
        Activity activity3 = new Activity("Paintball", 16, 20, "Have a colorful shootout with your friends", "imagestringgoeshere....");
        Reservation reservation1 = new Reservation(LocalDateTime.of(2024, 4, 16, 12, 30,0), false);
        Reservation reservation2 = new Reservation(LocalDateTime.of(2024,4, 18, 10, 0, 0), false);


        Customer customer1 = new Customer("Allan", 18, "12345678", "allan@email.email");
        customerRepository.save(customer1);


        CompanyDto companyDto = new CompanyDto();
        companyDto.setCompanyName("KEA");
        companyDto.setContactPerson("Lars Mogensen");
        companyDto.setContactInfo(46460000);
        companyDto.setCvr(12345678);
        CompanyDto newCompanyDto = companyService.addCompany(companyDto);

        // Convert CompanyDto to Company entity
        Company newCompany = new Company();
        newCompany.setCompanyName(newCompanyDto.getCompanyName());
        newCompany.setContactPerson(newCompanyDto.getContactPerson());
        newCompany.setContactInfo(newCompanyDto.getContactInfo());
        newCompany.setCvr(newCompanyDto.getCvr());

        CompanyDto companyDto2 = new CompanyDto();
        companyDto2.setCompanyName("Facebook");
        companyDto2.setContactPerson("Mark Zuckerberg");
        companyDto2.setContactInfo(555012043);
        companyDto2.setCvr(88888888);
        CompanyDto newCompanyDto2 = companyService.addCompany(companyDto2);

        // Convert CompanyDto to Company entity
        Company newCompany2 = new Company();
        newCompany2.setCompanyName(newCompanyDto2.getCompanyName());
        newCompany2.setContactPerson(newCompanyDto2.getContactPerson());
        newCompany2.setContactInfo(newCompanyDto2.getContactInfo());
        newCompany2.setCvr(newCompanyDto2.getCvr());

        // Save the company entity
        companyRepository.save(newCompany);
        companyRepository.save(newCompany2);

        // Construct a ReservationDto object
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setDateTime(LocalDateTime.of(2024, 4, 16, 12, 30, 0));
        reservationDto.setBookedStatus(false);
        reservationDto.setCompanyId(1); // Set the companyId for the reservation

// Call the createReservation method in ReservationService to create the reservation
        Reservation newReservation = reservationService.createReservation(reservationDto);

// Note: Since the createReservation method returns a Reservation entity,
// there's no need to set the attributes of newReservation again.

// Save the reservation to the database
        reservationRepository.save(newReservation);


        // Save the company entity
        companyRepository.save(newCompany);

// You can pass this reservationDto to your service method to handle the association with the company

        reservation2.getActivities().add(activity1);
        reservation1.getActivities().add(activity3);
        reservation1.getActivities().add(activity2);
        reservation2.setCustomer(customer1);




        activityRepository.save(activity1);
        activityRepository.save(activity2);
        activityRepository.save(activity3);
        reservationRepository.save(reservation2);
        reservationRepository.save(reservation1);

        Equipment equipment1 = new Equipment("Golfkøller", true, 100, 10);
        Equipment equipment2 = new Equipment("Gokarts", true, 20, 5);
        Equipment equipment3 = new Equipment("Paintball pistoler", true, 30, 2);

        equipment1.setActivity(activity1);
        equipment2.setActivity(activity2);
        equipment3.setActivity(activity3);

        equipmentRepository.save(equipment1);
        equipmentRepository.save(equipment2);
        equipmentRepository.save(equipment3);

        //---- test data end ---- \\
    }
}
