/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Rahul
 * Created: Apr 28, 2017
 */

create table users(id number(30) not null,user_id varchar2(50) not null, user_password varchar2(50) not null)
 
alter table users add (constraint id_pk primary key (id));

create sequence id_seq start with 1;

CREATE OR REPLACE TRIGGER user_bir 
BEFORE INSERT ON users 
FOR EACH ROW

BEGIN
  SELECT id_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;
/

--------------------------

--supported queries
-- drop table users
-- drop sequence test.id_seq

-------------
CREATE TABLE USERS 
  ( 
     USER_ID         VARCHAR2(20) NOT NULL ENABLE,
     USER_PASSWORD   VARCHAR2(50) NOT NULL ENABLE, 
     USER_FULL_NAME  VARCHAR2(50) NOT NULL ENABLE,
     USER_EMAIL_ADDR VARCHAR2(50), 
     USER_MOBILE     VARCHAR2(20), 
     CONSTRAINT xpkusers PRIMARY KEY (USER_ID) ENABLE 
  ) 

-- CREATE SEQUENCE id_seq 
--   START WITH 1; 
-- 
-- CREATE OR replace TRIGGER user_bir 
--   BEFORE INSERT ON USERS 
--   FOR EACH ROW 
-- BEGIN 
--     SELECT id_seq.NEXTVAL 
--     INTO   :new.id 
--     FROM   DUAL; 
-- END; 
-- 
-- / 