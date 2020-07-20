CREATE SCHEMA IF NOT EXISTS archivist;
GRANT USAGE ON SCHEMA archivist to archi;

-- user_data table

create table archivist.user_data
(
    "userId"     varchar(15) not null,
    "cardNumber" varchar(15),
    "lastName"   varchar(50),
    "firstName"  varchar(50),
    "middleName" varchar(50),
    snils        varchar(11) not null
        constraint user_data_pk
            primary key,
    enp          varchar(16),
    "birthDate"  date,
    "remdResult" varchar(50),
    "codeMo"     varchar(100)
);

--column comment

comment on column archivist.user_data."userId" is 'id пользователя';
comment on column archivist.user_data."cardNumber" is 'Номер карты';
comment on column archivist.user_data."lastName" is 'Фамилия';
comment on column archivist.user_data."firstName" is 'Имя';
comment on column archivist.user_data."middleName" is 'Отчество';
comment on column archivist.user_data.snils is 'Снилс"';
comment on column archivist.user_data.enp is 'Единый номер полиса';
comment on column archivist.user_data."birthDate" is 'Дата рождения';
comment on column archivist.user_data."remdResult" is 'РЭМД результаты';
comment on column archivist.user_data."codeMo" is 'код Медицинской организации"';

alter table archivist.user_data
    owner to archi;
