package days25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author user
 * @date 2024. 2. 2. 오후 12:07:39
 * @subject
 * @contents
 */
public class Ex05_02 {
	public static void main(String[] args) {
		// 버퍼 기능이 있는 보조 스트림을 사용해서 파일 복사
		// 
		String sourceFile = ".\\src\\days25\\Ex01.java";
		String copyFile = ".\\src\\days25\\Ex01_Copy.java";
		
		fileCopyTextStream(sourceFile,copyFile);
		
		
	}

	private static void fileCopyTextStream(String sourceFile, String copyFile) {
		long start = System.nanoTime();
		final int BUFFER_SIZE = 1024; // 단위 바이트 
		try (FileReader fr = new FileReader(sourceFile);
				FileWriter fw = new FileWriter(copyFile);
				BufferedReader br = new BufferedReader(fr,BUFFER_SIZE);
				BufferedWriter bw = new BufferedWriter(fw,BUFFER_SIZE)
						) {
			// char -> int
			/*int code;
			while ((code = br.read())!=-1) {
				//System.out.printf("%c",(char)code);
				//fw.append(code); 매개변수 자료형 char,CharSequence
				bw.write(code);
				
			}
			//fw.flush();
			*/	
			/*	String line = null;
				while ((line=br.readLine())!=null) {
					bw.write(line);
				}*/
			char cbuf[] = new char[BUFFER_SIZE]; // 자동으로 br.read에서 마지막 부분의 1024 미만ㅇ으로 남은 것을 자동으로 배열크기를 조정.
			int readCharNumber ;
			while ((readCharNumber = br.read(cbuf))!=-1) { //남은것도 cbuf배열 에 채워서 읽어감.
				bw.write(cbuf, 0, readCharNumber);
			}
			System.out.println("파일 복사 완료");
			long end = System.nanoTime() -start;
			System.out.println(end);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
