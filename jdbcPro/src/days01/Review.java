package days01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import domain.Viewvo;





public class Review {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		String searchword = null ;
		System.out.print("검색할 사원명 입력 > ");
		searchword = sc.next();
		Connection conn = null ;
		ResultSet rs = null ;
		Statement st = null ;
		String id = "scott";
		String pw = "tiger";
		
		String dr = "oracle.jdbc.driver.OracleDriver";
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
		int num ;
		String name ;
		String name2 ;
		String d1;
		int pay;
		String grade;
		try {
			Class.forName(dr);
			conn = DriverManager.getConnection(jdbcurl,id,pw);
			st = conn.createStatement();
			String sql = "select e.empno,d.dname,e.ename,e.hiredate,e.sal+nvl(comm,0) as pay"
					+ " ,s.grade from emp e,dept d,salgrade s where e.deptno=d.deptno and s.losal <= "
					+ "e.sal and s.hisal >=e.sal and REGEXP_like(ENAME,'"+searchword+"','i')";
			rs = st.executeQuery(sql);
			
			ArrayList<Viewvo> al = new ArrayList<Viewvo>();
			
			
			while (rs.next()) {
				num = rs.getInt("empno");
				name = rs.getString("dname");
				name2 = rs.getString("ename");
				d1 = rs.getString("hiredate");
				pay = rs.getInt("pay");
				grade = rs.getString("grade");
				Viewvo vo = new Viewvo(num, name, name2, d1, pay, grade);
				al.add(vo);
				
				
			}
			dispemplist(al);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}

	private static void dispemplist(ArrayList<Viewvo> al) {
		if (al.size()==0) { 
			System.out.println("사원 정보가 없습니다");
			return ;
			}
		Iterator<Viewvo> ir = al.iterator();
		while (ir.hasNext()) {
			Viewvo vo = ir.next();
			System.out.println(vo);
		}
		
	}

	
		
}
//com.util.DBConn.java 순서에 맞는 커넥션 및 공통적인 작업은 유틸로  만듦

	

