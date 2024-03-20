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
 * @subject	dept - UPDATE 부서추가
 * @contents up_updatedept
 */
public class Ex05_04 {
	public static void main(String[] args) {
		
		String sql = "{call up_updatedept(?, ? ,?)}"; // ploc=> ? 이런식으로 표현해도 됨, 그 매개변수만 받을 수 있음.
		Connection conn = null;
		CallableStatement cs = null;
		int rowcount = 0;
		int pdeptno = 50;
		String pdname = "QC2";
		String ploc = "SEOUL2";
		conn = DBConn.getConnection();
		try {
			cs = conn.prepareCall(sql);
			cs.setInt(1, pdeptno);
			cs.setString(2, pdname);
			cs.setString(3, ploc);
			rowcount = cs.executeUpdate(); 
			
			if (rowcount==1) {
				System.out.println("부서 수정 성공");
			} else {
				System.out.println("부서 수정 실패");
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
-- insert
create or replace procedure up_updatedept
(
    pdeptno dept.deptno%type ,
    pdname dept.dname%type :=null,
    ploc dept.loc%type := null
)
is

begin
      update dept set dname = nvl(pdname,dname) , loc = nvl(ploc,loc) where deptno= pdeptno;
      commit;
end;*/