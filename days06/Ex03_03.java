package days06;

import java.io.IOException;

/**
 * @author user
 * @date 2024. 1. 8. 오후 2:06:06
 * @subject
 * @contents
 */
public class Ex03_03 {
	public static void main(String[] args) throws IOException {
		
		// int read() : 표준입력장치의 입력스트림으로 부터 다음 byte를 읽어서 0~255까지의 정수 int 정수를 
		// 반환하는 함수(메서드) , 스트림의 끝을 만나면 -1값을 반환..
		char one;
		int code;
		System.out.print("한 문자 입력 >");
		code = System.in.read();
		one = (char)code;
		System.out.printf("%c\n",one); // 엔터값이 입력되서(\r\n값이 두개 들어감) 두번째것이 실행 안되고 그냥 넘어감.
		
		/*code = System.in.read();
		 * code = System.in.read();
		code = System.in.read(); // 읽고 버림
		*/
		System.in.skip(System.in.available()); // 나아있는데 위에 두줄이랑 같음
		
		System.out.print("한 문자 입력 >");
		code = System.in.read();
		one = (char)code;
		System.out.printf("%c\n",one);
		
		System.out.println("end");
	}

}
