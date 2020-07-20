CREATE SCHEMA IF NOT EXISTS archivist;

GRANT USAGE ON SCHEMA archivist to archi;

-- ref_mo table

CREATE TABLE archivist.ref_mo (
    "oid" varchar(1000) NULL,
    "version" varchar(15) NULL,
    namefull varchar(500) NULL,
    nameshort varchar(255) NULL, 
    guid numeric NOT NULL, 
    is_shown bool NULL, 
    CONSTRAINT ref_mo_pkey PRIMARY KEY (guid),
    CONSTRAINT ref_mo_version_recid_key UNIQUE (version, oid)
);

-- Column comments

COMMENT ON COLUMN archivist.ref_mo."oid" IS 'фед.ОИД';
COMMENT ON COLUMN archivist.ref_mo."version" IS 'Версия';
COMMENT ON COLUMN archivist.ref_mo.namefull IS 'Полное наименование МО';
COMMENT ON COLUMN archivist.ref_mo.nameshort IS 'Короткое наименование МО';
COMMENT ON COLUMN archivist.ref_mo.guid IS 'Гуид';
COMMENT ON COLUMN archivist.ref_mo.is_shown IS 'Признак "Показывать в приложении"';

-- user_data table


create table archivist.user_data
(
    "userId"     varchar(15) not null,
    "cardNumber" varchar(15),
    "lastName"   varchar(50),
    "firstName"  varchar(50),
    "middleName" varchar(50),
    snils        varchar(11),
    enp          varchar(16),
    "birthDate"  date,
    "remdResult" varchar(50),
    "codeMo"     varchar(100)
);

-- Column comments

COMMENT ON COLUMN archivist.user_data."userId" IS 'id пользователя';
COMMENT ON COLUMN archivist.user_data."cardNumber" IS 'Номер карты';
COMMENT ON COLUMN archivist.user_data."lastName" IS 'Фамилия';
COMMENT ON COLUMN archivist.user_data."firstName" IS 'Имя';
COMMENT ON COLUMN archivist.user_data."middleName" IS 'Отчество';
COMMENT ON COLUMN archivist.user_data.snils IS 'Снилс"';
COMMENT ON COLUMN archivist.user_data."enp" IS 'Единый номер пациента';
COMMENT ON COLUMN archivist.user_data."birthDate" IS 'Дата рождения';
COMMENT ON COLUMN archivist.user_data."remdResult" IS 'РЭМД результаты';
COMMENT ON COLUMN archivist.user_data."codeMo" IS 'код Медицинской организации"';

alter table archivist.user_data
    owner to archi;

-- Permissions

GRANT SELECT ON ALL TABLES IN SCHEMA archivist TO archi;
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA archivist TO archi;