-- drop table statments

drop table response_time cascade constraints;
drop table respond_to cascade constraints;
drop table times_of_call cascade constraints;
drop table type_of_call cascade constraints;
drop table outcome cascade constraints;
drop table recieving_hospital cascade constraints;
drop table recieving_service cascade constraints;
drop table call_t cascade constraints;
drop table loc cascade constraints;
drop table staff cascade constraints;
drop table time_t cascade constraints;
drop table call_location cascade constraints;
drop table hospital_transports cascade constraints;
drop table service_transports cascade constraints;
drop table hospital_location cascade constraints;

-- create table statements

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

create table loc (
location_id int,
loc_name char(50),
addr char(50),
loc_type char(50),
primary key (location_id));

create table recieving_hospital (
hospital_id int,
hospital_name char(50),
location_id int,
primary key (hospital_id, hospital_name));

create table recieving_service (
service_id int,
service_name char(50),
location_id int,
primary key (service_id, service_name));

create table outcome (
outcome_id int,
oresult char(50),
recieving_service char(50),
recieving_hospital char(50),
primary key (outcome_id));

create table call_t (
call_time date,
call_type_t char(50),
call_id int,
call_reported char(50),
call_actual char(50),
outcome_id int,
location_id int,
primary key (call_time, call_id));

create table type_of_call (
toc_id int,
reported char(25),
actual char(25),
outcome_id int,
location_id int,
primary key (toc_id));

create table times_of_call (
time_t date,
call_id int,
type_t char(50),
call_time date,
primary key (time_t, call_id),
foreign key (time_t, type_t) references time_t (time_t, type_t),
foreign key (call_id, call_time) references call_t (call_id, call_time));

create table respond_to (
staff_id int,
call_id int,
call_time date,
primary key (staff_id, call_id, call_time),
foreign key (staff_id) references staff (staff_id),
foreign key (call_id, call_time) references call_t (call_id, call_time));

create table response_time (
staff_id int,
time_t date,
type_t char(50),
primary key (staff_id, time_t),
foreign key (staff_id) references staff (staff_id),
foreign key (time_t, type_t) references time_t (time_t, type_t));

create table call_location (
call_id int,
call_time date,
loc_id int,
primary key (call_id, call_time, loc_id),
foreign key (call_id, call_time) references call_t (call_id, call_time),
foreign key (loc_id) references loc (location_id));

create table hospital_transports (
outcome_id int,
hospital_id int,
hospital_name char(50),
primary key (outcome_id, hospital_id, hospital_name),
foreign key (hospital_id, hospital_name) references recieving_hospital (hospital_id, hospital_name),
foreign key (outcome_id) references outcome (outcome_id));

create table service_transports (
outcome_id int,
service_id int,
service_name char(50),
primary key (outcome_id, service_id, service_name),
foreign key (outcome_id) references outcome (outcome_id),
foreign key (service_id, service_name) references recieving_service (service_id, service_name));

create table hospital_location (
hospital_id int,
hospital_name char(50),
loc_id int,
primary key (hospital_id, hospital_name, loc_id),
foreign key (hospital_id, hospital_name) references recieving_hospital (hospital_id, hospital_name),
foreign key (loc_id) references loc (location_id));

-- drop sequencers

drop sequence seq_staffid;
drop sequence seq_locid;
drop sequence seq_hospitalid;
drop sequence seq_outcomeid;
drop sequence seq_callid;

-- create sequencers

CREATE SEQUENCE seq_staffid
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 25;

CREATE SEQUENCE seq_locid
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 25;

CREATE SEQUENCE seq_hospitalid
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 25;

CREATE SEQUENCE seq_outcomeid
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 25;

CREATE SEQUENCE seq_callid
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 25;



