package days18;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author user
 * @date 2024. 1. 24. 오전 10:07:30
 * @subject  try ~ resources 문 // 자동으로 file을 닫아줌 close
 * @contents	
 */
public class Ex01_03 {
	public static void main(String[] args) {
		
	
		String fileName = "C:\\Setup.log";
		String line = null ;
		int lineNumber = 0;
		try (FileReader fr=new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr)){
			/*while ((one=fr.read())!=-1) {
				System.out.printf("%c",(char)one);
			}*/
			while ((line=br.readLine())!=null) { 
			
				System.out.printf("%d: %s\n",++lineNumber,line);
			}
			System.out.println("예외 없음.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//try ~resources 문에 의해서 
			//자동으로 close() 시킴.
			
		}
	}

}
