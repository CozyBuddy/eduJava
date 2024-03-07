-- 참조 관계가 있는 테이블 삭제
ALTER TABLE payrefund DROP CONSTRAINT FK_Scplane_TO_payrefund_1;
ALTER TABLE Scplane DROP CONSTRAINT FK_airplane_TO_Scplane_1;
ALTER TABLE SEAT_NUM DROP CONSTRAINT FK_airplane_TO_SEAT_NUM_1;
ALTER TABLE payrefund DROP CONSTRAINT FK_flightuser_TO_payrefund_1;
ALTER TABLE yesno DROP CONSTRAINT FK_Contract_TO_yesno_1;
ALTER TABLE Ifare DROP CONSTRAINT FK_Adminstrator_TO_Ifare_1;
ALTER TABLE Mtracking DROP CONSTRAINT FK_flightuser_TO_Mtracking_1;
ALTER TABLE dfare DROP CONSTRAINT FK_Adminstrator_TO_dfare_1;
ALTER TABLE L_rule DROP CONSTRAINT FK_R_section_TO_L_rule_1;
ALTER TABLE Notice DROP CONSTRAINT FK_Adminstrator_TO_Notice_1;
ALTER TABLE Rfamily DROP CONSTRAINT FK_flightuser_TO_Rfamily_1;
ALTER TABLE Cservice DROP CONSTRAINT FK_Adminstrator_TO_Cservice_1;

-- 참조 관계가 없는 테이블 삭제
DROP TABLE CARD_USE;
DROP TABLE GIFTCARD;
DROP TABLE Contract;
DROP TABLE Event;
DROP TABLE Winner;
DROP TABLE Prize;
DROP TABLE Adminstrator;
DROP TABLE Userdetail;
DROP TABLE S_Grade;
DROP TABLE Movie;
DROP TABLE TV;
DROP TABLE Music;
DROP TABLE Bpass;
DROP TABLE flight_meal;
DROP TABLE Scplane;
DROP TABLE SEAT_NUM;
DROP TABLE payrefund;
DROP TABLE Ifare;
DROP TABLE yesno;
DROP TABLE Customerc;
DROP TABLE dfare;
DROP TABLE LOUNGE_INFO;
DROP TABLE L_rule;
DROP TABLE R_section;
DROP TABLE Notice;
DROP TABLE Rfamily;
DROP TABLE Cservice;
DROP TABLE airplane;
DROP TABLE Mtracking;
DROP TABLE flightuser;

CREATE TABLE flightuser (
    UserID varchar2(100) NOT NULL,
    Korlastname varchar2(20) NOT NULL,
    Korfirstname varchar2(100) NOT NULL,
    lastname varchar2(100) NOT NULL,
    firstname varchar2(100) NOT NULL,
    password varchar2(200) NOT NULL,
    birthdate date NOT NULL,
    gender varchar2(6) NOT NULL,
    emailaddress varchar2(200) NOT NULL,
    phoneNumber varchar2(200) NOT NULL,
    Anation varchar2(200) NOT NULL,
    Skypassnumber varchar2(200) NOT NULL
);

CREATE TABLE Cservice (
    CS_num VARCHAR2(4) NOT NULL,
    Area VARCHAR2(30) NOT NULL,
    Country_name VARCHAR2(30) NOT NULL,
    CS_call1 VARCHAR2(50) NOT NULL,
    CS_call2 VARCHAR2(50) NULL,
    lang_time clob NOT NULL,
    AdminID varchar2(100) NOT NULL
);

CREATE TABLE Rfamily (
    keynum VARCHAR(50) NOT NULL,
    relation VARCHAR2(20) NOT NULL,
    status VARCHAR2(10) NULL,
    request_date DATE DEFAULT SYSDATE NOT NULL,
    family_id VARCHAR2(100) NOT NULL,
    UserID varchar2(100) NOT NULL
);

CREATE TABLE Notice (
    Notice_num VARCHAR2(3) NOT NULL,
    Notice_title VARCHAR2(200) NOT NULL,
    Notice_contents clob NOT NULL,
    Notice_topic VARCHAR2(20) NOT NULL,
    AdminID varchar2(100) NOT NULL
);

CREATE TABLE R_section (
    ROUTE_SECTION VARCHAR2(50) NOT NULL,
    dairport VARCHAR2(1000) NOT NULL,
    aairport varchar2(1000) NOT NULL
);

CREATE TABLE L_rule (
    LUGREGULAR_NUM NUMBER(2) NOT NULL,
    SEAT_GRADE VARCHAR2(15) NOT NULL,
    numberofluggage NUMBER(2) NOT NULL,
    EXCESS_FEE NUMBER(8) NOT NULL,
    ROUTE_SECTION VARCHAR2(50) NOT NULL
);

CREATE TABLE LOUNGE_INFO (
    LOUNGE_NUM VARCHAR2(10) NOT NULL,
    LOUNGE_NAME VARCHAR2(100) NULL,
    DESTINATION_AIRPORT VARCHAR2(50) NOT NULL,
    COUNTRY VARCHAR2(40) NOT NULL,
    LOCATION VARCHAR2(1000) NOT NULL,
    OPERATING_TIME clob NOT NULL,
    OPERATOR VARCHAR2(10) NOT NULL,
    ENTRY_PASSENGER clob NOT NULL,
    SERVICE VARCHAR2(500) NOT NULL,
    ETC VARCHAR2(300) NULL
);

CREATE TABLE dfare (
    Keynum number(4) NOT NULL,
    peak varchar2(100) NOT NULL,
    discount varchar2(100) NOT NULL,
    timezone varchar2(100) NOT NULL,
    sg varchar2(50) NOT NULL,
    route varchar2(200) NOT NULL,
    fare number NOT NULL,
    redis number NOT NULL,
    AdminID varchar2(100) NOT NULL
);

CREATE TABLE airplane (
    asnum varchar2(100) NOT NULL,
    AIRLINE VARCHAR(30) NULL,
    totalseat NUMBER(4) NOT NULL,
    TYPE VARCHAR(30) NULL,
    M_DATE DATE NULL,
    FCLA_COUNT NUMBER(3) NULL,
    PreCLA_COUNT NUMBER(3) NULL,
    NCLA_COUNT NUMBER(3) NULL,
    PRECLA_Features VARCHAR2(300) NULL,
    NCLA_Features VARCHAR2(300) NULL
);

CREATE TABLE Mtracking (
    Tracking_num NUMBER NOT NULL,
    Consumtion_date DATE DEFAULT SYSDATE NOT NULL,
    Amount_Mileage NUMBER NOT NULL,
    airline_type VARCHAR2(50) NOT NULL,
    spendorearned VARCHAR2(10) NOT NULL,
    UserID varchar2(100) NOT NULL
);

CREATE TABLE payrefund (
    SerialNumber number NOT NULL,
    payrefund varchar2(50) NOT NULL,
    pmethod varchar2(70) DEFAULT '카드' NOT NULL,
    flight varchar2(50) DEFAULT '정상' NOT NULL,
    seatNumber varchar2(50) NULL,
    drdate date default sysdate NOT NULL,
    nluggage number(2) DEFAULT 0 NULL,
    cost number NOT NULL,
    mileage number NOT NULL,
    UserID varchar2(100) NOT NULL,
    renum varchar2(10 char) NOT NULL
);

CREATE TABLE SEAT_NUM (
    SEAT_CODE VARCHAR2(20) NOT NULL,
    SEAT_NUM VARCHAR2(5) NOT NULL,
    SEAT_GRADE VARCHAR2(15) NULL,
    asnum varchar2(100) NOT NULL
);

CREATE TABLE Scplane (
    renum varchar2(10 char) NOT NULL,
    food varchar2(100) DEFAULT '(기내식 제공없음)' NULL,
    adate date NOT NULL,
    ddate date NOT NULL,
    dnation varchar2(100) NOT NULL,
    anation varchar2(100) NOT NULL,
    AdminID varchar2(100) NOT NULL,
    price number NOT NULL,
    fnumber varchar2(100) NOT NULL,
    aairport varchar2(100) NOT NULL,
    dairport varchar2(100) NOT NULL,
    GATE number(4) NULL,
    Terminal number(2) NOT NULL,
    asnum varchar2(100) NOT NULL
);

COMMENT ON COLUMN Scplane.dnation IS '한국고정';

COMMENT ON COLUMN Scplane.anation IS '한국,일본,중국,미국';

CREATE TABLE Bpass (
    Key VARCHAR2(10) NOT NULL,
    dairport varchar2(100) NOT NULL,
    aairport varchar2(100) NOT NULL,
    ddate date NOT NULL,
    SEAT_NUM VARCHAR2(5) NOT NULL,
    PNAME VARCHAR2(200) NOT NULL,
    GATE NUMBER(4) NULL,
    TERMINAL NUMBER(2) NOT NULL,
    UserID varchar2(100) NOT NULL
);

CREATE TABLE flight_meal (
    mael_code NUMBER(2) NOT NULL,
    menu VARCHAR2(300) NULL,
    MENU_PDF BLOB NULL
);

CREATE TABLE Customerc (
    Q_num NUMBER NOT NULL,
    type VARCHAR2(12) NOT NULL,
    Field VARCHAR2(60) NOT NULL,
    F_NAME VARCHAR2(20) NOT NULL,
    L_NAME VARCHAR2(20) NOT NULL,
    P_NUM VARCHAR2(20) DEFAULT '(82)' NOT NULL,
    Email VARCHAR2(40) NOT NULL,
    title VARCHAR2(100) NOT NULL,
    content clob NOT NULL,
    SP_NUM NUMBER(20) NULL,
    renum VARCHAR2(8) NULL,
    e_check NUMBER(1) NOT NULL,
    city_arr VARCHAR2(40) NULL,
    start_city VARCHAR2(40) NULL,
    arr_date DATE NULL,
    Flights VARCHAR2(6) NULL
);

CREATE TABLE yesno (
    Contrat_num varchar2(4) NOT NULL,
    agree varchar2(100) NOT NULL,
    Agree_date date NOT NULL,
    UserID varchar2(100) NOT NULL,
    Contract_code varchar2(4) NOT NULL
);

COMMENT ON COLUMN yesno.agree IS '동의/비동의';

CREATE TABLE Ifare (
    Keynum number(4) NOT NULL,
    starta varchar2(100) NOT NULL,
    arrive varchar2(100) NOT NULL,
    sg varchar2(50) NOT NULL,
    fare number NOT NULL,
    redis number NOT NULL,
    tax number NOT NULL,
    fuelch number NOT NULL,
    AdminID varchar2(100) NOT NULL
);

CREATE TABLE CARD_USE (
    record_num NUMBER(10) NOT NULL,
    section VARCHAR(12) NOT NULL,
    tdate DATE NOT NULL,
    amount number NOT NULL,
    CARD_NUM VARCHAR2(19) NOT NULL
);

CREATE TABLE GIFTCARD (
    CARD_NUM VARCHAR2(19) NOT NULL,
    message VARCHAR2(450) NOT NULL,
    PIN_NUM NUMBER(6) NOT NULL,
    Recipient VARCHAR2(30) NOT NULL,
    Recipient_PNUM NUMBER(20) NOT NULL,
    SENDER VARCHAR2(30) NOT NULL,
    SENDER_PNUM NUMBER(20) NOT NULL,
    amount NUMBER(7) NOT NULL
);

CREATE TABLE Contract (
    Contract_code varchar2(4) NOT NULL,
    Essentiality varchar2(6) NOT NULL,
    Contract_title varchar2(150) NOT NULL,
    Contract_contents clob NOT NULL
);

COMMENT ON COLUMN Contract.Essentiality IS '필수/선택';

COMMENT ON COLUMN Contract.Contract_title IS '50자내외';

CREATE TABLE Event (
    Evnum number(4) NOT NULL,
    Evcat varchar2(100) NOT NULL,
    Evname varchar2(100) NOT NULL,
    stdate date NOT NULL,
    endate date NOT NULL,
    AdminID varchar2(100) NOT NULL
);

CREATE TABLE Winner (
    Key number(8) NOT NULL,
    Wingrade varchar2(100) NOT NULL,
    phoneNumber varchar2(100) NOT NULL,
    UserID varchar2(100) NOT NULL,
    Evnum number(4) NOT NULL
);

CREATE TABLE Prize (
    Evnum number(4) NOT NULL,
    Price1 VARCHAR2(30) NOT NULL,
    Price2 VARCHAR2(30) NOT NULL,
    Price3 VARCHAR2(30) NOT NULL
);

CREATE TABLE Adminstrator (
    AdminID varchar2(100) NOT NULL,
    Korlastname varchar2(20) NOT NULL,
    Korfirstname varchar2(100) NOT NULL,
    lastname varchar2(100) NOT NULL,
    firstname varchar2(100) NOT NULL,
    password varchar2(200) NOT NULL,
    birthdate date NOT NULL,
    gender varchar2(6) NOT NULL,
    emailaddress varchar2(200) NOT NULL,
    phoneNumber varchar2(200) NOT NULL,
    Area_Nation varchar2(200) NOT NULL,
    Skypassnumber varchar2(200) NOT NULL
);

CREATE TABLE Userdetail (
    UserID varchar2(100) NOT NULL,
    totalmile number DEFAULT 0 NULL,
    usergrade varchar2(100) DEFAULT '스카이패스 클럽' NULL,
    family_id VARCHAR2(100) NOT NULL
);

CREATE TABLE S_Grade (
    Key NUMBER NOT NULL,
    grade varchar2(100) DEFAULT '스카이패스 클럽' NOT NULL,
    totalmile NUMBER DEFAULT 0 NOT NULL,
    minarr NUMBER DEFAULT 0 NOT NULL
);

CREATE TABLE Movie (
    Title varchar2(100) NOT NULL,
    Duration date NOT NULL,
    Category varchar2(100) NOT NULL,
    Content clob NOT NULL,
    Lang varchar2(20) NOT NULL
);

CREATE TABLE TV (
    Title varchar2(100) NOT NULL,
    duration date NOT NULL,
    cate varchar2(100) NOT NULL,
    content clob NOT NULL
);

CREATE TABLE Music (
    Title varchar2(100) NOT NULL,
    Duration date NOT NULL,
    cate varchar2(100) NOT NULL,
    content clob NOT NULL
);

ALTER TABLE flightuser ADD CONSTRAINT PK_FLIGHTUSER PRIMARY KEY (UserID);

ALTER TABLE Cservice ADD CONSTRAINT PK_CSERVICE PRIMARY KEY (CS_num);

ALTER TABLE Rfamily ADD CONSTRAINT PK_RFAMILY PRIMARY KEY (keynum);

ALTER TABLE Notice ADD CONSTRAINT PK_NOTICE PRIMARY KEY (Notice_num);

ALTER TABLE R_section ADD CONSTRAINT PK_R_SECTION PRIMARY KEY (ROUTE_SECTION);

ALTER TABLE L_rule ADD CONSTRAINT PK_L_RULE PRIMARY KEY (LUGREGULAR_NUM);

ALTER TABLE LOUNGE_INFO ADD CONSTRAINT PK_LOUNGE_INFO PRIMARY KEY (LOUNGE_NUM);

ALTER TABLE dfare ADD CONSTRAINT PK_DFARE PRIMARY KEY (Keynum);

ALTER TABLE airplane ADD CONSTRAINT PK_AIRPLANE PRIMARY KEY (asnum);

ALTER TABLE Mtracking ADD CONSTRAINT PK_MTRACKING PRIMARY KEY (Tracking_num);

ALTER TABLE payrefund ADD CONSTRAINT PK_PAYREFUND PRIMARY KEY (SerialNumber);

ALTER TABLE SEAT_NUM ADD CONSTRAINT PK_SEAT_NUM PRIMARY KEY (SEAT_CODE);

ALTER TABLE Scplane ADD CONSTRAINT PK_SCPLANE PRIMARY KEY (renum);

ALTER TABLE Bpass ADD CONSTRAINT PK_BPASS PRIMARY KEY (Key);

ALTER TABLE flight_meal ADD CONSTRAINT PK_FLIGHT_MEAL PRIMARY KEY (mael_code);

ALTER TABLE Customerc ADD CONSTRAINT PK_CUSTOMERC PRIMARY KEY (Q_num);

ALTER TABLE yesno ADD CONSTRAINT PK_YESNO PRIMARY KEY (Contrat_num);

ALTER TABLE Ifare ADD CONSTRAINT PK_IFARE PRIMARY KEY (Keynum);

ALTER TABLE CARD_USE ADD CONSTRAINT PK_CARD_USE PRIMARY KEY (record_num);

ALTER TABLE GIFTCARD ADD CONSTRAINT PK_GIFTCARD PRIMARY KEY (CARD_NUM);

ALTER TABLE Contract ADD CONSTRAINT PK_CONTRACT PRIMARY KEY (Contract_code);

ALTER TABLE Event ADD CONSTRAINT PK_EVENT PRIMARY KEY (Evnum);

ALTER TABLE Winner ADD CONSTRAINT PK_WINNER PRIMARY KEY (Key);

ALTER TABLE Prize ADD CONSTRAINT PK_PRIZE PRIMARY KEY (Evnum);

ALTER TABLE Adminstrator ADD CONSTRAINT PK_ADMINSTRATOR PRIMARY KEY (AdminID);

ALTER TABLE Userdetail ADD CONSTRAINT PK_USERDETAIL PRIMARY KEY (UserID);

ALTER TABLE S_Grade ADD CONSTRAINT PK_S_GRADE PRIMARY KEY (Key);

ALTER TABLE Movie ADD CONSTRAINT PK_MOVIE PRIMARY KEY (Title);

ALTER TABLE TV ADD CONSTRAINT PK_TV PRIMARY KEY (Title);

ALTER TABLE Music ADD CONSTRAINT PK_MUSIC PRIMARY KEY (Title);

ALTER TABLE Cservice ADD CONSTRAINT FK_Adminstrator_TO_Cservice_1 FOREIGN KEY (AdminID)
REFERENCES Adminstrator (AdminID);

ALTER TABLE Rfamily ADD CONSTRAINT FK_flightuser_TO_Rfamily_1 FOREIGN KEY (UserID)
REFERENCES flightuser (UserID);

ALTER TABLE Notice ADD CONSTRAINT FK_Adminstrator_TO_Notice_1 FOREIGN KEY (AdminID)
REFERENCES Adminstrator (AdminID);

ALTER TABLE L_rule ADD CONSTRAINT FK_R_section_TO_L_rule_1 FOREIGN KEY (ROUTE_SECTION)
REFERENCES R_section (ROUTE_SECTION);

ALTER TABLE dfare ADD CONSTRAINT FK_Adminstrator_TO_dfare_1 FOREIGN KEY (AdminID)
REFERENCES Adminstrator (AdminID);

ALTER TABLE Mtracking ADD CONSTRAINT FK_flightuser_TO_Mtracking_1 FOREIGN KEY (UserID)
REFERENCES flightuser (UserID);

ALTER TABLE payrefund ADD CONSTRAINT FK_flightuser_TO_payrefund_1 FOREIGN KEY (UserID)
REFERENCES flightuser (UserID);

ALTER TABLE payrefund ADD CONSTRAINT FK_Scplane_TO_payrefund_1 FOREIGN KEY (renum)
REFERENCES Scplane (renum);

ALTER TABLE SEAT_NUM ADD CONSTRAINT FK_airplane_TO_SEAT_NUM_1 FOREIGN KEY (asnum)
REFERENCES airplane (asnum);

ALTER TABLE Scplane ADD CONSTRAINT FK_airplane_TO_Scplane_1 FOREIGN KEY (asnum)
REFERENCES airplane (asnum);

ALTER TABLE Bpass ADD CONSTRAINT FK_flightuser_TO_Bpass_1 FOREIGN KEY (UserID)
REFERENCES flightuser (UserID);

ALTER TABLE yesno ADD CONSTRAINT FK_flightuser_TO_yesno_1 FOREIGN KEY (UserID)
REFERENCES flightuser (UserID);

ALTER TABLE yesno ADD CONSTRAINT FK_Contract_TO_yesno_1 FOREIGN KEY (Contract_code)
REFERENCES Contract (Contract_code);

ALTER TABLE Ifare ADD CONSTRAINT FK_Adminstrator_TO_Ifare_1 FOREIGN KEY (AdminID)
REFERENCES Adminstrator (AdminID);

ALTER TABLE CARD_USE ADD CONSTRAINT FK_GIFTCARD_TO_CARD_USE_1 FOREIGN KEY (CARD_NUM)
REFERENCES GIFTCARD (CARD_NUM);

ALTER TABLE Event ADD CONSTRAINT FK_Adminstrator_TO_Event_1 FOREIGN KEY (AdminID)
REFERENCES Adminstrator (AdminID);

ALTER TABLE Winner ADD CONSTRAINT FK_flightuser_TO_Winner_1 FOREIGN KEY (UserID)
REFERENCES flightuser (UserID);

ALTER TABLE Winner ADD CONSTRAINT FK_Event_TO_Winner_1 FOREIGN KEY (Evnum)
REFERENCES Event (Evnum);

ALTER TABLE Prize ADD CONSTRAINT FK_Event_TO_Prize_1 FOREIGN KEY (Evnum)
REFERENCES Event (Evnum);

ALTER TABLE Userdetail ADD CONSTRAINT FK_flightuser_TO_Userdetail_1 FOREIGN KEY (UserID)
REFERENCES flightuser (UserID);


-----
-- 회원 정보 5개
INSERT INTO flightuser VALUES ('user001', '홍', '길동', 'Hong', 'GilDong', 'password123', TO_DATE('1990-01-01', 'YYYY-MM-DD'), 'Male', 'user001@example.com', '01012345678', 'Korea', '1234-5678-9012-3456');

INSERT INTO flightuser VALUES ('user002', '김', '철수', 'Kim', 'ChulSoo', 'pass456', TO_DATE('1985-12-15', 'YYYY-MM-DD'), 'Male', 'user002@example.com', '01023456789', 'Korea', '5678-9012-3456-7890');

INSERT INTO flightuser VALUES ('user003', '이', '영희', 'Lee', 'YoungHee', 'securepass', TO_DATE('1993-05-20', 'YYYY-MM-DD'), 'Female', 'user003@example.com', '01034567890', 'Japan', '9012-3456-7890-1234');

INSERT INTO flightuser VALUES ('user004', '박', '미영', 'Park', 'MiYoung', 'mypassword', TO_DATE('1987-04-03', 'YYYY-MM-DD'), 'Female', 'user004@example.com', '01045678901', 'China', '2345-6789-0123-4567');

INSERT INTO flightuser VALUES ('user005', '김', '수현', 'Kim', 'SuHyun', 'p@ssw0rd', TO_DATE('1990-11-11', 'YYYY-MM-DD'), 'Female', 'user005@example.com', '01056789012', 'Korea', '6789-0123-4567-8901');



-- 예약 일정 5개
INSERT INTO Scplane VALUES (1, NULL, TO_DATE('2024-03-20 09:30', 'YYYY-MM-DD HH24:MI'), TO_DATE('2024-03-20 10:45', 'YYYY-MM-DD HH24:MI'), 'Korea', 'Korea', 'admin001', 97000, 'KE1234', 'GMP', 'CJU', 23, 2, 'HL7553');
INSERT INTO Scplane VALUES (2, NULL, TO_DATE('2024-03-23 15:15', 'YYYY-MM-DD HH24:MI'), TO_DATE('2024-03-23 16:30', 'YYYY-MM-DD HH24:MI'), 'Korea', 'Korea', 'admin002', 115000, 'KE5678', 'GMP', 'CJU', 15, 3, 'HL7554');
INSERT INTO Scplane VALUES (3, '햄버거', TO_DATE('2024-04-09 14:45', 'YYYY-MM-DD HH24:MI'), TO_DATE('2024-04-09 20:00', 'YYYY-MM-DD HH24:MI'), 'Korea', 'Japan', 'admin003', 199000, 'KE9876', 'ICN', 'FUK', 8, 1, 'HL7611');
INSERT INTO Scplane VALUES (4, '김치찌개', TO_DATE('2024-04-10 09:05', 'YYYY-MM-DD HH24:MI'), TO_DATE('2024-04-10 10:25', 'YYYY-MM-DD HH24:MI'), 'Korea', 'China', 'admin004', 169000, 'KE4321', 'ICN', 'PEK', 12, 4, 'HL8348');
INSERT INTO Scplane VALUES (5, NULL, TO_DATE('2024-05-03 21:00', 'YYYY-MM-DD HH24:MI'), TO_DATE('2024-05-03 22:15', 'YYYY-MM-DD HH24:MI'), 'Korea', 'Korea', 'admin005', 132000, 'KE8765', 'GMP', 'CJU', 20, 2, 'HL8240');

--결제/예약/환불
INSERT INTO payrefund VALUES (1, '결제', '카드', '정상', '12A', SYSDATE, 2, 97000, 276, 'user001', 1);
INSERT INTO payrefund VALUES (2, '결제', '기프트카드', '정상', '8C', SYSDATE, 0, 115000, 150, 'user002', 2);
INSERT INTO payrefund VALUES (3, '결제', '카드', '정상', '5B', SYSDATE, 1, 199000, 250, 'user003', 3);
INSERT INTO payrefund VALUES (4, '결제', '마일리지', '정상', '14D', SYSDATE, 0, 169000, 398, 'user004', 4);
INSERT INTO payrefund VALUES (5, '결제', '기프트카드', '할인', '9A', SYSDATE, 3, 63000, 276, 'user005', 5);

--
-- 관리자 5개행 삽입
INSERT INTO Adminstrator VALUES ('admin001', '김', '철수', 'Kim', 'Chulsoo', 'adminpass1', TO_DATE('1990-01-15', 'YYYY-MM-DD'), 'Male', 'chulsoo.kim@example.com', '010-1234-5678', 'Seoul, South Korea', '1234-5678-9012-3456');
INSERT INTO Adminstrator VALUES ('admin002', '이', '영희', 'Lee', 'Younghee', 'adminpass2', TO_DATE('1985-03-22', 'YYYY-MM-DD'), 'Female', 'younghee.lee@example.com', '010-9876-5432', 'Busan, South Korea', '7890-1234-5678-9012');
INSERT INTO Adminstrator VALUES ('admin003', '박', '민수', 'Park', 'Minsu', 'adminpass3', TO_DATE('1995-07-10', 'YYYY-MM-DD'), 'Male', 'minsu.park@example.com', '010-5555-1234', 'Incheon, South Korea', '3456-7890-1234-5678');
INSERT INTO Adminstrator VALUES ('admin004', '장', '서영', 'Jang', 'Seoyoung', 'adminpass4', TO_DATE('1988-11-05', 'YYYY-MM-DD'), 'Female', 'seoyoung.jang@example.com', '010-7777-8888', 'Daejeon, South Korea', '9012-3456-7890-1234');
INSERT INTO Adminstrator VALUES ('admin005', '윤', '준호', 'Yoon', 'Junho', 'adminpass5', TO_DATE('1992-04-30', 'YYYY-MM-DD'), 'Male', 'junho.yoon@example.com', '010-3333-9999', 'Ulsan, South Korea', '5678-9012-3456-7890');

--
insert into dfare values (1,'성수기','정상','일반','일반석','서울/김포-제주',132000,3000,'admin001');
insert into ifare values (1,'ICN','FUK','일반석',150000,110000,21000,28000,'admin002');
--
SELECT * FROM SCPLANE;
SELECT * FROM FLIGHTUSER;
select * from adminstrator;
select * from dfare;
select * from ifare;





















