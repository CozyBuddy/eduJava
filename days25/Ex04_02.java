package days25;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * @author user
 * @date 2024. 2. 2. 오전 11:26:37
 * @subject
 * @contents
 */
public class Ex04_02 {
	public static void main(String[] args) {
		          // 실행 후
			      // 1. 저장할 파일명 입력 ? kenik.txt 엔터
			      // 2. 저장할 문자열(Data) 입력 ?내일은 금요일.... 엔터
			      //    계속 ?
			      //   저장할 문자열(Data) 입력 ? sdafsasfd 엔터
			      //    계속 ? n
		String parent = ".\\src\\days25";
		String child = null;
		String contents= null;
		char con ='Y' ;
		try(Scanner sc = new Scanner(System.in);
			 ) {
			System.out.print("저장할 파일명 입력?>");
			child = sc.next();
			File f = new File(parent,child);
			try (FileWriter fw = new FileWriter(f)){
			do {
				System.out.print("저장할 문자열(Data) 입력 ?");
				contents = sc.next();
				fw.append(contents);
				System.out.println("계속 입력하려면 Y를 누르세요.>");
				con = (char)System.in.read();
				System.in.skip(System.in.available());
			} while (Character.toUpperCase(con)=='Y');
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			
	}  catch (Exception e) {
		e.printStackTrace();
	}
	}

}
