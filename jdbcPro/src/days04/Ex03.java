package days04;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.DBConn;

import oracle.jdbc.OracleTypes;

public class Ex03 {
	public static void main(String[] args) {
		//callablestatement - 저장 프로시저 ,저장 함수
		// [저장 프로시저] - 입력받은 ID를 사용 여부 체크하는 프로시저 
		//		ㄴ 회원가입 
		//			 아이디 : [ hong ] <중복여부체크버튼> 
		//			비밀번호 : 
		//			 이메일 
		// 			 연락처 .... 
		Scanner sc = new Scanner(System.in);
		System.out.print("중복체크할 사원번호를 입력하세요 > ");
		int id = sc.nextInt(); // 7369
		
		Connection conn = null ;
		CallableStatement cs = null;
		int check = 0 ;
		String sql = "{call up_dupid(?,?)}";
		conn = DBConn.getConnection();
		try {
			cs = conn.prepareCall(sql);
			cs.setInt(1, id);
			cs.registerOutParameter(2, OracleTypes.INTEGER); // 출력용 매개변수 설정 함수
			cs.executeQuery();
			check = cs.getInt(2);
			if (check == 0) {
				System.out.println("사용 가능한 사원번호입니다.");
			} else {
				System.out.println("이미 사용중인 사원번호입니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				cs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		DBConn.close();
		System.out.println(" end ");
	}
}
