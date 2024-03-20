package days04;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBConn;

import domain.DeptVO;
import oracle.jdbc.OracleTypes;

/**
 * @author user
 * @date 2024. 3. 20. 오후 2:01:10
 * @subject	dept - delete 부서삭제
 * @contents up_updatedept
 */
public class Ex05_03 {
	public static void main(String[] args) {
		
		String sql = "{call up_deletedept(?)}"; // ploc=> ? 이런식으로 표현해도 됨, 그 매개변수만 받을 수 있음.
		Connection conn = null;
		CallableStatement cs = null;
		int rowcount = 0;
		int pdeptno = 50;
	
		conn = DBConn.getConnection();
		try {
			conn.setAutoCommit(true);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			cs = conn.prepareCall(sql);
			cs.setInt(1, pdeptno);
			rowcount = cs.executeUpdate(); 
			
			if (rowcount==1) {
				System.out.println("부서 삭제 성공");
			} else {
				System.out.println("부서 삭제 실패");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				cs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			DBConn.close();
		}
		
	}
	

}
/*
create or replace procedure up_deletedept
(
    pdeptno dept.deptno%type
)
is
begin
    delete dept where deptno = pdeptno;
end;*/