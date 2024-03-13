package dat3.AXP.configuration;

import dat3.AXP.entity.Activity;
import dat3.AXP.entity.Customer;
import dat3.AXP.entity.Reservation;
import dat3.AXP.repository.ActivityRepository;
import dat3.AXP.repository.CustomerRepository;
import dat3.AXP.repository.ReservationRepository;
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

    ReservationRepository reservationRepository;
    ActivityRepository activityRepository;
    CustomerRepository customerRepository;
    UserWithRolesRepository userWithRolesRepository;
    RoleRepository roleRepository;
    PasswordEncoder pwEncoder;
    String passwordUsedByAll;

    public SetupDevUsers(ReservationRepository reservationRepository, ActivityRepository activityRepository, CustomerRepository customerRepository, UserWithRolesRepository userWithRolesRepository,RoleRepository roleRepository,PasswordEncoder passwordEncoder) {
        this.reservationRepository = reservationRepository;
        this.activityRepository = activityRepository;
        this.customerRepository = customerRepository;
        this.userWithRolesRepository = userWithRolesRepository;
        this.roleRepository = roleRepository;
        this.pwEncoder = passwordEncoder;

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

        reservation2.getActivities().add(activity1);
        reservation1.getActivities().add(activity3);
        reservation1.getActivities().add(activity2);
//        activity1.getReservations().add(reservation1);
//        activity2.getReservations().add(reservation2);
//        activity3.getReservations().add(reservation2);
        reservation2.setCustomer(customer1);


        activityRepository.save(activity1);
        activityRepository.save(activity2);
        activityRepository.save(activity3);
        reservationRepository.save(reservation2);
        reservationRepository.save(reservation1);
        //---- test data end ---- \\
    }
}
