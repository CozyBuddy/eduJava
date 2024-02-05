package days17;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author user
 * @date 2024. 1. 23. 오후 5:19:26
 * @subject  [파일 읽어서 출력 +try ~catch ~finally 문]
 * @contents
 */
public class Ex16 {
	public static void main(String[] args) {
		String fileName = "C:\\Setup.log";
		// [FileReader]/FileWriter
		
		FileReader reader = null;
		 
		try {
			reader = new FileReader(fileName);
			
			/*
			int one = reader.read();
			System.out.printf("%c", (char)one );
			one = reader.read();
			System.out.printf("%c", (char)one );
			one = reader.read();
			System.out.printf("%c", (char)one );
			*/
			int one ;
			while( ( one = reader.read() ) != -1) {
				System.out.printf("%c", (char)one );
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null ) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	} // main

} // class