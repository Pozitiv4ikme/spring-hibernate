-- parameterized insertion in client table
DROP PROCEDURE IF EXISTS insertion_into_gym;
DELIMITER //
create procedure insertion_into_gym(
    in new_phone varchar(12),
    in new_street_address varchar(50),
    in new_city_id int,
    OUT generated_id int)
    begin
        insert into gym(phone, street_address, city_id) VALUE (new_phone, new_street_address, new_city_id);
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
