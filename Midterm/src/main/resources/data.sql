insert into role (name) values ('ROLE_ADMIN');
insert into role (name) values ('ROLE_USER' );
insert into user (username, password,email ,active, role_id) values ('titouan', '$2a$10$3VTFGn.2rT4Lgr6jPeix8OotoPZL8kMWEWexOVPsTUPTzTxvhfB/m','titouan.lemao@gmail.com' ,true, 1);
insert into employee (name,level, birthday, base_salary, user_id) values ('Titouan', 'C1',TO_DATE('26/05/1998', 'DD/MM/YYYY'), 1300.18 ,1);
insert into address (city, street, house_no, zipcode, employee_id) values ('Bangkok', 'Ramindra','30/6', '10220', 1);