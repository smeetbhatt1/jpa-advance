insert into course(id, name, created_date, updated_date)
values
(10001, 'JPA in 50 steps', SYSDATE(), SYSDATE()),
(10002, 'Spring in 50 steps', SYSDATE(), SYSDATE()),
(10003, 'Spring Boot in 100 steps', SYSDATE(), SYSDATE());

insert into passport(id, number)
values
(40001,'E123456'),
(40002,'N123457'),
(40003,'L123890');

insert into student(id, name, passport_id)
values
(20001,'Ranga',40001),
(20002,'Adam',40002),
(20003,'Jane',40003);

insert into review(id, rating, description)
values
(50001,'5', 'Great course.'),
(50002,'4', 'Good content'),
(50003,'2', 'Bad course');
