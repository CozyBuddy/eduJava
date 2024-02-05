package days25;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author user
 * @date 2024. 2. 2. 오후 12:07:39
 * @subject
 * @contents
 */
public class Ex05 {
	public static void main(String[] args) {
		//텍스트파일 복사
		// 원본파일을 읽어서 FileReader
		// 복사파일에 쓰기  FileWriter
		String sourceFile = ".\\src\\days25\\Ex01.java";
		String copyFile = ".\\src\\days25\\Ex01_Copy.java";
		
		fileCopyTextStream(sourceFile,copyFile);
		
		
	}

	private static void fileCopyTextStream(String sourceFile, String copyFile) {
		long start = System.nanoTime();
		try (FileReader fr = new FileReader(sourceFile);
				FileWriter fw = new FileWriter(copyFile)) {
			// char -> int
			int code;
			while ((code = fr.read())!=-1) {
				//System.out.printf("%c",(char)code);
				//fw.append(code); 매개변수 자료형 char,CharSequence
				fw.write(code);
				
			}
			//fw.flush();/
	        //1108800
			//5932500
			System.out.println("파일 복사 완료");
			long end = System.nanoTime() -start;
			System.out.println(end);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
