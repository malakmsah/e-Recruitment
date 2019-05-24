create table INTEREST
(
    ID      NUMBER(10)   not null
        constraint IPK
            primary key,
    NAME_AR VARCHAR2(50) not null,
    NAME_EN VARCHAR2(50) not null
)
/

create table RECRUITER
(
    ID                  NUMBER(10)    not null
        constraint RPK
            primary key,
    NAME_AR             VARCHAR2(255),
    NAME_EN             VARCHAR2(255),
    USERNAME            VARCHAR2(255) not null,
    PASSWORD            VARCHAR2(255) not null,
    PHONE               NUMBER(10),
    EMAIL               VARCHAR2(255),
    ABOUT               VARCHAR2(500),
    NUMBER_OF_EMPLOYEES NUMBER(10),
    FOUNDED_AT          DATE,
    CREATED_AT          TIMESTAMP(6) default CURRENT_TIMESTAMP
)
/

create table JOB_SEEKER
(
    ID             NUMBER(10)    not null
        constraint JSPK
            primary key,
    FIRST_NAME     VARCHAR2(255),
    LAST_NAME      VARCHAR2(255),
    USERNAME       VARCHAR2(255) not null,
    PASSWORD       VARCHAR2(255) not null,
    PHONE          NUMBER(10),
    EMAIL          VARCHAR2(255) not null,
    BIRTH_DATE     DATE,
    GENDER         NUMBER(1),
    CREATED_AT     TIMESTAMP(6) default CURRENT_TIMESTAMP,
    IS_DEACTIVATED NUMBER(1)
)
/

create table EXPERIENCE
(
    ID          NUMBER(10) not null
        constraint EXPK
            primary key,
    POSITION    VARCHAR2(255),
    COMPANY     VARCHAR2(255),
    DESCRIPTION VARCHAR2(500),
    START_DATE  DATE,
    END_DATE    DATE,
    CREATED_AT  TIMESTAMP(6) default CURRENT_TIMESTAMP
)
/

create table COUNTRY
(
    ID      NUMBER(10) not null
        constraint COPK
            primary key,
    NAME_AR VARCHAR2(255),
    NAME_EN VARCHAR2(255)
)
/

create table CITY
(
    ID      NUMBER(10) not null
        constraint CPK
            primary key,
    NAME_AR VARCHAR2(255),
    NAME_EN VARCHAR2(255)
)
/

create table VACANCY
(
    ID          NUMBER(10) not null
        constraint VPK
            primary key,
    POSITION    VARCHAR2(255),
    DESCRIPTION VARCHAR2(500),
    CREATED_AT  TIMESTAMP(6) default CURRENT_TIMESTAMP
)
/

create table DEGREE_TYPES
(
    ID      NUMBER(10) not null
        constraint DPK
            primary key,
    NAME_AR VARCHAR2(255),
    NAME_EN VARCHAR2(255)
)
/

create table EDUCATION
(
    ID          NUMBER(10) not null
        constraint EPK
            primary key,
    INSTITUTION VARCHAR2(255),
    MAJOR       VARCHAR2(255),
    START_DATE  DATE,
    END_DATE    DATE,
    CREATED_AT  TIMESTAMP(6) default CURRENT_TIMESTAMP,
    GPA         NUMBER(10, 2)
)
/

create table VACANCY_APPLICANTS
(
    VACANCY_ID NUMBER(10) not null
        constraint JS_VAC_ID
            references VACANCY,
    JS_ID      NUMBER(10) not null
        constraint VAC_JS_ID
            references JOB_SEEKER,
    CREATED_AT TIMESTAMP(6) default CURRENT_TIMESTAMP,
    constraint VAPK
        primary key (VACANCY_ID, JS_ID)
)
/

create table RECRUITER_VACANCY
(
    VACANCY_ID   NUMBER(10) not null
        constraint REC_VAC_ID
            references VACANCY,
    RECRUITER_ID NUMBER(10) not null
        constraint VAR_REC_ID
            references RECRUITER,
    constraint RVPK
        primary key (VACANCY_ID, RECRUITER_ID)
)
/

create table JS_ADDRESS
(
    JS_ID      NUMBER(10) not null
        constraint ADRS_JS_ID
            references JOB_SEEKER,
    COUNTRY_ID NUMBER(10) not null
        constraint JS_COUNTRY_ID
            references COUNTRY,
    CITY_ID    NUMBER(10) not null
        constraint JS_CITY_ID
            references CITY,
    constraint JSAPK
        primary key (JS_ID, COUNTRY_ID, CITY_ID)
)
/

create table RECRUITER_ADDRESS
(
    RECRUITER_ID            NUMBER(10) not null
        constraint ADRS_REC_ID
            references RECRUITER,
    COUNTRY_ID              NUMBER(10) not null
        constraint REC_CON_ID
            references COUNTRY,
    CITY_ID                 NUMBER(10) not null
        constraint REC_CITY_ID
            references CITY,
    NEIGHBOURHOOD           VARCHAR2(255),
    STREET                  VARCHAR2(255),
    BUILDING_OFFICE_DETAILS VARCHAR2(500),
    CREATED_AT              TIMESTAMP(6) default CURRENT_TIMESTAMP,
    constraint RAPK
        primary key (RECRUITER_ID, COUNTRY_ID, CITY_ID)
)
/

create table RECRUITER_INTEREST
(
    RECRUITER_ID NUMBER(10) not null
        constraint INT_REC_ID
            references RECRUITER,
    INTEREST_ID  NUMBER(10) not null
        constraint REC_INT_ID
            references INTEREST,
    constraint RIPK
        primary key (RECRUITER_ID, INTEREST_ID)
)
/

create table EDUCATION_DEGREE
(
    EDUCATION_ID NUMBER(10) not null
        constraint DEG_EDU_ID
            references EDUCATION,
    DEGREE_ID    NUMBER(10) not null
        constraint EDU_DEG_ID
            references DEGREE_TYPES,
    constraint PK
        primary key (EDUCATION_ID, DEGREE_ID)
)
/

create table JS_EDUCATION
(
    JS_ID        NUMBER(10) not null
        constraint EDU_JS_ID
            references JOB_SEEKER,
    EDUCATION_ID NUMBER(10) not null
        constraint JS_EDU_ID
            references EDUCATION,
    constraint JSEPK
        primary key (JS_ID, EDUCATION_ID)
)
/

create table JS_INTEREST
(
    JS_ID       NUMBER(10) not null
        constraint INT_JS_ID
            references JOB_SEEKER,
    INTEREST_ID NUMBER(10) not null
        constraint JS_INT_ID
            references INTEREST,
    constraint JSIPK
        primary key (JS_ID, INTEREST_ID)
)
/

create table JS_EXPERIENCE
(
    JS_ID         NUMBER(10) not null
        constraint EXP_JS_ID
            references JOB_SEEKER,
    EXPERIENCE_ID NUMBER(10) not null
        constraint JS_EXP_ID
            references EXPERIENCE
)
/


