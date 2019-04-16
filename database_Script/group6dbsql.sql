-- drop table statments

drop table respond_to cascade constraints;
drop table times_of_call cascade constraints;
drop table outcome cascade constraints;
drop table recieving_hospital cascade constraints;
drop table recieving_service cascade constraints;
drop table call cascade constraints;
drop table loc cascade constraints;
drop table staff cascade constraints;
drop table time_t cascade constraints;
drop table call_location cascade constraints;
drop table hospital_transports cascade constraints;
drop table service_transports cascade constraints;
drop table hospital_location cascade constraints;
drop table call_outcome cascade constraints;

-- create table statements

create table time_t (
time_t date,
type_t char(50),
primary key (time_t, type_t)
);

create table staff (
staff_id int,
name_s char(50),
badge_id int,
dob date,
primary key (staff_id)
);

create table loc (
location_id int,
loc_name char(50),
addr char(50),
loc_type char(50),
primary key (location_id)
);

create table recieving_hospital (
hospital_id int,
hospital_name char(50),
location_id int,
primary key (hospital_id)
);

create table recieving_service (
service_id int,
service_name char(50),
primary key (service_id)
);

create table outcome (
outcome_id int,
oresult char(50),
primary key (outcome_id)
);

create table call (
call_id int,
call_reported char(100),
call_actual char(100),
primary key (call_id)
);

create table call_outcome (
call_id int,
outcome_id int,
primary key (call_id, outcome_id),
foreign key (call_id) references call (call_id),
foreign key (outcome_id) references outcome (outcome_id)
);

create table times_of_call (
call_id int,
time_t date,
type_t char(50),
primary key (call_id, time_t,type_t),
foreign key (time_t, type_t) references time_t (time_t, type_t),
foreign key (call_id) references call (call_id)
);

create table respond_to (
staff_id int,
call_id int,
primary key (staff_id, call_id),
foreign key (staff_id) references staff (staff_id),
foreign key (call_id) references call (call_id)
);

create table call_location (
call_id int,
loc_id int,
primary key (call_id, loc_id),
foreign key (call_id) references call (call_id),
foreign key (loc_id) references loc (location_id));

create table hospital_transports (
outcome_id int,
hospital_id int,
primary key (outcome_id, hospital_id),
foreign key (hospital_id) references recieving_hospital (hospital_id),
foreign key (outcome_id) references outcome (outcome_id));

create table service_transports (
outcome_id int,
service_id int,
primary key (outcome_id, service_id),
foreign key (outcome_id) references outcome (outcome_id),
foreign key (service_id) references recieving_service (service_id));

create table hospital_location (
hospital_id int,
loc_id int,
primary key (hospital_id, loc_id),
foreign key (hospital_id) references recieving_hospital (hospital_id),
foreign key (loc_id) references loc (location_id));

-- drop sequencers

drop sequence seq_staffid;
drop sequence seq_locid;
drop sequence seq_hospitalid;
drop sequence seq_outcomeid;
drop sequence seq_callid;
drop sequence seq_sevcid;

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

CREATE SEQUENCE seq_sevcid
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 25;