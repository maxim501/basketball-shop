alter table PRODUCT add constraint FK_PRODUCT_COMPANY foreign key (COMPANY_ID) references COMPANY(ID);
alter table PRODUCT add constraint FK_PRODUCT_COLOR foreign key (COLOR_ID) references COLOR(ID);
alter table PRODUCT add constraint FK_PRODUCT_SUB_SECTION foreign key (SUB_SECTION_ID) references SUB_SECTION(ID);

alter table COLOR add constraint FK_COLOR_PRODUCT foreign key (PRODUCT_ID) references PRODUCT(ID);

alter table SUB_SECTION add constraint FK_SUB_SECTION_SECTION foreign key (SECTION_ID) references _SECTION(ID);