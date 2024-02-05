package days23;

import java.io.FileWriter;
import java.util.Hashtable;
import java.util.Properties;

/**
 * @author user
 * @date 2024. 1. 31. 오후 4:20:38
 * @subject 시험
 * @contents
 */
public class Ex10 {
	public static void main(String[] args) {
		// [Properties] 컬렉션 클래스( 자주 사용)
		// 1) == Hashtable 컬렉션 클래스
		// 2) Map = entry( key+value)
		// 3) Key,value 모두 자료형이	String,String 인 Hashtable 이다.
		// xHashtable<String, String > 
		// 4)환경 설정값들을 읽기/쓰기 할때 Properties클래스를 자주 씀.
		// 5)put(),get() X 대신 setProperty(),getProperty()
		// 6)* .properties 확장자를 사용함.(파일로 저장시 파일명이)
		// 7) 저장할때는 store() 오버로딩, 파일 저장.
	    // 		storetoXML()
		//예) DBMS (data base management system) (오라클) + Java 연동 (CRUD작업)(DB 연결 설정 정보)
		//오라클 사용 예시
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
		 
		 //String value = (String) dbConfig.get("className");
//		 String value = dbConfig.getProperty("className");
//		 System.out.println(value);
		 
		 //Properties dbConfig 객체 안에 DB연결정보가 저장.
		 // -> 파일로 저장.
		 // 상대경로
		 // .   현재 디렉토리 \javaPro
		 // ..  상위 디렉토리 \
		 String path = ".\\src\\days23\\jdbc.properties"; //javaPro 까지 지칭
		 
		 try(FileWriter fw = new FileWriter(path)) {
			 dbConfig.store(fw, "db connection config.."); // 맨뒤에는 주석처리
			 System.out.println("SAVE END");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}

}
