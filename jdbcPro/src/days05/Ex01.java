package days05;

/**
 * @author user
 * @date 2024. 3. 20. 오후 4:03:54
 * @subject
 * @contents
 */
public class Ex01 {
	public static void main(String[] args) {
		// [1] 게시판 패키지 선언
		// days05
		//		ㄴ board
		//			ㄴ domain
		//				BoardDTO
		//			ㄴ persistence
		//				인터페이스 BoardDAO.java
		//				BoardDAOImpl.java
		//			ㄴ service
		//			ㄴ controller
		/*create sequence seq_tbl_cstVSBoard
nocache;
create table tbl_cstVSBoard (
  seq number not null primary key , -- 글 일련번호 (PK)
  writer varchar2(20) not null , -- 작성자
  pwd varchar2(20) not null , --비밀번호
  email varchar2(100) null , -- 이메일
  title varchar2(200) not null , 
  writedate date default sysdate ,
  readed number default 0,
  tag number(1) not null ,
  content clob null
)*/
	}

}