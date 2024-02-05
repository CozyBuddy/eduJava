package days18;

/**
 * @author user
 * @date 2024. 1. 24. 오후 12:16:04
 * @subject  [문자열을 다루는 클래스]
 * @contents 1.String *** 변경 불가능한 클래스
 * 				2. StringBuffer 
 * 				3. String Builder 
 * 				4.StringTokenizer
 */
public class Ex04 {
	public static void main(String[] args) {
		/*String name = "홍길동"; name은 "홍길동"이라는 인스턴스를 생성하고 그 주솟값을 참조하는 것
		name = "백예린";*/
			String name = "백예린";
			name += "님";
			name += "안녕!!!"; // 객체가 추가로 생성되는 것. 총 3개
			
		//String 타입 -> 자료형, 클래스, 참조타입
		//String name = new String("홍길동");
		
			//[String method 이해,암기]
			//	리턴값       매개변수 
			//1.char charAt(int index);
			//2.int length()
			int len = name.length();
			for (int i = 0; i < len; i++) {
				System.out.print(name.charAt(i));
			}
			//3.substring()
			// name 문자열 속에서 안녕이라는 문자열이 있는지 여부 확인 후에 
			// 안녕을 "Hi" 문자열로 변경
			// 
			
			name.indexOf("안");
			name =name.substring(0, name.indexOf("안")) +"HI" + name.substring(name.indexOf("녕")+1, len);
			System.out.println(name);
			boolean isExist = name.contains("안녕");
			 if (name.contains("안녕")) 
				 System.out.println("안녕은 문자열 속에 있다.");
				name =name.replace("안녕", "Hi");
				System.out.println();
				//String.replace()활용
				
			 System.out.println(name);
			 
			
	}

}
