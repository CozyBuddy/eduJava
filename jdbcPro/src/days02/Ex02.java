package days02;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
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

/**
 * @author user
 * @date 2024. 3. 18. 오전 11:44:36
 * @subject dept 부서 테이블에 추가 ,수정,삭제 ,조회 CRUD
 * @contents
 */
public class Ex02 {
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

	/*private static void 부서검색() {
		//검색 조건 입력? 1(부서번호) , 2(부서명) , 3(지역명)
		//select * from dept where deptno = 10 //1번을 누르면 부서번호로 이렇게 검색
		//select * from dept where regexp_like ( dname,'lo','i')//2번을 누르면 부서명로 이렇게 검색
		//select * from dept where regexp_like ( loc,'SL','i')//3번을 누르면 부서명로 이렇게 검색
		int d;
		String e;
		String f;
		ArrayList<DeptVO> al = new ArrayList<DeptVO>();
		System.out.print("부서번호(1),부서명(2),지역명(3)을 검색할 조건을 숫자로 입력하세요.");
		int a = sc.nextInt();
		if (a==1) {
			System.out.println("검색할 부서번호를 입력하세요.");
			String b = sc.next();
			ResultSet RS;
			String sql = "select * from dept where deptno=" + b + "";
			Statement st = null;
			try {
				st = conn.createStatement();
				RS = st.executeQuery(sql);
				while (RS.next()) {
					d = RS.getInt(1);
					e = RS.getString(2);
					f = RS.getString(3);
					DeptVO vo = new DeptVO(d, e, f);
					al.add(vo);
				}
				부서출력(al);
				
			} catch (SQLException h) {
				// TODO Auto-generated catch block
				h.printStackTrace();
			}
		} else if (a==2) {
			System.out.println("검색할 부서명을 입력하세요.");
			String b = sc.next();
			ResultSet RS;
			String sql = "select * from dept where dname= '" + b + "'";
			Statement st = null;
			try {
				st = conn.createStatement();
				RS = st.executeQuery(sql);
				while (RS.next()) {
					d = RS.getInt(1);
					e = RS.getString(2);
					f = RS.getString(3);
					DeptVO vo = new DeptVO(d, e, f);
					al.add(vo);
				}
				부서출력(al);
			
				
			} catch (SQLException h) {
				// TODO Auto-generated catch block
				h.printStackTrace();
			}
		} else if (a==3) {
			System.out.println("검색할 지역명을 입력하세요");
			String b = sc.next();
			ResultSet RS;
			String sql = "select * from dept where loc='" + b + "'";
			Statement st = null;
			try {
				st = conn.createStatement();
				RS = st.executeQuery(sql);
				while (RS.next()) {
					d = RS.getInt(1);
					e = RS.getString(2);
					f = RS.getString(3);
					DeptVO vo = new DeptVO(d, e, f);
					al.add(vo);
				}
				부서출력(al);
			
				
			} catch (SQLException h) {
				// TODO Auto-generated catch block
				h.printStackTrace();
			}
		}
		//검색어 입력 ?
		
		
		
		//부서출력 메서드 
		
	}*/

	private static void 부서검색() {
		ArrayList<DeptVO> al = new ArrayList<DeptVO>();
		int deptno;
		String dname;
		String loc;
		Statement st = null;
		ResultSet rs = null;
		int searchCondition = 1;
		String searchWord = null ;
		System.out.println("검색조건을 입력하세요");
		searchCondition = sc.nextInt();
		sc.nextLine();
		System.out.println("검색어를 입력하세요");
		searchWord = sc.next();
		
		String sql = "select * from dept where ";
		if (searchCondition==1) {
			sql+= String.format("deptno in (%s)",searchWord.trim());
		} else if (searchCondition==2) {
			sql+= String.format("REGEXP_LIKE(dname,'%s','i')",searchWord.trim());
		} else if (searchCondition==3) {
			sql+= String.format("REGEXP_LIKE(loc,'%s','i')",searchWord.trim());
		} else if (searchCondition==4) {
			sql += String.format("REGEXP_LIKE(dname,'%1$s', 'i') or REGEXP_LIKE(loc,'%1$s', 'i')",searchWord.trim());
		}
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
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
				st.close();
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
			String loc = sc.next();
		
		if (dname.equals("")) {
			ResultSet RS;
			String sql = "select dname from dept where deptno=" + deptno + "";
			Statement st = null;
			try {
				st = conn.createStatement();
				RS = st.executeQuery(sql);
				while (RS.next()) {
					dname = RS.getString("dname");
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (loc == "") {
			ResultSet RS;
			String sql = "select loc from dept where deptno=" + deptno + "";
			Statement st = null;
			try {
				st = conn.createStatement();
				 RS =st.executeQuery(sql);
				 while (RS.next()) {
						loc = RS.getString("loc");
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		String sql = "update dept set dname = '" + dname + "', loc='" + loc + "' where deptno = " + deptno + "";
		Statement st = null;

		try {
			st = conn.createStatement();

			int rowcount = st.executeUpdate(sql);
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
		String sql = String.format("delete from dept where deptno in(%s)", a);
		
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
		String sql = "Insert into dept values (" + deptno + ",'" + dname + "','" + loc + "')";
		Statement st = null;
		try {
			st = conn.createStatement();
			int rowcount = st.executeUpdate(sql);
			if (rowcount == 1) {
				System.out.println("부서추가 성공");
			}
			rowcount = 0;
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
		Statement st = null;
		ResultSet rs = null;
		int deptno;
		String dname, loc;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from dept order by deptno");
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
				st.close();
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
