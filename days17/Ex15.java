package days17;

import java.io.IOException;

/**
 * @author user
 * @date 2024. 1. 23. 오후 4:29:12
 * @subject
 * @contents
 */
public class Ex15 {
	public static void main(String[] args) {
		//예외 클래스에 따라 컴파일러가 예외처리를 확인하기도 하고 안하기도 함.
		//컴파일 오류O
		//"checked 예외" Exception 자손예외클래스
	    //throw new IOException("강제 IO 예외 발생");
		
		//throw new Exception("강제 예외 발생");
		
		//컴파일 오류X
		//컴파일러가 예외 발생을 확인하지 않음. 이유? RuntimeException 및 자식클래스
		//unChecked 예외
		throw new RuntimeException("강제 예외 발생");
		
	}
}
