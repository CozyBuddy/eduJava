package days01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import domain.DeptVO;
import oracle.jdbc.driver.OracleDriver;
import oracle.jdbc.pool.OracleDataSource;

/**
 * @author user
 * @date 2024. 3. 15. 오후 3:45:00
 * @subject
 * @contents [내일 복습 문제 ] 
 * 		 scott 접속 + dept 테이블 select 
 */
public class Ex03_02 {
	public static void main(String[] args) throws SQLException {
		Connection conn = null ;
		Statement stmt = null ;
		ResultSet rs = null ;
		String dr = "oracle.jdbc.driver.OracleDriver";
		String id = "scott";
		String pw = "tiger";
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe"; // this => type 4방식 1521은 오라클에서는 고정 xe는 식별자 
		int deptno ;
		String dname ;
		String loc ;
		
		ArrayList<DeptVO> list = new ArrayList<DeptVO>() ;
		try {
			Class.forName(dr);
			conn = DriverManager.getConnection(jdbcurl,id,pw);
			
			if (conn != null) {
				System.out.println("커넥션 연결 성공");
			}
			//3. 필요한 작업 (CRUD)
			String sql = "select * from dept";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
				while (rs.next()) {
					deptno = rs.getInt("deptno");
					dname = rs.getString("dname");
					loc = rs.getString("loc");
					DeptVO vo = new DeptVO(deptno,dname,loc);
					//hiredate = rs.getTimestamp("hiredate").toLocalDateTime();
					list.add(vo);
					/*System.out.printf("%d\t%s\t%s\n",deptno,dname,loc);*/
				}
				dispdept(list);
				
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("> error : " + e.toString());
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		}
		
		System.out.println("end");
		
	
		
		
	}

	private static void dispdept(ArrayList<DeptVO> list) {
		Iterator<DeptVO> ir = list.iterator();
		while (ir.hasNext()) {
			DeptVO vo = ir.next();
			System.out.println(vo.toString());
			
		}
		
	}

}
