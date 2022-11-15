create table REMAINDER_PRODUCT
(
    ID                  varchar(255) not null,
    PRODUCT_MODEL_ID    varchar(255),
    SIZE_ID             varchar(255),
    REMAINDER           varchar(255),
    primary key (ID)
);

alter table PRODUCT add constraint FK_PRODUCT_PRODUCT_MODEL foreign key (PRODUCT_MODEL_ID) references PRODUCT_MODEL(ID);
alter table PRODUCT_MODEL add constraint FK_PRODUCT_MODEL_PRODUCT foreign key (PRODUCT_ID) references PRODUCT(ID);

alter table REMAINDER_PRODUCT add constraint FK_REMAINDER_PRODUCT_PRODUCT_MODEL foreign key (PRODUCT_MODEL_ID) references PRODUCT_MODEL(ID);
alter table REMAINDER_PRODUCT add constraint FK_REMAINDER_PRODUCT_SIZE foreign key (SIZE_ID) references SIZE(ID);