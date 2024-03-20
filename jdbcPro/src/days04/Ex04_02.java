package days04;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.DBConn;

import oracle.jdbc.OracleTypes;

public class Ex04_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("변경할 부서번호를 입력하세요.");
		int a = sc.nextInt();
		sc.nextLine();
		System.out.print("변경할 부서명을 입력하세요.");
		String b = sc.nextLine();
	
		System.out.println("변경할 지역명을 입력하세요.");
		String c = sc.nextLine();
		String sql = "{call up_update (? ,?, ?, ?)}";
		Connection conn = null;
		CallableStatement cs = null;
		int check = 0;
		conn = DBConn.getConnection();
		
		try {
			cs = conn.prepareCall(sql);
			cs.setInt(1, a);
			cs.setString(2, b);
			cs.setString(3, c);
			cs.registerOutParameter(4, OracleTypes.INTEGER);
			 cs.executeUpdate();
			 check = cs.getInt(4);
			 if (check ==0 ) {
				System.out.print("부서명만 변경완료되었습니다.");
			} else if (check == 1) {
				System.out.print("지역명만 변경완료되었습니다.");
			} else {
				System.out.println("모두 변경완료되었습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
/*//create or replace procedure up_update
(
		   pdeptno dept.deptno%type,
		   pdname dept.dname%type,
		   ploc dept.loc%type,
		   pcheck out number
		)
		is
		   vdname dept.dname%type;
		   vloc dept.loc%type;
		begin
		    vdname := pdname;
		    vloc := ploc;
		    if pdname is null and ploc is not null then 
		    select dname into vdname from dept where deptno = pdeptno;
		    pcheck:=1;
		    elsif ploc is null and pdname is not null then
		    select loc into vloc from dept where deptno = pdeptno;
		    pcheck:=0;
		    else 
		    pcheck:=2;
		    end if;
		    
		    update dept set dname = vdname ,loc=vloc where deptno = pdeptno ;
		    
		end;*/
		
