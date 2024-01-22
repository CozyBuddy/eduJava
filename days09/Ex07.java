package days09;

/**
 * @author user
 * @date 2024. 1. 11. 오후 12:10:11
 * @subject
 * @contents
 */
public class Ex07 {
	public static void main(String[] args) {
		/* Resident registration number, RRN
		 * [주민등록번호] 
		 *  1.생년월일
		 *  2.성별 
		 *  3.내국인/외국인
		 *  4.출신지역
		 *  5.나이(퇴직일)
		 *  6.검증
		 */
		String rrn = "731127-5121311";
		// 주민등록번호 -> 생년월일
		// "1999년 1월 23일"
		String birthday = getBirth(rrn);
		System.out.println(birthday);
	}
	// 주민등록번호로 부터 성별 얻어오는 기능
	// 매개변수 : 주민등록번호
	// 리턴값(리턴자료형) : 남/여 1/2/G 정수 )
	// 
	private static int getGender(String rrn) { // 이방식이 추후에 활용하기에 더 좋음.
		char a = rrn.charAt(7);  //'1' - 48 
		return a-48;
	}
	private static String getBirth(String rrn) {
		int year = Integer.parseInt(rrn.substring(0,2));
		int month = Integer.parseInt(rrn.substring(2,4));
		int day = Integer.parseInt(rrn.substring(4,6));
		int gender = getGender(rrn);
		switch (gender) {
		case 9: case 0:
			year += 1800;
			break;
		case 1: case 2: case 5: case 6:
			year += 1900;
			break;
		case 3: case 4: case 7: case 8:
			year +=2000;
			break;
		}
		String birthday = String.format("%d년 %d월 %d일",year,month,day);
		return  birthday;
		
	}

	/*
	 * private static String getBirth(String rrn) { int year =
	 * Integer.parseInt(rrn.substring(0,2)); int month =
	 * Integer.parseInt(rrn.substring(2,4)); int day =
	 * Integer.parseInt(rrn.substring(4,6)); int G =
	 * Integer.parseInt(rrn.substring(7,8)); if (G==9||G==0) { G =18; } else
	 * if(G==1||G==5||G==2||G==6) { G=19; } else { G=20; } String birthday =
	 * String.format("%d%d년 %d월 %d일",G,year,month,day); return birthday;
	 * 
	 * }
	 */
}
