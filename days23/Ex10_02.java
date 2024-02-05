package days23;

import java.io.FileReader;
import java.util.Properties;

/**
 * @author user
 * @date 2024. 1. 31. 오후 4:43:48
 * @subject [시험]
 * @contents
 */
public class Ex10_02 {
	public static void main(String[] args) {
		String className ;            
		 String url ;                  
		 String user ;                                                                   
		 String password ;
		 
		 String path = ".\\src\\days23\\jdbc.properties"; 
		 
		 Properties p = new Properties();
		 
		 try (FileReader fr = new FileReader(path)){
			p.load(fr);
			className = p.getProperty("className");
			url = p.getProperty("url");
			user = p.getProperty("user");
			password = p.getProperty("password");
			System.out.println(className + url + user + password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
