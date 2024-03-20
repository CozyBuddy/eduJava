package days03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Map.Entry;

import com.util.DBConn;

import domain.DeptEmpSalVo;
import domain.SalgradeVO;

public class Review {
	public static void main(String[] args) {
		String sql ="select s.grade ,s.losal,s.hisal ,count(*) cnt from salgrade s join emp e on  s.losal<= e.sal and s.hisal>=e.sal group by s.grade ,s.losal,s.hisal order by s.grade" ;
		String sqlemp = "select d.deptno,dname,empno,ename,sal,hiredate from dept d right join emp e on d.deptno = e.deptno join salgrade s on sal between losal and hisal where  grade = ? "; 
		
		Connection conn = null ;
		PreparedStatement pst = null;
		PreparedStatement pst2 = null;
		SalgradeVO vo = null ;
		DeptEmpSalVo des = null ;
		ArrayList<DeptEmpSalVo> al = null ;
		ResultSet rs = null;
		ResultSet rs2 = null;
		LinkedHashMap<SalgradeVO, ArrayList<DeptEmpSalVo>>  lhm= new LinkedHashMap<SalgradeVO, ArrayList<DeptEmpSalVo>>();
		conn = DBConn.getConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()) {
				do {
					int grade = rs.getInt("grade");
					vo = new SalgradeVO(grade, rs.getInt("losal"), rs.getInt("hisal"), rs.getInt("cnt"));
					
					pst2 = conn.prepareStatement(sqlemp);
					pst2.setInt(1, grade);
					rs2 = pst2.executeQuery();
			
			
				if (rs2.next()) {
					
	
					do {
						al = new ArrayList<DeptEmpSalVo>();
						des = new DeptEmpSalVo(rs2.getInt("empno"), rs2.getString("dname"), rs2.getString("ename"), rs2.getInt("sal"), rs2.getDate("hiredate"), rs2.getInt("deptno"));
						al.add(des);
						
					} while (rs2.next());
					lhm.put(vo, al);
				}
			} while (rs.next());
		}
			
			rs2.close();
			pst2.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				DBConn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		DispSalgrade(lhm);
		
		
		
	}
	private static void DispSalgrade(
			LinkedHashMap<SalgradeVO, ArrayList<DeptEmpSalVo>> map) {
		Set<Entry<SalgradeVO, ArrayList<DeptEmpSalVo>>> set = map.entrySet();
		Iterator<Entry<SalgradeVO, ArrayList<DeptEmpSalVo>>> ir = set.iterator();
		while (ir.hasNext()) {
			Entry<SalgradeVO, ArrayList<DeptEmpSalVo>> entry = 
					   ir.next();
			SalgradeVO vo =  entry.getKey();
			ArrayList<DeptEmpSalVo> list = entry.getValue();
			// 출력
			System.out.printf("%d등급	( %d~%d ) - %d명\n"
					, vo.getGrade()
					, vo.getLosal()
					, vo.getHisal()
					, vo.getCnt());
			// 사원 출력
			Iterator<DeptEmpSalVo> ir2 = list.iterator();
			while (ir2.hasNext()) {
				DeptEmpSalVo empvo = ir2.next();
				System.out.printf(
						"\t\t%s\t%d\t%s\t%d\n"
						, empvo.getDname()
						, empvo.getEmpno()
						, empvo.getEname()
						, empvo.getSal());
			}
		} // while
	}

}
