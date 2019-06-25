CREATE TABLESPACE RestTablespace DATAFILE 'C:\RestTablespace.DBF' SIZE 100M;
create user rest identified by rest
default tablespace RestTablespace
quota 100M on RestTablespace;
grant dba to rest;
create table persona (
per_id number,
per_nom varchar2(100),
per_ape varchar2(100),
per_edad number(2,0),
primary key (per_id));

CREATE SEQUENCE incremento_id_persona
INCREMENT BY 10
START WITH 10;

CREATE OR REPLACE TRIGGER TR_AUTO_INCREMENT
BEFORE INSERT
ON persona FOR EACH ROW
BEGIN
--SELECT incremento_id_persona.nextval INTO :NEW.per_id FROM dual; 
:NEW.per_id := incremento_id_persona.nextval;
END TR_AUTO_INCREMENT;

INSERT INTO persona values (null,'Andres','Zamora',21);
