CREATE TABLE "Member" (
	"user_id"	VARCHAR2(100)		NOT NULL,
	"user_name"	VARCHAR2(100)		NOT NULL,
	"user_email_address"	VARCHAR2(100)		NOT NULL,
	"user_birthday"	date	DEFAULT sysdate	NOT NULL,
	"user_nickname"	VARCHAR2(100)		NOT NULL,
	"user_password"	VARCHAR2(100)		NOT NULL
);

COMMENT ON COLUMN "Member"."user_id" IS '투표자를식별할ID';

COMMENT ON COLUMN "Member"."user_name" IS '회원의 이름';

COMMENT ON COLUMN "Member"."user_email_address" IS '회원의 이메일 주소';

COMMENT ON COLUMN "Member"."user_birthday" IS '회원의 생년월일';

COMMENT ON COLUMN "Member"."user_nickname" IS '회원의 닉네임';

COMMENT ON COLUMN "Member"."user_password" IS '회원의 비밀번호';

CREATE TABLE "Vote" (
	"member_id"	VARCHAR2(60)		NOT NULL,
	"SURVEY_NUM"	NUMBER(2)		NOT NULL,
	"CHOICE_NUM"	NUMBER(1)	DEFAULT 1	NOT NULL
);

CREATE TABLE "Survey" (
	"SURVEY_NUM"	NUMBER(4)		NOT NULL,
	"TITLE"	VARCHAR2(100)		NOT NULL,
	"START_DATE"	DATE	DEFAULT SYSDATE	NOT NULL,
	"END_DATE"	DATE	DEFAULT SYSDATE+7	NOT NULL,
	"COL_COUNT"	NUMBER(1)		NOT NULL,
	"WRITE_DATE"	DATE	DEFAULT SYSDATE	NOT NULL
);

CREATE TABLE "Edit" (
	"SURVERY_NUM"	NUMBER(4)		NOT NULL,
	"Key"	varchar2(100)		NOT NULL
);

CREATE TABLE "Administrator" (
	"Key"	varchar2(100)		NOT NULL,
	"name"	varchar2(100)		NOT NULL,
	"emailAddress"	varchar2(100)		NOT NULL,
	"birthdate"	date	DEFAULT sysdate	NOT NULL,
	"nickname"	varchar2(80)		NOT NULL,
	"password"	varchar2(100)		NOT NULL
);

CREATE TABLE "Item" (
	"SURVEY_NUM"	NUMBER(2)		NOT NULL,
	"CHOICE1"	varchar2(100)	DEFAULT 1번	NOT NULL,
	"CHOICE2"	varchar2(100)	DEFAULT 2번	NULL,
	"CHOICE3"	varchar2(100)	DEFAULT 3번	NULL,
	"CHOICE4"	varchar2(100)	DEFAULT 4번	NULL,
	"CHOICE5"	varchar2(100)	DEFAULT 5번	NULL
);

ALTER TABLE "Member" ADD CONSTRAINT "PK_MEMBER" PRIMARY KEY (
	"user_id"
);

ALTER TABLE "Vote" ADD CONSTRAINT "PK_VOTE" PRIMARY KEY (
	"member_id",
	"SURVEY_NUM"
);

ALTER TABLE "Survey" ADD CONSTRAINT "PK_SURVEY" PRIMARY KEY (
	"SURVEY_NUM"
);

ALTER TABLE "Edit" ADD CONSTRAINT "PK_EDIT" PRIMARY KEY (
	"SURVERY_NUM",
	"Key"
);

ALTER TABLE "Administrator" ADD CONSTRAINT "PK_ADMINISTRATOR" PRIMARY KEY (
	"Key"
);

ALTER TABLE "Item" ADD CONSTRAINT "PK_ITEM" PRIMARY KEY (
	"SURVEY_NUM"
);

ALTER TABLE "Vote" ADD CONSTRAINT "FK_Member_TO_Vote_1" FOREIGN KEY (
	"member_id"
)
REFERENCES "Member" (
	"user_id"
);

ALTER TABLE "Vote" ADD CONSTRAINT "FK_Survey_TO_Vote_1" FOREIGN KEY (
	"SURVEY_NUM"
)
REFERENCES "Survey" (
	"SURVEY_NUM"
);

ALTER TABLE "Edit" ADD CONSTRAINT "FK_Survey_TO_Edit_1" FOREIGN KEY (
	"SURVERY_NUM"
)
REFERENCES "Survey" (
	"SURVEY_NUM"
);

ALTER TABLE "Edit" ADD CONSTRAINT "FK_Administrator_TO_Edit_1" FOREIGN KEY (
	"Key"
)
REFERENCES "Administrator" (
	"Key"
);

ALTER TABLE "Item" ADD CONSTRAINT "FK_Survey_TO_Item_1" FOREIGN KEY (
	"SURVEY_NUM"
)
REFERENCES "Survey" (
	"SURVEY_NUM"
);
drop table administrator ;
drop table administrator ;
drop table administrator ;
