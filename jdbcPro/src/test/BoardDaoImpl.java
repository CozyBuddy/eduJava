package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.util.DBConn;

import days05.board.domain.BoardDTO;
import days05.board.persistence.BoardDAO;
import days05.board.persistence.BoardDAOImpl;
import domain.EMPVO;
import persistence.EmpDAO;
import persistence.EmpDAOImpl;

class BoardDaoImpl {

	@Test
	void test() throws SQLException {
		Connection conn = DBConn.getConnection();
		BoardDAO dao = new BoardDAOImpl(conn);
		//fail("Not yet implemented");
		
		//BoardDTO bd = BoardDTO.builder().seq().build();
		int rowCount = 0;
		ArrayList<BoardDTO> al = dao.Sboard();;
	
		try {
			rowCount = dao.Sboard().size();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < rowCount; i++) {
			System.out.println(al.get(i).toString());
		}
	
		//출력확인
		if (rowCount==150) {
			System.out.println("조회 성공");
		}
		
		DBConn.close();
	}

}