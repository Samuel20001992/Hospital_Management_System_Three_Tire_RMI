create database if not exists advanced_java_project;
use advanced_java_project;

create table departments
(
	id int auto_increment
		primary key,
	name varchar(255) null,
	head_id int null ,
	phone_number int not null,
	email varchar(255) not null
);

create table employees
(
	id int auto_increment
		primary key,
	first_name varchar(255) not null,
	middle_name varchar(255) null,
	last_name varchar(255) not null,
	sex char not null,
	age int not null,
	phone_number varchar(255) not null,
	email varchar(255) not null,
	address varchar(255) not null,
	hired_date timestamp not null,
	salary int not null,
	job_type varchar(255) not null,
	department_id int null,
	image_address varchar(255) null,
	constraint employees_departments_id_fk
		foreign key (department_id) references departments (id)
			on delete set null
);

alter table departments
	add constraint head___fk
		foreign key (head_id) references employees (id)
			on delete set null;


create table passwords
(
	id int primary key,
	password varchar(255) not null,
	constraint employee___fk
		foreign key (id) references employees (id)
			on delete cascade
);



create table patients(
    id int auto_increment
		primary key,
	first_name varchar(255) not null,
	middle_name varchar(255) null,
	last_name varchar(255) not null,
	sex char not null,
	age int not null,
	phone_number varchar(255) not null,
	address varchar(255) not null,
	registration_date timestamp
);

create table appointments
(
	id int auto_increment
		primary key,
	patient_id int not null,
	doctor_id int not null,
	description varchar(255) not null,
	date date not null,
	constraint appointed_doctor
		foreign key (doctor_id) references employees (id)
			on delete cascade,
	constraint appointed_patient
		foreign key (patient_id) references patients (id)
			on delete cascade
);

create table prescriptions
(
	id int auto_increment
		primary key,
	patient_id int not null,
	doctor_id int not null,
	medicines varchar(255) not null,
	deadline date not null,
	issued_date timestamp ,
	constraint prescriber_doctor
		foreign key (doctor_id) references employees (id)
			on delete cascade,
	constraint prescribed_patient
		foreign key (patient_id) references patients (id)
			on delete cascade
);

create table rooms
(
    id int auto_increment
        primary key,
    room_no int not null,
    patient_id int null,
    constraint room_patient_id_uindex
        unique (patient_id),
    constraint room_room_no_uindex
        unique (room_no),
    constraint room_patients_id_fk
        foreign key (patient_id) references patients (id)
            on delete set null
);

insert into rooms(room_no) values (1);
insert into rooms(room_no, patient_id) values (2,null);
insert into rooms(room_no, patient_id) values (3,null);
insert into rooms(room_no, patient_id) values (4,null);
insert into rooms(room_no, patient_id) values (5,null);
insert into rooms(room_no, patient_id) values (6,null);
insert into rooms(room_no, patient_id) values (7,null);
insert into rooms(room_no, patient_id) values (8,null);
insert into rooms(room_no, patient_id) values (9,null);
insert into rooms(room_no, patient_id) values (10,null);
insert into rooms(room_no, patient_id) values (11,null);
insert into rooms(room_no, patient_id) values (12,null);
insert into rooms(room_no, patient_id) values (13,null);
insert into rooms(room_no, patient_id) values (14,null);
insert into rooms(room_no, patient_id) values (15,null);
insert into rooms(room_no, patient_id) values (16,null);
insert into rooms(room_no, patient_id) values (17,null);
insert into rooms(room_no, patient_id) values (18,null);
insert into rooms(room_no, patient_id) values (19,null);
insert into rooms(room_no, patient_id) values (20,null);




