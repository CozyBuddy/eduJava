package days25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author user
 * @date 2024. 2. 2. 오후 12:36:30
 * @subject
 * @contents
 */
public class Ex06 {
	public static void main(String[] args) {
		//실행파일 복사 -> 바이트(이진)스트림 //텍스트 아닌 파일에 대해서 사용
		//FileInputStream / FileOutputStream 사용
		String sourceFile = "C:\\Users\\user\\Downloads\\Kozypop.jpg";
		String copyFile = "C:\\Users\\user\\Kozypop_copy.jpg";
		
		fileCopyBinaryStream(sourceFile,copyFile);
		// 시간 : 1784703400
		
	}

	private static void fileCopyBinaryStream(String sourceFile, String copyFile) {
		long start = System.nanoTime();
		//final int BUFFER_SIZE = 1024; // 단위 바이트 
		try (FileInputStream fr = new FileInputStream(sourceFile);
				FileOutputStream fw = new FileOutputStream(copyFile);
						) {
			
			//char cbuf[] = new char[BUFFER_SIZE]; // 자동으로 br.read에서 마지막 부분의 1024 미만ㅇ으로 남은 것을 자동으로 배열크기를 조정.
			int code ;
			while ((code = fr.read())!=-1) { //남은것도 cbuf배열 에 채워서 읽어감.
				System.out.printf("%08d\n",Integer.parseInt(Integer.toBinaryString(code)));
				fw.write(code);
			}
			fw.flush();
			System.out.println("파일 복사 완료");
			long end = System.nanoTime() -start;
			System.out.println(end);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
