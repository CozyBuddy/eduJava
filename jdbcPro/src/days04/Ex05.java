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
 * @subject	dept - select 부서조회
 * @contents up_selectdept
 */
public class Ex05 {
	public static void main(String[] args) {
		
		String sql = "{call up_selectdept(?)}";
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		conn = DBConn.getConnection();
		try {
			cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.executeQuery();
			rs = (ResultSet) cs.getObject(1);
			
			DeptVO vo = null ;
			while (rs.next()) {
				
				int deptno = rs.getInt(1);
				String dname = rs.getString(2);
				String loc = rs.getString(3);
				vo= new DeptVO(deptno,dname,loc);
				System.out.printf("%d \t %s \t %s \n", deptno ,dname ,loc);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
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
 * create or replace procedure up_selectdept
(
   pdeptcursor out sys_refcursor
)
is

begin
    --OPEN커서 for문
   open pdeptcursor for  select * from dept;
    
end;
 */
