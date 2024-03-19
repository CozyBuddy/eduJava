package days01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;
import oracle.jdbc.pool.OracleDataSource;

/**
 * @author user
 * @date 2024. 3. 15. 오후 2:49:52
 * @subject
 * @contents
 */
public class Ex02_02 {
	public static void main(String[] args)  {
		Connection conn = null ;
		// EX02.java <--> localhost 에 있는 오라클 서버에 연결 
		// 1. Class.forName() JDBC 드라이버 로딩
		String className = "oracle.jdbc.driver.OracleDriver";
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger"; //대소문자 구분
		
		// DataSource 객체
		OracleDataSource ds;
		try {
			ds = new OracleDataSource() ;
			ds.setURL(jdbcUrl);
			conn = ds.getConnection(user, password);
			
			System.out.println(conn.isClosed());
			System.out.println("end");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		
		// 2. Connection 객체 생성 - DriverMAnager.getConnection
		// 3.필요한 작업( CRUD)
		// 4. Connection 닫기(Close)
		
		
		
	}

}
