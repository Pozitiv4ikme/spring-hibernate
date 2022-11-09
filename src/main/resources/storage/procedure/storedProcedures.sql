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