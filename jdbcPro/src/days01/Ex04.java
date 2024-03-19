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

public class Ex04 {
	public static void main(String[] args) throws SQLException {
		ResultSet rs = null ;
		String dr = "oracle.jdbc.driver.OracleDriver";
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String pw = "tiger";
		int empno ;
		String ename ;
		String deptno ;
		Connection conn = null ;
		Statement stmt = null ;
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		
		try {
			Class.forName(dr);
			conn = DriverManager.getConnection(jdbcurl,id,pw);
			String sql = "select * from emp where deptno = 30";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				empno = rs.getInt("empno");
				ename = rs.getString("ename");
				deptno = rs.getString("deptno");
				DeptVO vo = new DeptVO(empno,ename,deptno);
				list.add(vo);
			}
			dispdept(list);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
			conn.close();
		}
		
		
	}

	private static void dispdept(ArrayList<DeptVO> list) {
		Iterator<DeptVO> ir = list.iterator();
		while (ir.hasNext()) {
			DeptVO vo = ir.next();
			System.out.println(vo.toString());
			
		}
		
	}

}
