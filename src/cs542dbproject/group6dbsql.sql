drop table response_time cascade constraints;
drop table respond_to cascade constraints;
drop table times_of_call cascade constraints;
drop table type_of_call cascade constraints;
drop table outcome cascade constraints;
drop table recieving_hospital cascade constraints;
drop table loc cascade constraints;
drop table staff cascade constraints;
drop table address cascade constraints;
drop table time_t cascade constraints;


create table time_t (
time_t date,
type_t char(50) unique,
primary key (time_t, type_t));

create table staff (
staff_id int,
name_s char(50),
badge_id int,
dob date,
primary key (staff_id));

create table address (
street_num int,
street_name char(50) unique,
primary key (street_num, street_name));

create table loc (
location_id int,
room_number int,
street_num int,
street_name char(50),
type_l char(50),
name_l char(50),
primary key (location_id),
foreign key (street_num, street_name) references address (street_num, street_name));

create table recieving_hospital (
hospital_id int,
hospital_name char(50) unique,
location_id int,
primary key (hospital_id),
foreign key (location_id) references loc (location_id));

create table outcome (
outcome_id int,
oresult char(50),
recieving_service char(50),
recieving_hospital char(50),
primary key (outcome_id),
foreign key (recieving_hospital) references recieving_hospital (hospital_name));

create table type_of_call (
call_id int,
reported char(25),
actual char(25),
outcome_id int,
location_id int,
primary key (call_id),
foreign key (outcome_id) references outcome (outcome_id),
foreign key (location_id) references loc (location_id));

create table times_of_call (
time_t date,
call_id int,
type_t char(50),
primary key (time_t, call_id),
foreign key (time_t, type_t) references time_t (time_t, type_t),
foreign key (call_id) references type_of_call (call_id));

create table respond_to (
staff_id int,
call_id int,
primary key (staff_id, call_id),
foreign key (staff_id) references staff (staff_id),
foreign key (call_id) references type_of_call (call_id));

create table response_time (
staff_id int,
time_t date,
type_t char(50),
primary key (staff_id, time_t),
foreign key (staff_id) references staff (staff_id),
foreign key (time_t, type_t) references time_t (time_t, type_t));



