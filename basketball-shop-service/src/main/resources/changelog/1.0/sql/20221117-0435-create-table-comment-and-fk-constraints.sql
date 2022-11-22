create table COMMENT
(
    ID              varchar(255) not null,
    PRODUCT_ID      varchar(255),
    MESSAGE         varchar(255),
    CREATE_TS       date,
    USER_ID         varchar(255),
    primary key (ID)
);

alter table COMMENT add constraint FK_COMMENT_PRODUCT foreign key (PRODUCT_ID) references PRODUCT(ID);
alter table COMMENT add constraint FK_COMMENT__USER foreign key (USER_ID) references _USER(ID);