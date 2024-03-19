package days03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;

import com.util.DBConn;

import domain.DeptEmpSalVo;
import domain.EMPVO;
import domain.SalgradeVO;

public class Ex03_02 {
	public static void main(String[] args) {
     String sql ="select s.grade ,s.losal,s.hisal ,count(*) "+"cnt"
     		+ " from salgrade s right join emp e on  s.losal<= e.sal and s.hisal>=e.sal "
     		+ "group by s.grade ,s.losal,s.hisal order by s.grade";
	String empsql = "select d.deptno,dname,empno,ename,sal from dept d right join emp e on"
				+ " d.deptno = e.deptno join salgrade s on sal between losal and hisal where "
				+ "grade =1";
     Connection conn = null ;
     PreparedStatement pst = null ,empPst=null;
     ResultSet rs = null ,empRs = null ;
     SalgradeVO vo = null; // key
     //ArrayList<SalgradeVO> list = null ;
     ArrayList<DeptEmpSalVo> emplist = null ; //value
     LinkedHashMap<SalgradeVO, ArrayList<DeptEmpSalVo>> map = new LinkedHashMap<SalgradeVO, ArrayList<DeptEmpSalVo>>();
     DeptEmpSalVo empvo = null;
     
     conn = DBConn.getConnection();
     try {
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();
		if (rs.next()) {
			do {
				
				int grade = rs.getInt("grade");
				vo = new SalgradeVO(grade, rs.getInt("losal"), rs.getInt("hisal"),rs.getInt("cnt"));
				empPst = conn.prepareStatement(empsql);
				empPst.setInt(1, grade);
				empRs = empPst.executeQuery();
				if (empRs.next()) {
					emplist = new ArrayList<DeptEmpSalVo>();
					do {
						// d.deptno,dname,empno,ename,sal
						empvo = new DeptEmpSalVo(empRs.getInt("empno"), empRs.getString("dname"), empRs.getString("ename"), empRs.getInt("sal"), empRs.getDate("hiredate"),empRs.getInt("deptno"));
					
					} while (empRs.next());
					
				}
				map.put(vo, emplist);
				empRs.close();
				empPst.close();
			} while (rs.next());
			
		}
		DispSalgrade(map);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
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
     // 1.
     // 2.
     // 3.
     // 4.
	}

	private static void DispSalgrade(LinkedHashMap<SalgradeVO, ArrayList<DeptEmpSalVo>> map) {
		Set<Entry<SalgradeVO, ArrayList<DeptEmpSalVo>>> set = map.entrySet();
		
	}

	private static void DispSalgrade(ArrayList<SalgradeVO> list) {
		Iterator<SalgradeVO> ir = list.iterator();
		while (ir.hasNext()) {
			SalgradeVO vo =  ir.next();
			System.out.printf("%d등급 ( %d ~ %d) - %d명\n",vo.getGrade(),vo.getLosal(),vo.getHisal(),vo.getCnt());
			
		}
		
	}

}