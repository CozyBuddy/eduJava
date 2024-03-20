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
 * @subject	dept - insert 부서추가
 * @contents up_insertdept
 */
public class Ex05_02 {
	public static void main(String[] args) {
		
		String sql = "{call up_insertdept(?,?)}"; // ploc=> ? 이런식으로 표현해도 됨, 그 매개변수만 받을 수 있음.
		Connection conn = null;
		CallableStatement cs = null;
		int rowcount = 0;
		String pdname = "QC";
		String ploc = "SEOUL";
		conn = DBConn.getConnection();
		try {
			cs = conn.prepareCall(sql);
			cs.setString(1, pdname);
			cs.setString(2, ploc);
			rowcount = cs.executeUpdate(); 
			
			if (rowcount==1) {
				System.out.println("부서 추가 성공");
			} else {
				System.out.println("부서 추가 실패");
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
create or replace procedure up_insertdept
(
   pdname dept.dname%type :=null,
   ploc dept.loc%type := null
)
is

begin
    Insert into dept values ( seq_deptno.nextval , pdname, ploc); 
    commit;
end;*/
