--------------------------------------------------------
--  파일이 생성됨 - 월요일-3월-04-2024   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table T_MEMBER
--------------------------------------------------------

  CREATE TABLE "SCOTT"."T_MEMBER" 
   (	"MEMBERSEQ" NUMBER(4,0), 
	"MEMBERID" VARCHAR2(20 BYTE), 
	"MEMBERPASSWD" VARCHAR2(20 BYTE), 
	"MEMBERNAME" VARCHAR2(20 BYTE), 
	"MEMBERPHONE" VARCHAR2(20 BYTE), 
	"MEMBERADDRESS" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "SCOTT"."T_MEMBER"."MEMBERSEQ" IS '회원SEQ';
   COMMENT ON COLUMN "SCOTT"."T_MEMBER"."MEMBERID" IS '회원아이디';
   COMMENT ON COLUMN "SCOTT"."T_MEMBER"."MEMBERPASSWD" IS '비밀번호';
   COMMENT ON COLUMN "SCOTT"."T_MEMBER"."MEMBERNAME" IS '회원명';
   COMMENT ON COLUMN "SCOTT"."T_MEMBER"."MEMBERPHONE" IS '휴대폰';
   COMMENT ON COLUMN "SCOTT"."T_MEMBER"."MEMBERADDRESS" IS '주소';
   COMMENT ON TABLE "SCOTT"."T_MEMBER"  IS '회원';
--------------------------------------------------------
--  DDL for Table T_POLLSUB
--------------------------------------------------------

  CREATE TABLE "SCOTT"."T_POLLSUB" 
   (	"POLLSUBSEQ" NUMBER(38,0), 
	"ANSWER" VARCHAR2(100 BYTE), 
	"ACOUNT" NUMBER(4,0), 
	"POLLSEQ" NUMBER(4,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "SCOTT"."T_POLLSUB"."POLLSUBSEQ" IS '답변항목SEQ';
   COMMENT ON COLUMN "SCOTT"."T_POLLSUB"."ANSWER" IS '답변항목';
   COMMENT ON COLUMN "SCOTT"."T_POLLSUB"."ACOUNT" IS '답변항목선택수';
   COMMENT ON COLUMN "SCOTT"."T_POLLSUB"."POLLSEQ" IS '설문SEQ';
   COMMENT ON TABLE "SCOTT"."T_POLLSUB"  IS '설문항목';
--------------------------------------------------------
--  DDL for Table T_POLL
--------------------------------------------------------

  CREATE TABLE "SCOTT"."T_POLL" 
   (	"POLLSEQ" NUMBER(4,0), 
	"QUESTION" VARCHAR2(256 BYTE), 
	"SDATE" DATE, 
	"EDATE" DATE, 
	"ITEMCOUNT" NUMBER(1,0) DEFAULT 1, 
	"POLLTOTAL" NUMBER(4,0), 
	"REGDATE" DATE DEFAULT sysdate, 
	"MEMBERSEQ" NUMBER(4,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "SCOTT"."T_POLL"."POLLSEQ" IS '설문SEQ';
   COMMENT ON COLUMN "SCOTT"."T_POLL"."QUESTION" IS '질문';
   COMMENT ON COLUMN "SCOTT"."T_POLL"."SDATE" IS '시작일';
   COMMENT ON COLUMN "SCOTT"."T_POLL"."EDATE" IS '종료일';
   COMMENT ON COLUMN "SCOTT"."T_POLL"."ITEMCOUNT" IS '답변항목수';
   COMMENT ON COLUMN "SCOTT"."T_POLL"."POLLTOTAL" IS '총참여수';
   COMMENT ON COLUMN "SCOTT"."T_POLL"."REGDATE" IS '작성일';
   COMMENT ON COLUMN "SCOTT"."T_POLL"."MEMBERSEQ" IS '작성자(회원SEQ)';
   COMMENT ON TABLE "SCOTT"."T_POLL"  IS '설문조사';
--------------------------------------------------------
--  DDL for Table T_VOTER
--------------------------------------------------------

  CREATE TABLE "SCOTT"."T_VOTER" 
   (	"VECTORSEQ" NUMBER, 
	"USERNAME" VARCHAR2(20 BYTE), 
	"REGDATE" DATE, 
	"POLLSEQ" NUMBER(4,0), 
	"POLLSUBSEQ" NUMBER(38,0), 
	"MEMBERSEQ" NUMBER(4,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "SCOTT"."T_VOTER"."VECTORSEQ" IS '투표SEQ';
   COMMENT ON COLUMN "SCOTT"."T_VOTER"."USERNAME" IS '사용자이름';
   COMMENT ON COLUMN "SCOTT"."T_VOTER"."REGDATE" IS '투표일';
   COMMENT ON COLUMN "SCOTT"."T_VOTER"."POLLSEQ" IS '설문SEQ';
   COMMENT ON COLUMN "SCOTT"."T_VOTER"."POLLSUBSEQ" IS '답변항목SEQ';
   COMMENT ON COLUMN "SCOTT"."T_VOTER"."MEMBERSEQ" IS '회원SEQ';
   COMMENT ON TABLE "SCOTT"."T_VOTER"  IS '투표자';
--------------------------------------------------------
--  DDL for Index PK_T_MEMBER
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."PK_T_MEMBER" ON "SCOTT"."T_MEMBER" ("MEMBERSEQ") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_T_POLLSUB
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."PK_T_POLLSUB" ON "SCOTT"."T_POLLSUB" ("POLLSUBSEQ") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_T_POLL
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."PK_T_POLL" ON "SCOTT"."T_POLL" ("POLLSEQ") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_T_VOTER
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."PK_T_VOTER" ON "SCOTT"."T_VOTER" ("VECTORSEQ") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table T_MEMBER
--------------------------------------------------------

  ALTER TABLE "SCOTT"."T_MEMBER" ADD CONSTRAINT "PK_T_MEMBER" PRIMARY KEY ("MEMBERSEQ")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "SCOTT"."T_MEMBER" MODIFY ("MEMBERID" NOT NULL ENABLE);
  ALTER TABLE "SCOTT"."T_MEMBER" MODIFY ("MEMBERSEQ" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table T_POLLSUB
--------------------------------------------------------

  ALTER TABLE "SCOTT"."T_POLLSUB" ADD CONSTRAINT "PK_T_POLLSUB" PRIMARY KEY ("POLLSUBSEQ")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "SCOTT"."T_POLLSUB" MODIFY ("POLLSEQ" NOT NULL ENABLE);
  ALTER TABLE "SCOTT"."T_POLLSUB" MODIFY ("ANSWER" NOT NULL ENABLE);
  ALTER TABLE "SCOTT"."T_POLLSUB" MODIFY ("POLLSUBSEQ" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table T_POLL
--------------------------------------------------------

  ALTER TABLE "SCOTT"."T_POLL" ADD CONSTRAINT "PK_T_POLL" PRIMARY KEY ("POLLSEQ")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "SCOTT"."T_POLL" MODIFY ("REGDATE" NOT NULL ENABLE);
  ALTER TABLE "SCOTT"."T_POLL" MODIFY ("ITEMCOUNT" NOT NULL ENABLE);
  ALTER TABLE "SCOTT"."T_POLL" MODIFY ("EDATE" NOT NULL ENABLE);
  ALTER TABLE "SCOTT"."T_POLL" MODIFY ("SDATE" NOT NULL ENABLE);
  ALTER TABLE "SCOTT"."T_POLL" MODIFY ("QUESTION" NOT NULL ENABLE);
  ALTER TABLE "SCOTT"."T_POLL" MODIFY ("POLLSEQ" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table T_VOTER
--------------------------------------------------------

  ALTER TABLE "SCOTT"."T_VOTER" ADD CONSTRAINT "PK_T_VOTER" PRIMARY KEY ("VECTORSEQ")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "SCOTT"."T_VOTER" MODIFY ("VECTORSEQ" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table T_POLLSUB
--------------------------------------------------------

  ALTER TABLE "SCOTT"."T_POLLSUB" ADD CONSTRAINT "FK_T_POLL_TO_T_POLLSUB" FOREIGN KEY ("POLLSEQ")
	  REFERENCES "SCOTT"."T_POLL" ("POLLSEQ") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table T_POLL
--------------------------------------------------------

  ALTER TABLE "SCOTT"."T_POLL" ADD CONSTRAINT "FK_T_MEMBER_TO_T_POLL" FOREIGN KEY ("MEMBERSEQ")
	  REFERENCES "SCOTT"."T_MEMBER" ("MEMBERSEQ") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table T_VOTER
--------------------------------------------------------

  ALTER TABLE "SCOTT"."T_VOTER" ADD CONSTRAINT "FK_T_MEMBER_TO_T_VOTER" FOREIGN KEY ("MEMBERSEQ")
	  REFERENCES "SCOTT"."T_MEMBER" ("MEMBERSEQ") ENABLE;
  ALTER TABLE "SCOTT"."T_VOTER" ADD CONSTRAINT "FK_T_POLLSUB_TO_T_VOTER" FOREIGN KEY ("POLLSUBSEQ")
	  REFERENCES "SCOTT"."T_POLLSUB" ("POLLSUBSEQ") ENABLE;
  ALTER TABLE "SCOTT"."T_VOTER" ADD CONSTRAINT "FK_T_POLL_TO_T_VOTER" FOREIGN KEY ("POLLSEQ")
	  REFERENCES "SCOTT"."T_POLL" ("POLLSEQ") ENABLE;
      
      
      
  select * from t_member;    
  select * from t_poll;    
  select * from t_pollsub;    
  select * from t_voter;    
      
      --------------------------------------------------------------------------------
1) 회원 가입/수정/탈퇴 쿼리..
DESC T_MEMBER;
이름            널?       유형            
------------- -------- ------------- 
MEMBERSEQ     NOT NULL NUMBER(4)       PK
MEMBERID      NOT NULL VARCHAR2(20)  
MEMBERPASSWD           VARCHAR2(20)  
MEMBERNAME             VARCHAR2(20)  
MEMBERPHONE            VARCHAR2(20)  
MEMBERADDRESS          VARCHAR2(100) 

  ㄱ. T_MEMBER  -> PK 확인.
SELECT *  
FROM user_constraints  
WHERE table_name LIKE 'T_M%'  AND constraint_type = 'P';
    
  ㄴ.  회원가입
  시퀀스(sequence)  자동으로 번호 발생시키는 객체 == 은행 (번호)
INSERT INTO   T_MEMBER (  MEMBERSEQ,MEMBERID,MEMBERPASSWD,MEMBERNAME,MEMBERPHONE,MEMBERADDRESS )
VALUES                 (  1,         'admin', '1234',  '관리자', '010-1111-1111', '서울 강남구' );
INSERT INTO   T_MEMBER (  MEMBERSEQ,MEMBERID,MEMBERPASSWD,MEMBERNAME,MEMBERPHONE,MEMBERADDRESS )
VALUES                 (  2,         'hong', '1234',  '홍길동', '010-1111-1112', '서울 동작구' );
INSERT INTO   T_MEMBER (  MEMBERSEQ,MEMBERID,MEMBERPASSWD,MEMBERNAME,MEMBERPHONE,MEMBERADDRESS )
VALUES                 (  3,         'kim', '1234',  '김기수', '010-1111-1341', '경기 남양주시' );
    COMMIT;
  ㄷ. 회원 정보 조회
  SELECT * 
  FROM t_member;
  
  ㄹ. 회원 정보 수정
  로그인 -> (홍길동) -> [내 정보] -> 내 정보 보기 -> [수정] -> [이름][][][][][][] -> [저장]
  PL/SQL
  UPDATE T_MEMBER
  SET    MEMBERNAME = , MEMBERPHONE = 
  WHERE MEMBERSEQ = 2;
  ㅁ. 회원 탈퇴
  DELETE FROM T_MEMBER 
  WHERE MEMBERSEQ = 2;
  
--------------------------------------------------------------------------------
1) 회원 가입/수정/탈퇴 쿼리..    
   ㄱ. 관리자로 로그인         
   ㄴ. [설문작성] 메뉴 선택
   ㄷ. 설문 작성 페이지로 이동...
   INSERT INTO T_POLL (PollSeq,Question,SDate, EDAte , ItemCount,PollTotal, RegDate, MemberSEQ )
   VALUES             ( 1  ,'좋아하는 여배우?'
                          , TO_DATE( '2024-02-01 00:00:00'   ,'YYYY-MM-DD HH24:MI:SS')
                          , TO_DATE( '2024-02-15 18:00:00'   ,'YYYY-MM-DD HH24:MI:SS') 
                          , 5
                          , 0
                          , TO_DATE( '2024-01-15 00:00:00'   ,'YYYY-MM-DD HH24:MI:SS')
                          , 1
                    );
    ㄹ. 설문 항목                  
 
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (1 ,'배슬기', 0, 1 );
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (2 ,'김옥빈', 0, 1 );
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (3 ,'아이유', 0, 1 );
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (4 ,'김선아', 0, 1 );
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (5 ,'홍길동', 0, 1 );      
   COMMIT;
--
   ㄷ. 설문 작성 페이지로 이동...
   INSERT INTO T_POLL (PollSeq,Question,SDate, EDAte , ItemCount,PollTotal, RegDate, MemberSEQ )
   VALUES             ( 2  ,'좋아하는 과목?'
                          , TO_DATE( '2024-02-26 00:00:00'   ,'YYYY-MM-DD HH24:MI:SS')
                          , TO_DATE( '2024-03-15 18:00:00'   ,'YYYY-MM-DD HH24:MI:SS') 
                          , 4
                          , 0
                          , TO_DATE( '2024-02-20 00:00:00'   ,'YYYY-MM-DD HH24:MI:SS')
                          , 1
                    );
                   
    ㄹ. 설문 항목                  
 
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (6 ,'자바', 0, 2 );
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (7 ,'오라클', 0, 2 );
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (8 ,'HTML5', 0, 2 );
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (9 ,'JSP', 0, 2 );
   
   COMMIT;
--
  ㄷ. 설문 작성 페이지로 이동...
   INSERT INTO T_POLL (PollSeq,Question,SDate, EDAte , ItemCount,PollTotal, RegDate, MemberSEQ )
   VALUES             ( 3  ,'좋아하는 색?'
                          , TO_DATE( '2024-03-26 00:00:00'   ,'YYYY-MM-DD HH24:MI:SS')
                          , TO_DATE( '2024-04-15 18:00:00'   ,'YYYY-MM-DD HH24:MI:SS') 
                          , 4
                          , 0
                          , TO_DATE( '2024-03-01 00:00:00'   ,'YYYY-MM-DD HH24:MI:SS')
                          , 1
                    );
                   
    ㄹ. 설문 항목                  
 
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (10 ,'빨강', 0, 3 );
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (11 ,'녹색', 0, 3 );
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (12 ,'파랑', 0,3 );
INSERT INTO T_PollSub (PollSubSeq          , Answer , ACount , PollSeq  ) 
VALUES                (13 ,'주황', 0,3 );
   
   COMMIT;
--
SELECT *
FROM t_poll;
SELECT *
FROM t_pollsub; 
 
   설문 수정, 설문 삭제 query

--------------------------------------------------------------------------------
3) 회원이 로그인했습니다.     [ 설문목록페이지  ]
   2 설문 : 좋아하는 과목 "제목" 클릭
SELECT *
FROM t_member;   
  --> 3   kim   1234   김기수 (인증)
SELECT *
FROM (
    SELECT  pollseq 번호, question 질문, membername 작성자
         , sdate 시작일, edate 종료일, itemcount 항목수, polltotal 참여자수
         , CASE 
              WHEN  SYSDATE > edate THEN  '종료'
              WHEN  SYSDATE BETWEEN  sdate AND edate THEN '진행 중'
              ELSE '시작 전'
           END 상태 -- 추출속성   종료, 진행 중, 시작 전
    FROM t_poll p JOIN  t_member m ON m.memberseq = p.memberseq
    ORDER BY 번호 DESC
) t 
WHERE 상태 != '시작 전';  

--------------------------------------------------------------------------------  
3)  3(김기수) 로그인 상태 +  2번 설문 참여..( 좋아하는 과목 ) [ 투표 페이지 ]
   업무 프로세스 
   설문 목로페이지에서 설문참여하기 위해서 2번 질문을 클릭
   [설문 보기 페이지]
   1) 2번 설문의 내용이 SELECT-> 출력
       ㄱ. 설문내용 
           질문, 작성자, 작성일, 시작일, 종료일, 상태, 항목수 조회
           SELECT question, membername
               , TO_CHAR(regdate, 'YYYY-MM-DD AM hh:mi:ss')
               , TO_CHAR(sdate, 'YYYY-MM-DD')
               , TO_CHAR(edate, 'YYYY-MM-DD')
               , CASE 
                  WHEN  SYSDATE > edate THEN  '종료'
                  WHEN  SYSDATE BETWEEN  sdate AND edate THEN '진행 중'
                  ELSE '시작 전'
               END 상태
               , itemcount
           FROM t_poll p JOIN t_member m ON p.memberseq = m.memberseq
           WHERE pollseq = 2;
       ㄴ. 설문항목
           SELECT answer
           FROM t_pollsub
           WHERE pollseq = 2;
   2) 총참여자수 7명
      배 []
      .  []
      .  []
    -- 2번 설문의 총참여자수   
    SELECT  polltotal  
    FROM t_poll
    WHERE pollseq = 2;
    -- 
    SELECT answer, acount
        , ( SELECT  polltotal      FROM t_poll    WHERE pollseq = 2 ) totalCount
        -- ,  막대그래프
        , ROUND (acount /  ( SELECT  polltotal      FROM t_poll    WHERE pollseq = 2 ) * 100) || '%'
     FROM t_pollsub
    WHERE pollseq = 2;
  
  3) [ 투표하기 ] 버튼 클릭
     - 2질문의 항목을 선택을 해야된다. 
    자바
    오라클 (체크)  PK 7  ( 질문항목  PK 값인 7을 선택)
    HTML5
    JSP
    
    SELECT *
    FROM t_voter;
    -- (1) t_voter
    INSERT INTO t_voter 
    ( vectorseq, username, regdate, pollseq, pollsubseq, memberseq )
    VALUES
    (      1   ,  '김기수'  , SYSDATE,   2  ,  7 ,  3 );
    COMMIT;
    
    -- 1)         2/3 자동 UPDATE  [트리거]
    -- (2) t_poll   totalCount = 1증가
    UPDATE   t_poll
    SET polltotal = polltotal + 1
    WHERE pollseq = 2;
    
    -- (3)t_pollsub   account = 1증가
    UPDATE   t_pollsub
    SET acount = acount + 1
    WHERE  pollsubseq = 7;
    
    commit;
    
    SELECT *
    FROM t_poll;
      
      
      
      
      
      
      
