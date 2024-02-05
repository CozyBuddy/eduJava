package days02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
 * @author user
 * @date 2024. 1. 2. 오후 12:30:27
 * @subject 
 * @contents 키보드(표준입력장치)로 부터 이름을 입력받아서 출력.
 *  
 */
public class Ex06 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("입력 :");
		String name = scanner.nextLine();
		System.out.println("제 이름은 :"+name );
		System.out.println("입력 :");
		name = br.readLine(); //Unhandled exception type IOException		
		System.out.printf("> 이름 : %d\n",name);
		
		
	}

}
