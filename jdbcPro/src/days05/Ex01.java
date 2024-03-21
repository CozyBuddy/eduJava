package days05;

import java.security.Provider.Service;
import java.sql.Connection;

import com.util.DBConn;

import days05.baord.controller.BoardController;
import days05.board.persistence.BoardDAO;
import days05.board.persistence.BoardDAOImpl;
import days05.board.service.BoardService;

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
		/*
		 * 사용자(user) => BoardController.java > BoardDTO > BoardService.java >>int 게시글 쓰기() // DTO Data Transform Object 데이터 전송용 
		 * 				*[게시글 쓰기] : 새로운 게시글 작성								1) DB 처리 BoardDAOImpl.java  > DB저장
		 * 					수정 														ㄴInsert(dto) 메서드
		 * 					삭제														2) 로그기록 처리 등의 여러기능을 위해서 BoardService라는 계층이 필요함.
		 * 					상세보기													3) 트랜잭션 작업 등등 1+2+3) 논리적인 처리작업 커밋,롤백 (트랜잭션 처리)
		 * 					메뉴 선택
		 */
		
		
		
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
  
  
  			//목록, 쓰기, 삭제 ,수정 , [검색]
  			// BoardDAO, BoardDAOImpl, BoardService, BoardController
)*/		Connection conn = DBConn.getConnection();
		BoardDAO dao = new BoardDAOImpl(conn);
		BoardService service = new BoardService(dao);
		BoardController controller = new BoardController(service);
		
		controller.boardstart();
	}

}
