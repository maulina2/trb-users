create table officer
(
    birth_date      date,
    is_blocked      boolean not null,
    id              uuid    not null,
    who_blocked_id  uuid,
    who_created_id  uuid,
    address         varchar(255),
    email           varchar(255),
    first_name      varchar(255),
    last_name       varchar(255),
    passport_number varchar(255),
    passport_series varchar(255),
    password        varchar(255),
    patronymic      varchar(255),
    phone_number    varchar(255),
    sex             varchar(255) check (sex in ('MALE', 'FEMALE')),
    primary key (id)
);


create table _user
(
    birth_date      date,
    is_blocked      boolean not null,
    is_client       boolean not null,
    is_officer      boolean not null,
    id              uuid    not null,
    who_blocked_id  uuid,
    who_created_id  uuid,
    address         varchar(255),
    email           varchar(255),
    first_name      varchar(255),
    last_name       varchar(255),
    passport_number varchar(255),
    passport_series varchar(255),
    password        varchar(255),
    patronymic      varchar(255),
    phone_number    varchar(255),
    sex             varchar(255) check (sex in ('MALE', 'FEMALE')),
    primary key (id)
)