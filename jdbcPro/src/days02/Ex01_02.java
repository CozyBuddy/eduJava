package days02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.util.DBConn;

import domain.Viewvo;

public class Ex01_02 {
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
		String ipAddress = "192.168.10.165";
		String url = "jdbc:oracle:thin:@"+ipAddress+":1521:xe";
		int num ;
		String name ;
		String name2 ;
		String d1;
		String pay;
		String grade;
		try {
			conn = DBConn.getConnection(url,id,pw);
			st = conn.createStatement();
			String sql = "select * from cmt_reply";
			rs = st.executeQuery(sql);
			
			ArrayList<Viewvo> al = new ArrayList<Viewvo>();
			
			
			while (rs.next()) {
				num = rs.getInt(1);
				name = rs.getString(2);
				name2 = rs.getString(3);
				d1 = rs.getString(4);
				pay = rs.getString(5);
				grade = rs.getString(6);
				Viewvo vo = new Viewvo(num, name, name2, d1, pay, grade);
				al.add(vo);
				
				
			}
			dispemplist(al);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				//conn.close();
				DBConn.close();
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