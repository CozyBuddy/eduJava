drop table Vote;
drop table Item ;

drop table Edit ;
drop table Administrator ;
drop table Member;
drop table Survey ;

CREATE TABLE Member (
    user_id VARCHAR2(100) NOT NULL,
    user_name VARCHAR2(100) NOT NULL,
    user_email_address VARCHAR2(100) NOT NULL,
    user_birthday DATE DEFAULT sysdate NOT NULL,
    user_nickname VARCHAR2(100) NOT NULL,
    user_password VARCHAR2(100) NOT NULL
);

COMMENT ON COLUMN Member.user_id IS '투표자를식별할ID';
COMMENT ON COLUMN Member.user_name IS '회원의 이름';
COMMENT ON COLUMN Member.user_email_address IS '회원의 이메일 주소';
COMMENT ON COLUMN Member.user_birthday IS '회원의 생년월일';
COMMENT ON COLUMN Member.user_nickname IS '회원의 닉네임';
COMMENT ON COLUMN Member.user_password IS '회원의 비밀번호';

CREATE TABLE Vote (
    user_id VARCHAR2(100) NOT NULL,
    SURVEY_NUM NUMBER NOT NULL,
    COL_NUMBER NUMBER(1) NOT NULL,
    CHOICE_NUM NUMBER(1) DEFAULT 1 NOT NULL
);

CREATE TABLE Survey (
    SURVEY_NUM NUMBER NOT NULL,
    COL_NUMBER NUMBER(1) NOT NULL,
    TITLE VARCHAR2(50 CHAR) NOT NULL,
    START_DATE date DEFAULT SYSDATE NOT NULL,
    END_DATE date DEFAULT SYSDATE + 7 NOT NULL,
    WRITE_DATE timestamp DEFAULT SYSDATE NOT NULL
);

CREATE TABLE Edit (
    SURVERY_NUM NUMBER NOT NULL,
    admin_id VARCHAR2(100) NOT NULL,
    COL_NUMBER NUMBER(1) NOT NULL
);

CREATE TABLE Administrator (
    admin_id VARCHAR2(100) NOT NULL,
    name VARCHAR2(100) NOT NULL,
    emailAddress VARCHAR2(100) NOT NULL,
    birthdate DATE DEFAULT sysdate NOT NULL,
    nickname VARCHAR2(80) NOT NULL,
    password VARCHAR2(100) NOT NULL
);

CREATE TABLE Item (
    CHO_NUM VARCHAR2(100) NOT NULL,
    SURVEY_NUM NUMBER NOT NULL,
    COL_NUMBER NUMBER(1) NOT NULL,
    CHOICE1 VARCHAR2(100) NOT NULL
);

ALTER TABLE Member ADD CONSTRAINT PK_MEMBER PRIMARY KEY (user_id);
ALTER TABLE Vote ADD CONSTRAINT PK_VOTE PRIMARY KEY (user_id, SURVEY_NUM, COL_NUMBER);
ALTER TABLE Survey ADD CONSTRAINT PK_SURVEY PRIMARY KEY (SURVEY_NUM, COL_NUMBER);
ALTER TABLE Edit ADD CONSTRAINT PK_EDIT PRIMARY KEY (SURVERY_NUM, admin_id, COL_NUMBER);
ALTER TABLE Administrator ADD CONSTRAINT PK_ADMINISTRATOR PRIMARY KEY (admin_id);
ALTER TABLE Item ADD CONSTRAINT PK_ITEM PRIMARY KEY (CHO_NUM, SURVEY_NUM, COL_NUMBER);

ALTER TABLE Vote ADD CONSTRAINT FK_Member_TO_Vote_1 FOREIGN KEY (user_id) REFERENCES Member (user_id);
ALTER TABLE Vote ADD CONSTRAINT FK_Survey_TO_Vote_1 FOREIGN KEY (SURVEY_NUM,COL_NUMBER) REFERENCES Survey (SURVEY_NUM,COL_NUMBER);
--ALTER TABLE Vote ADD CONSTRAINT FK_Survey_TO_Vote_2 FOREIGN KEY (COL_NUMBER) REFERENCES Survey (COL_NUMBER);
ALTER TABLE Edit ADD CONSTRAINT FK_Survey_TO_Edit_1 FOREIGN KEY (SURVERY_NUM,COL_NUMBER) REFERENCES Survey (SURVEY_NUM,COL_NUMBER);
--ALTER TABLE Edit ADD CONSTRAINT FK_Survey_TO_Edit_2 FOREIGN KEY (SURVEY_NUM,COL_NUMBER) REFERENCES Survey (SURVEY_NUM,COL_NUMBER);
ALTER TABLE Edit ADD CONSTRAINT FK_Administrator_TO_Edit_1 FOREIGN KEY (admin_id) REFERENCES Administrator (admin_id);
ALTER TABLE Item ADD CONSTRAINT FK_Survey_TO_Item_1 FOREIGN KEY (SURVEY_NUM,COL_NUMBER) REFERENCES Survey (SURVEY_NUM,COL_NUMBER);
--ALTER TABLE Item ADD CONSTRAINT FK_Survey_TO_Item_2 FOREIGN KEY (COL_NUMBER) REFERENCES Survey (COL_NUMBER);







alter table Administrator add constraint idconstr check(admin_id like '#%');
alter table Administrator add constraint emailunique unique(emailAddress);
alter table Administrator add constraint nicunique unique(nickname);

insert into administrator values ( '#1234','김진영','kimjinyoung@naver.com',to_date('1993/11/1'),'DEX','12341234');
insert into administrator values ( '#0000','김진영2','kimjinyoung2@naver.com',to_date('1993/11/30'),'DEX2','12341234');
insert into administrator values ( '#12345','김진영3','kimjinyoung3@naver.com',to_date('1993/11/11'),'DEX3','12341234');

--명건
ALTER TABLE Member 
ADD CONSTRAINT chk_email_format 
CHECK (REGEXP_LIKE(user_email_address, '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$'));
--이메일 형식 제약
ALTER TABLE Member 
ADD CONSTRAINT chk_id_format 
CHECK (REGEXP_LIKE(user_id, '^[a-zA-Z0-9_-]{1,20}$'));
--아이디 형식 제약

ALTER TABLE Member 
ADD CONSTRAINT chk_password_format 
CHECK (REGEXP_LIKE(user_password, '^[a-zA-Z0-9!@#$%^&*()_+-=;:{}|`~<>,.?/]{8,20}$'));

INSERT INTO Member VALUES ('kang0821', '강명건', 'aaa123@aaa.com', TO_DATE('1993-08-21', 'YYYY-MM-DD'), '이상해씨', 'aaaa1234!');
INSERT INTO Member VALUES ('pokemonmaster1', '한지우', 'gonnabe@poke.com', TO_DATE('1988-01-29', 'YYYY-MM-DD'), '꼬부기', 'bbbb4567@');
INSERT INTO Member VALUES ('water02', '이슬이', 'swimisgood@poke.com', TO_DATE('1999-09-23', 'YYYY-MM-DD'), '파이리', 'CcAa7896%$');
INSERT INTO Member VALUES ('rock55', '웅이', 'ilovewomen@poke.com', TO_DATE('1994-07-09', 'YYYY-MM-DD'), '피카츄', 'Whdkdy19684$%@');
INSERT INTO Member VALUES ('purple66', '로이', 'qqq444@rocket.com', TO_DATE('1981-05-19', 'YYYY-MM-DD'), '버터플', 'eocndgo@@1234');

--
--시은--영은
ALTER TABLE Survey ADD CONSTRAINT CK_Survey_TO_Survey_Num CHECK(survey_num >=1);
ALTER TABLE Survey ADD CONSTRAINT CK_Survey_TO_Col_Number CHECK(col_number >=2);
ALTER TABLE Survey ADD CONSTRAINT CK_Survey_TO_Start_Date CHECK(start_date <= end_date);
ALTER TABLE Survey ADD CONSTRAINT CK_Survey_TO_Wirte_Date CHECK(write_date <= start_date);

--작성 기능
INSERT INTO Survey VALUES ( 1,5,'좋아하는 동물', TO_DATE( '2023' || '08' || '19','yyyymmdd' ),TO_DATE( '2023' || '08' || '23','yyyymmdd' ),to_date('2023-08-18 11:11:24','YYYY-mm-dd hh24":"mi":"ss'));
INSERT INTO Item VALUES (1,1,5,'강아지');
INSERT INTO Item VALUES (2,1,5,'고양이');
INSERT INTO Item VALUES (3,1,5,'햄스터');
INSERT INTO Item VALUES (4,1,5,'쿼카');
INSERT INTO Item VALUES (5,1,5,'판다');

INSERT INTO Survey VALUES ( 2,5,'출생년도 고르기',TO_DATE( '2023' || '10' || '10','yyyymmdd' ),TO_DATE( '2023' || '10' || '21','yyyymmdd' ),to_date('2023-10-9 16:33:24','YYYY-mm-dd hh24":"mi":"ss'));
INSERT INTO Item VALUES (1,2,5,'1970년대');
INSERT INTO Item VALUES (2,2,5,'1980년대');
INSERT INTO Item VALUES (3,2,5,'1990년대');
INSERT INTO Item VALUES (4,2,5,'2000년대');
INSERT INTO Item VALUES (5,2,5,'2010년대');

INSERT INTO Survey VALUES ( 3,2,'성별고르기', TO_DATE( '2023' || '10' || '11','yyyymmdd' ), TO_DATE( '2023' || '10' || '13','yyyymmdd' ),to_date('2023-10-10 23:55:24','YYYY-mm-dd hh24":"mi":"ss'));
INSERT INTO Item VALUES (1,3,2,'여자');
INSERT INTO Item VALUES (2,3,2,'남자');

INSERT INTO Survey VALUES ( 4,4,'살고싶은 주거환경', TO_DATE( '2024' || '01' || '30','yyyymmdd' ),TO_DATE( '2024' || '03' || '15','yyyymmdd' ),to_date('2024-1-29 23:12:24','YYYY-mm-dd hh24":"mi":"ss'));
INSERT INTO Item VALUES (1,4,4,'단독주택');
INSERT INTO Item VALUES (2,4,4,'아파트');
INSERT INTO Item VALUES (3,4,4,'빌라');
INSERT INTO Item VALUES (4,4,4,'기숙사');


INSERT INTO Survey VALUES ( 5,4,'직업고르기', TO_DATE( '2024' || '02' || '28','yyyymmdd' ),TO_DATE( '2024' || '03' || '07','yyyymmdd' ),to_date('2024-02-27 10:25:56','YYYY-mm-dd hh24":"mi":"ss'));
INSERT INTO Item VALUES (1,5,4,'회사원');
INSERT INTO Item VALUES (2,5,4,'사업가');
INSERT INTO Item VALUES (3,5,4,'공무원');
INSERT INTO Item VALUES (4,5,4,'학생');

--

--vote 동찬
INSERT INTO VOTE VALUES ('kang0821', 1, 5,1);
INSERT INTO VOTE VALUES ('water02', 1,5, 1);
INSERT INTO VOTE VALUES ('rock55', 1, 5,2);
INSERT INTO VOTE VALUES ('purple66', 1,5, 1);
INSERT INTO VOTE VALUES ('pokemonmaster1', 1,5, 2);

INSERT INTO VOTE VALUES ('kang0821', 2, 5,3);
INSERT INTO VOTE VALUES ('water02', 2,5, 1);
INSERT INTO VOTE VALUES ('rock55', 2,5, 2);
INSERT INTO VOTE VALUES ('purple66', 2,5, 1);

INSERT INTO VOTE VALUES ('kang0821', 3,2,2);
INSERT INTO VOTE VALUES ('water02', 3, 2,1);
INSERT INTO VOTE VALUES ('rock55', 3,2, 2);
INSERT INTO VOTE VALUES ('purple66', 3,2, 2);
INSERT INTO VOTE VALUES ('pokemonmaster1', 3,2, 2);

INSERT INTO VOTE VALUES ('water02', 4, 4,4);
INSERT INTO VOTE VALUES ('rock55', 4,4, 4);
INSERT INTO VOTE VALUES ('purple66', 4,4, 3);
INSERT INTO VOTE VALUES ('pokemonmaster1', 4,4, 1);

INSERT INTO VOTE VALUES ('kang0821', 5,4, 1);
INSERT INTO VOTE VALUES ('rock55', 5,4, 4);
INSERT INTO VOTE VALUES ('purple66', 5,4, 1);

-- 총투표자수
select count(a.survey_num) 총투표자수
from (select v.survey_num,v.col_number,choice_num from vote v,survey s where v.survey_num=s.survey_num and v.col_number=s.col_number) a
where a.survey_num=3;

--투표결과
select a.choice_num 번호,count(a.choice_num) 투표자수
from (select v.survey_num,v.col_number,i.choice1,choice_num from vote v,survey s,item i where v.survey_num=s.survey_num and v.col_number=s.col_number and i.survey_num = s.survey_num and i.col_number = v.col_number order by survey_num ) a
where a.survey_num=1
group by a.choice_num
order by a.choice_num;

select b.choice1 ,count(b.choice_num)
from (select i.choice1 ,a.survey_num ,a.col_number,nvl(a.choice_num,0) choice_num , a.user_id
from (select v.survey_num,v.col_number, choice_num, v.user_id  from vote v ,item  i where v.survey_num=i.survey_num and v.col_number=i.col_number and v.choice_num=i.cho_num group by v.survey_num,v.col_number, choice_num, v.user_id order by survey_num) a right join item i 
on i.survey_num=a.survey_num and i.col_number=a.col_number and a.choice_num = i.cho_num ) b
where b.survey_num=1 and col_number=5
group by b.choice1;




SELECT LPAD(' ', count(*)+1, '#')  
FROM VOTE
WHERE survey_num=1 
group by choice_num ;




select * from vote;
select * from item;







select * from administrator;
select * from survey;








