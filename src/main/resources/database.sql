CREATE TABLE CLIENTS (id         INT PRIMARY KEY NOT NULL,
                      FIRSTNAME  VARCHAR(50),
                      LASTNAME   VARCHAR(50),
                      PHONE      CHAR(12),
                      BIRTH      DATE,
                      EMAIL      VARCHAR(50),
                      USERNAME   VARCHAR(50)     NOT NULL,
                      PASSWORD   VARCHAR(50)     NOT NULL,
                      ID_CITY    INT,
                      ID_COUNTRY INT,
  FOREIGN KEY (ID_CITY) REFERENCES CITY (ID),
  FOREIGN KEY (ID_COUNTRY) REFERENCES COUNTRY (ID),
  FOREIGN KEY (ID_ROLE) REFERENCES ROLE (ID))

CREATE TABLE EMPLOYEES (id                 INT PRIMARY KEY NOT NULL,
                        FIRSTNAME          VARCHAR(50),
                        LASTNAME           VARCHAR(50),
                        BIRTH              DATE,
                        PHONE              CHAR(12),
                        ATTESTATION_NUMBER VARCHAR(50),
                        EMAIL              VARCHAR(50),
                        ID_ROLE            INT             NOT NULL,
                        ID_SEPARATION      INT,
                        USERNAME           VARCHAR(50)     NOT NULL,
                        PASSWORD           VARCHAR(50)     NOT NULL,

  FOREIGN KEY (ID_SEPARATION) REFERENCES SEPARATION (ID),
  FOREIGN KEY (ID_ROLE) REFERENCES ROLE (ID))

CREATE TABLE PRODUCT (ID    INT PRIMARY KEY NOT NULL,
                      NAME  VARCHAR(50)     NOT NULL,
                      MODEL VARCHAR(50)     NOT NULL,
                      MAKER VARCHAR(50)     NOT NULL,

)

CREATE TABLE COUNTRY (ID      INT PRIMARY KEY NOT NULL,
                      COUNTRY VARCHAR(255))


CREATE TABLE SEPARATION (ID         INT PRIMARY KEY NOT NULL,
                         SEPARATION VARCHAR(255))



