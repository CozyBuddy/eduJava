package days18;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex01 {
	public static void main(String[] args) {
		//FileReader/FileWriter 클래스 사용 //FileReader는 한 문자씩 읽어올 수 있는 read 메서드가 있고 BufferedReader는 한 라인씩
		//읽어올수 있음. readLine() 으로
		FileReader reader = null ;
		String fileName = "C:\\Setup.log";
		int one ;// 유니코드 값
		try {
			reader = new FileReader(fileName);
			//EOF (End of File) -1
			while ((one=reader.read())!=-1) {
				System.out.printf("%c",(char)one);
			}
			System.out.println("예외 없음.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader !=null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}// 안 닫으면 다른 곳에서는 읽기 전용으로밖에 못 읽음.
			}
		}
	}

}
