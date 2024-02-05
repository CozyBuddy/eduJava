package days25;

import java.io.File;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

/**
 * @author user
 * @date 2024. 2. 2. 오전 11:03:53
 * @subject   파일에 대한 정보 
 * @contents
 */
public class Ex04 {
	public static void main(String[] args) {
		String parent = ".\\src\\days25";
		String child = "Ex01.java";
		
		//파일 정보
		//File 클래스 - 파일,폴더(디렉토리)을 다루는 여러 기능(메서드)이 구현된 클래스
		//					생성,파일명변경,삭제,정보 등등
		//File openFile = new File("www.naver.com");
		//System.out.println(openFile.length());
		
		
		//String path = dir+"\\"+fileName;
		File openFile = new File(parent,child);
		System.out.println(openFile.length());
		
		System.out.println(openFile.lastModified());
		Date d = new Date(openFile.lastModified());
		System.out.println(d.toLocaleString());
		// File+읽기 + 문자 스트림 == FileReader
		try (FileReader fr = new FileReader(openFile)) {
			// char -> int
			int code;
			while ((code = fr.read())!=-1) {
				System.out.printf("%c",(char)code);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
