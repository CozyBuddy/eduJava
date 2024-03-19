package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.Viewvo;

//싱글톤 ( Singleton)
public class DBConn {
	
	private static Connection conn = null ;
	
	private DBConn() {}
	
	public static Connection getConnection() {
		if (conn == null) {
			String id = "scott";
			String pw = "tiger";
			
			String dr = "oracle.jdbc.driver.OracleDriver";
			String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
			
			try {
				Class.forName(dr);
				conn = DriverManager.getConnection(jdbcurl,id,pw);
			
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
				
				
			
		
		
		}
		return conn;
	}

// 오버로딩
public static Connection getConnection(String url,String user, String password) {
	if (conn == null) {
		String dr = "oracle.jdbc.driver.OracleDriver";
		
		try {
			Class.forName(dr);
			conn = DriverManager.getConnection(url,user,password);
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
			
		
	
	
	}
	return conn;
}

	public static void close() {
		try {
			if (conn!=null && !conn.isClosed()) {
				conn.close();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		conn = null;
	}


}
