--liquibase formatted sql
--changeset fxboot_demo:20160927_2334

CREATE TABLE USERS (
	ID           BIGINT    (10) AUTO_INCREMENT,
	NAME         NVARCHAR2 (50),
	MERIT        NVARCHAR2 (50),
	ORGANIZATION NVARCHAR2 (50),
	PRIMARY KEY (ID)
);


INSERT INTO USERS (ID, NAME, MERIT, ORGANIZATION) VALUES (1,'James Gosling', 'Father of Java', 'Liquid Robotics');
INSERT INTO USERS (ID, NAME, MERIT, ORGANIZATION) VALUES (2,'Joshua Bloch', 'Collections Framework', 'Institute for Software Research');
INSERT INTO USERS (ID, NAME, MERIT, ORGANIZATION) VALUES (3,'Doug Lea', 'Concurrency', 'State University of New York at Oswego');
