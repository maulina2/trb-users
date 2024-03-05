create table client (
                        birth_date date not null,
                        is_blocked boolean not null,
                        id uuid not null,
                        who_blocked_id uuid,
                        who_created_id uuid,
                        address varchar(255),
                        first_name varchar(255) not null,
                        last_name varchar(255) not null,
                        passport_number varchar(255) not null,
                        passport_series varchar(255),
                        patronymic varchar(255),
                        phone_number varchar(255) not null,
                        sex varchar(255) check (sex in ('MALE','FEMALE')),
                        primary key (id)
);

create table officer (
                         birth_date date not null,
                         is_blocked boolean not null,
                         id uuid not null,
                         who_blocked_id uuid,
                         who_created_id uuid,
                         address varchar(255) not null,
                         first_name varchar(255) not null,
                         last_name varchar(255) not null,
                         passport_number varchar(255) not null,
                         passport_series varchar(255),
                         patronymic varchar(255),
                         phone_number varchar(255) not null,
                         sex varchar(255) check (sex in ('MALE','FEMALE')),
                         primary key (id)
);