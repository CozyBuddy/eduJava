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
    relation VARCHAR2(20) NOT NULL,
    status VARCHAR2(10) NULL,
    request_date DATE DEFAULT SYSDATE NULL,
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
    SEAT_GRADE VARCHAR2(20) NOT NULL,
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
    AdminID varchar2(100) NOT NULL,
    wknddy varchar2(100) null
);

CREATE TABLE airplane (
    asnum varchar2(100) NOT NULL,
    AIRLINE VARCHAR(30) NULL,
    totalseat NUMBER(4) NOT NULL,
    airmodel VARCHAR(30) NULL,
    M_DATE DATE NULL,
    FCLA_COUNT NUMBER(3) NULL,
    PreCLA_COUNT NUMBER(3) NULL,
    NCLA_COUNT NUMBER(3) NULL,
    PRECLA_Features VARCHAR2(300) NULL,
    NCLA_Features VARCHAR2(300) NULL,
    FCLA_Features varchar2(300) null
);

CREATE TABLE Mtracking (
    Tracking_num NUMBER NOT NULL,
    Consumtion_date DATE DEFAULT SYSDATE NULL,
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
    mileage number null,
    UserID varchar2(100) NOT NULL,
    renum varchar2(10 char) NOT NULL
);

CREATE TABLE SEAT_NUM (
    SEAT_CODE VARCHAR2(20) NOT NULL,
    SEAT_NUM VARCHAR2(20) NOT NULL,
    SEAT_GRADE VARCHAR2(100) NULL,
    asnum varchar2(100) NOT NULL
);

CREATE TABLE Scplane (
    renum varchar2(10 char) NOT NULL,
    food varchar2(100) DEFAULT '(기내식 제공없음)' NULL,
    ddate date NOT NULL,
    adate date NOT NULL,
    dnation varchar2(100) NOT NULL,
    anation varchar2(100) NOT NULL,
    AdminID varchar2(100) NOT NULL,
    fare number null,
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
    meal_code NUMBER(2) NOT NULL,
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
    content varchar2(3000) NOT NULL,
    SP_NUM VARCHAR2(20) NULL,
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
    Contract_code number NOT NULL
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
    Recipient_PNUM varchar2(20) NOT NULL,
    SENDER VARCHAR2(30) NOT NULL,
    SENDER_PNUM varchar2(20) NOT NULL,
    amount NUMBER(7) NOT NULL
);

CREATE TABLE Contract (
    Contract_code number NOT NULL,
    Essentiality varchar2(6) NOT NULL,
    Contract_title varchar2(150) NOT NULL,
    Contract_contents varchar2(3000) NOT NULL
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
    family_id VARCHAR2(100) NULL
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

ALTER TABLE Rfamily ADD CONSTRAINT PK_RFAMILY PRIMARY KEY (userid);

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

ALTER TABLE flight_meal ADD CONSTRAINT PK_FLIGHT_MEAL PRIMARY KEY (meal_code);

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
REFERENCES Adminstrator (AdminID) on delete cascade;

ALTER TABLE Rfamily ADD CONSTRAINT FK_flightuser_TO_Rfamily_1 FOREIGN KEY (UserID)
REFERENCES flightuser (UserID) on delete cascade;

ALTER TABLE Notice ADD CONSTRAINT FK_Adminstrator_TO_Notice_1 FOREIGN KEY (AdminID)
REFERENCES Adminstrator (AdminID) on delete cascade;

ALTER TABLE L_rule ADD CONSTRAINT FK_R_section_TO_L_rule_1 FOREIGN KEY (ROUTE_SECTION)
REFERENCES R_section (ROUTE_SECTION) on delete cascade;

ALTER TABLE dfare ADD CONSTRAINT FK_Adminstrator_TO_dfare_1 FOREIGN KEY (AdminID)
REFERENCES Adminstrator (AdminID) on delete cascade;

ALTER TABLE Mtracking ADD CONSTRAINT FK_flightuser_TO_Mtracking_1 FOREIGN KEY (UserID)
REFERENCES flightuser (UserID) on delete cascade;

ALTER TABLE payrefund ADD CONSTRAINT FK_flightuser_TO_payrefund_1 FOREIGN KEY (UserID)
REFERENCES flightuser (UserID) on delete cascade;

ALTER TABLE payrefund ADD CONSTRAINT FK_Scplane_TO_payrefund_1 FOREIGN KEY (renum)
REFERENCES Scplane (renum) on delete cascade;

ALTER TABLE SEAT_NUM ADD CONSTRAINT FK_airplane_TO_SEAT_NUM_1 FOREIGN KEY (asnum)
REFERENCES airplane (asnum) on delete cascade;

ALTER TABLE Scplane ADD CONSTRAINT FK_airplane_TO_Scplane_1 FOREIGN KEY (asnum)
REFERENCES airplane (asnum) on delete cascade;

ALTER TABLE Bpass ADD CONSTRAINT FK_flightuser_TO_Bpass_1 FOREIGN KEY (UserID)
REFERENCES flightuser (UserID) on delete cascade;

ALTER TABLE yesno ADD CONSTRAINT FK_flightuser_TO_yesno_1 FOREIGN KEY (UserID)
REFERENCES flightuser (UserID) on delete cascade;

ALTER TABLE yesno ADD CONSTRAINT FK_Contract_TO_yesno_1 FOREIGN KEY (Contract_code)
REFERENCES Contract (Contract_code) on delete cascade;

ALTER TABLE Ifare ADD CONSTRAINT FK_Adminstrator_TO_Ifare_1 FOREIGN KEY (AdminID)
REFERENCES Adminstrator (AdminID) on delete cascade;

ALTER TABLE CARD_USE ADD CONSTRAINT FK_GIFTCARD_TO_CARD_USE_1 FOREIGN KEY (CARD_NUM)
REFERENCES GIFTCARD (CARD_NUM) on delete cascade;

ALTER TABLE Event ADD CONSTRAINT FK_Adminstrator_TO_Event_1 FOREIGN KEY (AdminID)
REFERENCES Adminstrator (AdminID) on delete cascade;

ALTER TABLE Winner ADD CONSTRAINT FK_flightuser_TO_Winner_1 FOREIGN KEY (UserID)
REFERENCES flightuser (UserID) on delete cascade;

ALTER TABLE Winner ADD CONSTRAINT FK_Event_TO_Winner_1 FOREIGN KEY (Evnum)
REFERENCES Event (Evnum) on delete cascade;

ALTER TABLE Prize ADD CONSTRAINT FK_Event_TO_Prize_1 FOREIGN KEY (Evnum)
REFERENCES Event (Evnum) on delete cascade;

ALTER TABLE Userdetail ADD CONSTRAINT FK_flightuser_TO_Userdetail_1 FOREIGN KEY (UserID) 
REFERENCES flightuser (UserID) on delete cascade;


-----
-- 회원 정보 5개
INSERT INTO flightuser VALUES ('user001', '홍', '길동', 'Hong', 'GilDong', 'password123', TO_DATE('1990-01-01', 'YYYY-MM-DD'), 'Male', 'user001@example.com', '01012345678', 'Korea', '1234-5678-9012-3456');

INSERT INTO flightuser VALUES ('user002', '김', '철수', 'Kim', 'ChulSoo', 'pass456', TO_DATE('1985-12-15', 'YYYY-MM-DD'), 'Male', 'user002@example.com', '01023456789', 'Korea', '5678-9012-3456-7890');

INSERT INTO flightuser VALUES ('user003', '이', '영희', 'Lee', 'YoungHee', 'securepass', TO_DATE('1993-05-20', 'YYYY-MM-DD'), 'Female', 'user003@example.com', '01034567890', 'Japan', '9012-3456-7890-1234');

INSERT INTO flightuser VALUES ('user004', '박', '미영', 'Park', 'MiYoung', 'mypassword', TO_DATE('1987-04-03', 'YYYY-MM-DD'), 'Female', 'user004@example.com', '01045678901', 'China', '2345-6789-0123-4567');

INSERT INTO flightuser VALUES ('user005', '김', '수현', 'Kim', 'SuHyun', 'p@ssw0rd', TO_DATE('1990-11-11', 'YYYY-MM-DD'), 'Female', 'user005@example.com', '01056789012', 'Korea', '6789-0123-4567-8901');

--항공기 정보 5개
INSERT INTO airplane  VALUES (
    'HL7553',
    '대한항공',
    276,
    'A330-300',
    TO_DATE('1999-04-16', 'YYYY-MM-DD'),
    0,
    24,
    252,
    '프레스티지 클래스 우선 탑승, 추가 수하물 허용',
    '향상된 좌석 공간, 개인 엔터테인먼트 시스템',
    NULL
);



INSERT INTO airplane VALUES (
    'HL7554',
    '대한항공',
    276,
    'A330-300',
    TO_DATE('1999-01-04', 'YYYY-MM-DD'),
    0,
    24,
    252,
    '프레스티지 클래스 전용 체크인, 라운지 이용 가능',
    '조절 가능한 헤드레스트, USB 충전 포트',
    NULL
);

INSERT INTO airplane VALUES (
    'HL7611',
    '대한항공',
    407,
    'A380-800',
    TO_DATE('2010-09-27', 'YYYY-MM-DD'),
    12,
    94,
    301,
    '프레스티지 클래스 셀프 체크인, 우선 탑승',
    '와이드 스크린 개인 모니터, 다리 공간 확장'
    ,'퍼스트클래스 최고의 서비스'
);


INSERT INTO airplane VALUES (
    'HL8348',
    '대한항공',
    146,
    'B737-8',
    TO_DATE('2019-04-18', 'YYYY-MM-DD'),
    0,
    8,
    138,
    '프레스티지 클래스 스위트, 고급 식사 옵션',
    '개인 엔터테인먼트, 더 넓은 좌석 및 다리 공간'
    ,NULL
);

INSERT INTO airplane VALUES (
    'HL8240',
    '대한항공',
    138,
    'B737-800',
    TO_DATE('2011-09-14', 'YYYY-MM-DD'),
    0,
    12,
    126,
    '프레스티지 클래스 스위트, 고급 식사 옵션',
    '개인 엔터테인먼트, 더 넓은 좌석 및 다리 공간'
    ,NULL
);
-- 예약 일정 5개
INSERT INTO Scplane VALUES (1, NULL, TO_DATE('2024-03-20 09:30', 'YYYY-MM-DD HH24:MI'), TO_DATE('2024-03-20 10:45', 'YYYY-MM-DD HH24:MI'), 'Korea', 'Korea', 'admin001', 97000, 'KE1234', 'JEJU.CJU', 'SEOUL.GMP', 23, 2, 'HL7553');
INSERT INTO Scplane VALUES (2, NULL, TO_DATE('2024-03-23 15:15', 'YYYY-MM-DD HH24:MI'), TO_DATE('2024-03-23 16:30', 'YYYY-MM-DD HH24:MI'), 'Korea', 'Korea', 'admin002', 115000, 'KE5678',  'JEJU.CJU','SEOUL.GMP', 15, 3, 'HL7554');
INSERT INTO Scplane VALUES (3, '햄버거', TO_DATE('2024-04-09 14:45', 'YYYY-MM-DD HH24:MI'), TO_DATE('2024-04-09 20:00', 'YYYY-MM-DD HH24:MI'), 'Korea', 'Japan', 'admin003', 199000, 'KE9876', 'FUKU.FUK','SEOUL.ICN', 8, 1, 'HL7611');
INSERT INTO Scplane VALUES (4, '김치찌개', TO_DATE('2024-04-10 09:05', 'YYYY-MM-DD HH24:MI'), TO_DATE('2024-04-10 10:25', 'YYYY-MM-DD HH24:MI'), 'Korea', 'China', 'admin004', 169000, 'KE4321', 'BEIJING.PEK', 'SEOUL.ICN', 12, 4, 'HL8348');
INSERT INTO Scplane VALUES (5, NULL, TO_DATE('2024-05-03 21:00', 'YYYY-MM-DD HH24:MI'), TO_DATE('2024-05-03 22:15', 'YYYY-MM-DD HH24:MI'), 'Korea', 'Korea', 'admin005', 132000, 'KE8765', 'JEJU.CJU', 'SEOUL.GMP', 20, 2, 'HL8240');
INSERT INTO Scplane VALUES 
(6, NULL, TO_DATE('2024-03-28 06:05', 'YYYY-MM-DD HH24:MI'), TO_DATE('2024-03-28 07:15', 'YYYY-MM-DD HH24:MI')
, 'Korea', 'Korea', 'admin001', 101000, 'KE5153', 'JEJU.CJU', 'SEOUL.GMP', 23, 2, 'HL7553');
INSERT INTO Scplane VALUES 
(7, NULL, TO_DATE('2024-03-28 08:05', 'YYYY-MM-DD HH24:MI'), TO_DATE('2024-03-28 09:15', 'YYYY-MM-DD HH24:MI')
, 'Korea', 'Korea', 'admin001', 101000, 'KE5153','JEJU.CJU','SEOUL.GMP', 23, 2, 'HL7553');
INSERT INTO Scplane VALUES 
(8, NULL, TO_DATE('2024-03-28 06:05', 'YYYY-MM-DD HH24:MI'), TO_DATE('2024-03-28 07:15', 'YYYY-MM-DD HH24:MI')
, 'Korea', 'Korea', 'admin001', 101000, 'KE5153','JEJU.CJU', 'SEOUL.GMP',  23, 2, 'HL7553');
INSERT INTO Scplane VALUES 
(9, NULL, TO_DATE('2024-03-28 06:05', 'YYYY-MM-DD HH24:MI'), TO_DATE('2024-03-28 07:15', 'YYYY-MM-DD HH24:MI')
, 'Korea', 'Korea', 'admin001', 101000, 'KE5153','JEJU.CJU', 'SEOUL.GMP', 23, 2, 'HL7553');
INSERT INTO Scplane VALUES 
(10, NULL, TO_DATE('2024-03-28 06:05', 'YYYY-MM-DD HH24:MI'), TO_DATE('2024-03-28 07:15', 'YYYY-MM-DD HH24:MI')
, 'Korea', 'Korea', 'admin001', 101000, 'KE5153','JEJU.CJU', 'SEOUL.GMP', 23, 2, 'HL7553');

--select * from scplane;
---- 나머지 5개의 데이터
--INSERT INTO Scplane VALUES 
--(11, NULL, TO_DATE('2024-03-25 09:00', 'YYYY-MM-DD HH24:MI'), TO_DATE('2024-03-25 11:05', 'YYYY-MM-DD HH24:MI')
--, 'Korea', 'Japan', 'admin001', 421000, 'KE2468', 'ICN', 'HND', 18, 3, 'HL9102');
--INSERT INTO Scplane VALUES 
--(12, '스테이크', TO_DATE('2024-04-15 11:10', 'YYYY-MM-DD HH24:MI'), TO_DATE('2024-04-15 12:25', 'YYYY-MM-DD HH24:MI')
--, 'Korea', 'CHINA', 'admin001', 166000, 'KE6543', 'ICN', 'PVG', 10, 1, 'HL7321');
--INSERT INTO Scplane VALUES 
--(13, NULL, TO_DATE('2024-05-01 16:30', 'YYYY-MM-DD HH24:MI'), TO_DATE('2024-05-01 17:40', 'YYYY-MM-DD HH24:MI')
--, 'Korea', 'Korea', 'admin001', 97000, 'KE7890', 'GMP', 'CJU', 25, 4, 'HL8197');
--INSERT INTO Scplane VALUES 
--(14, NULL, TO_DATE('2024-05-10 20:30', 'YYYY-MM-DD HH24:MI'), TO_DATE('2024-05-10 21:40', 'YYYY-MM-DD HH24:MI')
--, 'Korea', 'Korea', 'admin001', 132000, 'KE1227', 'GMP', 'CJU', 22, 2, 'HL6635');
--INSERT INTO Scplane VALUES 
--(15, NULL, TO_DATE('2024-05-20 13:20', 'YYYY-MM-DD HH24:MI'), TO_DATE('2024-05-20 14:30', 'YYYY-MM-DD HH24:MI')
--, 'Korea', 'Thailand', 'admin010', 101000, 'KE1115', 'GMP', 'CJU', 14, 3, 'HL5721');

--결제/예약/환불
--INSERT INTO payrefund VALUES (1, '결제', '카드', '정상', '20A', SYSDATE, 2, 97000, 276, 'user001', 1);
--INSERT INTO payrefund VALUES (2, '결제', '기프트카드', '정상', '21A', SYSDATE, 0, 115000, 150, 'user002', 2);
--INSERT INTO payrefund VALUES (3, '결제', '카드', '정상', '22A', SYSDATE, 1, 199000, 250, 'user003', 3);
--INSERT INTO payrefund VALUES (4, '결제', '마일리지', '정상', '20A', SYSDATE, 0, 169000, 398, 'user004', 4);
--INSERT INTO payrefund VALUES (5, '결제', '기프트카드', '할인', '20A', SYSDATE, 3, 63000, 276, 'user005', 5);

--
-- 관리자 5개행 삽입
INSERT INTO Adminstrator VALUES ('admin001', '김', '철수', 'Kim', 'Chulsoo', 'adminpass1', TO_DATE('1990-01-15', 'YYYY-MM-DD'), 'Male', 'chulsoo.kim@example.com', '010-1234-5678', 'Seoul, South Korea', '1234-5678-9012-3456');
INSERT INTO Adminstrator VALUES ('admin002', '이', '영희', 'Lee', 'Younghee', 'adminpass2', TO_DATE('1985-03-22', 'YYYY-MM-DD'), 'Female', 'younghee.lee@example.com', '010-9876-5432', 'Busan, South Korea', '7890-1234-5678-9012');
INSERT INTO Adminstrator VALUES ('admin003', '박', '민수', 'Park', 'Minsu', 'adminpass3', TO_DATE('1995-07-10', 'YYYY-MM-DD'), 'Male', 'minsu.park@example.com', '010-5555-1234', 'Incheon, South Korea', '3456-7890-1234-5678');
INSERT INTO Adminstrator VALUES ('admin004', '장', '서영', 'Jang', 'Seoyoung', 'adminpass4', TO_DATE('1988-11-05', 'YYYY-MM-DD'), 'Female', 'seoyoung.jang@example.com', '010-7777-8888', 'Daejeon, South Korea', '9012-3456-7890-1234');
INSERT INTO Adminstrator VALUES ('admin005', '윤', '준호', 'Yoon', 'Junho', 'adminpass5', TO_DATE('1992-04-30', 'YYYY-MM-DD'), 'Male', 'junho.yoon@example.com', '010-3333-9999', 'Ulsan, South Korea', '5678-9012-3456-7890');

--
--국내선 운임 인서트 3개
insert into dfare values (1,'비수기','정상','선호','일반석','SEOUL/GMP-JEJU/CJU',97000,3000,'admin001','주중');
insert into dfare values (2,'비수기','정상','일반','일반석','SEOUL/GMP-JEJU/CJU',115000,3000,'admin002','주말');
insert into dfare values (3,'성수기','정상','일반','일반석','SEOUL/GMP-JEJU/CJU',132000,3000,'admin005','주중');


--국제선 운임 인서트 2개
insert into ifare values (1,'ICN','FUK','일반석',150000,110000,20300,21000,'admin003');
insert into ifare values (2,'ICN','PEK','일반석',235000,172300,22350,35000,'admin004');


-- 안내 사항 5개
INSERT INTO notice VALUES ( 1, '한국 입국 세관신고 절차 변경', '2023년 5월 1일부터 대한민국 입국 세관신고 절차가 변경됩니다. 
 신고할 물품이 없는 경우에는 세관 신고서 없이 면세 라인 이용해 주세요.
 º 필수 신고 품목이 있는 경우에만 세관 신고서 제출 (검사 라인 이용) - 필수 신고 품목 : 미화 8백불 초과 물품, 미화 1만불 초과 외환, 검역물품 등
 º 신고 방법 : App/Web 사전 신고 또는 종이 휴대품 신고서 작성 
 º App 설치 및 Web 접속 방법', '여행정보', 'admin005');
INSERT INTO notice VALUES ( 2, '스카이패스 회원 할인 제휴 변경(키자니아 서울)', '스카이패스 회원 제휴사인 키자니아 서울과의 제휴 내용이 변경됩니다.
 º 스카이패스 회원 할인 적용은 현장 예매 시에만 가능 - 인터넷 사전 예매 시 할인 제공 불가  
 º 반일권 2부 할인율 30%로 인상 ( 2024년 2월 26일 부터) - 반일권 1부 할인율은 20% 유지', '스카이패스', 'admin001');
INSERT INTO notice VALUES ( 3, '엑설런트 보딩패스 제휴 종료 (쉐이크쉑)', '제휴사 폐점 계획에 따라 쉐이크쉑과의 엑설런트 보딩패스 제휴가 종료됩니다.
 º 제휴사 : 쉐이크쉑 (SHAKE SHACK) 인천국제공항 제2여객터미널 인천공항점
 º 제휴 종료일 : 2024년 3월 30일 º 엑설런트 보딩패스 제휴 혜택은 3월 29일 까지 제공됩니다.', '여행정보', 'admin003');
INSERT INTO notice VALUES ( 4, '카드 영수 일시 중단 (Diners Club, Discover)', '홈페이지에서 항공권 구매 시 Diners club 및 Discover 카드 영수가 일시 중단될 예정입니다.
 º 중단 일자 : 2024년 3월 16일 부 º 중단 사유 : 해당 카드사 심화인증 프로그램 개선 
 * 그 외 클로벌 카드사(Visa, Mastercard, American Express, JCB, UATP)로의 결제는 가능하며 카드사 심화인증 프로그램 개선 작업 후 다시 영수할 예정입니다.(20204년 상반기 내)'
, '기타안내', 'admin001');
INSERT INTO notice VALUES ( 5, '신규 마일리지 적립 제휴( 교보문고, 11번가)', '교보문고 및 11번가와 마일리지 적립 제휴를 시행하여,
 대한항공 홈페이지 내 제공된 링크를 통해 쇼핑 시 지불 금액에 따라 스카이패스 마일리지 적립이 가능함을 알려드립니다. 
 <제휴내용> 
  º 교보문고 : 지불 금액 1,000원당 2마일  
  º 11번가 : 지불 금액 1,000원당 1마일'
, '제휴소식', 'admin002');

--좌석 입력쿼리

-- 일등석 좌석 추가
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL7553-01A', 'HL7553', '01A', '일등석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL7553-01B', 'HL7553', '01B', '일등석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL7553-01C', 'HL7553', '01C', '일등석');

-- 일반석 좌석 추가
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL7553-20A', 'HL7553', '20A', '일반석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL7553-20B', 'HL7553', '20B', '일반석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL7553-20C', 'HL7553', '20C', '일반석');

-- 프레스티지석 좌석 추가
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL7553-10A', 'HL7553', '10A', '프레스티지석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL7553-10B', 'HL7553', '10B', '프레스티지석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL7553-10C', 'HL7553', '10C', '프레스티지석');


-- 일등석
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL7554-01D', 'HL7554', '01D', '일등석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL7554-01E', 'HL7554', '01E', '일등석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL7554-01F', 'HL7554', '01F', '일등석');

-- 일반석
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL7554-21A', 'HL7554', '21A', '일반석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL7554-21B', 'HL7554', '21B', '일반석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL7554-21C', 'HL7554', '21C', '일반석');

-- 프레스티지석
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL7554-11A', 'HL7554', '11A', '프레스티지석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL7554-11B', 'HL7554', '11B', '프레스티지석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL7554-11C', 'HL7554', '11C', '프레스티지석');


-- 일등석
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL7611-01G', 'HL7611', '01G', '일등석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL7611-01H', 'HL7611', '01H', '일등석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL7611-01I', 'HL7611', '01I', '일등석');

-- 일반석
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL7611-22A', 'HL7611', '22A', '일반석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL7611-22B', 'HL7611', '22B', '일반석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL7611-22C', 'HL7611', '22C', '일반석');

-- 프레스티지석
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL7611-12A', 'HL7611', '12A', '프레스티지석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL7611-12B', 'HL7611', '12B', '프레스티지석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL7611-12C', 'HL7611', '12C', '프레스티지석');


-- 일등석 좌석 추가
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL8348-01A', 'HL8348', '01A', '일등석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL8348-01B', 'HL8348', '01B', '일등석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL8348-01C', 'HL8348', '01C', '일등석');

-- 일반석 좌석 추가
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL8348-20A', 'HL8348', '20A', '일반석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL8348-20B', 'HL8348', '20B', '일반석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL8348-20C', 'HL8348', '20C', '일반석');

-- 프레스티지석 좌석 추가
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL8348-10A', 'HL8348', '10A', '프레스티지석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL8348-10B', 'HL8348', '10B', '프레스티지석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL8348-10C', 'HL8348', '10C', '프레스티지석');



-- 일등석 좌석 추가
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL8240-01A', 'HL8240', '01A', '일등석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL8240-01B', 'HL8240', '01B', '일등석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL8240-01C', 'HL8240', '01C', '일등석');

-- 일반석 좌석 추가
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL8240-20A', 'HL8240', '20A', '일반석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL8240-20B', 'HL8240', '20B', '일반석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL8240-20C', 'HL8240', '20C', '일반석');

-- 프레스티지석 좌석 추가
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL8240-10A', 'HL8240', '10A', '프레스티지석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL8240-10B', 'HL8240', '10B', '프레스티지석');
INSERT INTO SEAT_NUM (SEAT_CODE, asnum, SEAT_NUM, SEAT_GRADE) VALUES ('HL8240-10C', 'HL8240', '10C', '프레스티지석');


-- 클럽등급기준 값 넣기 


INSERT INTO S_Grade (Key) VALUES (1); 
INSERT INTO S_Grade VALUES (2, '모닝캄 클럽', 50000, 40 ) ;  
INSERT INTO S_Grade VALUES (3, '모닝캄 프리미엄 클럽' , 500000, 40);
INSERT INTO S_Grade VALUES (4, '밀리언 마일러 클럽', 1000000, 40); 

-- 가족 신청 하기 


INSERT INTO Rfamily (keynum,relation,family_id,userid) VALUES (1,'부','#id_01','user001');
INSERT INTO Rfamily (keynum,relation,family_id,userid) VALUES (2,'모','#id_01','user002');
INSERT INTO Rfamily (keynum,relation,family_id,userid) VALUES (3,'부','#id_02','user003');
INSERT INTO Rfamily (keynum,relation,family_id,userid) VALUES (4,'모','#id_02','user004');
INSERT INTO Rfamily (keynum,relation,family_id,userid) VALUES (5,'자','#id_02','user005');

-- 회원 세부 정보 
INSERT INTO Userdetail (UserID) VALUES ('user001');
INSERT INTO Userdetail (UserID) VALUES ('user002');
INSERT INTO Userdetail (UserID) VALUES ('user003');
INSERT INTO Userdetail (UserID) VALUES ('user004');
INSERT INTO Userdetail (UserID) VALUES ('user005');


-- 마일리지 적립 / 소비
    
INSERT INTO Mtracking (Tracking_num, Amount_Mileage, airline_type, spendorearned, userID) VALUES(1,0,'대한항공','적립','user001');
INSERT INTO Mtracking (Tracking_num, Amount_Mileage, airline_type, spendorearned, userID) VALUES(2,0,'대한항공','소비','user001');
INSERT INTO Mtracking (Tracking_num, Amount_Mileage, airline_type, spendorearned, userID) VALUES(3,20,'대한항공','적립','user002');
INSERT INTO Mtracking (Tracking_num, Amount_Mileage, airline_type, spendorearned, userID) VALUES(4,30,'대한항공','소비','user002');
INSERT INTO Mtracking (Tracking_num, Amount_Mileage, airline_type, spendorearned, userID) VALUES(5,40,'대한항공','적립','user003');


-- 고객의 말씀
-- 첫 번째 행 삽입
INSERT INTO Customerc VALUES (
    1,                -- 문의사항고유번호
    '칭송',                        -- 유형
    '공항서비스',                  -- 분야
    '이',                         -- 승객 성
    '동찬',                       -- 승객 이름
    '(82) 10-1234-5678',          -- 전화번호
    'example@email.com',          -- 이메일주소
    '칭찬해요 ~',                  -- 제목
    '모두 너무 친절합니다',          -- 내용
    '1232-3456-7890-1323',                       -- 스카이패스회원번호
    '34534534',                     -- 예약번호
    1,                            -- 이메일수신여부
    '서울',                        -- 도착도시
    '뉴욕',                        -- 출발도시
    TO_DATE('2024-03-10', 'YYYY-MM-DD'), -- 출발일자
    'KE123'                       -- 항공편명
);

-- 두 번째 행 삽입
INSERT INTO Customerc VALUES (
    2,                -- 문의사항고유번호
    '문의',                        -- 유형
    '기내식',                      -- 분야
    '김',                         -- 승객 성
    '영희',                       -- 승객 이름
    '(82) 10-2345-6789',          -- 전화번호
    'user2@example.com',          -- 이메일주소
    '기내식 관련 문의',            -- 제목
    '기내식 옵션이 무엇인가요?',   -- 내용
    '9012-3678-7890-1323',                       -- 스카이패스회원번호
    '12346786',                     -- 예약번호
    0,                            -- 이메일수신여부
    '도쿄',                        -- 도착도시
    '서울',                        -- 출발도시
    TO_DATE('2024-04-15', 'YYYY-MM-DD'), -- 출발일자
    'KE456'                       -- 항공편명
);

-- 세 번째 행 삽입
INSERT INTO Customerc VALUES (
   3,                -- 문의사항고유번호
    '불만',                        -- 유형
    '수화물',                      -- 분야
    '박',                         -- 승객 성
    '민수',                       -- 승객 이름
    '(82) 10-3456-7890',          -- 전화번호
    'user3@example.com',          -- 이메일주소
    '수화물 분실에 대한 불만',      -- 제목
    '짐을 받지 못했습니다',        -- 내용
    '9012-3456-2340-1323',                       -- 스카이패스회원번호
    '54367344',                     -- 예약번호
    1,                            -- 이메일수신여부
    '뉴욕',                        -- 도착도시
    '런던',                        -- 출발도시
    TO_DATE('2024-05-20', 'YYYY-MM-DD'), -- 출발일자
    'KE789'                       -- 항공편명
);

-- 네 번째 행 삽입
INSERT INTO Customerc VALUES (
    4,                -- 문의사항고유번호
    '제언',                        -- 유형
    '기타',                        -- 분야
    '최',                         -- 승객 성
    '지민',                       -- 승객 이름
    '(82) 10-4567-8901',          -- 전화번호
    'user4@example.com',          -- 이메일주소
    '기내 서비스 개선 제안',        -- 제목
    '기내 엔터테인먼트를 개선해주세요', -- 내용
    '9012-3456-7890-1323',                       -- 스카이패스회원번호
    '21346578',                     -- 예약번호
    0,                            -- 이메일수신여부
    '로스앤젤레스',                -- 도착도시
    '서울',                        -- 출발도시
    TO_DATE('2024-06-01', 'YYYY-MM-DD'), -- 출발일자
    'KE890'                       -- 항공편명
);

INSERT INTO Customerc VALUES (
   5,                -- 문의사항고유번호
    '불만',                        -- 유형
    '기내식',                      -- 분야
    '김',                         -- 승객 성
    '민준',                       -- 승객 이름
    '(82) 10-2345-6789',          -- 전화번호
    'user5@example.com',          -- 이메일주소
    '기내식 품질 개선 요청',         -- 제목
    '기내식의 맛과 질이 기대에 못 미쳤습니다.', -- 내용
    '1234-5678-9012-3456',        -- 스카이패스회원번호
    '87654321',                   -- 예약번호
    1,                            -- 이메일수신여부
    '도쿄',                        -- 도착도시
    '서울',                        -- 출발도시
    TO_DATE('2024-09-15', 'YYYY-MM-DD'), -- 출발일자
    'KE453'                       -- 항공편명
);

--식사메뉴

-- 첫 번째 식사 옵션 추가
INSERT INTO flight_meal (meal_code, menu) VALUES (1, '치킨 카레 라이스 - 온화한 향신료와 함께 제공되는 풍미 가득한 치킨 카레');

-- 두 번째 식사 옵션 추가
INSERT INTO flight_meal (meal_code, menu) VALUES (2, '비건 스페셜 - 채식주의자를 위한 특별 준비된 신선한 야채와 곡물로 만든 식사');

-- 세 번째 식사 옵션 추가
INSERT INTO flight_meal (meal_code, menu) VALUES (3, '스테이크와 감자 - 고급스러운 스테이크와 함께 제공되는 구운 감자');



---
--기프트카드 50만원 1개 생성

---
INSERT INTO GIFTCARD (
    CARD_NUM, 
    message, 
    PIN_NUM, 
    Recipient, 
    Recipient_PNUM, 
    SENDER, 
    SENDER_PNUM, 
    amount
) VALUES (
    '1234-5678-9012-3456',       -- 카드 번호
    '축하합니다!',               -- 메시지
    123456,                      -- PIN 번호
    '홍길동',                    -- 수령인
    '010-1234-5678',             -- 수령인 전화번호
    '김철수',                    -- 발송인
    '010-8765-4321',             -- 발송인 전화번호
    500000                       -- 금액 (50만원)
);

-- 구간 테이블 3개

INSERT INTO r_section VALUES ( '국내선', 'ICN, GMP, PUS, CJU, KWJ, TAE, RSU, USN, HIN, CJJ, KPO'
                              , 'ICN, GMP, PUS, CJU, KWJ, TAE, RSU, USN, HIN, CJJ, KPO');
INSERT INTO r_section VALUES ( '국제선 미주', 'ICN, GMP, PUS, CJU, KWJ, TAE, RSU, USN, HIN, CJJ, KPO'
                              , 'NYC, DFW, DTW, LAS, LAX, MSP, YVR, BOS, SFO, SEA, CHI, ATL, WAS, YYZ, HNL');   
INSERT INTO r_section VALUES ( '국제선 동북아시아', 'ICN, GMP, PUS, CJU, KWJ, TAE, RSU, USN, HIN, CJJ, KPO'
                             ,'KOJ, KHH, KMQ, CAN, KKJ, NGO, NKG, KIJ, DLC, TYO, MFM, PEK, CTS, SHA, XMN, SHE, SZX, XIY, AOJ, YNJ, YNT, KIX, OIT, OKA, URC, WUH, WEH, DYG, CGO, TNA, CSX, TAO, KMG, TPE, RMQ, TSN, HGH, HFE, HKG, TXN, FUK');

--수화물 규정

INSERT INTO l_rule VALUES ( 1, '일반석', 1, 0 , '국제선 동북아시아' );
INSERT INTO l_rule VALUES ( 2, '일반석', 2, 70000 , '국제선 동북아시아' );
INSERT INTO l_rule VALUES ( 3, '일반석', 3, 170000 , '국제선 동북아시아' );
INSERT INTO l_rule VALUES ( 4, '프레스티지석', 1, 0 , '국제선 동북아시아' );
INSERT INTO l_rule VALUES ( 5, '프레스티지석', 2, 0 , '국제선 동북아시아' );
INSERT INTO l_rule VALUES ( 6, '프레스티지석', 3, 100000 , '국제선 동북아시아' );
INSERT INTO l_rule VALUES ( 7, '일등석', 1, 0 , '국제선 동북아시아' );
INSERT INTO l_rule VALUES ( 8, '일등석', 2, 0 , '국제선 동북아시아' );
INSERT INTO l_rule VALUES ( 9, '일등석', 3, 0 , '국제선 동북아시아' );
INSERT INTO l_rule VALUES ( 10, '일등석', 4, 100000 , '국제선 동북아시아' );

INSERT INTO l_rule VALUES ( 11, '일반석', 1, 0 , '국제선 미주' );
INSERT INTO l_rule VALUES ( 12, '일반석', 2, 0 , '국제선 미주' );
INSERT INTO l_rule VALUES ( 13, '일반석', 3, 200000 , '국제선 미주' );
INSERT INTO l_rule VALUES ( 14, '프레스티지석', 1, 0 , '국제선 미주' );
INSERT INTO l_rule VALUES ( 15, '프레스티지석', 2, 0 , '국제선 미주' );
INSERT INTO l_rule VALUES ( 16, '프레스티지석', 3, 200000 , '국제선 미주' );
INSERT INTO l_rule VALUES ( 17, '일등석', 1, 0 , '국제선 미주' );
INSERT INTO l_rule VALUES ( 18, '일등석', 2, 0 , '국제선 미주' );
INSERT INTO l_rule VALUES ( 19, '일등석', 3, 0 , '국제선 미주' );
INSERT INTO l_rule VALUES ( 20, '일등석', 4, 200000 , '국제선 미주' );

--라운지 정보
INSERT INTO lounge_info (lounge_num, lounge_name, destination_airport, country, location, operating_time, operator, entry_passenger, service)
VALUES ( 1,'KAL 일등석 라운지', '서울/인천', '대한민국','(제 2여객 터미널,출국심사 후)248 Gate 맞은편 위층(4F)', 'º 요일 : 매일
 º 시간 : 04:00 ~ 22:00 ', '직영', '일등석 승객' ,'음료, 스낵, 독서물, 텔레비전, 팩스, 무선 인터넷, 노트북 포트, 프린터, 회의실, 샤워시설, 주류');
INSERT INTO lounge_info (lounge_num, lounge_name, destination_airport, country, location, operating_time, operator, entry_passenger, service)
VALUES ( 2,'KAL 라운지(국제선)', '서울/김포', '대한민국','대한민국, 출국장 내 4층(보안 검색 및 출국심사 후)', 'º 요일 : 매일
 º 시간 : 06:20 ~ 20:05 º 라운지 운영 시간은 항공기 운항 스케줄에 따라 변동될 수 있습니다.', '직영', 'º 프레스티지 클래스 승객 º 대한항공 밀리언 마일러 클럽 승객
 º 대한항공 모닝캄 프리미엄 클럽 승객 º 스카이팀 엘리트 플러스 승객 º 대한항공 모닝캄 클럽 승객 (라운지 좌석 상황에 따라 입장 제한)' 
 ,'음료, 스낵, 독서물, 텔레비전, 팩스, 무선 인터넷, 노트북 포트, 프린터, 주류');
INSERT INTO lounge_info (lounge_num, lounge_name, destination_airport, country, location, operating_time, operator, entry_passenger, service)
VALUES ( 3,'KAL 라운지', '도쿄/나리타', '동북아시아','제1 터미널 출국심사 후 26번 GATE 근처에 위치', 'º 요일 : 매일
 º 시간 : 07:15 ~ 20:30 º 최종 접수 시간 : 종료 시간 20분전', '직영', 'º 일등석 승객 º 프리스티지 클래스 승객 º 대한항공 밀리언 마일러 클럽 승객 º 대한항공 모닝캄 프리미엄 클럽 승객
 º 스카이팀 엘리트 플러스 승객 º 대한항공 모닝캄 클럽 승객 (라운지 좌석 상황에 따라 입장 제한)' ,'음료, 스낵, 텔레비전, 무선 인터넷, 주류');
INSERT INTO lounge_info (lounge_num, lounge_name, destination_airport, country, location, operating_time, operator, entry_passenger, service)
VALUES ( 4,'중국국제항공 라운지', '베이징/서우두(PEK)', '동북아시아','터미널2,보안검색지역 통과 후 면세지역','<º 요일 : 화, 목, 토
 º 시간 : 07:40 ~ 10:40> <º 요일 : 월, 수, 금, 일 º 시간 : 07:50 ~ 10:50> <º 요일 : 매일 º 시간 : 08:45 ~ 11:45> <º 요일 : 월, 수, 금, 일 º 시간 : 11:15 ~ 14:15>
 <º 요일 : 월, 수, 금, 일 º 시간 : 15:55 ~ 18:55> <º 요일 : 매일 º 시간 : 18:55 ~ 21:45>', '임차', 'º 일등석 승객 º 프리스티지 클래스 승객 º 대한항공 밀리언 마일러 클럽 승객
 º 대한항공 모닝캄 프리미엄 클럽 승객 º 스카이팀 엘리트 플러스 승객' ,'음료, 스낵, 독서물, 텔레비전, 무선 인터넷, 노트북 포트, 프린터, 주류');
INSERT INTO lounge_info (lounge_num, lounge_name, destination_airport, country, location, operating_time, operator, entry_passenger, service)
VALUES ( 5,'36번 동방항공 라운지', '상하이/푸동(PVG)', '동북아시아','보안검색지역 통과후 면세지역','º 요일 : 매일 º 시간 : 05:00 ~ 23:59', '임차'
 , 'º 일등석 승객 º 프리스티지 클래스 승객 º 대한항공 밀리언 마일러 클럽 승객 º 대한항공 모닝캄 프리미엄 클럽 승객 º 스카이팀 엘리트 플러스 승객' 
 ,'음료, 스낵, 독서물, 텔레비전, 전화, 팩스, 컴퓨터(인터넷 가능), 무선 인터넷, 프린터, 수면실, 샤워시설, 주류');
INSERT INTO lounge_info (lounge_num, lounge_name, destination_airport, country, location, operating_time, operator, entry_passenger, service)
VALUES ( 6,'중화항공 라운지', '타이베이/타오위엔(TPE)', '동북아시아','제1 여객터미널, 출국장 3층 안전검사 통과 및 출국사열 후 오른쪽"A" 방향의 4층에 위치'
 ,'º 요일 : 매일 º 시간 : 05:30 ~ 23:30', '임차', 'º 일등석 승객 º 프리스티지 클래스 승객 º 대한항공 밀리언 마일러 클럽 승객 º 대한항공 모닝캄 프리미엄 클럽 승객
 º 스카이팀 엘리트 플러스 승객' ,'음료, 스낵, 독서물, 텔레비전, 팩스, 컴퓨터(인터넷 가능), 무선 인터넷, 노트북 포트, 수면실, 샤워시설, 주류');
INSERT INTO lounge_info (lounge_num, lounge_name, destination_airport, country, location, operating_time, operator, entry_passenger, service)
VALUES ( 7,'플라자 프리미엄 라운지', '홍콩(HKG)', '동북아시아','1번 탑승구 부근','º 요일 : 매일 º 시간 : 06:00 ~ 01:00 º 라운지 사용 시간 : 최대 3시간'
, '임차', 'º 일등석 승객 º 프리스티지 클래스 승객 º 대한항공 밀리언 마일러 클럽 승객 º 대한항공 모닝캄 프리미엄 클럽 승객
 º 스카이팀 엘리트 플러스 승객' ,'음료, 스낵, 텔레비전, 전화');
INSERT INTO lounge_info (lounge_num, lounge_name, destination_airport, country, location, operating_time, operator, entry_passenger, service)
VALUES ( 8,'스카이팀 라운지', '밴쿠버(YVR)', '미주','국제선 청사 탑승구 D54 근처에 위치','º 요일 : 매일 º 시간 : 07:30 ~ 02:00
 º 추가정보는 공식 웹사이트 참조 요망 http://www.skyteam.com/en/lounges/Vancouver 참조', '임차', 'º 프리스티지 클래스 승객 º 대한항공 밀리언 마일러 클럽 승객
 º 대한항공 모닝캄 프리미엄 클럽 승객 º 스카이팀 엘리트 플러스 승객 ※주류 제공으로 인해 19세 이상만 출입 가능( 단, 성인 동반자와는 입장 가능)' 
 ,'음료, 스낵, 팩스, 무선 인터넷, 노트북 포트, 프린터, 수면실, 샤워시설, 주류');

--서비스 센터 5개

INSERT INTO cservice VALUES ('82', '한국', '대한민국', '1588-2001', '02-2656-2001', '[국내선] 
한국어/영어 : 매일 07:00-19:00 
[국제선] 
한국어 : 매일 07:00-22:00 
영어 : 매일 24시간 
일본어 : 매일 09:00-19:00(일본 현지시간 기준) 
중국어 : 매일 08:00-19:00(중국 현지시간 기준)','admin002');
INSERT INTO cservice VALUES ('81', '동북아시아', '일본', '0570-05-2001', '06-6648-8201', '한국어/영어 : 매일 24시간 
일본어 : 매일 09:00-19:00 
중국어 : 매일 08:00-19:00(중국 현지시간 기준)','admin002');
INSERT INTO cservice (cs_num, area, country_name, cs_call1,lang_time, adminid) VALUES ('852', '동북아시아', '홍콩', '2366-2001', '한국어/영어 : 매일 24시간 
일본어 : 매일 09:00-19:00(일본 현지시간 기준) 
중국어(보통화) : 매일 08:00-19:00(중국 현지시간 기준)','admin003');
INSERT INTO cservice (cs_num, area, country_name, cs_call1,lang_time, adminid) VALUES ('61', '대양주/괌', '호주', '02-9262-6000', '한국어/영어 : 매일 24시간 
일본어 : 매일 09:00-19:00(일본 현지시간 기준) 
중국어 : 매일 08:00-19:00(중국 현지시간 기준)','admin003');
INSERT INTO cservice VALUES ('7', '러시아/중앙아시아', '러시아', '(모스크바)8-800-500-2510(무료)', '(블라디보스토크)8-4232-433-444', '한국어/영어 : 매일 24시간 
일본어 : 매일 09:00-19:00(일본 현지시간 기준) 
중국어 : 매일 08:00-19:00(중국 현지시간 기준) 
* 현지어 선택 가능
현지어는 지점의 운영시간에 따라 서비스 제공 시간이 다릅니다.','admin002');

-- 약관
INSERT INTO Contract (Contract_code, Essentiality, Contract_title, Contract_contents)
VALUES (1, '필수', '이용약관', '제1장 총칙 제1조 (목적) 이 약관은 ㈜대한항공(이하 "대한항공"이라 합니다)이 운영하는 대한항공 온라인 플랫폼에서 제공하는 온라인 서비스(이하 "서비스"라 합니다)를 이용함에 있어 대한항공과 이용자의 권리· 및 의무 및 책임사항을 규정함을 목적으로 합니다.');
INSERT INTO Contract (Contract_code, Essentiality, Contract_title, Contract_contents)
VALUES (2, '필수', '개인정보 수집 및 이용 동의', '회원의 개인정보 수집 및 이용에 대한 동의 사항');
INSERT INTO Contract (Contract_code, Essentiality, Contract_title, Contract_contents)
VALUES (3, '선택', '개인정보 제3자 제공 동의', '회원의 개인정보보호를 위한 이용자 동의 사항');
INSERT INTO Contract (Contract_code, Essentiality, Contract_title, Contract_contents)
VALUES (4, '선택', '마케팅 광고 활용 및 수신 동의', '마케팅 광고 활용 동의
대한항공은 광고성 정보(이벤트, 혜택) 제공을 위해 휴대전화 번호, 이메일 주소, 우편물 수령지(자택, 직장), 회사정보(회사명, 부서명, 직위)를 수집합니다.');
INSERT INTO Contract (Contract_code, Essentiality, Contract_title, Contract_contents)
VALUES (5, '선택', '뉴스레터', '내용없음');
INSERT INTO Contract (Contract_code, Essentiality, Contract_title, Contract_contents)
VALUES (6, '선택', '프로모션 정보', '내용없음');
INSERT INTO Contract (Contract_code, Essentiality, Contract_title, Contract_contents)
VALUES (7, '선택', '이메일', '내용없음');
INSERT INTO Contract (Contract_code, Essentiality, Contract_title, Contract_contents)
VALUES (8, '선택', 'SMS', '내용없음');


-- 약관 동의 여부
INSERT INTO yesno (Contrat_num, agree, Agree_date, UserID, Contract_code)
VALUES ('1', '동의', TO_DATE('2024.03.08', 'YYYY.MM.DD'), 'user001', 1);
INSERT INTO yesno (Contrat_num, agree, Agree_date, UserID, Contract_code)
VALUES ('2', '동의', TO_DATE('2024.03.08', 'YYYY.MM.DD'), 'user001', 2);
INSERT INTO yesno (Contrat_num, agree, Agree_date, UserID, Contract_code)
VALUES ('3', '동의', TO_DATE('2024.03.08', 'YYYY.MM.DD'), 'user001', 3);
INSERT INTO yesno (Contrat_num, agree, Agree_date, UserID, Contract_code)
VALUES ('4', '동의', TO_DATE('2024.03.08', 'YYYY.MM.DD'), 'user001', 4);
INSERT INTO yesno (Contrat_num, agree, Agree_date, UserID, Contract_code)
VALUES ('5', '동의', TO_DATE('2024.03.08', 'YYYY.MM.DD'), 'user001', 5);
INSERT INTO yesno (Contrat_num, agree, Agree_date, UserID, Contract_code)
VALUES ('6', '동의', TO_DATE('2024.03.08', 'YYYY.MM.DD'), 'user001', 6);
INSERT INTO yesno (Contrat_num, agree, Agree_date, UserID, Contract_code)
VALUES ('7', '동의', TO_DATE('2024.03.08', 'YYYY.MM.DD'), 'user001', 7);
INSERT INTO yesno (Contrat_num, agree, Agree_date, UserID, Contract_code)
VALUES ('8', '동의', TO_DATE('2024.03.08', 'YYYY.MM.DD'), 'user001', 8);

--기프트 카드 사용 내역

INSERT INTO CARD_USE VALUES (1,'등록',TO_DATE('2024-03-07','YYYY-MM-DD'),500000,'1234-5678-9012-3456');

-- 약관용 수열
create sequence yesnoseq
start with 1 increment by 1 nomaxvalue nocycle;

--회원가입 프로시저
create or replace procedure mk_flightuser_01 
(
    UI flightuser.userid%type,
    kl flightuser.Korlastname%type ,
    kf flightuser.Korfirstname%type ,
    lne flightuser.lastname%type,
    fn flightuser.firstname%type ,
    pw flightuser.password%type ,
    bd  flightuser.birthdate%type ,
    gd flightuser.gender%type ,
    ea1 flightuser.emailaddress%type ,
    pn flightuser.phoneNumber%type  ,
    at1 flightuser.Anation%type,
    spn flightuser.Skypassnumber%type,
    ct1 contract.contract_code%type,
    ct2 contract.contract_code%type
)
is
  vui flightuser.userid%type;
begin
    if ct1<>12 then 
        raise_application_error(-20003,' 필수 약관 미동의 회원가입 진행 불가');
     end if;
      select userid into vui from flightuser where userid=ui ;
     if ui=vui then
        raise_application_error(-20002,' 유저Id 중복 오류');
    end if;
    exception 
        when no_data_found then
       insert into flightuser values ( ui,kl,kf,lne,fn,pw,bd,gd,ea1,pn,at1,spn);
       insert into yesno values ( yesnoseq.nextval,'동의',to_char(sysdate,'yyyy-mm-dd'),ui,1);
       insert into yesno values ( yesnoseq.nextval,'동의',to_char(sysdate,'yyyy-mm-dd'),ui,2);
       insert into yesno values ( yesnoseq.nextval,decode(instr(ct2,'3'),0,'거부','동의'),to_char(sysdate,'yyyy-mm-dd'),ui,3);
       insert into yesno values ( yesnoseq.nextval,decode(instr(ct2,'4'),0,'거부','동의'),to_char(sysdate,'yyyy-mm-dd'),ui,4);
       insert into yesno values ( yesnoseq.nextval,decode(instr(ct2,'5'),0,'거부','동의'),to_char(sysdate,'yyyy-mm-dd'),ui,5);
end;

--회원 탈퇴 프로시저
create or replace procedure mk_flightuser_02
 (
    UI flightuser.userid%type 
 )
 is 

 begin
   delete flightuser
   where userid=ui;
 end;
 
 --로그인 프로시저
 create or replace procedure mk_flightuser_03
 (
   ui flightuser.userid%type ,
   pw flightuser.password%type
 )
 is
     vui flightuser.userid%type;
    vpw flightuser.password%type;
 begin
        select  password into vpw from flightuser where userid=ui;
        if vpw <> pw then
        raise_application_error(-20006,'비밀번호가 일치하지 않습니다.');
        end if;
        execute immediate 'grant generaluser to project1';
        dbms_output.put_line('로그인에 성공하였습니다');
        exception
            when no_data_found then 
            raise_application_error(-20007,'아이디가 존재하지 않습니다.');
end;


select * from user_role_privs;
exec mk_flightuser_01('user006', '홍', '길동', 'Hong', 'GilDong', 'password123', TO_DATE('1990-01-01', 'YYYY-MM-DD'), 'Male', 'user001@example.com', '01012345678', 'Korea', '1234-5678-9012-3456',2,35);
exec mk_flightuser_02('user006');

exec mk_flightuser_03('user001','password123');

set serveroutput on;

--예약 가능 일정 조회 프로시저 (국내선)
create or replace procedure mk_scplane_01
(
    dap scplane.dairport%type,
    aap scplane.aairport%type,
    dd scplane.ddate%type,
    anum number,
    sgrade seat_num.seat_grade%type
)
is
 cursor vreserv is
 select to_char(s.ddate,'yy/mm/dd hh24:mi') 출발시각, to_char(s.adate,'yy/mm/dd hh24:mi') 도착시각, 
 to_char(to_number(to_char(s.adate , 'hh24')) -to_number(to_char(s.ddate , 'hh24')) )||'시간' || to_char(to_number(to_char(s.adate , 'mi')) -to_number(to_char(s.ddate , 'mi'))) || '분' 소요시간,
 substr(dairport,instr(dairport,'.')+1) 출발공항,
 substr(aairport,instr(aairport,'.')+1) 도착공항,
 a.FCLA_COUNT -(select count(p.renum) from scplane s,airplane a ,payrefund p,seat_num sn where s.asnum=a.asnum and s.renum=p.renum and sn.asnum=s.asnum and sn.seat_num=p.seatnumber and substr(s.dairport,1,instr(s.dairport,'.')-1)=dap and substr(s.aairport,1,instr(s.aairport,'.')-1)=aap and to_char(s.ddate,'yymmdd')=dd and sn.seat_grade='일등석'
) 남은일등석수 ,
a.PreCLA_COUNT -(select count(p.renum)   from scplane s,airplane a ,payrefund p,seat_num sn where s.asnum=a.asnum and s.renum=p.renum and sn.asnum=s.asnum and sn.seat_num=p.seatnumber and substr(s.dairport,1,instr(s.dairport,'.')-1)=dap and substr(s.aairport,1,instr(s.aairport,'.')-1)=aap and to_char(s.ddate,'yymmdd')=dd and sn.seat_grade='프레스티지석'
) 남은프레스티지석수 , 
a.NCLA_COUNT -(select count(p.renum)  from scplane s,airplane a ,payrefund p,seat_num sn where s.asnum=a.asnum and s.renum=p.renum and sn.asnum=s.asnum and sn.seat_num=p.seatnumber and substr(s.dairport,1,instr(s.dairport,'.')-1)=dap and substr(s.aairport,1,instr(s.aairport,'.')-1)=aap and to_char(s.ddate,'yymmdd')=dd and sn.seat_grade='일반석'
) 남은일반석수, 
d.fare 정상운임 from scplane s,airplane a , dfare d 
where s.asnum=a.asnum 
and substr(s.dairport,1,instr(s.dairport,'.')-1)=dap and substr(s.aairport,1,instr(s.aairport,'.')-1)=aap 
and to_char(s.ddate,'yymmdd')=dd and d.peak = CASE
        WHEN to_char(s.ddate, 'yymmdd') = to_date('240101','yymmdd') THEN '성수기'
        WHEN to_char(s.ddate, 'yymmdd') BETWEEN to_date('240208','yymmdd') AND to_date('240213','yymmdd') THEN '성수기'
        WHEN to_char(s.ddate, 'yymmdd') BETWEEN to_date('240224','yymmdd') AND to_date('240302','yymmdd') THEN '성수기'
        WHEN to_char(s.ddate, 'yymmdd') BETWEEN to_date('240503','yymmdd') AND to_date('240506','yymmdd') THEN '성수기'
        WHEN to_char(s.ddate, 'yymmdd') = to_date('240515','yymmdd') THEN '성수기'
        WHEN to_char(s.ddate, 'yymmdd') BETWEEN to_Date('240606','yymmdd') AND to_date('240608','yymmdd') THEN '성수기'
        WHEN to_char(s.ddate, 'yymmdd') BETWEEN to_Date('240727','yymmdd') AND to_date('240824','yymmdd') THEN '성수기'
        WHEN to_char(s.ddate, 'yymmdd') BETWEEN to_Date('240913','yymmdd')AND to_Date('240919','yymmdd') THEN '성수기'
        WHEN to_char(s.ddate, 'yymmdd') BETWEEN to_Date('241003','yymmdd') AND to_Date('241005','yymmdd') THEN '성수기'
        WHEN to_char(s.ddate, 'yymmdd') = to_Date('241009','yymmdd') THEN '성수기'
        WHEN to_char(s.ddate, 'yymmdd') = to_Date('241225','yymmdd') THEN '성수기'
        WHEN to_char(s.ddate, 'yymmdd') = to_Date('241231','yymmdd') THEN '성수기'
        else '비수기'
        end
    and d.discount = '정상' and d.sg=sgrade and substr(d.route,1,instr(d.route,'/')-1)=dap and substr(d.route,instr(d.route,'-')+1,instr(d.route,'/',-1)-instr(d.route,'-')-1)=aap and 
      d.timezone = case when to_char( s.ddate , 'hh24mi') >= '1500' then '일반' else '선호' end  and d.wknddy  = case to_char(s.ddate , 'dy') when '월' then '주중' when '화' then '주중' when '수' then '주중' when '목' then '주중' else '주말' end;

begin
        for rec in vreserv loop 
            dbms_output.put_line('출발시각 :'|| rec.출발시각 || ' 도착시각 : ' ||rec.도착시각 || ' 출발공항 :'|| rec.출발공항 ||' 도착공항 :'||rec.도착공항 || ' 소요시간 : '|| rec.소요시간 ||' 정상 운임 : ' ||rec.정상운임 ||' 남은 일등석 갯수 :'|| rec.남은일등석수 ||' 남은 프레스티지석 갯수 :'||rec.남은프레스티지석수||' 남은 일반석 갯수 :'|| rec.남은일반석수  );
        end loop;

        
end;

exec mk_scplane_01 ('SEOUL','JEJU','240328',1,'일반석');
exec mk_scplane_01 ('SEOUL','JEJU','240323',1,'일반석');
exec mk_scplane_01 ('SEOUL','JEJU','240410',1,'일반석');
--
--예약 (결제 ) 기능 
drop sequence mk_payrefundseq;
     create sequence mk_payrefundseq 
     start with 1 increment by 1 ;
create or replace procedure mk_payrefund_01
(
    pddate varchar2,
    pdairport scplane.dairport%type,
    paairport scplane.aairport%type,
    pseatnum payrefund.seatnumber%type default null,
    pnum number,
    pflight payrefund.flight%type,
    ppmethod payrefund.pmethod%type,
    pnluggage payrefund.nluggage%type
)

is
    vrenum scplane.renum%type;
    vcost payrefund.cost%type;
    
begin
    select renum  into vrenum from scplane s where to_char(s.ddate ,'YYMMDDhh24mi') =pddate
    and substr(s.dairport,instr(s.dairport,'.')+1) = pdairport and  substr(s.aairport,instr(s.aairport,'.')+1) = paairport ;
    select d.fare 정상운임 into vcost from scplane s,dfare d 
where s.renum=vrenum and d.peak = CASE
        WHEN to_char(s.ddate, 'yymmdd') = to_date('240101','yymmdd') THEN '성수기'
        WHEN to_char(s.ddate, 'yymmdd') BETWEEN to_date('240208','yymmdd') AND to_date('240213','yymmdd') THEN '성수기'
        WHEN to_char(s.ddate, 'yymmdd') BETWEEN to_date('240224','yymmdd') AND to_date('240302','yymmdd') THEN '성수기'
        WHEN to_char(s.ddate, 'yymmdd') BETWEEN to_date('240503','yymmdd') AND to_date('240506','yymmdd') THEN '성수기'
        WHEN to_char(s.ddate, 'yymmdd') = to_date('240515','yymmdd') THEN '성수기'
        WHEN to_char(s.ddate, 'yymmdd') BETWEEN to_Date('240606','yymmdd') AND to_date('240608','yymmdd') THEN '성수기'
        WHEN to_char(s.ddate, 'yymmdd') BETWEEN to_Date('240727','yymmdd') AND to_date('240824','yymmdd') THEN '성수기'
        WHEN to_char(s.ddate, 'yymmdd') BETWEEN to_Date('240913','yymmdd')AND to_Date('240919','yymmdd') THEN '성수기'
        WHEN to_char(s.ddate, 'yymmdd') BETWEEN to_Date('241003','yymmdd') AND to_Date('241005','yymmdd') THEN '성수기'
        WHEN to_char(s.ddate, 'yymmdd') = to_Date('241009','yymmdd') THEN '성수기'
        WHEN to_char(s.ddate, 'yymmdd') = to_Date('241225','yymmdd') THEN '성수기'
        WHEN to_char(s.ddate, 'yymmdd') = to_Date('241231','yymmdd') THEN '성수기'
        else '비수기'
        end
    and d.discount = '정상' and substr(d.route,instr(d.route,'/')+1,instr(d.route,'-')-instr(d.route,'/')-1)=pdairport and substr(d.route,instr(d.route,'/',-1)+1)=paairport and 
      d.timezone = case when to_char( s.ddate , 'hh24mi') >= '1500' then '일반' else '선호' end  and d.wknddy  = case to_char(s.ddate , 'dy') when '월' then '주중' when '화' then '주중' when '수' then '주중' when '목' then '주중' else '주말' end;

    insert into payrefund  values
    (mk_payrefundseq.nextval, '결제', ppmethod , pflight, pseatnum ,sysdate, pnluggage ,vcost,0 ,'user001', vrenum);
    dbms_output.put_line('예약이 완료되었습니다.');
    exception
        when no_data_found then
        dbms_output.put_line('예약가능한 일정이 없습니다');
end;

exec mk_payrefund_01('2403200930','GMP','CJU','20A',1,'정상','카드',1);
select * from payrefund;
select to_char(ddate,'hh24mi') from scplane;
delete payrefund where 1=1;
-- 예약 결제 행 업데이트 후 
create or replace trigger tr_mk_payrefund_01
before insert on payrefund
for each row
begin
    if select pmethod 
end;

-- 지역별 서비스 조회쿼리
CREATE OR REPLACE PROCEDURE se_cservice_01
(
 parea cservice.area%TYPE
)
IS
BEGIN
 FOR vrow IN ( SELECT * 
 FROM cservice
 WHERE area = parea)
 LOOP
 IF vrow.cs_call2 IS NULL THEN
 DBMS_OUTPUT.PUT_LINE(vrow.country_name||'('||vrow.cs_num||')');
 DBMS_OUTPUT.PUT_LINE('전화번호 : ' || vrow.cs_call1);
 DBMS_OUTPUT.PUT_LINE('언어/시간 : ' || vrow.lang_time);
 DBMS_OUTPUT.PUT_LINE(' ');
 ELSE
 DBMS_OUTPUT.PUT_LINE(vrow.country_name||'('||vrow.cs_num||')');
 DBMS_OUTPUT.PUT_LINE('전화번호 : ' || vrow.cs_call1 || ',' || vrow.cs_call2);
 DBMS_OUTPUT.PUT_LINE('언어/시간 : ' || vrow.lang_time);
 DBMS_OUTPUT.PUT_LINE(' ');
 END IF;
 END LOOP;
END;

EXEC SE_CSERVICE_01('한국');
EXEC SE_CSERVICE_01('동북아시아');

-- 공지사항 수정을 위한 프로시저
CREATE OR REPLACE PROCEDURE ye_Notice_01(
    p_Notice_num IN VARCHAR2,
    p_New_Title IN VARCHAR2
)
AS
BEGIN
    UPDATE Notice
    SET Notice_title = p_New_Title
    WHERE Notice_num = p_Notice_num;
    
    -- 수정된 데이터 출력
    DBMS_OUTPUT.PUT_LINE('Notice_num: ' || p_Notice_num || ', Notice_title: ' || p_New_Title || ' - 제목이 성공적으로 변경되었습니다.');
    
    COMMIT;
END;
-- 공지사항 생성을 위한 프로시저
CREATE OR REPLACE PROCEDURE ye_Notice_01(
    p_Notice_num IN VARCHAR2,
    p_Notice_title IN VARCHAR2,
    p_Notice_contents IN CLOB,
    p_Notice_topic IN VARCHAR2,
    p_AdminID IN VARCHAR2
)
AS
BEGIN
    INSERT INTO Notice (Notice_num, Notice_title, Notice_contents, Notice_topic, AdminID)
    VALUES (p_Notice_num, p_Notice_title, p_Notice_contents, p_Notice_topic, p_AdminID);
    DBMS_OUTPUT.PUT_LINE('"새로운 공지사항이 추가되었습니다."');
    COMMIT;
END;


SET SERVEROUTPUT ON;
BEGIN
    ye_Notice_01('10', '새로운 공지사항', '새로운 내용', '새로운 주제', 'admin003');
END;
/
SET SERVEROUTPUT ON;
DECLARE
    notice_cursor SYS_REFCURSOR;
BEGIN
    ye_Notice_02('10', notice_cursor);
END;


-- 공지사항 조회을 위한 프로시저
CREATE OR REPLACE PROCEDURE ye_Notice_02(
    p_Notice_num IN VARCHAR2,
    p_Notice OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN p_Notice FOR
    SELECT *
    FROM Notice
    WHERE Notice_num = p_Notice_num;
    DBMS_OUTPUT.PUT_LINE('"공지사항을 출력했습니다."');
    FOR notice_rec IN (SELECT * FROM Notice WHERE Notice_num = p_Notice_num) LOOP
        DBMS_OUTPUT.PUT_LINE('Notice_num: ' || notice_rec.Notice_num || ', Notice_title: ' || notice_rec.Notice_title || ', Notice_contents: ' || notice_rec.Notice_contents || ', Notice_topic: ' || notice_rec.Notice_topic || ', AdminID: ' || notice_rec.AdminID);
    END LOOP;
END;
SET SERVEROUTPUT ON;
DECLARE
    notice_cursor SYS_REFCURSOR;
BEGIN
    ye_Notice_02('1', notice_cursor);
END;

-- 공지사항 수정을 위한 프로시저
CREATE OR REPLACE PROCEDURE ye_Notice_03(
    p_Notice_num IN VARCHAR2,
    p_New_Title IN VARCHAR2
)
AS
BEGIN
    UPDATE Notice
    SET Notice_title = p_New_Title
    WHERE Notice_num = p_Notice_num;
    DBMS_OUTPUT.PUT_LINE('Notice_num: ' || p_Notice_num || ', Notice_title: ' || p_New_Title || ' - 제목이 성공적으로 변경되었습니다.');
    COMMIT;
END;

SET SERVEROUTPUT ON;
BEGIN
    UpdateNoticeTitle('1', '세관신고 절차 복잡다난해짐');
END;


-- 공지사항 삭제를 위한 프로시저
CREATE OR REPLACE PROCEDURE ye_Notice_04(
    p_Notice_num IN VARCHAR2
)
AS
BEGIN
    DELETE FROM Notice
    WHERE Notice_num = p_Notice_num;
    DBMS_OUTPUT.PUT_LINE('"공지사항이 삭제되었습니다."');
    COMMIT;
END;

SET SERVEROUTPUT ON;
BEGIN
    ye_Notice_04('3');
END;

--국제선 기본운임 작성 쿼리
--EXEC  up_createifare('ICN', 'FUK', '일반석', 150000, 110000, 20300, 21000, 'admin004');
--                    (keynum, starta, arrive, sg, fare, redis, tax, fuelch, adminid)

CREATE OR REPLACE PROCEDURE up_createifare (
    
    p_starta IN VARCHAR2,
    p_arrive IN VARCHAR2,
    p_sg IN VARCHAR2,
    p_fare IN NUMBER,
    p_redis IN NUMBER,
    p_tax IN NUMBER,
    p_fuelch IN NUMBER,
    p_adminid IN VARCHAR2
    )
IS
    v_admin_count NUMBER;
    v_keynum ifare.keynum%TYPE;
BEGIN
    -- 관리자 권한 확인
    SELECT COUNT(*)
    INTO v_admin_count
    FROM Adminstrator
    WHERE AdminID = p_adminid;

    IF v_admin_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('해당 관리자는 권한이 없습니다.');
        RETURN;
    END IF;

    -- KEYNUM 값 한개씩 증가
    SELECT NVL(MAX(keynum), 0) + 1 INTO v_keynum FROM ifare;

    -- 운임 정보 작성
    INSERT INTO ifare (keynum, starta, arrive, sg, fare, redis, tax, fuelch, adminid)
    VALUES (v_keynum, p_starta, p_arrive, p_sg, p_fare, p_redis, p_tax, p_fuelch, p_adminid);
    DBMS_OUTPUT.PUT_LINE('운임 정보가 성공적으로 추가되었습니다.');
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('해당하는 관리자가 없습니다.');
END;

------------------------------------------------------------------------------
SELECT *
FROM ifare;
EXEC up_updateifare(3, NULL, NULL, '쮸쀼', NULL, NULL, NULL, NULL, 'admin005');

--국제선 운임 테이블 수정쿼리
--EXEC up_updateifare(3, 'IC', 'FU', '반석', 333333, 333333, 33333, 33333, 'admin001');
--                   (keynum, starta, arrive, sg, fare, redis, tax, fuelch, adminid)
--EXEC up_updateifare(3, NULL, NULL, '쮸쀼', NULL, NULL, NULL, NULL, 'admin005');
--                  일부만 수정하고싶을때에는 NULL값을 준다.
--                  수정의 경우 adminid는 권한확인에만 쓰임
CREATE OR REPLACE PROCEDURE up_updateifare (
    p_keynum IN NUMBER,
    p_starta IN VARCHAR2 DEFAULT NULL,
    p_arrive IN VARCHAR2 DEFAULT NULL,
    p_sg IN VARCHAR2 DEFAULT NULL,
    p_fare IN NUMBER DEFAULT NULL,
    p_redis IN NUMBER DEFAULT NULL,
    p_tax IN NUMBER DEFAULT NULL,
    p_fuelch IN NUMBER DEFAULT NULL,
    p_adminid IN VARCHAR2
)
IS
    v_admin_count NUMBER;
BEGIN
    -- 관리자 권한 확인
    SELECT COUNT(*)
    INTO v_admin_count
    FROM Adminstrator
    WHERE AdminID = p_adminid;

    IF v_admin_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('해당 관리자는 권한이 없습니다.');
        RETURN;
    END IF;

    -- 매개변수가 NULL이 아니면 해당 값으로 수정
    UPDATE ifare
    SET starta = COALESCE(p_starta, starta),
        arrive = COALESCE(p_arrive, arrive),
        sg = COALESCE(p_sg, sg),
        fare = COALESCE(p_fare, fare),
        redis = COALESCE(p_redis, redis),
        tax = COALESCE(p_tax, tax),
        fuelch = COALESCE(p_fuelch, fuelch)
    WHERE keynum = p_keynum;
    
    DBMS_OUTPUT.PUT_LINE('운임 정보가 성공적으로 수정되었습니다.');
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('해당하는 관리자가 없습니다.');
END;
------------------------------------------------------------------------------
--국제선 운임 테이블 삭제 프로시저
--EXEC up_deleteifare(3, 'admin001');
CREATE OR REPLACE PROCEDURE up_deleteifare (
    p_keynum IN ifare.keynum%TYPE,
    p_adminid IN VARCHAR2
)
IS
    v_admin_count NUMBER;
BEGIN
    -- 관리자 권한 확인
    SELECT COUNT(*)
    INTO v_admin_count
    FROM Adminstrator
    WHERE AdminID = p_adminid;

    IF v_admin_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('해당 관리자는 권한이 없습니다.');
        RETURN;
    END IF;

    -- 운임 정보 삭제
    DELETE FROM ifare
    WHERE keynum = p_keynum;
    DBMS_OUTPUT.PUT_LINE('운임 정보가 성공적으로 삭제되었습니다.');
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('해당하는 운임 정보가 없습니다.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('운임 정보를 삭제하는 도중 오류가 발생했습니다.');
END;



delete yesno
where userid='user006';
delete flightuser
where userid='user006';

drop sequence yesnoseq;
select * from yesno;
select * from flightuser;


commit;
delete flightuser
where userid='user007';

SELECT * FROM SCPLANE;
SELECT * FROM FLIGHTUSER;
select * from adminstrator;
select * from dfare;
select * from ifare;
select * from notice;
select * from airplane;
SELECT * FROM S_Grade;
SELECT * FROm Rfamily;
SELECT * FROM userdetail;
SELECT * fROM Mtracking;
select * from CARD_USE;