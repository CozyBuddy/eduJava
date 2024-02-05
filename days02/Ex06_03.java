package days02;

/**
 * @author user
 * @date 2024. 1. 2. 오후 2:26:30
 * @subject String -> 숫자 형(byte,short,int,long,float,double) 변환
 * @contents 기본형 래더 클래스.parseXXX(String "123123")
 */
public class Ex06_03 {
	// Integer. -> wrapper 래퍼 클래스
	public static void main(String[] args) {
		int maxValue = Integer.MAX_VALUE;
		int minValue = Integer.MIN_VALUE;
		System.out.println(maxValue);
		System.out.println(minValue);
		
		String n = "23";
		int m = Integer.parseInt(n);
		System.out.println(m+1);
		byte m1 = Byte.parseByte(n);
		System.out.println(m1);
		
		/////////////////////////
		// int,double 숫자형 ->String 형 변환
		System.out.println("홍길동 "+7); //"홍길동7"
		System.out.println(""+7); //"7"
		System.out.println(""+3.14); //"3.14"
	}

}
