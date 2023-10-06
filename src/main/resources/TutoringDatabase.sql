drop database if exists tutoring_db;
create database tutoring_db;
use tutoring_db;

create table student(
    student_id int auto_increment,
    name varchar(30) not null,
    surname varchar(30),
    constraint ps_studentid_pk primary key (student_id)
);

insert into student values(100, 'Andrew', 'Bernard')
insert into student values(101, 'Dwight', 'Schrute')
insert into student values(102, 'Michael', 'Scott')

create table lesson(
    student_id int,
    lesson_date date not null,
    start_time time not null,
    finish_time time not null,
    duration time,
    description varchar(200),
    wage float not null,
    to_pay float,
    payment float not null,
    constraint ps_lessondate_starttime_pk primary key (lesson_date, start_time),
    constraint ps_student_id_fk foreign key(student_id) references student(student_id)
);

insert into lesson values (100, '2022-11-16', '18:00:00', '19:30:00', '01:30:00', 'Trigonometry', 60.0, 90.0, 100.0);
insert into lesson values (102, '2022-11-16', '19:45:00', '21:15:00', '01:30:00', 'Quadratic function', 60.0, 90.0, 90.0);
insert into lesson values (100, '2022-11-18', '18:00:00', '19:30:00', '01:30:00', 'Matrices', 60.0, 90.0, 100.0);
insert into lesson values (101, '2022-11-18', '20:00:00', '21:30:00', '01:30:00', 'Polynomials', 60.0, 90.0, 0.0);

commit;
select * from student;
select * from lesson;
