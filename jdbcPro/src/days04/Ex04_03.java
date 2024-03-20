package days04;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.DBConn;

import oracle.jdbc.OracleTypes;

public class Ex04_03 { //추가 //원대안, 이동찬
	// MAIN JAVA INSERT 
	public static void main(String[] args) {
	      String sql = "{call i_dept (?,?,?,?)}";
	      Connection conn = null;
	      Scanner scanner = new Scanner(System.in);
	      System.out.println("> 넣을 부서 번호 입력 ");
	      int deptno = scanner.nextInt();
	      scanner.nextLine();
	      System.out.println("> 넣을 부서명 입력 ? ");
	      String dname = scanner.nextLine();
	      
	      System.out.println("> 넣을 부서 위치 입력 ");
	      String loc = scanner.nextLine();      
	      
	      CallableStatement cstmt = null;
	      int check = 0;
	      
	      conn = DBConn.getConnection();
	      try {
	         cstmt = conn.prepareCall(sql);
	         cstmt.setInt(1, deptno);
	         cstmt.setString(2, dname);
	         cstmt.setString(3, loc);
	         cstmt.registerOutParameter(4, OracleTypes.INTEGER);
	         cstmt.executeQuery();
	         check = cstmt.getInt(4);
	         if (check == 0 ) {
	            System.out.println("부서 생성에 성공하였습니다. ");
	         } else {
	            System.out.println("이미 존재하는 부서입니다.");
	         }
	         
	      } catch (SQLException e) {
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
	      System.out.println("END");
	   } 

}

/*
 * -- dept INSERT 프로시저
CREATE OR REPLACE PROCEDURE i_dept
(
pnumber dept.deptno%TYPE,
pdname dept.dname%TYPE,
ploc dept.loc%TYPE,
pcheck OUT NUMBER
)
IS
vaild NUMBER(1);
BEGIN
    SELECT COUNT(deptno) into vaild
    FROM dept
    WHERE deptno = pnumber;
    
    IF vaild = 1 THEN
        pcheck := 1;
    ELSE 
        INSERT INTO dept VALUES(pnumber, pdname,ploc);
        pcheck := 0 ;
    END IF;
--EXCEPTION
END;
 */
