alter table PRODUCT drop constraint FK_PRODUCT_COLOR;
alter table COLOR drop constraint FK_COLOR_PRODUCT;
alter table PRODUCT rename column COLOR_ID to PRODUCT_MODEL_ID;
alter table COLOR rename to PRODUCT_MODEL;