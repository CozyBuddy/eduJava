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
public class Ex02 {
	public static void main(String[] args) {
		//페이징 처리
		// 1) 현재 페이지 번호
		// 2) 한 페이지 보여줄 게시글 갯수 
		// 3) 페이징 블럭 갯수?
		Connection conn = DBConn.getConnection();
		BoardDAO dao = new BoardDAOImpl(conn);
		BoardService service = new BoardService(dao);
		BoardController controller = new BoardController(service);
		
		controller.boardstart();
	}

}
