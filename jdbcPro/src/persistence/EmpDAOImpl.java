package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.util.DBConn;

import domain.EMPVO;
import domain.Viewvo;

public class EmpDAOImpl implements EmpDAO{
	private Connection conn = null ;
	private PreparedStatement pstmt = null ;
	private ResultSet rs = null ;
	//생성자를 통한 DI
	public EmpDAOImpl(Connection conn) {
		this.conn = conn;
	}
	//2. Setter를 통한 DI
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public ArrayList<EMPVO> getEmpS() {
		ArrayList<EMPVO> al = null;

		int empno;
		String ename;
		String job;
		int mgr;
		Date hiredate;
		double sal;
		double comm;
		int deptno;
		String sql = "select * from emp";
		//PreparedStatement pst = null ;
		try {
			//           st = conn.createStatement();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//           rs = st.executeQuery(sql);
			if (rs.next()) {
				al = new ArrayList<EMPVO>();
				do {
					empno = rs.getInt(1);
					ename = rs.getString(2);
					job = rs.getString(3);
					mgr = rs.getInt(4);
					hiredate = rs.getDate(5);
					sal = rs.getDouble(6);
					comm = rs.getDouble(7);
					deptno = rs.getInt(8);
					EMPVO ev = new EMPVO(empno,ename,job,mgr,hiredate,sal,comm,deptno);
					al.add(ev);
				} while (rs.next());
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return al;
	}
	@Override
	public int addEmp(EMPVO vo) {

		String sql = " INSERT INTO emp ( deptno, empno, ename, job, mgr, hiredate, sal, comm  )"
				+ " VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )";
		int rowCount = 0;
		try {
		
			pstmt = conn.prepareStatement(sql);

			// ?, ?, ?  pstmt의 매개변수 설정 X
			// java.sql.SQLException: 부적합한 열 인덱스
			pstmt.setInt(1, vo.getDepno());
			pstmt.setInt(2, vo.getEmpno());
			pstmt.setString(3, vo.getEname());
			pstmt.setString(4, vo.getJob());
			pstmt.setInt(5, vo.getMgr());
			// java.util.date -> java.sql.date 변환
			long ms = vo.getHire().getTime(); // java.util.date
			java.sql.Date sdHiredate = new java.sql.Date(ms);
			//pstmt.setDate(6, (java.sql.Date)vo.getHire());
			pstmt.setDate(6, sdHiredate);
			pstmt.setDouble(7, vo.getSal());
			pstmt.setDouble(8, vo.getComm());

			//int rowCount = stmt.executeUpdate(sql);
		  rowCount = pstmt.executeUpdate();


			if (rowCount == 1) {
				System.out.println("사원 추가 성공!!");
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//stmt.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			
		}
		return rowCount;

	}
	@Override
	public int upEmp(EMPVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int delEmp(int empno) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int delEmp(ArrayList<Integer> empnos) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ArrayList<EMPVO> searchEmp(int searchCondition, String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public EMPVO getEmp(int empno) {
		// TODO Auto-generated method stub
		return null;
	}
}
