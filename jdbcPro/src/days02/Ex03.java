package days02;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.util.DBConn;

import domain.EMPVO;

/**
 * @author user
 * @date 2024. 3. 18. 오후 4:49:26
 * @subject
 * @contents
 */
public class Ex03 {
   public static Connection conn;
   public static Scanner sc = new Scanner(System.in);
   public static ArrayList<EMPVO> al = new ArrayList<EMPVO>();
   public static void main(String[] args) throws SQLException {
      conn = DBConn.getConnection();
      사원조회();
	  //사원삭제();
			 사원추가(); //이시은
			 System.out.println("계속하시려면 엔터를 누르세요");
			 try {
			 System.in.read();
			 System.in.skip(System.in.available());
			 } catch (IOException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 }
			 사원조회();
			 System.out.println("계속하시려면 엔터를 누르세요");
			 try {
			 System.in.read();
			 System.in.skip(System.in.available());
			 } catch (IOException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 }
			 사원수정();
			 //직원수정();
			 
			 System.out.println("계속하시려면 엔터를 누르세요");
			 try {
			 System.in.read();
			 System.in.skip(System.in.available());
			 } catch (IOException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 }
			// 6명 , 7명인 조 
			//[팀문제]
			//emp 사원테이블  -
			//1) 사원추가 쿼리
			//2) 사원정보수정
			//3) 사원삭제 
			//4) 사원검색
			//5) 사원조회
			사원검색(); // 권맑음
			System.out.println("계속하시려면 엔터를 누르세요");
			try {
			 System.in.read();
			 System.in.skip(System.in.available());
			} catch (IOException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			}
			
			
			사원조회(); //이동찬
			System.out.println("계속하시려면 엔터를 누르세요");
			try {
			 System.in.read();
			 System.in.skip(System.in.available());
			} catch (IOException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			}
      사원삭제(); //류영은
      
      
      DBConn.close();
      System.exit(-1);
      
   }

   private static void 직원수정() {
	      System.out.print("> 수정할 직원번호 입력하세요 ? ");
	      int empno = sc.nextInt();
	      sc.nextLine();  
	      System.out.print("> 수정할 직원명 입력하세요 ? ");
	      String ename = sc.nextLine(); 
	      System.out.print("> 수정할 직무 입력하세요 ? ");
	      String job  = sc.nextLine(); 
	      System.out.print("> 수정할 상사의 사원번호를 입력하세요 ? ");
	      int mgr = sc.nextInt();
	      sc.nextLine(); 
	      System.out.print("> 수정할 입사일을 입력하세요 ? (yyyy-MM-dd 형식으로 입력하세요) ");
	      String hiredate = sc.nextLine(); 
	      System.out.print("> 수정할 급여를 입력하세요 ? ");
	      int sal = sc.nextInt();
	      sc.nextLine(); 
	      System.out.print("> 수정할 보너스를 입력하세요 ? ");
	      int comm = sc.nextInt();
	      sc.nextLine(); 
	      System.out.print("> 수정할 부서번호를 입력하세요 ? ");
	      int deptno = sc.nextInt();
	      sc.nextLine(); 

	      String sql = null;


	      sql = " UPDATE emp SET"
	                  + " ename = ? ,job = ?, mgr = ?, hiredate = TO_DATE(?, 'YYYY-MM-DD'), sal = ?, comm = ?, deptno = ? "
	                  + " WHERE empno = ?";

	      System.out.println(sql); 

	      PreparedStatement pstmt = null;
	      try {

	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, ename);
	         pstmt.setString(2, job);
	         pstmt.setInt(3, mgr);
	         pstmt.setString(4, hiredate);
	         pstmt.setInt(5, sal);
	         pstmt.setInt(6, comm);
	         pstmt.setInt(7, deptno);
	         pstmt.setInt(8, empno);
	         

	         int rowCount = pstmt.executeUpdate();

	         if (rowCount==1) {
	            System.out.println("부서 수정 성공!!!");
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            pstmt.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	   }

		/* private static void editemp() throws IOException {
		      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//	      Statement stmt = null;
		      PreparedStatement pstmt = null;
		      ResultSet rs = null;
		      try {
		//	         stmt = conn.createStatement();
		         String sql = "SELECT * FROM emp WHERE 1 != 0";
		         pstmt = conn.prepareStatement(sql);
		         rs = pstmt.executeQuery();
		         ResultSetMetaData rsmd = rs.getMetaData();
		         String [] columnName = new String[rsmd.getColumnCount() - 1];
		         String [] updateColumn = new String[rsmd.getColumnCount() -1 ];
		            // 컬럼의 인덱스가 1부터 시작하기 때문에 for-loop도 1부터 시작하도록 함
		         for(int i = 2; i <= rsmd.getColumnCount(); i++) {
		              // columnType은 java.sql.Types 에 선언되어있다.
		            int columnType = rsmd.getColumnType(i);
		            columnName[i - 2] = rsmd.getColumnName(i);
		         }  
		         System.out.println("사원 번호를 입력하세요.");
		         int empno = Integer.parseInt(br.readLine());
		         
		         for (int i = 0; i < columnName.length; i++) {
		            System.out.printf("%s 정보를 입력하세요 ", columnName[i]);
		            updateColumn[i] = br.readLine();
		         }
		         
		       
		         for (int i = 0; i < updateColumn.length; i++) {
		         if ( updateColumn[i].isEmpty() ) {
		            sql = String.format("SELECT %s FROM emp WHERE empno = ? ", columnName[i]);
		            pstmt = conn.prepareStatement(sql);
		            pstmt.setInt(1, empno);
		            rs = pstmt.executeQuery();
		            rs.next();
		            updateColumn[i] = rs.getString(columnName[i]);
		            System.out.println(updateColumn[i]);
		         }
		         }
		         
		         int rowCount = 0 ;
		         sql = "UPDATE emp SET ";
		         for (int i = 0; i < updateColumn.length; i++) {
		            if (columnName[i].equals("HIREDATE")) {
		               String hiredate = updateColumn[i];
		               hiredate = hiredate.replaceAll("-", "/");
		               hiredate = hiredate.substring(0,10);
		               sql += String.format("%s = '%s', ", columnName[i],  hiredate);
		            } else 
		               sql += String.format("%s = '%s', ", columnName[i],  updateColumn[i] == null ? "0" : updateColumn[i]);
		         }
		         sql = sql.substring(0,sql.length()-2);
		         sql += "WHERE empno = " + empno;
		        
		         
		         pstmt = conn.prepareStatement(sql);
		         
		         rowCount = pstmt.executeUpdate();
		      System.out.println(rowCount + "행의 정보가 수정되었습니다.");
		       
		         
		      } catch (SQLException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      } finally {
		         try {
		            br.close();
		            pstmt.close();
		            rs.close();
		            conn.close();
		            
		         } catch (SQLException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		         }
		         
		      }
		      
		      
		   }*/
   private static void 사원수정() {
      System.out.println("수정할 사원의 사원번호를 입력하세요");
      int empno =sc.nextInt();
      sc.nextLine();
   
      System.out.println("수정할 사원이름을 입력하세요");
      String b = sc.nextLine();
     
      System.out.println("수정할 사원의 직업을 입력하세요");
      String job =sc.nextLine();
     
      System.out.println("수정할 사원의 매니저번호를 입력하세요");
      String MGR =sc.nextLine();
   
      System.out.println("수정할 사원의 고용일자를 입력하세요");
      String hire =sc.nextLine();
    
      System.out.println("수정할 사원의 급여를 입력하세요");
      String sal =sc.nextLine();
      
      System.out.println("수정할 사원의 성과급을 입력하세요");
      String comm =sc.nextLine();
      
      System.out.println("수정할 사원의 부서번호를 입력하세요");
      String deptno =sc.nextLine();
  
      String sql = String.format("update emp set %s %s %s %s %s %s %s  where empno = %d",
    		  (b.equals("")?"ename=ename":"ename='"+b+"'"),(job.equals("")?"":",job= '"+job+"'"),
    		  (MGR.equals("")?"":",mgr='"+MGR+"'"),(hire.equals("")?"":",hiredate = '"+hire+"'"),(sal.equals("")?"":",sal= '"+sal+"'"),
    		  (comm.equals("")?"":",comm = '"+comm+"'"),(deptno.equals("")?"":",deptno= '"+deptno+"'"),empno );
      PreparedStatement pst = null;
      //Statement st = null ;
      try {
         //st = conn.createStatement();
    	  pst = conn.prepareStatement(sql);
    	  //int c =st.executeUpdate(sql);
         int c =pst.executeUpdate();
         if (c==1) {
            System.out.println("사원정보 수정 성공");
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      
      
   }
   private static void 사원조회() {
	      int empno;
	      String ename;
	      String job;
	      int mgr;
	      String hire;
	      int sal;
	      int comm;
	      int deptno;
	      ResultSet rs ;
	      String sql = "select * from emp";
	      PreparedStatement pst = null ;
	      try {
//	         st = conn.createStatement();
	          pst = conn.prepareStatement(sql);
	          rs = pst.executeQuery();
//	         rs = st.executeQuery(sql);
	         while (rs.next()) {
	            empno = rs.getInt(1);
	            ename = rs.getString(2);
	            job = rs.getString(3);
	            mgr = rs.getInt(4);
	            hire = rs.getString(5);
	            sal = rs.getInt(6);
	            comm = rs.getInt(7);
	            deptno = rs.getInt(8);
	            EMPVO ev = new EMPVO(empno,ename,job,mgr,hire,sal,comm,deptno);
	            al.add(ev);
	         }
	         정보출력(al);
	         
	         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      
	   }
   private static void 사원검색() {
      int empno;
      String ename;
      String job;
      int mgr;
      String hire;
      int sal;
      int comm;
      int deptno;
      al.clear();
      System.out.println("검색할 조건을 입력하세요> (1=>사원번호,2=>사원이름)");
      int c = sc.nextInt();
      if (c==2) {
         
   
      System.out.print("검색할 사원의 이름을 입력하세요>");
      String a = sc.next();
      ResultSet rs ;
      String sql = "select * from emp where regexp_like ( ename,?,'i')";
      //Statement st = null ;
      PreparedStatement pst = null;
      try {
         pst = conn.prepareStatement(sql);
         pst.setString(1, a);
         rs = pst.executeQuery();
         while (rs.next()) {
            empno = rs.getInt(1);
            ename = rs.getString(2);
            job = rs.getString(3);
            mgr = rs.getInt(4);
            hire = rs.getString(5);
            sal = rs.getInt(6);
            comm = rs.getInt(7);
            deptno = rs.getInt(8);
            EMPVO ev = new EMPVO(empno,ename,job,mgr,hire,sal,comm,deptno);
            al.add(ev);
         }
         정보출력(al);
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      } else if (c==1) {
         System.out.print("검색할 사원번호를 입력하세요>");
         int a = sc.nextInt();
         ResultSet rs ;
         String sql = "select * from emp where empno=?";
         //Statement st = null ;
         PreparedStatement pst = null ;
         try {
        	//st = conn.createStatement();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, a);
            
            rs = pst.executeQuery();
            while (rs.next()) {
               empno = rs.getInt(1);
               ename = rs.getString(2);
               job = rs.getString(3);
               mgr = rs.getInt(4);
               hire = rs.getString(5);
               sal = rs.getInt(6);
               comm = rs.getInt(7);
               deptno = rs.getInt(8);
               EMPVO ev = new EMPVO(empno,ename,job,mgr,hire,sal,comm,deptno);
               al.add(ev);
            }
            정보출력(al);
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
      }
      
      
   }
   private static void 정보출력(ArrayList<EMPVO> al2) {
      Iterator<EMPVO> ir = al2.iterator();
      while (ir.hasNext()) {
         EMPVO empvo =  ir.next();
         System.out.println(empvo);
      }
      al2.clear();
      
   } 
   private static void 사원삭제() {
	      System.out.println("삭제할 사원번호 입력 ? "); 
	      int empno = sc.nextInt();
	      String sql  = "DELETE FROM emp WHERE empno = ?";
	      PreparedStatement pstmt = null;
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt .setInt(1, empno);
	         int rowCount = pstmt.executeUpdate();

	         if (rowCount == 1) {
	             System.out.println("삭제 성공 ");
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	     } finally {
	         try {
	             if (pstmt != null) {
	                 pstmt.close();
	             }
	         } catch (SQLException e) {
	             e.printStackTrace();
	         }
	     }
	 }
   private static void 사원추가() {
	      System.out.println("> 사원번호, 사원명, 직업, MGR, 고용일자, SAL, COMM, 부서번호 입력하세요? ");
	      int empno = sc.nextInt();
	      String ename = sc.next();
	      String job = sc.next();
	      int mgr = sc.nextInt();
	      String hiredate = sc.next();
	      int sal = sc.nextInt();
	      int comm = sc.nextInt();
	      int deptno = sc.nextInt();
	     
	      
	      String sql ="INSERT INTO emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) "
	             + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	      
	      // Statement stmt = null;
	      PreparedStatement pstmt = null;
	      
	      try {
	          // stmt = conn.createStatement();
	          pstmt = conn.prepareStatement(sql);
	          
	          pstmt.setInt(1, empno);
	          pstmt.setString(2, ename);
	          pstmt.setString(3, job);
	          pstmt.setInt(4, mgr);
	          pstmt.setString(5, hiredate);
	          pstmt.setInt(6, sal);
	          pstmt.setInt(7, comm);
	          pstmt.setInt(8, deptno);
	         
	         // int rowCount = stmt.executeUpdate(sql);
	          int rowCount = pstmt.executeUpdate();

	         if (rowCount ==1) {
	            System.out.println(" 부서 추가 성공!!! ");
	         }

	         // COMMIT or ROLLBACK 
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         try {
	            // stmt.close();
	            pstmt.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      
	   }


   
   

}