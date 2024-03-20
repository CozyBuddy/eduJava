package days04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBConn;

import domain.DeptVO;
import domain.EMPVO;

/**
 * @author user
 * @date 2024. 3. 20. 오전 10:50:01
 * @subject	문제점) 부서가 존재하지 않는 King 사원처리 X where deptno is null 실행 관련 코딩을 수정
 * @contents
 */
public class Ex01_02 {
	
   public static void main(String[] args) {
      String deptSql = "SELECT d.deptno, dname, COUNT(*) cnt "
            + "FROM dept d RIGHT JOIN emp e ON d.deptno = e.deptno "
            + "GROUP BY d.deptno, dname "
            + "ORDER BY d.deptno ASC";
      String empSql = "SELECT empno, ename, hiredate, sal+NVL(comm,0) pay "
            + "FROM emp e JOIN dept d ON e.deptno = d.deptno "
            + "WHERE d.deptno = ?";
      
      Connection conn = null;
      PreparedStatement deptPstmt = null, empPstmt = null;
      ResultSet deptRs = null, empRs = null;
      
      DeptVO dvo = new DeptVO();
      EMPVO evo = new EMPVO();
      
      conn = DBConn.getConnection();
      try {
         deptPstmt = conn.prepareStatement(deptSql);
         deptRs = deptPstmt.executeQuery();
         if (deptRs.next()) {
            do {
               int deptno = deptRs.getInt("deptno");
               dvo = DeptVO.builder()
                     .deptno(deptno)
                     .dname(deptRs.getString("dname"))
                     .build();
                     System.out.printf("%s(%d)-00명\n", dvo.getDname(), dvo.getDeptno());
                     // START
                     empPstmt = conn.prepareStatement(empSql);
                     empPstmt.setInt(1, deptno);
                     empRs = empPstmt.executeQuery();
                     if (empRs.next()) {
                        do {
                           evo = EMPVO.builder()
                                 .empno(empRs.getInt(1))
                                 .ename(empRs.getString(2))
                                 .hiredate(empRs.getDate(3))
                                 .sal(empRs.getDouble(4))
                                 .build();
                           System.out.printf("\t%d \t%s \t%s \t%.2f\n", evo.getEmpno(), evo.getEname(), evo.getHiredate(), evo.getSal());
                        } while (empRs.next());
                     }
                     
                     empRs.close();
                     empPstmt.close();
                     // END
            } while (deptRs.next());
         } // if
      } catch (SQLException e) {
         e.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            deptPstmt.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      DBConn.getConnection();
   }

}