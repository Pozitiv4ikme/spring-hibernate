USE study_iot;

INSERT INTO city (id, name)
VALUES (1, 'Lviv'),
       (2, 'Lutsk'),
       (3, 'Odessa'),
       (4, 'Kovel'),
       (5, 'Rivne'),
       (6, 'Kharkiv'),
       (7, 'Sambir');

INSERT INTO gym (phone, street_address, city_id)
VALUES (380932793092, 'Kravchuk 22', 2),
       (380674398042, 'Stepana Bandera 1', 1),
       (380674880844, 'Internationalist soldiers 12', 4);

INSERT INTO membership(card_price)
VALUES (10330.21),
       (3499.99),
       (4999.99),
       (1549.01);

INSERT INTO trainer (id, name, surname, phone, gym_id, membership_id)
VALUES (1, 'Vitalii', 'Pashynskyi', '380638743292', 3, 2),
       (2, 'Pavlo', 'Tkachuk', '380678241228', 1, 1),
       (3, 'Victoria', 'Pavelchak', '380637681290', 2, 3),
       (4, 'Zenoviy', 'Veres', '380678934201', 2, 1);

INSERT INTO personal_training (id, trainer_id)
VALUES (1, 2),
       (2, 1),
       (3, 4);

INSERT INTO personal_exercise_machine (id, type, client_weight, client_height, client_shoulder_width, client_leg_length,
                                       client_amount_of_fat_in_body, client_state_of_health)
VALUES (1, 'seated arm extension', 60, 170, null, null, 30, 'healthy'),
       (2, 'seated arm cur', 70, null, 100, 120, 25, 'light sick'),
       (3, 'seated press', null, null, 80, null, 15, 'light sick'),
       (4, 'seated overhead press', null, null, 85, null, 45, 'unhealthy'),
       (5, 'seated lat pulldown', 75, 180, 90, null, 18, 'healthy'),
       (6, 'seated leg curl', null, 160, null, 90, null, 'unhealthy'),
       (7, 'lying leg curl', null, null, null, null, 13, 'healthy'),
       (8, 'seated arm row', null, 178, 75, null, null, 'healthy'),
       (9, 'assisted close-grip pull-up', 80, 170, 60, 100, 23, 'healthy'),
       (10, 'rear leg extension', null, 160, null, 80, null, 'light sick');

INSERT INTO exercise (number_of_repetitions, approach, complexity, personal_exercise_machine_id, type_of_muscle_load_on)
VALUES (16, 5, null, 3, 'one type'),
       (10, 4, 10, 1, 'complex'),
       (25, 2, 100, 2, 'complex'),
       (10, 5, 50, 2, 'all'),
       (13, 5, 20, 10, 'one type'),
       (30, 3, 90, 7, 'complex'),
       (18, 4, null, 6, 'complex'),
       (30, 2, 60, 5, 'one type'),
       (5, 5, 20, 4, 'all'),
       (19, 6, null, 9, 'all'),
       (10, 5, null, 8, 'one type'),
       (20, 4, 35, 5, 'complex'),
       (34, 6, null, 3, 'complex'),
       (12, 8, 78, 2, 'all'),
       (35, 2, null, 10, 'one type');

INSERT INTO exercise_personal_training (exercise_id, personal_training_id)
VALUES (1, 2),
       (10, 2),
       (15, 2),
       (11, 2),
       (13, 2),

       (2, 1),
       (5, 1),
       (6, 1),
       (8, 1),
       (9, 1),

       (3, 3),
       (4, 3),
       (7, 3),
       (12, 3),
       (14, 3);

INSERT INTO free_group_program (id, day, exercise)
VALUES (1, 'Monday', 'tango'),
       (2, 'Tuesday', 'cycle'),
       (3, 'Wednesday', 'basic yoga'),
       (4, 'Thursday', 'pilates matwork'),
       (5, 'Friday', 'basic step'),

       (6, 'Wednesday', 'power cycle'),
       (7, 'Thursday', 'aqua medium'),
       (8, 'Friday', 'nothing'),
       (9, 'Sunday', 'aqua freestyle');

INSERT INTO free_group_training (trainer_id, free_group_program_id)
VALUES (3, 1),
       (3, 2),
       (3, 3),
       (3, 4),
       (3, 5),

       (2, 6),
       (2, 7),
       (2, 8),
       (2, 9);

INSERT INTO gender (id, type)
VALUES (1, 'male'),
       (2, 'female'),
       (3, 'non-binary'),
       (4, 'transgender');

INSERT INTO client (name, surname, birthday, phone, gender_id)
VALUES ('Marko', 'Yaminskyi', '2004-12-10', '380634892933', 1),
       ('Cat', 'Beautiful', '2005-12-20', '380961531912', 2),
       ('Alina', 'Veres', '2005-03-18', '380675979856', 2),
       ('Ruslan', 'Toxic', '2004-01-28', '380668092751', 4),
       ('Dmytro', 'Shaposhnikov', '2004-04-15', '380662292751', 1),
       ('Oleg', 'Tkachuk', '2004-01-09', '380668011751', 1);


INSERT INTO client_gym (gym_id, client_id)
VALUES (1, 2),
       (1, 3),
       (2, 1),
       (3, 4);