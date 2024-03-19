USE axp;

-- ACTIVITY
INSERT INTO activity (age_limit, participant_limit, activity_name, description, image)
VALUES (0, 8, "Mini Golf", "Same as golf, just a bit smaller", "theimagestring");
INSERT INTO activity (age_limit, participant_limit, activity_name, description, image)
VALUES (14, 12, "Go-Kart", "Race your friends in a Go-Kart", "theimagestring");
INSERT INTO activity (age_limit, participant_limit, activity_name, description, image)
VALUES (16, 20, "Paintball", "Have a colorful shootout with your friends", "theimagestring");

-- COMPANIES
INSERT INTO companies (id, company_name, contact_info, contact_person, cvr)
VALUES (1, 'ABC Industries', 00112233, 'John Smith', '12345678');
INSERT INTO companies (id, company_name, contact_info, contact_person, cvr)
VALUES (2, 'XYZ Corporation', 88776655, 'Jane Doe', '87654321');


-- CUSTOMERS
INSERT INTO customer (age, name, email, phone_number)
VALUES (24, "anders andersen", "anders@andersen.mail", "12345678");
INSERT INTO customer (age, name, email, phone_number)
VALUES (42, "peter petersen", "peter@petersen.mail", "87654321");

-- EMPLOYEES
INSERT INTO employees (id, first_name, last_name, phone) VALUES (1, 'John', 'Doe', 12345678);
INSERT INTO employees (id, first_name, last_name, phone) VALUES (2, 'Alice', 'Smith', 98765432);
INSERT INTO employees (id, first_name, last_name, phone) VALUES (3, 'Bob', 'Johnson', 55512345);
INSERT INTO employees (id, first_name, last_name, phone) VALUES (4, 'Emily', 'Brown', 45678901);
INSERT INTO employees (id, first_name, last_name, phone) VALUES (5, 'Michael', 'Davis', 78901234);

-- EQUIPMENT
INSERT INTO equipment (activity_id, defective_units, status, total_units, name)
VALUES (1, 0, true, 20, "Minigolf (sæt)");
INSERT INTO equipment (activity_id, defective_units, status, total_units, name)
VALUES (2, 3, true, 12, "GoKart");
INSERT INTO equipment (activity_id, defective_units, status, total_units, name)
VALUES (3, 1, true, 16, "Paintball pistol");


-- RESERVATIONS
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week )
VALUES (1, 2, "Fredag", "10:30 - 12:00", 13);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week)
VALUES (0, null, "Torsdag", "10:30 - 12:00", 13);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week)
VALUES (1, 1, "Mandag", "10:30 - 12:00", 13);

-- RESERVATION_ACTIVITY
INSERT INTO reservation_activity (activity_id, reservation_id)
VALUES (1, 1);
INSERT INTO reservation_activity (activity_id, reservation_id)
VALUES (2, 2);