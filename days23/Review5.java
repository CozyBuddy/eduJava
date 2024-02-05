package days23;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

public class Review5 {
	public static void main(String[] args) {
		Properties p = new Properties();
		String user = "admin";
		String password = "1234";
		
		p.setProperty("user", user);
		p.setProperty("password", password);
		
		String path = ".\\src\\days23\\user.properties";
		try (FileWriter fw = new FileWriter(path)){
			p.store(fw, " ");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try (FileReader fr = new FileReader(path)) {
			p.load(fr);
			System.out.println(p);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
