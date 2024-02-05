package days02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author user
 * @date 2024. 1. 2. 오후 2:01:46
 * @subject
 * @contents 키보드로부터 나이를 입력받아서 입력받은 나이를 출력....
 */ 
public class Ex06_02 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("나이 입력 : ");
	    String age1=br.readLine(); 
	    byte age = Byte.parseByte(age1);
		System.out.printf("> 나이 : %d\n",age);
	}

}
