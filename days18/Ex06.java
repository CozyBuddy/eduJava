package days18;

/**
 * @author user
 * @date 2024. 1. 24. 오후 4:03:43
 * @subject
 * @contents
 */
public class Ex06 {
	public static void main(String[] args) {
		// 			동기화처리 여부에 따라 차이 나머지 사용법 ,메서드는 동일
		//		     StringBuffer  StringBuilder
		// 멀티스레드     안전o			안전x
		// 동기화처리		  o				 x	
		String sql = "SELECT "; 
	      sql += "a.ano ";
	      sql += " ";
	      sql += ", a.user_id as userId ";
	      sql += " ";
	      sql += ", b.user_name as userName ";
	      sql += " ";
	      sql += ", a.rno ";
	      sql += " ";
	      sql += ", c.rname ";
	      sql += " ";
	      sql += ", DATE_FORMAT(a.sd,'%Y-%m-%d') as sd ";
	      sql += " ";
	      sql += ", DATE_FORMAT(a.ed,'%Y-%m-%d') as ed ";
	      sql += " ";
	      sql += ", DATE_FORMAT(a.rd,'%Y-%m-%d %T') as rd ";
	      sql += " ";
	      sql += ", DATE_FORMAT(a.check_in,'%Y-%m-%d %T') as checkIn ";
	      sql += " ";
	      sql += ", DATE_FORMAT(a.check_out,'%Y-%m-%d %T') as checkOut ";
	      sql += " ";
	      sql += "-- , a.sign_yn as signYn ";
	      sql += " ";
	      sql += ", d.code_name as signYn ";
	      sql += " ";
	      sql += "-- , a.cancel_yn as cancelYn ";
	      sql += " ";
	      sql += ", e.code_name as cancelYn ";
	      sql += " ";
	      sql += "FROM tb_reservation a left outer join tb_user b on a.user_id = b.user_id ";
	      sql += " ";
	      sql += "left outer join tb_rooms c on a.rno = c.rno ";
	      sql += " ";
	      sql += "left outer join tb_code d on a.sign_yn = d.code_cd ";
	      sql += " ";
	      sql += "left outer join tb_code e on a.cancel_yn = e.code_cd ";

	      System.out.println( sql );
	}

}
