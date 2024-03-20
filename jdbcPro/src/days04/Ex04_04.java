package days04;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.DBConn;

public class Ex04_04 { //명건,영은
	
	 public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);
	      System.out.println(" 삭제할 empno 입력 ?");
	      int id = sc.nextInt();// 7369, 8888

	      Connection conn = null;
	      CallableStatement cstmt = null;

	      String sql = "{call up_delete (?)}";
	      //      String sql = "{call UP_IDCHECK (pid=>?,pcheck=>?)}";


	      conn = DBConn.getConnection();

	      try {
	         cstmt = conn.prepareCall(sql);
	         cstmt.setInt(1, id); //IN
	         cstmt.executeQuery();

	         int rowCount = cstmt.executeUpdate();

	         if (rowCount == 1) {
	            System.out.println("삭제 성공");
	         } else {
	            System.out.println("삭제 실패");
	         } 

	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         try {
	            cstmt.close();
	         } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }
	      }




	      DBConn.close();
	   }//m
}

/*
 * CREATE OR REPLACE PROCEDURE up_delete
(
    pempno IN emp.empno%TYPE
)
IS
    vdcount NUMBER;
BEGIN   
    DELETE FROM emp
    WHERE empno = pempno;
    vdcount := SQL%ROWCOUNT;
        IF vdcount = 0 THEN
            DBMS_OUTPUT.PUT_LINE('삭제안됨');
        ELSE
            COMMIT;
            DBMS_OUTPUT.PUT_LINE('삭제됨');
        END IF;
END;
*/