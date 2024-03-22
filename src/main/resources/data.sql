USE axp;

-- ACTIVITY
INSERT INTO activity (age_limit, participant_limit, activity_name, description, image)
VALUES (0, 8, "Mini Golf", "Same as golf, just a bit smaller", "https://images.unsplash.com/photo-1612733061393-9b9f998e1f40?q=80&w=2048&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
INSERT INTO activity (age_limit, participant_limit, activity_name, description, image)
VALUES (14, 12, "Go-Kart", "Race your friends in a Go-Kart", "https://images.unsplash.com/photo-1505570554449-69ce7d4fa36b?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
INSERT INTO activity (age_limit, participant_limit, activity_name, description, image)
VALUES (16, 20, "Paintball", "Have a colorful shootout with your friends", "https://images.unsplash.com/photo-1588432892836-99b9aa3feb8a?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
INSERT INTO activity (age_limit, participant_limit, activity_name, description, image)
VALUES (18, 6, "Bungee Jumping", "For the REAL adrenalinejunkies", "https://media.istockphoto.com/id/618974736/photo/jump-rope.jpg?s=2048x2048&w=is&k=20&c=HehYVH6PT3RwL_MTEX2O6R629x70tpydjgnxvrz4kt8=");
INSERT INTO activity (age_limit, participant_limit, activity_name, description, image)
VALUES (6, 14, "Wall Climbing", "Test your strength and endurance at the super cool climbing wall", "https://media.istockphoto.com/id/878244958/photo/you-did-it.jpg?s=2048x2048&w=is&k=20&c=sAawSgwWPY3NmMstWPOk9wvNfN1gvBjHEBbd7aphc8Q=");
INSERT INTO activity (age_limit, participant_limit, activity_name, description, image)
VALUES (18, 6, "Sumo Wrestling", "Have fun wrestling your friends", "https://media.istockphoto.com/id/1434690616/photo/men-and-women-in-sumo-suits-fighting-in-outdoor-amusement-park.jpg?s=1024x1024&w=is&k=20&c=fFAfgJKek7Uw3-5u0ettDrAHJ4GF9tAw5p6ww1twnD0=");



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
/* Mini Golf */
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Mandag", "09:00 - 10:30", 14, 1);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Tirsdag", "09:00 - 10:30", 14, 1);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Onsdag", "09:00 - 10:30", 14, 1);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Torsdag", "09:00 - 10:30", 14, 1);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Fredag", "09:00 - 10:30", 14, 1);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Lørdag", "09:00 - 10:30", 14, 1);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Søndag", "09:00 - 10:30", 14, 1);

/* Go-Cart */
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Mandag", "10:30 - 12:00", 14, 2);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Tirsdag", "10:30 - 12:00", 14, 2);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Onsdag", "10:30 - 12:00", 14, 2);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Torsdag", "10:30 - 12:00", 14, 2);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Fredag", "10:30 - 12:00", 14, 2);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Lørdag", "10:30 - 12:00", 14, 2);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Søndag", "10:30 - 12:00", 14, 2);

/* Paintball*/
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Mandag", "12:00 - 13:30", 14, 3);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Tirsdag", "12:00 - 13:30", 14, 3);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Onsdag", "12:00 - 13:30", 14, 3);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Torsdag", "12:00 - 13:30", 14, 3);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Fredag", "12:00 - 13:30", 14, 3);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Lørdag", "12:00 - 13:30", 14, 3);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Søndag", "12:00 - 13:30", 14, 3);

/* Bungee Jumping */
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Mandag", "13:30 - 15:00", 14, 4);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Tirsdag", "13:30 - 15:00", 14, 4);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Onsdag", "13:30 - 15:00", 14, 4);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Torsdag", "13:30 - 15:00", 14, 4);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Fredag", "13:30 - 15:00", 14, 4);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Lørdag", "13:30 - 15:00", 14, 4);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Søndag", "13:30 - 15:00", 14, 4);

/* Wall Climbing */
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Mandag", "15:00 - 16:30", 14, 5);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Tirsdag", "15:00 - 16:30", 14, 5);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Onsdag", "15:00 - 16:30", 14, 5);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Torsdag", "15:00 - 16:30", 14, 5);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Fredag", "15:00 - 16:30", 14, 5);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Lørdag", "15:00 - 16:30", 14, 5);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Søndag", "15:00 - 16:30", 14, 5);

/* Sumo Wrestling */
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Mandag", "16:30 - 18:00", 14, 6);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Tirsdag", "16:30 - 18:00", 14, 6);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Onsdag", "16:30 - 18:00", 14, 6);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Torsdag", "16:30 - 18:00", 14, 6);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Lørdag", "16:30 - 18:00", 14, 6);
INSERT INTO reservation (booked_status, customer_id, reservation_day,reservation_time, reservation_week , activity_id)
VALUES (1, 2, "Søndag", "16:30 - 18:00", 14, 6);


-- RESERVATION_ACTIVITY
/*
INSERT INTO reservation_activity (activity_id, reservation_id)
VALUES (1, 1);
INSERT INTO reservation_activity (activity_id, reservation_id)
VALUES (2, 2);
*/