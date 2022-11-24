create table ATTACHMENTS
(
    PRODUCT_MODEL_ID    varchar(255) not null,
    TITLE               varchar(255),
    UPLOAD_DATE         date,
    EXTENSION           varchar(255),
    SIZE                bigint,
    DOWNLOAD_LINK       varchar(255),
    primary key (PRODUCT_MODEL_ID)
);