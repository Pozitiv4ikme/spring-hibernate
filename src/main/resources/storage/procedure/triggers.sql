use study_iot;

DROP trigger IF EXISTS before_trainer_insert;
DROP trigger IF EXISTS before_trainer_update;
DROP trigger IF EXISTS before_membership_update;
DROP trigger IF EXISTS before_membership_delete;

DELIMITER //
create trigger before_trainer_insert
    before INSERT
        on trainer for each row
        begin
            declare match_row_for_id int;
            select count(*) into match_row_for_id from membership where id = NEW.membership_id;
            if match_row_for_id = 0 then
                signal sqlstate '22000'
                set MESSAGE_TEXT = 'A foreign key constrain fails for membership_id';
            end if;
        end //
DELIMITER ;

DELIMITER //
create trigger before_trainer_update
    before UPDATE
        on trainer for each row
        begin
            declare match_row_for_id int;
            if OLD.membership_id <> NEW.membership_id then
                select count(*) into match_row_for_id from membership where id = NEW.membership_id;
                if match_row_for_id = 0 then
                    signal sqlstate '22000'
                    set MESSAGE_TEXT = 'A foreign key constrain fails for membership_id';
                end if;
            end if;
        end;
DELIMITER ;

DELIMITER //
create trigger before_membership_update
    before UPDATE
        on membership for each row
        begin
            declare count_used_for_id int;
            if OLD.id <> NEW.id then
                select count(*) into count_used_for_id from trainer where membership_id = OLD.id;
                if count_used_for_id > 0 then
                    signal sqlstate '22000'
                    set MESSAGE_TEXT = 'A foreign key constrain fails for membership_id';
                end if;
            end if;
        end;
DELIMITER ;

DELIMITER //
create trigger before_membership_delete
    before delete
        on membership for each row
        begin
            declare count_used_for_id int;
            select count(*) into count_used_for_id from trainer where id = OLD.id;
            if count_used_for_id > 0 then
                signal sqlstate '22000'
                set MESSAGE_TEXT = 'A foreign key constraint fails for id in table trainer';
            end if;
        end;
DELIMITER ;

