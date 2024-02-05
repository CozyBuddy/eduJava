package days25;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Properties;

/**
 * @author user
 * @date 2024. 2. 2. 오전 10:29:52
 * @subject
 * @contents
 */
public class Ex03 {
		public static void main(String[] args) {
			// [Properties] 컬렉션 클래스( 자주 사용)
			
			 String className = "oracle.jdbc.driver.OracleDriver";            
			 String url = "jdbc:oracle:thin:@localhost:1521:xe";                  
			 String user = "scott";                                                                   
			 String password = "tiger";
			 
			 Properties dbConfig = new Properties();
			 //dbConfig.put(key, value) ; 사용가능
			 dbConfig.setProperty("className", className);
			 dbConfig.setProperty("url", url);
			 dbConfig.setProperty("user", user);
			 dbConfig.setProperty("password", password);
		
			 String path = ".\\src\\days25\\jdbc.xml"; //javaPro 까지 지칭
			 
			 try(FileOutputStream fs = new FileOutputStream(path);) {
				 //XML 파일 형식으로 환경설정 값들을 저장.
				 dbConfig.storeToXML(fs, "db connection config");
				 //dbConfig.store(fw, "db connection config.."); // 맨뒤에는 주석처리
				 System.out.println("SAVE END");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			 
		}

	}