package days03;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.util.DBConn;

import domain.DeptVO;

//PreparedStatement



public class Ex01 {
	public static String menu[] = { "추가", "수정", "삭제", "조회", "검색" , "종료"};
	public static int selectednum;
	public static Connection conn;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// 1. DB 사용할 작업
		conn = DBConn.getConnection();
		do {
			메뉴출력();
			메뉴선택();
			메뉴처리();
		} while (true);

	}

	private static void 메뉴처리() {

		switch (selectednum) {
		case 1: // 추가
			부서추가();

			break;
		case 2:
			부서수정();
			break;
		case 3: // 삭제
			부서삭제();
			break;
		case 4:// 조회
			부서조회();

			break;
		case 5:// 검색
			부서검색();

			break;
		case 6: // 종료
			종료();

			break;

		default:
			break;
		}
		일시정지();

	}



	private static void 부서검색() {
		ArrayList<DeptVO> al = new ArrayList<DeptVO>();
		int deptno;
		String dname;
		String loc;
		//Statement st = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int searchCondition ;
		String searchWord = null ;
		System.out.println("검색조건을 입력하세요");
		searchCondition = sc.nextInt();
		sc.nextLine();
		System.out.println("검색어를 입력하세요");
		searchWord = sc.next().trim();

		String sql = "select * from dept where ";
		if (searchCondition==1) {
			sql+= " deptno = ?";
		} else if (searchCondition==2) {
			sql+="REGEXP_LIKE(dname,?,'i')";
		} else if (searchCondition==3) {
			sql+= "REGEXP_LIKE(loc,?,'i')";
		} else if (searchCondition==4) {
			sql += "REGEXP_LIKE(dname,?, 'i') or REGEXP_LIKE(loc,?, 'i')";
		} // ? 에는 테이블명이나 속성명은 올 수 없음
		try {
			pst = conn.prepareStatement(sql);
			//st = conn.createStatement();
		
			if (searchCondition==4) {
				pst.setString(1,searchWord);
				pst.setString(2,searchWord);
			} else if (searchCondition==1) {
				pst.setInt(1,Integer.parseInt(searchWord));
			}
			else {
				pst.setString(1,searchWord);
			} 
			rs = pst.executeQuery();
			if (rs.next()) {
				do {
					deptno = rs.getInt("deptno");
					dname = rs.getString("dname");
					loc = rs.getString("loc");
					DeptVO vo = new DeptVO(deptno, dname, loc);
					al.add(vo);
				} while (rs.next());
				부서출력(al);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				pst.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}

	private static void 부서수정() {

		/*System.out.println("수정할 부서번호,부서명,지역명을 입력하세요");
		String record = sc.next();
		String pattern = "{0},{1},{2}";
		MessageFormat mf = new MessageFormat(pattern);
		try {
			Object objs[] = mf.parse(record);
			deptno = Integer.parseInt(objs[0].toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("수정할 부서번호을 입력하세요");
		int deptno = sc.nextInt();
		sc.nextLine();
		System.out.println("변경할 부서명를 입력하세요");
		String dname = sc.nextLine();
		System.out.println("변경할 지역명를 입력하세요");
		String loc = sc.nextLine();
		ResultSet RS;
		String sql;
		if (dname.equals("")) {
			
			 sql = "update dept set  "
			 		+ "loc=? where deptno = "+deptno+"";
			
		}
		else if (loc.equals("")) {
		
			 sql = "update dept set dname= ? "
			 		+ "where deptno = "+deptno+"";
			
		
		} else {
		   sql = "update dept set dname = ?, loc=? where deptno = "+deptno+"";
		
		}
		try {
			PreparedStatement pst = null;
			
			pst=conn.prepareStatement(sql);
			if (dname.equals("")) {
				pst.setString(1, loc);
				
			}
			else if (loc.equals("")) {
			 pst.setString(1, dname);
			} else {
			 pst.setString(1, dname);
			 pst.setString(2, loc);
			
			}
			
			int rowcount = pst.executeUpdate();
			if (rowcount == 1) {
				System.out.println("부서정보 수정완료");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*private static void 부서수정() {
	System.out.println("수정할 부서번호를 입력하세요");
	int deptno = sc.nextInt();
	sc.nextLine();
	System.out.println("변경할 부서명를 입력하세요");
	String dname = sc.nextLine();
	System.out.println("변경할 지역명를 입력하세요");
	String loc = sc.next();
	 if ( dname.equals("")) {
	     sql = String.format(
	             " UPDATE  dept "
	           + " SET loc = '%s' "
	           + " WHERE deptno = %d ", loc, deptno );
	  } else if (loc.equals("")) {
	     sql = String.format(
	             " UPDATE  dept "
	           + " SET dname = '%s' "
	           + " WHERE deptno = %d ", dname, deptno );
	  } else {
	     sql = String.format(
	             " UPDATE  dept "
	           + " SET dname = '%s',loc = '%s' "
	           + " WHERE deptno = %d ", dname, loc, deptno );
	  }

	if (dname.equals("")) {

		String sql = "select dname from dept where deptno="+deptno+"";
		Statement st = null ;
		try {
			st =conn.createStatement();
		    dname =st.executeQuery(sql).toString();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
	if (loc == "") {

		String sql = "select loc from dept where deptno="+deptno+"";
		Statement st = null ;
		try {
			st =conn.createStatement();
		    loc =st.executeQuery(sql).toString();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
	String sql = "update dept set dname = '"+dname+"', loc='"+loc+"' where deptno = "+deptno+"";
	Statement st = null ;

	 try {
		st =conn.createStatement();

		int rowcount = st.executeUpdate(sql);
		if (rowcount==1) {
			System.out.println("부서정보 수정완료");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}*/
	/*private static void 부서수정() {
		System.out.println("수정할 부서번호를 입력하세요");
		int deptno = sc.nextInt();
		System.out.println("변경할 부서명를 입력하세요");
		String dname = sc.next();
		System.out.println("변경할 지역명를 입력하세요");
		String loc = sc.next();
		String sql = "update dept set dname = '"+dname+"', loc='"+loc+"' where deptno = "+deptno+"";
		Statement st = null ;

		 try {
			st =conn.createStatement();

			int rowcount = st.executeUpdate(sql);
			if (rowcount==1) {
				System.out.println("부서정보 수정완료");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/

	//[2]
	private static void 부서삭제() {
		System.out.println("삭제할 부서번호를 모두입력 (,)로 구분자 "); //쿼리에서는 String으로 int를 받아도 오라클에서는 '숫자' 를 문자로 인식안하고 숫자로 인식

		String a = sc.nextLine();
		

		//Statement st = null;
		PreparedStatement pst = null;
		String st[] = a.trim().split("\s*,\s*");
		String sql = "delete from dept where deptno in(";
		for (int i = 0; i < st.length-1; i++) {
			sql+="?, ";
		}
		sql+="? )";
		try {
			//st = conn.createStatement();
			pst=conn.prepareStatement(sql);
			//int rowcount = st.executeUpdate(sql);
			for (int i = 0; i < st.length; i++) {
				pst.setString(i+1, st[i]);
			}
			int rowcount = pst.executeUpdate();
			if (rowcount>=1) {
				System.out.println("부서 삭제 완료");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("삭제 완료");
	}

	//[1]
	/*private static void 부서삭제() {
		System.out.println("삭제할 부서번호를 입력"); //쿼리에서는 String으로 int를 받아도 오라클에서는 '숫자' 를 문자로 인식안하고 숫자로 인식
		int a = sc.nextInt();
		String sql = "delete dept where deptno=" + a + "";
		Statement st = null;

		try {
			st = conn.createStatement();
			int rowcount = st.executeUpdate(sql);
			if (rowcount==1) {
				System.out.println("부서 삭제 완료");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("삭제 완료");
	}*/

	private static void 부서추가() {
		// conn.setautocommit(true) ; //커밋이 자동으로 설정되어있음.
		System.out.print("추가할 부서번호를 입력하세요.");
		int deptno = sc.nextInt();
		System.out.print("부서명을 입력하세요.");
		String dname = sc.next();
		System.out.println("지역명을 입력하세요");
		String loc = sc.next();
		String sql = "Insert into dept values ( ?,?,?)"; // ' 홑따옴표 필요없음.
		
		PreparedStatement pst = null;
		//Statement st = null;
		try {
			//st = conn.createStatement();
			pst=conn.prepareStatement(sql);
			//int rowcount = pst.executeUpdate(sql);
			pst.setInt(1, deptno);
			pst.setString(2, dname);
			pst.setString(3, loc);
			int rowcount = pst.executeUpdate();
			
			if (rowcount == 1) {
				System.out.println("부서추가 성공");
			}
			rowcount = 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.print("계속 추가하려면 y를 입력");
		char yes = sc.next().charAt(0);
		if (Character.toUpperCase(yes) == 'Y') {
			부서추가();

		}

	}

	private static void 일시정지() {
		System.out.println("엔터치면 계속 진행");

		try {
			System.in.read();
			System.in.skip(System.in.available());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void 부서조회() {
		ArrayList<DeptVO> al = new ArrayList<DeptVO>();
		PreparedStatement pst = null ;
		//Statement st = null;
		ResultSet rs = null;
		int deptno;
		String dname, loc;
		String sql ="select * from dept order by deptno";
		try {
			//st = conn.createStatement();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery(sql);
			if (rs.next()) {
				do {
					deptno = rs.getInt("deptno");
					dname = rs.getString("dname");
					loc = rs.getString("loc");
					DeptVO vo = new DeptVO(deptno, dname, loc);
					al.add(vo);
				} while (rs.next());
				부서출력(al);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void 부서출력(ArrayList<DeptVO> al) {
		Iterator<DeptVO> ir = al.iterator();
		System.out.println("deptno\tdname\tloc\n");
		while (ir.hasNext()) {
			DeptVO deptVO = ir.next();
			System.out.println(deptVO);
		}

	}

	private static void 종료() {
		// 1. DB 닫기
		DBConn.close();
		// 1-2 스캐너 닫기
		sc.close();
		// 2. 종료메세지
		System.out.println("프로그램을 종료합니다.");
		System.exit(-1);

	}

	private static void 메뉴선택() {
		try {
			System.out.println("선택할 메뉴를 입력하세요");
			selectednum = sc.nextInt();
			sc.nextLine();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private static void 메뉴출력() {
		System.out.println("[메뉴]\n");
		for (int i = 0; i < menu.length; i++) {
			System.out.printf("%d. %s\n", i + 1, menu[i]);
		}

	}

}
