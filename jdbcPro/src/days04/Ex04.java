package days04;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.DBConn;

import oracle.jdbc.OracleTypes;

public class Ex04 {
	public static void main(String[] args) {
		//로그인 
		// 아이디 : [hong] empno
		// 비밀번호 : [1234] ename
		// <로그인 버튼> <회원가입 버튼> 
		
		//로그인 실패 , 성공 여부 출력
		
		//up_login 저장 프로시저
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디를 입력하세요.");
		int id = sc.nextInt();
		System.out.print("비밀번호를 입력하세요.");
		String pw = sc.next();
		String sql = "{call up_login (? ,? ,?)";
		Connection conn = null;
		CallableStatement cs = null;
		int check = 0;
		conn = DBConn.getConnection();
		try {
			cs = conn.prepareCall(sql);
			cs.setInt(1, id);
			cs.setString(2, pw);
			cs.registerOutParameter(3, OracleTypes.INTEGER);
			cs.executeQuery();
			check = cs.getInt(3);
			if (check==0) {
				System.out.println("비밀번호가 다릅니다.");
			} else if (check ==1) {
				System.out.println("로그인에 성공하였습니다.");
			}  else {
				System.out.println("맞는 회원정보가 없습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// 아이디가 존재하지 않는 경우 와 비밀번호가 다른경우를 나눔
	// DEPT  추가 /수정/삭제 하는 저장 프로시저 만들어서 CST 로 처리하는 코딩
}
