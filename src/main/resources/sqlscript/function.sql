drop function if exists getFirstNameById;
delimiter //
create function getFirstNameById(in_id INT)
returns varchar(60)
begin
return (select first_name from contact where id = in_id);
end//
