create table PRODUCT
(
    ID             varchar(255) not null,
    COMPANY_ID     varchar(255),
    NAME_MODEL     varchar(255),
    NOVELTY        boolean,
    VENDOR_CODE    varchar(255),
    COLOR_ID       varchar(255),
    DESCRIPTION    varchar(255),
    SUB_SECTION_ID varchar(255),
    primary key (ID)
);

create table COMPANY
(
    ID       varchar(255) not null,
    NAME     varchar(255),
    primary key (id)
);

create table COLOR
(
    ID         varchar(255) not null,
    PRODUCT_ID varchar(255),
    NAME       varchar(255),
    CODE       varchar(255),
    primary key (id)
);

create table _SECTION
(
    ID       varchar(255) not null,
    NAME     varchar(255),
    primary key (id)
);

create table SUB_SECTION
(
    ID          varchar(255) not null,
    SECTION_ID  varchar(255) not null,
    NAME        varchar(255),
    primary key (id)
);