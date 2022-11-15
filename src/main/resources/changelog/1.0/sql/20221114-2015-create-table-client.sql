create table CLIENT
(
    ID          varchar(255) not null,
    LOGIN       varchar(255),
    PASSWORD    varchar(255),
    EMAIL       varchar(255),
    NAME        varchar(255),
    ADMIN       boolean,
    primary key (ID)
);