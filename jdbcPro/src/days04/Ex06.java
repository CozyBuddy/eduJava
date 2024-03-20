package days04;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.util.DBConn;

import domain.DeptVO;
import oracle.jdbc.OracleTypes;

/**
 * @author user
 * @date 2024. 3. 20. 오후 3:09:18
 * @subject 자바 리플렉션 (reflection)
 * @contents-반사,상,반영 JDBC 리플렉션 ? 결과물(rs) 에 대한 정보를 추출해서 사용할 수 있는 기술.
 */
public class Ex06 {
	public static void main(String[] args) {
		String sql = "select table_name from tabs";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<String> al = new ArrayList<String>(); ;
		String tablename = null ;
		conn = DBConn.getConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				
				tablename = rs.getString(1);
				al.add(tablename);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//[2] al 출력
		System.out.println(al.toString());
		//[3]
		Scanner sc = new Scanner(System.in);
		System.out.print("원하는 테이블명을 입력하세요.");
		tablename = sc.next();
		// 테이블명이나 컬럼명은 ? 매개변수에 사용할 수 없음.
		sql = "select * from " + tablename;
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			ResultSetMetaData rsm = rs.getMetaData();
			//System.out.println("속성 갯수 : " + rsm.getColumnCount());
			int columncount = rsm.getColumnCount();
			System.out.println("-".repeat(columncount*7));
		/*	for (int j = 1; j <= columncount; j++) {
				String columnname = rsm.getColumnName(j);
				String columntype = rsm.getColumnTypeName(j);
				if (columntype.equals("NUMBER")) {
					//number(5,2) ? number(2) ? number( p ,s) precision과 scale 설정된 상태
					int precision = rsm.getPrecision(j);
					int scale = rsm.getScale(j);
					System.out.printf( "%s %s(%d,%d)\n",columnname,columntype,precision,scale);
				} else {
				System.out.println("컬럼명 : " + columnname +"컬럼 타입 : " + columntype);
				}*/
				
			for (int j = 1; j <= columncount; j++) {
				String columnname = rsm.getColumnName(j);
				System.out.printf("%s\t", columnname);
		
			}
			System.out.println();
			System.out.println("-".repeat(columncount*7));
			
			//rs 레코드 출력
			// 2 - number
			// 12 - varchar2
			// 93 - DATE 날짜형
			while (rs.next()) {
				for (int i = 1; i <= columncount; i++) {
					int columtype = rsm.getColumnType(i);
					if (columtype ==2 ) {
						int scale = rsm.getScale(i);
						if (scale==0) { //정수
							System.out.printf("%d\t",rs.getInt(i));
						} else { // 실수
							System.out.printf("%.2f \t",rs.getDouble(i));
							
						}

					} else if (columtype ==12) {
						System.out.printf("%s \t",rs.getString(i));
						
					} else if (columtype==93) {
						System.out.printf("%s \t",rs.getDate(i));
					}
				}
				System.out.println();
				
			}
			
			System.out.println("-".repeat(columncount*7));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		DBConn.close();
		
	}
	

}