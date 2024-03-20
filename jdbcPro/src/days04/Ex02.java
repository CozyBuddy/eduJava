package days04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.DBConn;

public class Ex02 {
	public static void main(String[] args) {
		//자바에서 트랜잭션 처리
		// 오라클 트랜잭션 처리
		// 예 ) 계좌이체 
		//	A -> 인출
		// 	B -> 입금
		/*
		 * PL/SQL (저장 프로시저)
		 * 
		 * BEGIN
		 * 	
		 * 	COMMIT;
		 * EXCEPTION
		 * 	when then 
		 * 	rollback;
		 * END
		 */
		// A : Insert deptno 50번추가 : 성공
		// B : Insert deptno 50번추가 : PK제약조건 위배 에러~ 
		String sql = "Insert into dept values (?,?,?)";
		Connection conn = null;
		PreparedStatement pst = null;
		int rowCount = 0;
		
		conn = DBConn.getConnection();
		try {
			conn.setAutoCommit(false);
			pst = conn.prepareStatement(sql);
			
			//insert
			pst.setInt(1, 50);
			pst.setString(2, "QC");
			pst.setString(3, "SEOUL");
			rowCount = pst.executeUpdate();
			//insert 
			System.out.println("첫 번째 INSERT문 : " + rowCount);
			//insert
			pst.setInt(1, 50);
			pst.setString(2, "QC2");
			pst.setString(3, "SEOUL2");
			rowCount = pst.executeUpdate();
			//insert 
			System.out.println("두 번째 INSERT문 : " + rowCount);
			
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		DBConn.close();
		
				
	} // main

}