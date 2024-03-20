
	package days03;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.Date;
	import java.util.Iterator;
	import java.util.LinkedHashMap;
	import java.util.Map.Entry;
	import java.util.Set;

	import com.util.DBConn;

	import domain.DeptcVO;
	import domain.EmpcVO;

	public class Review2 {
		public static void main(String[] args) {
			String sql = "select d.deptno,dname, count(*) cnt from dept d left join emp e on e.deptno = d.deptno group by d.deptno,dname";
			String esql = "select d.deptno ,empno,ename,hiredate, sal  from emp e right join dept d on d.deptno=e.deptno where e.deptno =  ? ";
			
			PreparedStatement pst = null;
			PreparedStatement pst2 = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			Connection conn = null ;
			ArrayList<EmpcVO> al = null;
			LinkedHashMap<DeptcVO, ArrayList<EmpcVO>> lhm = new LinkedHashMap<DeptcVO, ArrayList<EmpcVO>>();
			EmpcVO ev = null;
			DeptcVO dv= null;
			
			conn = DBConn.getConnection();
			try {
				
					pst = conn.prepareStatement(sql);
					rs = pst.executeQuery();
				if (rs.next()) {
					do {
					 int deptno =rs.getInt("deptno");
					 dv = new DeptcVO(rs.getString("dname"),deptno, rs.getInt("cnt"));
					 pst2 = conn.prepareStatement(esql);
					
					 pst2.setInt(1, deptno );
					 rs2 = pst2.executeQuery();
					 if (rs2.next()) {
						 al = new ArrayList<EmpcVO>();
						 do {
								
								ev = new EmpcVO(rs2.getInt("deptno"),
										rs2.getInt("empno"),
										rs2.getString("ename"),
										(java.util.Date)rs2.getDate("hiredate"),rs2.getInt("sal"));
								
								
								 al.add(ev);
						 } while (rs2.next());
						
						 lhm.put(dv, al);
						 pst2.close();
						 rs2.close();
						
					}
					
				
					
					
					
					
					
				  } while (rs.next());
					
					
			 }
				
				displhm(lhm);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					rs.close();
					pst.close();
					DBConn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			
		}

		private static void displhm(LinkedHashMap<DeptcVO, ArrayList<EmpcVO>> lhm) {
			Set<Entry<DeptcVO, ArrayList<EmpcVO>>> st = lhm.entrySet();
			Iterator<Entry<DeptcVO, ArrayList<EmpcVO>>> ir = st.iterator();
			while (ir.hasNext()) {
				Entry<DeptcVO, ArrayList<EmpcVO>> ey =  ir.next();
				DeptcVO dv = ey.getKey();
				ArrayList<EmpcVO> al2 = ey.getValue();
				System.out.println("부서명 : "+dv.getDname()+"(" + dv.getDeptno() +")"+ "인원수 :"+ dv.getCount());
				
				Iterator<EmpcVO> ir2 = al2.iterator();
				while (ir2.hasNext()) {
					EmpcVO empcVO =  ir2.next();
					System.out.print( "EMPNO : " + empcVO.getEmpno() + "사원이름 : " + empcVO.getEname() +"사원고용일자 :"+ empcVO.getHiredate() +"급여 : "+ empcVO.getSal()+"\n");
					
				}
				
				
				
			}
			
		}

	}


