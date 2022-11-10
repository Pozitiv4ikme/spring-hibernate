-- parameterized insertion in gym table
DROP PROCEDURE IF EXISTS insertion_into_gym;
DELIMITER //
create procedure insertion_into_gym(
    in new_phone varchar(12),
    in new_street_address varchar(50),
    in new_city_id int,
    OUT generated_id int)
    begin
        DECLARE new_city_id_exist int;
        select new_city_id into new_city_id_exist;
        if new_city_id_exist is null then
            signal sqlstate '45000'
            set MESSAGE_TEXT = 'City with this id not found';
        end if;
        insert into gym(phone, street_address, city_id) VALUE (new_phone, new_street_address, new_city_id_exist);
        select id into generated_id from gym where phone=new_phone;
    end //
DELIMITER ;

-- M:M connection between 2 tables by inspecting IDs(compare with other real values)
DROP PROCEDURE IF EXISTS insertion_into_client_gym_M_to_M;
DELIMITER //
create procedure insertion_into_client_gym_M_to_M(
    IN new_gym_id int,
    IN new_client_id int)
    begin
        DECLARE new_gym_id_exists int;
        DECLARE new_client_id_exists int;
        select id into new_gym_id_exists from gym where id=new_gym_id;
        select id into new_client_id_exists from client where id=new_client_id;
        if new_gym_id_exists is null then
            signal sqlstate '22000'
            set MESSAGE_TEXT = 'Gym with this id not found';
        elseif new_client_id_exists is null then
            signal sqlstate '22000'
            set MESSAGE_TEXT = 'Client with this id not found';
        end if;
        insert into client_gym(gym_id, client_id) VALUE (new_gym_id_exists, new_client_id_exists);
    end //
DELIMITER ;

-- insert 10 records into free_group_program table
DROP PROCEDURE IF EXISTS insert_10_records_into_free_group_program;
DELIMITER //
create procedure insert_10_records_into_free_group_program()
    begin
        declare counter int default 1;
        while counter < 11 do
                INSERT INTO free_group_program(day, exercise) VALUE (concat('day', counter), concat('exercise', counter));
                set counter = counter + 1;
            end while;
    end //
DELIMITER ;

-- custom function like avg, max, min or sum
DROP FUNCTION IF EXISTS complexity_avg;
DELIMITER //
create function complexity_avg()
    returns INT DETERMINISTIC
    begin
        return (SELECT avg(complexity) FROM exercise);
    end //
DELIMITER ;

DROP PROCEDURE IF EXISTS exercise_complexity_avg;
DELIMITER //
create procedure exercise_complexity_avg(
    OUT res_complexity_avg INT)
    begin
        SELECT complexity_avg() INTO res_complexity_avg;
    end //
DELIMITER ;