CREATE TABLE user_tbl (
	id number(10) primary key,
	name varchar(100) not null,
	email varchar(100) not null,
	picture varchar(200) not null,
	role varchar(20),
	created_date date,
	modified_date date
);

CREATE SEQUENCE BOARD_SEQ 
START WITH 1 
INCREMENT BY 1;

-- https://github.com/spring-projects/spring-session/blob/main/spring-session-jdbc/src/main/resources/org/springframework/session/jdbc/schema-oracle.sql

|-------------------------------------|-------------------------------------|--------------|-----------------|----------------------|------------------------|----------------|
|primary_id                        |session_id                         |creation_time |last_access_time |max_inactive_interval |attribute_name          |attribute_bytes |
|-------------------------------------|-------------------------------------|--------------|-----------------|----------------------|------------------------|----------------|
|3be84f95-ef92-4838-9d1b-e606fb5006ce |b38bcf0a-74c3-4734-b3f5-09bfc4f7fd10 |1622182415733 |1622182416733    |1800                  |user                    |[unread]        |
|[unread]                             |b38bcf0a-74c3-4734-b3f5-09bfc4f7fd10 |[unread]      |[unread]         |[unread]              |SPRING_SECURITY_CONTEXT |[unread]        |
|-------------------------------------|-------------------------------------|--------------|-----------------|----------------------|------------------------|----------------|

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


CREATE TABLE SPRING_SESSION (
	PRIMARY_ID CHAR(36) NOT NULL,
	SESSION_ID CHAR(36) NOT NULL,
	CREATION_TIME NUMBER(19,0) NOT NULL,
	LAST_ACCESS_TIME NUMBER(19,0) NOT NULL,
	MAX_INACTIVE_INTERVAL NUMBER(10,0) NOT NULL,
	EXPIRY_TIME NUMBER(19,0) NOT NULL,
	PRINCIPAL_NAME VARCHAR2(100 CHAR),
	CONSTRAINT SPRING_SESSION_PK PRIMARY KEY (PRIMARY_ID)
);

CREATE UNIQUE INDEX SPRING_SESSION_IX1 ON SPRING_SESSION (SESSION_ID);
CREATE INDEX SPRING_SESSION_IX2 ON SPRING_SESSION (EXPIRY_TIME);
CREATE INDEX SPRING_SESSION_IX3 ON SPRING_SESSION (PRINCIPAL_NAME);

CREATE TABLE SPRING_SESSION_ATTRIBUTES (
	SESSION_PRIMARY_ID CHAR(36) NOT NULL,
	ATTRIBUTE_NAME VARCHAR2(200 CHAR) NOT NULL,
	ATTRIBUTE_BYTES BLOB NOT NULL,
	CONSTRAINT SPRING_SESSION_ATTRIBUTES_PK PRIMARY KEY (SESSION_PRIMARY_ID, ATTRIBUTE_NAME),
	CONSTRAINT SPRING_SESSION_ATTRIBUTES_FK FOREIGN KEY (SESSION_PRIMARY_ID) REFERENCES SPRING_SESSION(PRIMARY_ID) ON DELETE CASCADE
);