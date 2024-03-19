package days01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

/**
 * @author user
 * @date 2024. 3. 15. 오후 2:49:52
 * @subject
 * @contents
 */
public class Ex02 {
	public static void main(String[] args) throws SQLException {
		Connection conn = null ;
		// EX02.java <--> localhost 에 있는 오라클 서버에 연결 
		// 1. Class.forName() JDBC 드라이버 로딩
		String className = "oracle.jdbc.driver.OracleDriver";
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger"; //대소문자 구분
		try {
			// 드라이버 객체 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//  커넥션 연결 
			
			conn = DriverManager.getConnection(jdbcUrl,user,password);
			
			if (conn != null) {
				System.out.println("커넥션 연결 성공 :"+ conn.toString());
			}
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 없음");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(conn.isClosed() ? "DB 닫힘" : "DB 연결");
		// OracleDriver가 
		System.out.println("end");
		// 2. Connection 객체 생성 - DriverMAnager.getConnection
		// 3.필요한 작업( CRUD)
		// 4. Connection 닫기(Close)
		
		
		
	}

}