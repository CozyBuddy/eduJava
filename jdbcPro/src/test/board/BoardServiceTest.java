package test.board;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.util.DBConn;

import days05.board.domain.BoardDTO;
import days05.board.persistence.BoardDAO;
import days05.board.persistence.BoardDAOImpl;
import days05.board.service.BoardService;

class BoardServiceTest {

	/*@Test
	void testinsertService() throws SQLException {
		BoardDTO dto = BoardDTO.builder().title("두 번째 게시글").writer("김진영").pwd("1234").email("kim@sist.com").tag(0).content("첫 번째 게시글 내용").build();
		
		
		Connection conn = DBConn.getConnection();
		BoardDAO dao = new BoardDAOImpl(conn);
		BoardService bs = new BoardService(dao);
		int rowcount = bs.InsertS(dto);
		if (rowcount==1) {
			System.out.println("게시글 작성 완료");
		}
		
		DBConn.close();
	}*/
	@Test
	void testselectService() throws SQLException {
		ArrayList<BoardDTO> al = null;
		Connection conn = DBConn.getConnection();
		BoardDAO dao = new BoardDAOImpl(conn);
		BoardService bs = new BoardService(dao);
		al = bs.Sselect();
		if (al.size()>=1) {
			System.out.println("게시글 조회 완료");
		}
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
		
		DBConn.close();
	}

}